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
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

public class MoreDiamondsPopulator extends BlockPopulator {
    private static final int HIGHEST_DIAMOND_LEVEL = 32;
    private static final int MINIMUM_NUMBER_OF_LEVELS = 8;
    private static final int LOWEST_DIAMOND_LEVEL = 8;

    private static int highestDiamondLevel = -1;

    public static int getHighestDiamondLevel() {
        if (highestDiamondLevel == -1) {
            highestDiamondLevel = new Random().nextInt(HIGHEST_DIAMOND_LEVEL - (LOWEST_DIAMOND_LEVEL + MINIMUM_NUMBER_OF_LEVELS) + 1) + LOWEST_DIAMOND_LEVEL;
        }
        return highestDiamondLevel;
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

            final int numberOfVeinsInChunk = randomGenerator.nextInt(4);

            for (int chance = 0; chance <= numberOfVeinsInChunk; chance++) {
                final int blockX = randomGenerator.nextInt(16);
                final int blockZ = randomGenerator.nextInt(16);
                final int blockY = randomGenerator.nextInt(getHighestDiamondLevel() - LOWEST_DIAMOND_LEVEL + 1) + LOWEST_DIAMOND_LEVEL;

                final Block block = source.getBlock(blockX, blockY, blockZ);
                if (!(Material.AIR.equals(block.getType()) || Material.COAL_ORE.equals(block.getType()) || Material.GOLD_ORE.equals(block.getType()) ||
                        Material.REDSTONE_ORE.equals(block.getType()) || Material.IRON_ORE.equals(block.getType()))) {
                    checkSurroundingBlocks(3, new DiamondVeinGenerator(block, randomGenerator));
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
