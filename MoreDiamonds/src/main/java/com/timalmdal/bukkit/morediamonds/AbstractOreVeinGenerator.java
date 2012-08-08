package com.timalmdal.bukkit.morediamonds;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;

public abstract class AbstractOreVeinGenerator {

	static private class BlockPosition {
		private final int dimension;
		private final int offset;

		public int getDimension() {
			return dimension;
		}

		public int getOffset() {
			return offset;
		}

		public BlockPosition(final int dimension, final int offset) {
			this.dimension = dimension;
			this.offset = offset;
		}
	}

	private Block block;
	private int thisChunkX;
	private int thisChunkZ;
	private int blockInChunkX;
	private int blockInChunkZ;
	private int blockInChunkY;
	private IntWrapper maximumOreBlocks;

	private final Material oreMaterial;

	public AbstractOreVeinGenerator(final Material oreMaterial) {
		this.oreMaterial = oreMaterial;
	}

	public int getClusterLevel(final Random randomGenerator) {
		final int lowestLevel = getLowestLevel();
		return randomGenerator.nextInt(getHighestLevel() - lowestLevel + 1) + lowestLevel;
	}

	private boolean adjustforChunkOverflow(final int newBlockX, final int newBlockY, final int newBlockZ) {
		boolean result = false;
		final BlockPosition x = calculateChunkAndBlockOffset(thisChunkX, newBlockX);
		final BlockPosition z = calculateChunkAndBlockOffset(thisChunkZ, newBlockZ);

		if (!block.getWorld().isChunkLoaded(x.getDimension(), z.getDimension())) {
			if (block.getWorld().loadChunk(x.getDimension(), z.getDimension(), true)) {
				final Chunk chunk = block.getWorld().getChunkAt(x.getDimension(), z.getDimension());
				result = placeOreBlock(chunk, x.getOffset(), newBlockY, z.getOffset());
				block.getWorld().unloadChunk(chunk);
			}
		}
		return result;
	}

	private boolean placeOreBlock(final Chunk chunk, final int newBlockX, final int newBlockZ, final int newBlockY) {
		boolean result = false;
		if (isValidForOre(newBlockY)) {
			final Block nextBlock = chunk.getBlock(newBlockX, newBlockZ, newBlockY);
			if (!Material.AIR.equals(nextBlock.getType())) {
				nextBlock.setType(oreMaterial);
				result = --maximumOreBlocks.value <= 0;
			}
		}
		return result;
	}

	private BlockPosition calculateChunkAndBlockOffset(final int dimension, final int offset) {
		BlockPosition position;
		if (offset < 0) {
			position = new BlockPosition(dimension - 1, 16 + offset);
		}
		else if (offset > 15) {
			position = new BlockPosition(dimension + 1, offset - 16);
		}
		else {
			position = new BlockPosition(dimension, offset);
		}
		return position;
	}

	private boolean isValidForChunk(final int dimension) {
		return 0 <= dimension && dimension <= 15;
	}

	private boolean isValidForOre(final int dimension) {
		return getLowestLevel() <= dimension && dimension <= getHighestLevel();
	}

	public SurroundingBlocksEnumerator getBlockProcessor(final Block block, final Random randomGenerator) {
		this.block = block;

		block.setType(oreMaterial);

		// Calculate some pseudo constants
		thisChunkX = block.getChunk().getX();
		thisChunkZ = block.getChunk().getZ();
		blockInChunkX = block.getX() - (thisChunkX << 4);
		blockInChunkZ = block.getZ() - (thisChunkZ << 4);
		blockInChunkY = block.getY();
		maximumOreBlocks = new IntWrapper(randomGenerator.nextInt(getMaximumClusterSize() - getMinimumClusterSize()) + getMinimumClusterSize());

		return new SurroundingBlocksEnumerator() {

			@Override
			public boolean processBlock(final int x, final int y, final int z) {
				boolean result = false;

				final int newBlockX = blockInChunkX + x;
				final int newBlockZ = blockInChunkZ + z;
				final int newBlockY = blockInChunkY + y;

				if (isValidForChunk(newBlockX) && isValidForChunk(newBlockZ)) {
					result = placeOreBlock(block.getChunk(), newBlockX, newBlockZ, newBlockY);
				}
				else {
					result = adjustforChunkOverflow(newBlockX, newBlockY, newBlockZ);
				}

				return result;
			}

		};
	}

	protected abstract int getMaximumClusterSize();

	protected abstract int getMinimumClusterSize();

	protected abstract int getHighestLevel();

	protected abstract int getLowestLevel();
}