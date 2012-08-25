/*
 * This file is part of MoreOreBlocks.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/MoreOreBlocks/>
 * MoreOreBlocks is licensed under the GNU Lesser General Public License.
 *
 * MoreOreBlocks is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MoreOreBlocks is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * This file is part of slopes.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/>
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
package com.timalmdal.bukkit.moreoreblocks;

import org.getspout.spoutapi.material.Material;
import org.getspout.spoutapi.material.MaterialData;

public enum OreSubTexture {
	REDSTONE(0, MaterialData.redstone),
		COAL(1, MaterialData.coal),
		OBSIDIAN(2, MaterialData.obsidian);

	private final int textureIndex;
	private final Material sourceMaterial;

	private OreSubTexture(final int textureIndex, final Material sourceMaterial) {
		this.textureIndex = textureIndex;
		this.sourceMaterial = sourceMaterial;
	}

	public int getTextureIndex() {
		return textureIndex;
	}

	public Material getSourceMaterial() {
		return sourceMaterial;
	}

	/**
	 * Format the display name by inserting the material name into the specified
	 * pattern.
	 * 
	 * @param namePattern
	 * @return material name
	 */
	public String getDisplayName() {
		final StringBuilder displayName = new StringBuilder(name().toLowerCase());
		displayName.setCharAt(0, Character.toUpperCase(displayName.charAt(0)));
		return String.format("Block of %s", displayName.toString());
	}

	public boolean isOpaque() {
		return true;
	}
}
