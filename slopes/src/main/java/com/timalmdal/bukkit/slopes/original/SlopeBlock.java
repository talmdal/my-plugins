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
package com.timalmdal.bukkit.slopes.original;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.packet.PacketCustomBlockDesign;
import org.getspout.spoutapi.player.SpoutPlayer;

public abstract class SlopeBlock extends GenericCustomBlock {
	Texture texture;
	SubTexture subTexture;
	SlopeBlockDesign blockDesign;

	public SlopeBlock(final Plugin plugin, final String name, final GenericBlockDesign design, final Texture tex, final SubTexture subtex) {
		super(plugin, name, false, design);

		texture = tex;
		subTexture = subtex;
	}

	@Override
	public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final int changedId) {
	}

	@Override
	public void onBlockPlace(final World world, final int x, final int y, final int z) {
	}

	@Override
	public void onBlockPlace(final World world, final int x, final int y, final int z, final LivingEntity living) {
		final Location loc = living.getLocation();
		final Block block = world.getBlockAt(x, y, z);
		final Location[] locs = getRelativeLocs(block);
		final double[] dist = getLocsDistance(locs, loc);
		final int closeFace = getClosestFace(dist);

		switch (closeFace) {
		default:
		case 1:
			blockDesign = new SlopeBlockDesign(texture, subTexture, Direction.EAST);
			break;
		case 2:
			blockDesign = new SlopeBlockDesign(texture, subTexture, Direction.SOUTH);
			break;
		case 3:
			blockDesign = new SlopeBlockDesign(texture, subTexture, Direction.WEST);
			break;
		case 0:
			blockDesign = new SlopeBlockDesign(texture, subTexture, Direction.NORTH);
			break;
		}

		this.setBlockDesign(blockDesign);
		final PacketCustomBlockDesign packet = new PacketCustomBlockDesign((short) 0, blockDesign, (byte) 0);

		final List<Player> players = world.getPlayers();
		for (final Player p : players) {
			final SpoutPlayer sp = (SpoutPlayer) p;
			if (sp.isSpoutCraftEnabled()) {
				sp.sendPacket(packet);
			}
		}
	}

	public int getClosestFace(final double[] dist) {
		final double d = dist[0];
		int f = 0;
		for (int i = 0; i < 4; i++) {
			if (dist[1] < d) {
				f = i;
			}
		}
		return f;
	}

	public double[] getLocsDistance(final Location[] locs, final Location loc) {
		final double[] dist = new double[4];
		for (int i = 0; i < 4; i++) {
			dist[i] = locs[i].distance(loc);
		}

		return dist;
	}

	public Location[] getRelativeLocs(final Block block) {
		final Location[] locs = { (block.getRelative(BlockFace.NORTH)).getLocation(), (block.getRelative(BlockFace.EAST)).getLocation(),
				(block.getRelative(BlockFace.SOUTH)).getLocation(), (block.getRelative(BlockFace.WEST)).getLocation() };

		return locs;
	}
}
