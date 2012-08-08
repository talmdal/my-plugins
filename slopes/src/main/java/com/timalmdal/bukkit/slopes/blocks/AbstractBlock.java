package com.timalmdal.bukkit.slopes.blocks;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;
import org.bukkit.material.Directional;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

import com.timalmdal.bukkit.slopes.SlopesPlugin;
import com.timalmdal.bukkit.slopes.designers.AbstractBlockDesign;
import com.timalmdal.bukkit.slopes.util.SlopeSubTexture;
import com.timalmdal.bukkit.slopes.util.Utilities;

public abstract class AbstractBlock extends GenericCustomBlock implements Directional, Climbable {

	private BlockFace blockFacing;

	public AbstractBlock(final Plugin plugin, final String displayName, final AbstractBlockDesign design, final Texture texture, final SlopeSubTexture slopeTexture) {
		super(plugin, displayName, 67, 0x00, design, true);
	}

	@Override
	public boolean isClimbable() {
		return true;
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
		final BlockFace playerFacing = Utilities.yawToFace(living.getLocation().getYaw());
		setFacingDirection(playerFacing.getOppositeFace());

		final Block block = world.getBlockAt(x, y, z);
		final byte ascendingDirection = Utilities.getNotchianAscendingDirection(getAscendingDirection());

		Bukkit.getScheduler().scheduleSyncDelayedTask(SlopesPlugin.getPlugin(), new Runnable() {
			@Override
			public void run() {
				block.setData(ascendingDirection);
			}
		});
	}

	@Override
	public String toString() {
		return new StringBuilder()
						.append(getName())
						.append("[")
						.append("Facing: ").append(blockFacing).append("; ")
						.append(super.toString())
						.append("]").toString();
	}

}
