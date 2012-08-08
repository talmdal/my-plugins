package com.timalmdal.bukkit.slopes.util;

public enum TextureOffset {

	Default(0),
	Rotated(16),
	Top(32),
	Bottom(48);

	private int offset;

	public int getOffset() {
		return offset;
	}

	private TextureOffset(final int offset) {
		this.offset = offset;
	}

}
