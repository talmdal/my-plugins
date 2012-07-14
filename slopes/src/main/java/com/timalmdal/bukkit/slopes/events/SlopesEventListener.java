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
package com.timalmdal.bukkit.slopes.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class SlopesEventListener implements Listener {
	private final Plugin plugin;

	public SlopesEventListener(final Plugin plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void PlayerMove(final PlayerMoveEvent event)
	{
		if (event.isCancelled()) {
			plugin.getLogger().warning("PlayerMove: is cancelled");
			return;
		}

		if (hasMoved(event)) {
			// final SpoutPlayer player = (SpoutPlayer) event.getPlayer();
			// plugin.getLogger().warning("PlayerMove: " + player);
			//
			// final Location fromLocation = event.getFrom();
			// final Location toLocation = event.getTo();
			// final SpoutBlock fromBlock = (SpoutBlock) player.getWorld().getBlockAt(fromLocation);
			// plugin.getLogger().warning("PlayerMove: From" + fromBlock);
			// final SpoutBlock toBlock = (SpoutBlock) player.getWorld().getBlockAt(toLocation);
			// plugin.getLogger().warning("PlayerMove: To" + toBlock);
			//
			// final BlockFace forwardFace = getFacingBlock(player);
			// final SpoutBlock facingBlock = fromBlock.getRelative(forwardFace);
			// plugin.getLogger().warning("PlayerMove: facingBlock" + facingBlock);

			// Object item = null;
			// if (block.isCustomBlock()) {
			// item = this.smpManager.getMaterial(new SpoutItemStack(block.getCustomBlock().getBlockItem(), 1));
			// }
			//
			// if ((item != null) && ((item instanceof SMCustomBlock)) && (((SMCustomBlock)item).getSpeedMultiplier().floatValue() != 1.0F)) {
			// player.setAirSpeedMultiplier(((SMCustomBlock)item).getSpeedMultiplier().floatValue());
			// player.setWalkingMultiplier(((SMCustomBlock)item).getSpeedMultiplier().floatValue());
			// } else {
			// player.setAirSpeedMultiplier(1.0D);
			// player.setWalkingMultiplier(1.0D);
			// }
			//
			// if ((item != null) && ((item instanceof SMCustomBlock)) && (((SMCustomBlock)item).getJumpMultiplier().floatValue() != 1.0F))
			// player.setJumpingMultiplier(((SMCustomBlock)item).getJumpMultiplier().floatValue());
			// else {
			// player.setJumpingMultiplier(1.0D);
			// }
			//
			// MaterialAction walkAction = null;
			//
			// if ((item != null) && ((item instanceof SMCustomBlock)) && (((SMCustomBlock)item).getActionWalk() != null)) {
			// walkAction = ((SMCustomBlock)item).getActionWalk();
			// }
			//
			// if (walkAction != null) {
			// doMaterialAction(walkAction, player, (SMCustomBlock)item);
			//
			// if (walkAction.getConsume().booleanValue())
			// block.setType(org.bukkit.Material.AIR);
			// }
		}
	}

	private boolean hasMoved(final PlayerMoveEvent event) {
		final Location fromLocation = event.getFrom();
		final Location toLocation = event.getTo();

		// Compare location without regard to pitch and yaw
		final World fromWorld = fromLocation.getWorld();
		final World toWorld = toLocation.getWorld();
		if (fromWorld != toWorld && (fromWorld == null || !fromWorld.equals(toWorld))) {
			return true;
		}
		if (Double.doubleToLongBits(fromLocation.getX()) != Double.doubleToLongBits(toLocation.getX())) {
			return true;
		}
		if (Double.doubleToLongBits(fromLocation.getY()) != Double.doubleToLongBits(toLocation.getY())) {
			return true;
		}
		if (Double.doubleToLongBits(fromLocation.getZ()) != Double.doubleToLongBits(toLocation.getZ())) {
			return true;
		}

		return false;
	}

	public BlockFace getFacingBlock(final Player player) {
		plugin.getLogger().warning("PlayerMove: yaw: " + player.getLocation().getYaw());
		plugin.getLogger().warning("PlayerMove: yaw + 360: " + player.getLocation().getYaw() + 360);
		plugin.getLogger().warning("PlayerMove: rot: " + (player.getLocation().getYaw() + 360) % 360);
		final double rot = (player.getLocation().getYaw() + 360) % 360;
		// if (rot < 0) {
		// rot += 360.0;
		// }
		if (0 <= rot && rot < 22.5) {
			return BlockFace.NORTH;
		}
		else if (22.5 <= rot && rot < 67.5) {
			return BlockFace.NORTH_EAST;
		}
		else if (67.5 <= rot && rot < 112.5) {
			return BlockFace.EAST;
		}
		else if (112.5 <= rot && rot < 157.5) {
			return BlockFace.SOUTH_EAST;
		}
		else if (157.5 <= rot && rot < 202.5) {
			return BlockFace.SOUTH;
		}
		else if (202.5 <= rot && rot < 247.5) {
			return BlockFace.SOUTH_WEST;
		}
		else if (247.5 <= rot && rot < 292.5) {
			return BlockFace.WEST;
		}
		else if (292.5 <= rot && rot < 337.5) {
			return BlockFace.NORTH_WEST;
		}
		else if (337.5 <= rot && rot < 360.0) {
			return BlockFace.NORTH;
		}
		else {
			return null;
		}
	}

}
