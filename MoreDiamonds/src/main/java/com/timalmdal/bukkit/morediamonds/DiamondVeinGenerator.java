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

import org.bukkit.Material;

public class DiamondVeinGenerator extends AbstractOreVeinGenerator {
	private static final int HIGHEST_DIAMOND_LEVEL = 32;
	private static final int LOWEST_DIAMOND_LEVEL = 8;
	private static final int MAX_DIAMOND_CLUSTER_SIZE = 16;
	private static final int MIN_DIAMOND_CLUSTER_SIZE = 4;

	public DiamondVeinGenerator() {
		super(Material.DIAMOND_ORE);
	}

	@Override
	protected int getMaximumClusterSize() {
		return MAX_DIAMOND_CLUSTER_SIZE;
	}

	@Override
	protected int getMinimumClusterSize() {
		return MIN_DIAMOND_CLUSTER_SIZE;
	}

	@Override
	protected int getHighestLevel() {
		return HIGHEST_DIAMOND_LEVEL;
	}

	@Override
	protected int getLowestLevel() {
		return LOWEST_DIAMOND_LEVEL;
	}
}
