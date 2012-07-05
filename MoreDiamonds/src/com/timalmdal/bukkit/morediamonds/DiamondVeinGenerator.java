/*
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/>
 * MoreDiamonds plugin is licensed under the GNU Lesser General Public License.
 *
 * MoreDiamonds plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MoreDiamonds plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.morediamonds;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class DiamondVeinGenerator implements SurroundingBlocksEnumerator {
    private static final int MAX_DIAMOND_CLUSTER_SIZE = 16; // Maximum number of
                                                            // diamonds in a
                                                            // cluster
    private static final int MIN_DIAMOND_CLUSTER_SIZE = 4; // Minimum number of
                                                           // diamonds in a
                                                           // cluster
    private static final int LOWEST_DIAMOND_LEVEL = 8;

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

    private final Block block;
    private final IntWrapper maxDiamond;
    private final int thisChunkX;
    private final int thisChunkZ;
    private final int blockInChunkX;
    private final int blockInChunkZ;
    private final int blockInChunkY;
    private final Random randomGenerator;

    public DiamondVeinGenerator(final Block block, final Random randomGenerator) {
        this.block = block;
        this.randomGenerator = randomGenerator;

        block.setType(Material.DIAMOND_ORE);

        // Calculate some pseudo constants
        maxDiamond = new IntWrapper(this.randomGenerator.nextInt(MAX_DIAMOND_CLUSTER_SIZE - MIN_DIAMOND_CLUSTER_SIZE) + MIN_DIAMOND_CLUSTER_SIZE);
        thisChunkX = block.getChunk().getX();
        thisChunkZ = block.getChunk().getZ();
        blockInChunkX = block.getX() - (thisChunkX << 4);
        blockInChunkZ = block.getZ() - (thisChunkZ << 4);
        blockInChunkY = block.getY();
    }

    @Override
    public boolean processBlock(final int x, final int y, final int z) {
        boolean result = false;

        final int newBlockX = blockInChunkX + x;
        final int newBlockZ = blockInChunkZ + z;
        final int newBlockY = blockInChunkY + y;

        if (isValidForChunk(newBlockX) && isValidForChunk(newBlockZ)) {
            result = placeDiamond(block.getChunk(), newBlockX, newBlockZ, newBlockY);
        }
        else {
            result = adjustforChunkOverflow(newBlockX, newBlockY, newBlockZ);
        }

        return result;
    }

    private boolean adjustforChunkOverflow(final int newBlockX, final int newBlockY, final int newBlockZ) {
        boolean result = false;
        final BlockPosition x = calculateChunkAndBlockOffset(thisChunkX, newBlockX);
        final BlockPosition z = calculateChunkAndBlockOffset(thisChunkZ, newBlockZ);

        if (!block.getWorld().isChunkLoaded(x.getDimension(), z.getDimension())) {
            if (block.getWorld().loadChunk(x.getDimension(), z.getDimension(), true)) {
                final Chunk chunk = block.getWorld().getChunkAt(x.getDimension(), z.getDimension());
                result = placeDiamond(chunk, x.getOffset(), newBlockY, z.getOffset());
                block.getWorld().unloadChunk(chunk);
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

    private boolean placeDiamond(final Chunk chunk, final int newBlockX, final int newBlockZ, final int newBlockY) {
        boolean result = false;
        if (isValidForDiamond(newBlockY)) {
            final Block nextBlock = chunk.getBlock(newBlockX, newBlockZ, newBlockY);
            if (!Material.AIR.equals(nextBlock.getType())) {
                nextBlock.setType(Material.DIAMOND_ORE);
                result = --maxDiamond.value <= 0;
            }
        }
        return result;
    }

    private boolean isValidForChunk(final int dimension) {
        return 0 <= dimension && dimension <= 15;
    }

    private boolean isValidForDiamond(final int dimension) {
        return LOWEST_DIAMOND_LEVEL <= dimension && dimension <= MoreDiamondsPopulator.getHighestDiamondLevel();
    }

}
