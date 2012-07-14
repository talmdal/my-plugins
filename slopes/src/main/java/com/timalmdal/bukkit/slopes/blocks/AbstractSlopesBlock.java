package com.timalmdal.bukkit.slopes.blocks;

import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.bukkit.material.Directional;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

import com.timalmdal.bukkit.slopes.SlopesPlugin.SlopeSubTexture;
import com.timalmdal.bukkit.slopes.designers.AbstractSlopesBlockDesign;

public abstract class AbstractSlopesBlock extends GenericCustomBlock implements Directional, Climbable {

	private BlockFace blockFacing;

	public AbstractSlopesBlock(final Plugin plugin, final String displayName, final AbstractSlopesBlockDesign design, final Texture texture, final SlopeSubTexture slopeTexture) {
		super(plugin, displayName, false, design, true);
		setFacingDirection(BlockFace.SOUTH);
	}

	/**
	 * @return the direction the stairs ascend towards
	 */
	public BlockFace getDescendingDirection() {
		return blockFacing;
	}

	/**
	 * @return the direction the stairs descend towards
	 */
	public BlockFace getAscendingDirection() {
		return getDescendingDirection().getOppositeFace();
	}

	@Override
	public void setFacingDirection(final BlockFace face) {
		blockFacing = face;
	}

	@Override
	public BlockFace getFacing() {
		return blockFacing;
	}

	@Override
	public void onBlockPlace(final World world, final int x, final int y, final int z, final LivingEntity living) {
		final BlockFace playerFacing = playerFacing(living.getLocation().getYaw());
		setFacingDirection(playerFacing.getOppositeFace());
		// getPlugin().getLogger().warning("onBlockPlace: Facing: " + playerFacing);
		// getPlugin().getLogger().warning("Ascending direction: " + getAscendingDirection());
		// getPlugin().getLogger().warning("Descending direction: " + getDescendingDirection());
	}

	public BlockFace playerFacing(final float yaw) {
		int angle = (int) yaw;

		while (angle <= -180) {
			angle += 360;
		}
		while (angle > 180) {
			angle -= 360;
		}

		switch (angle) {
		case 0:
			return BlockFace.SOUTH;
		case 90:
			return BlockFace.WEST;
		case 180:
			return BlockFace.NORTH;
		case -90:
			return BlockFace.EAST;
		default:
			if (yaw >= -45 && yaw < 45) {
				return BlockFace.SOUTH;
			}
			else if (yaw >= 45 && yaw < 135) {
				return BlockFace.WEST;
			}
			else if (yaw >= -135 && yaw < -45) {
				return BlockFace.EAST;
			}
			else {
				return BlockFace.NORTH;
			}
		}
	}

	// @Override
	// public void onBlockPlace(final World world, final int x, final int y, final int z, final LivingEntity living) {
	// // final Location loc = living.getLocation();
	// // final Block block = world.getBlockAt(x, y, z);
	// // final Location[] locs = getRelativeLocs(block);
	// // final double[] dist = getLocsDistance(locs, loc);
	// // final int closeFace = getClosestFace(dist);
	//
	// StairsBlockDesign blockDesign;
	//
	// final BlockFace facing = playerFacing(living.getLocation().getYaw());
	// getPlugin().getLogger().warning("onBlockPlace: Facing: " + facing);
	// setFacingDirection(facing);
	// getPlugin().getLogger().warning("Ascending direction: " + getAscendingDirection());
	// getPlugin().getLogger().warning("Descending direction: " + getDescendingDirection());
	//
	// switch (getDescendingDirection()) {
	// default:
	// case EAST:
	// blockDesign = new StairsBlockDesign(getPlugin(), texture, subTexture, Direction.WEST);
	// break;
	// case SOUTH:
	// blockDesign = new StairsBlockDesign(getPlugin(), texture, subTexture, Direction.SOUTH);
	// break;
	// case WEST:
	// blockDesign = new StairsBlockDesign(getPlugin(), texture, subTexture, Direction.EAST);
	// break;
	// case NORTH:
	// blockDesign = new StairsBlockDesign(getPlugin(), texture, subTexture, Direction.NORTH);
	// break;
	// }
	//
	// getPlugin().getLogger().warning("Ascending direction: " + getAscendingDirection());
	// getPlugin().getLogger().warning("Desending direction: " + getDescendingDirection());
	//
	// this.setBlockDesign(blockDesign);
	// final PacketCustomBlockDesign packet = new PacketCustomBlockDesign((short) 0, blockDesign, (byte) 0);
	//
	// final List<Player> players = world.getPlayers();
	// for (final Player p : players) {
	// final SpoutPlayer sp = (SpoutPlayer) p;
	// if (sp.isSpoutCraftEnabled()) {
	// sp.sendPacket(packet);
	// }
	// }
	// }

	// public Location[] getRelativeLocs(final Block block) {
	// final Location[] locs = { (block.getRelative(BlockFace.NORTH)).getLocation(), (block.getRelative(BlockFace.EAST)).getLocation(),
	// (block.getRelative(BlockFace.SOUTH)).getLocation(), (block.getRelative(BlockFace.WEST)).getLocation() };
	//
	// return locs;
	// }
	// final StairsBlockDesign stairsDesign = new StairsBlockDesign(plugin, texture, slopeTexture);
	// this.setBlockDesign(stairsDesign.rotate(270), 0);
	// this.setBlockDesign(stairsDesign, 1);
	// this.setBlockDesign(stairsDesign.rotate(90), 2);
	// this.setBlockDesign(stairsDesign.rotate(180), 3);

	// public static Block getBlockInFrontOf(Player p, boolean ignoreYaxis)
	// {
	// final Vector heading = p.getLocation().getDirection();
	// if (ignoreYaxis)
	// {
	// heading.setY(0);
	// }
	//
	// final Vector location = p.getLocation().toVector().add(heading.normalize());
	// return p.getWorld().getBlockAt(new Location(p.getWorld(), location.getX(), location.getY(), location.getZ()));
	// }
}
