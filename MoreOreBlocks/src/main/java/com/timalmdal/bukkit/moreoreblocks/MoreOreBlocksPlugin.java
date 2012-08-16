/*
 * This file is part of coal2diamonds.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/CoalToDiamonds/>
 * coal2diamonds is licensed under the GNU Lesser General Public License.
 *
 * coal2diamonds is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * coal2diamonds is distributed in the hope that it will be useful,
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
 * CoalToDiamonds plugin is licensed under the GNU Lesser General Public License.
 *
 * CoalToDiamonds plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CoalToDiamonds plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.moreoreblocks;

import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.GenericCubeBlockDesign;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.inventory.SpoutShapelessRecipe;
import org.getspout.spoutapi.material.block.GenericCustomBlock;

public class MoreOreBlocksPlugin extends JavaPlugin {
	private static final String TEXTURE_IMAGES = "textures.png";

	private final Map<OreSubTexture, GenericCustomBlock> blockMap = new HashMap<OreSubTexture, GenericCustomBlock>();

	private Texture texture;
	private String textureImagePath;

	@Override
	public void onEnable() {
		try {
			textureImagePath = FileUtilities.loadAndCacheResource(this, TEXTURE_IMAGES);
			texture = new Texture(this, textureImagePath, 48, 16, 16);

			for (final OreSubTexture oreSubTexture : EnumSet.allOf(OreSubTexture.class)) {
				final GenericCustomBlock oreBlock =
					new GenericCustomBlock(this, oreSubTexture.getDisplayName(), true,
						new GenericCubeBlockDesign(this, texture, oreSubTexture.getTextureIndex()));

				blockMap.put(oreSubTexture, oreBlock);

				SpoutManager.getMaterialManager()
					.registerSpoutRecipe(new SpoutShapedRecipe(new SpoutItemStack(oreBlock, 1))
						.shape("AAA", "AAA", "AAA")
						.setIngredient('A', oreSubTexture.getSourceMaterial()));
				SpoutManager.getMaterialManager().registerSpoutRecipe(
					new SpoutShapelessRecipe(new SpoutItemStack(oreSubTexture.getSourceMaterial(), 9))
						.addIngredient(oreBlock));
			}

		} catch (final IOException e) {
			getLogger().log(Level.SEVERE, "Problem initializing textures for [Slopes]: ", e);
		}

		getLogger().info("[MoreOreBlocks] enabled.");
	}

	@Override
	public void onDisable() {
		if (textureImagePath != null) {
			SpoutManager.getFileManager().removeFromCache(this, textureImagePath);
			textureImagePath = null;
		}
		blockMap.clear();

		getLogger().info("[MoreOreBlocks] disabled.");
	}
}
