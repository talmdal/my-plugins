/*
 * This file is part of More Diamonds.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/MoreDiamonds/>
 * More Diamonds is licensed under the GNU Lesser General Public License.
 *
 * More Diamonds is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * More Diamonds is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class MoreDiamondsPopulator extends BlockPopulator {

	private static final List<AbstractOreVeinGenerator> oreList = new ArrayList<AbstractOreVeinGenerator>(2);

	static {
		oreList.add(new DiamondVeinGenerator());
		oreList.add(new GoldVeinGenerator());
	}

	private final MoreDiamondsPlugin plugin;
	private Random randomGenerator;

	public MoreDiamondsPopulator(final MoreDiamondsPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void populate(final World world, final Random random, final Chunk source) {
		if (plugin.getServer().getWorlds().get(0).equals(world)) {
			randomGenerator = random;

			for (final AbstractOreVeinGenerator generator : oreList) {
				final int numberOfVeinsInChunk = randomGenerator.nextInt(4) + 1;

				int chance = 0;
				for (; chance <= numberOfVeinsInChunk;) {
					final int blockX = randomGenerator.nextInt(16);
					final int blockZ = randomGenerator.nextInt(16);
					final int blockY = generator.getClusterLevel(randomGenerator);

					final Block block = source.getBlock(blockX, blockY, blockZ);
					if ((Material.STONE.equals(block.getType()) || Material.DIRT.equals(block.getType()) || Material.GRAVEL.equals(block.getType()) ||
						Material.WATER.equals(block.getType()) || Material.COBBLESTONE.equals(block.getType()) || Material.LAVA.equals(block.getType()))) {
						checkSurroundingBlocks(3, generator.getBlockProcessor(block, randomGenerator));
						chance++;
					}
				}
			}
		}
	}

	private boolean checkSurroundingBlocks(final int radius, final SurroundingBlocksEnumerator surroundingBlocksEnumerator) {
		boolean result = false;
		for (int distance = 1; distance <= radius && !result; distance++) {
			final int beginBlock = -distance;
			final int endBlock = distance;
			for (int x = beginBlock; x <= endBlock && !result; x++) {
				for (int z = beginBlock; z <= endBlock && !result; z++) {
					for (int y = beginBlock; y <= endBlock && !result; y++) {
						result = surroundingBlocksEnumerator.processBlock(x, y, z);
					}
				}
			}
		}

		return result;
	}
}
