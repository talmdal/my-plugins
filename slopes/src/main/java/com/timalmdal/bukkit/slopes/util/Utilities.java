package com.timalmdal.bukkit.slopes.util;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;

public enum Utilities {
	;

	/**
	 * Normalize the yaw between -180 and 180
	 * @param angle
	 * @return
	 */
	public static double normalAngle(double angle) {
		if (angle <= -180 || angle > 180) {
			while (angle <= -180) {
				angle += 360;
			}
			while (angle > 180) {
				angle -= 360;
			}
		}
		return angle;
	}

	/**
	 * Determine the BlockFace as a direction given the yaw.
	 * @param yaw
	 * @return
	 */
	public static BlockFace yawToFace(final float yaw) {
		final int angle = (int) Utilities.normalAngle(yaw);

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
			if (angle >= -45 && angle < 45) {
				return BlockFace.SOUTH;
			}
			else if (angle >= 45 && angle < 135) {
				return BlockFace.WEST;
			}
			else if (angle >= -135 && angle < -45) {
				return BlockFace.EAST;
			}
			else {
				return BlockFace.NORTH;
			}
		}
	}

	public static byte getNotchianAscendingDirection(final BlockFace direction) {
		byte data = 0;
		switch (direction) {
		case SOUTH:
			data = 0x02;
			break;
		case EAST:
			data = 0x00;
			break;
		case WEST:
			data = 0x01;
			break;
		case NORTH:
			data = 0x03;
			break;
		default:
			throw new IllegalArgumentException("Blockface: '" + direction + "' not supported");
		}
		return data;
	}

	public static double directionAngle(final Location from, final Location to) {
		final Location direction = to.subtract(from);
		final double angle = Math.toDegrees(Math.atan2(direction.getX(), direction.getZ()));
		return normalAngle(angle);
	}
}
