package com.timalmdal.bukkit.slopes.util;

import java.util.EnumSet;

import org.getspout.spoutapi.material.Block;
import org.getspout.spoutapi.material.MaterialData;

public enum SlopeSubTexture {
	WOOD(0, MaterialData.wood),
	COBBLESTONE(1, MaterialData.cobblestone),
	GLASS(2, MaterialData.glass),
	SANDSTONE(3, MaterialData.sandstone),
	DIRT(4, MaterialData.dirt),
	STONE(5, MaterialData.stone),
	SAND(6, MaterialData.sand),
	SNOW(7, MaterialData.snow),
	GRASS(8, MaterialData.grass),
	BRICK(9, MaterialData.brick),
	GRAVEL(10, MaterialData.gravel),
	GOLD(11, MaterialData.goldBlock),
	IRON(12, MaterialData.ironBlock),
	OBSIDIAN(13, MaterialData.obsidian),
	DIAMOND(14, MaterialData.diamondBlock),
	NETHERBRICK(15, MaterialData.netherBrick);

	private final int textureIndex;
	private final Block sourceBlock;

	private SlopeSubTexture(final int textureIndex, final Block sourceBlock) {
		this.textureIndex = textureIndex;
		this.sourceBlock = sourceBlock;
	}

	public int getTextureIndex() {
		return textureIndex;
	}

	public Block getSourceBlock() {
		return sourceBlock;
	}

	public String getDisplayName(final String namePattern) {
		final StringBuilder displayName = new StringBuilder(name().toLowerCase());
		displayName.setCharAt(0, Character.toUpperCase(displayName.charAt(0)));
		return String.format(namePattern, displayName.toString());
	}

	public boolean isOpaque() {
		return sourceBlock.isOpaque();
	}

	public static EnumSet<SlopeSubTexture> getExtendedMaterialSet() {
		return EnumSet.of(
				SlopeSubTexture.GLASS, SlopeSubTexture.SANDSTONE, SlopeSubTexture.DIRT, SlopeSubTexture.SAND,
				SlopeSubTexture.SNOW, SlopeSubTexture.GRASS, SlopeSubTexture.GRAVEL, SlopeSubTexture.GOLD,
				SlopeSubTexture.IRON, SlopeSubTexture.OBSIDIAN, SlopeSubTexture.DIAMOND);
	}

	public static EnumSet<SlopeSubTexture> getAllMaterialSet() {
		return EnumSet.allOf(SlopeSubTexture.class);
	}

}
