/*
 * This file is part of slopes.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/slopes/>
 * slopes is licensed under the GNU Lesser General Public License.
 * This version of slopes is derived from Kaevator's Superslopes (http://goo.gl/Rd7io)
 * and retsrif's original Spout port (https://github.com/retsrif/Slopes)
 *
 * slopes is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * slopes is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.slopes.blocks;

import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.block.design.Texture;

import com.timalmdal.bukkit.slopes.designers.CornerDesign;
import com.timalmdal.bukkit.slopes.util.SlopeSubTexture;

public class Corner extends AbstractBlock {
	public static final String[] RECIPE = new String[] { " A ", " AA", " A " };

	public Corner(final JavaPlugin plugin, final Texture texture, final SlopeSubTexture slopeTexture) {
		super(plugin, slopeTexture.getDisplayName("%s Corner"),
				new CornerDesign(plugin, texture, slopeTexture), texture, slopeTexture);
		setFacingDirection(BlockFace.SOUTH);
	}

	@Override
	public boolean isClimbable() {
		return false;
	}

	@Override
	public void onBlockPlace(final World world, final int x, final int y, final int z, final LivingEntity living) {
		// TODO need to figure out which to place block (i.e. which corner
		super.onBlockPlace(world, x, y, z, living);
	}

}
