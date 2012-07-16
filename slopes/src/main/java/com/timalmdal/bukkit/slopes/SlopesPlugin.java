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
package com.timalmdal.bukkit.slopes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;

import com.timalmdal.bukkit.slopes.blocks.AbstractBlock;
import com.timalmdal.bukkit.slopes.blocks.Corner;
import com.timalmdal.bukkit.slopes.blocks.InvertedStair;
import com.timalmdal.bukkit.slopes.blocks.SlantedCorner;
import com.timalmdal.bukkit.slopes.blocks.SlopedAngle;
import com.timalmdal.bukkit.slopes.blocks.SlopedFloor;
import com.timalmdal.bukkit.slopes.blocks.StairBlock;
import com.timalmdal.bukkit.slopes.events.SlopesEventListener;
import com.timalmdal.bukkit.slopes.util.SlopeSubTexture;

public class SlopesPlugin extends JavaPlugin {
	private static final String TEXTURE_IMAGES = "Slopes.png";

	public static Texture texture;

	private static class SlopeBlockMap extends HashMap<SlopeSubTexture, List<AbstractBlock>> {
		private static final long serialVersionUID = 1L;

		@Override
		public List<AbstractBlock> get(final Object material) {
			List<AbstractBlock> materialBlocks = super.get(material);
			if (materialBlocks == null) {
				materialBlocks = new ArrayList<AbstractBlock>();
				super.put((SlopeSubTexture) material, materialBlocks);
			}
			return materialBlocks;
		}

	}

	private static SlopeBlockMap slopeBlocks = new SlopeBlockMap();

	@Override
	public void onDisable() {
		System.out.println("[SlopesPlugin] disabled.");
	}

	@Override
	public void onEnable() {
		texture = new Texture(this, getResource(TEXTURE_IMAGES), TEXTURE_IMAGES, 256, 16, 16);

		Bukkit.getServer().getPluginManager().registerEvents(new SlopesEventListener(this), this);

		setupBlocks();

		System.out.println("[SlopesPlugin] enabled.");
	}

	public void setupBlocks() {
		// Generate the blocks that are similiar to minecraft and only need to
		// generate in other materials
		generateBlocksForMaterials(SlopeSubTexture.getExtendedMaterialSet(),
				StairBlock.class,
				InvertedStair.class);

		// Generate the blocks that have no minecraft equivalent and need all
		// material generated
		generateBlocksForMaterials(SlopeSubTexture.getAllMaterialSet(),
				SlopedFloor.class,
				Corner.class,
				SlantedCorner.class,
				SlopedAngle.class);

		// setupSlopedCeilings();
		// setupCeilingAngles();
		// setupCeilingSlantedCorners();
		// setupObliqueSlopes();
		// setupInvertedObliqueSlopes();
		// setupSlopesIntersections();
		// setupInvertedSlopesIntersections();
	}

	/**
	 * Generate the specified blocks for all the materials
	 * @param blockClasses list of block classes to generate
	 */
	@SuppressWarnings("unchecked")
	private void generateBlocksForMaterials(final EnumSet<SlopeSubTexture> materialSet, final Class<?>... blockClasses) {
		for (final SlopeSubTexture material : materialSet) {
			final List<AbstractBlock> materialBlocks = slopeBlocks.get(material);
			for (final Class<?> block : blockClasses) {

				final Class<? extends AbstractBlock> abstractBlockClass = (Class<? extends AbstractBlock>) block;
				materialBlocks.add(createBlockForSubTexture(abstractBlockClass, material));
			}
		}
	}

	private <T extends AbstractBlock> T createBlockForSubTexture(final Class<T> blockClass, final SlopeSubTexture material) {
		try {
			final Constructor<T> constructor = blockClass.getConstructor(JavaPlugin.class, Texture.class, SlopeSubTexture.class);
			final T slopeBlock = constructor.newInstance(this, texture, material);

			final Field recipe = blockClass.getDeclaredField("RECIPE");
			recipe.setAccessible(true);
			final ItemStack itemStack = new SpoutItemStack(slopeBlock, 4);
			SpoutManager.getMaterialManager().registerSpoutRecipe(new SpoutShapedRecipe(itemStack)
					.shape((String[]) recipe.get(null))
					.setIngredient('A', material.getSourceBlock()));

			return slopeBlock;
		}
		catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException |
				InvocationTargetException | NoSuchFieldException e) {
			getLogger().severe(e.getMessage());
			getLogger().log(Level.SEVERE, "Problem creating block: " + blockClass.getSimpleName(), e);
		}
		return null;
	}

	public void setupSlopedCeilings() {
		// wsc = new WoodenSlopedCeiling(this, "Wooden Sloped Ceiling", texture,
		// wood);
		// csc = new CobbleSlopedCeiling(this, "Cobblestone Sloped Ceiling",
		// texture, cobble);
		// glsc = new GlassSlopedCeiling(this, "Glass Sloped Ceiling", texture,
		// glass);
		// sssc = new SandstoneSlopedCeiling(this, "Sandstone Sloped Ceiling",
		// texture, sandstone);
		// dirsc = new DirtSlopedCeiling(this, "Dirt Sloped Ceiling", texture,
		// dirt);
		// stsc = new StoneSlopedCeiling(this, "Stone Sloped Ceiling", texture,
		// stone);
		// sasc = new SandSlopedCeiling(this, "Sand Sloped Ceiling", texture,
		// sand);
		// snsc = new SnowSlopedCeiling(this, "Snow Sloped Ceiling", texture,
		// snow);
		// grassc = new GrassSlopedCeiling(this, "Grass Sloped Ceiling",
		// texture, grass);
		// bsc = new BricksSlopedCeiling(this, "Bricks Sloped Ceiling", texture,
		// bricks);
		// gravsc = new GravelSlopedCeiling(this, "Gravel Sloped Ceiling",
		// texture, gravel);
		// gosc = new GoldSlopedCeiling(this, "Gold Sloped Ceiling", texture,
		// gold);
		// isc = new IronSlopedCeiling(this, "Iron Sloped Ceiling", texture,
		// iron);
		// osc = new ObsidianSlopedCeiling(this, "Obisidian Sloped Ceiling",
		// texture, obsidian);
		// diasc = new DiamondSlopedCeiling(this, "Diamond Sloped Ceiling",
		// texture, diamond);
		// nsc = new NetherbrickSlopedCeiling(this,
		// "Netherbrick Sloped Ceiling", texture, netherbrick);
	}

	public void setupSlopedAngles() {
		// wsa = new WoodenSlopedAngle(this, "Wooden Sloped Angle", texture,
		// wood);
		// csa = new CobbleSlopedAngle(this, "Cobblestone Sloped Angle",
		// texture, cobble);
		// glsa = new GlassSlopedAngle(this, "Glass Sloped Angle", texture,
		// glass);
		// sssa = new SandstoneSlopedAngle(this, "Sandstone Sloped Angle",
		// texture, sandstone);
		// dirsa = new DirtSlopedAngle(this, "Dirt Sloped Angle", texture,
		// dirt);
		// stsa = new StoneSlopedAngle(this, "Stone Sloped Angle", texture,
		// stone);
		// sasa = new SandSlopedAngle(this, "Sand Sloped Angle", texture, sand);
		// snsa = new SnowSlopedAngle(this, "Snow Sloped Angle", texture, snow);
		// grassa = new GrassSlopedAngle(this, "Grass Sloped Angle", texture,
		// grass);
		// bsa = new BricksSlopedAngle(this, "Bricks Sloped Angle", texture,
		// bricks);
		// gravsa = new GravelSlopedAngle(this, "Gravel Sloped Angle", texture,
		// gravel);
		// gosa = new GoldSlopedAngle(this, "Gold Sloped Angle", texture, gold);
		// isa = new IronSlopedAngle(this, "Iron Sloped Angle", texture, iron);
		// osa = new ObsidianSlopedAngle(this, "Obisidian Sloped Angle",
		// texture, obsidian);
		// diasa = new DiamondSlopedAngle(this, "Diamond Sloped Angle", texture,
		// diamond);
		// nsa = new NetherbrickSlopedAngle(this, "Netherbrick Sloped Angle",
		// texture, netherbrick);
	}

	public void setupCeilingAngles() {
		// wca = new WoodenCeilingAngle(this, "Wooden Ceiling Angle", texture,
		// wood, d);
		// cca = new CobbleCeilingAngle(this, "Cobblestone Ceiling Angle",
		// texture, cobble, d);
		// glca = new GlassCeilingAngle(this, "Glass Ceiling Angle", texture,
		// glass, d);
		// ssca = new SandstoneCeilingAngle(this, "Sandstone Ceiling Angle",
		// texture, sandstone, d);
		// dirca = new DirtCeilingAngle(this, "Dirt Ceiling Angle", texture,
		// dirt, d);
		// stca = new StoneCeilingAngle(this, "Stone Ceiling Angle", texture,
		// stone, d);
		// saca = new SandCeilingAngle(this, "Sand Ceiling Angle", texture,
		// sand, d);
		// snca = new SnowCeilingAngle(this, "Snow Ceiling Angle", texture,
		// snow, d);
		// grasca = new GrassCeilingAngle(this, "Grass Ceiling Angle", texture,
		// grass, d);
		// bca = new BricksCeilingAngle(this, "Bricks Ceiling Angle", texture,
		// bricks, d);
		// gravca = new GravelCeilingAngle(this, "Gravel Ceiling Angle",
		// texture, gravel, d);
		// goca = new GoldCeilingAngle(this, "Gold Ceiling Angle", texture,
		// gold, d);
		// ica = new IronCeilingAngle(this, "Iron Ceiling Angle", texture, iron,
		// d);
		// oca = new ObsidianCeilingAngle(this, "Obisidian Ceiling Angle",
		// texture, obsidian, d);
		// diaca = new DiamondCeilingAngle(this, "Diamond Ceiling Angle",
		// texture, diamond, d);
		// nca = new NetherbrickCeilingAngle(this, "Netherbrick Ceiling Angle",
		// texture, netherbrick, d);
	}

	public void setupSlantedCorners() {
		// wsc = new WoodenSlantedCorner(this, "Wooden Slanted Corner", texture,
		// wood);
		// csc = new CobbleSlantedCorner(this, "Cobblestone Slanted Corner",
		// texture, cobble);
		// glsc = new GlassSlantedCorner(this, "Glass Slanted Corner", texture,
		// glass);
		// sssc = new SandstoneSlantedCorner(this, "Sandstone Slanted Corner",
		// texture, sandstone);
		// dirsc = new DirtSlantedCorner(this, "Dirt Slanted Corner", texture,
		// dirt);
		// stsc = new StoneSlantedCorner(this, "Stone Slanted Corner", texture,
		// stone);
		// sasc = new SandSlantedCorner(this, "Sand Slanted Corner", texture,
		// sand);
		// snsc = new SnowSlantedCorner(this, "Snow Slanted Corner", texture,
		// snow);
		// grassc = new GrassSlantedCorner(this, "Grass Slanted Corner",
		// texture, grass);
		// bsc = new BricksSlantedCorner(this, "Bricks Slanted Corner", texture,
		// bricks);
		// gravsc = new GravelSlantedCorner(this, "Gravel Slanted Corner",
		// texture, gravel);
		// gosc = new GoldSlantedCorner(this, "Gold Slanted Corner", texture,
		// gold);
		// isc = new IronSlantedCorner(this, "Iron Slanted Corner", texture,
		// iron);
		// osc = new ObsidianSlantedCorner(this, "Obisidian Slanted Corner",
		// texture, obsidian);
		// diasc = new DiamondSlantedCorner(this, "Diamond Slanted Corner",
		// texture, diamond);
		// nsc = new NetherbrickSlantedCorner(this,
		// "Netherbrick Slanted Corner", texture, netherbrick);
	}

	public void setupCeilingSlantedCorners() {
		// wcsc = new WoodenCeilingSlantedCorner(this,
		// "Wooden Ceiling Slanted Corner", texture, wood);
		// ccsc = new CobbleCeilingSlantedCorner(this,
		// "Cobblestone Ceiling Slanted Corner", texture, cobble);
		// glcsc = new GlassCeilingSlantedCorner(this,
		// "Glass Ceiling Slanted Corner", texture, glass);
		// sscsc = new SandstoneCeilingSlantedCorner(this,
		// "Sandstone Ceiling Slanted Corner", texture, sandstone);
		// dircsc = new DirtCeilingSlantedCorner(this,
		// "Dirt Ceiling Slanted Corner", texture, dirt);
		// stcsc = new StoneCeilingSlantedCorner(this,
		// "Stone Ceiling Slanted Corner", texture, stone);
		// sacsc = new SandCeilingSlantedCorner(this,
		// "Sand Ceiling Slanted Corner", texture, sand);
		// sncsc = new SnowCeilingSlantedCorner(this,
		// "Snow Ceiling Slanted Corner", texture, snow);
		// grascsc = new GrassCeilingSlantedCorner(this,
		// "Grass Ceiling Slanted Corner", texture, grass);
		// bcsc = new BricksCeilingSlantedCorner(this,
		// "Bricks Ceiling Slanted Corner", texture, bricks);
		// gravcsc = new GravelCeilingSlantedCorner(this,
		// "Gravel Ceiling Slanted Corner", texture, gravel);
		// gocsc = new GoldCeilingSlantedCorner(this,
		// "Gold Ceiling Slanted Corner", texture, gold);
		// icsc = new IronCeilingSlantedCorner(this,
		// "Iron Ceiling Slanted Corner", texture, iron);
		// ocsc = new ObsidianCeilingSlantedCorner(this,
		// "Obisidian Ceiling Slanted Corner", texture, obsidian);
		// diacsc = new DiamondCeilingSlantedCorner(this,
		// "Diamond Ceiling Slanted Corner", texture, diamond);
		// ncsc = new NetherbrickCeilingSlantedCorner(this,
		// "Netherbrick Ceiling Slanted Corner", texture, netherbrick);
	}

	public void setupObliqueSlopes() {
		// wos = new WoodenObliqueSlope(this, "Wooden Oblique Slope", texture,
		// wood);
		// cos = new CobbleObliqueSlope(this, "Cobblestone Oblique Slope",
		// texture, cobble);
		// glos = new GlassObliqueSlope(this, "Glass Oblique Slope", texture,
		// glass);
		// ssos = new SandstoneObliqueSlope(this, "Sandstone Oblique Slope",
		// texture, sandstone);
		// diros = new DirtObliqueSlope(this, "Dirt Oblique Slope", texture,
		// dirt);
		// stos = new StoneObliqueSlope(this, "Stone Oblique Slope", texture,
		// stone);
		// saos = new SandObliqueSlope(this, "Sand Oblique Slope", texture,
		// sand);
		// snos = new SnowObliqueSlope(this, "Snow Oblique Slope", texture,
		// snow);
		// grasos = new GrassObliqueSlope(this, "Grass Oblique Slope", texture,
		// grass);
		// bos = new BricksObliqueSlope(this, "Bricks Oblique Slope", texture,
		// bricks);
		// gravos = new GravelObliqueSlope(this, "Gravel Oblique Slope",
		// texture, gravel);
		// goos = new GoldObliqueSlope(this, "Gold Oblique Slope", texture,
		// gold);
		// ios = new IronObliqueSlope(this, "Iron Oblique Slope", texture,
		// iron);
		// oos = new ObsidianObliqueSlope(this, "Obisidian Oblique Slope",
		// texture, obsidian);
		// diaos = new DiamondObliqueSlope(this, "Diamond Oblique Slope",
		// texture, diamond);
		// nos = new NetherbrickObliqueSlope(this, "Netherbrick Oblique Slope",
		// texture, netherbrick);
	}

	public void setupInvertedObliqueSlopes() {
		// wios = new WoodenInvertedObliqueSlope(this,
		// "Wooden Inverted Oblique Slope", texture, wood);
		// cios = new CobbleInvertedObliqueSlope(this,
		// "Cobblestone Inverted Oblique Slope", texture, cobble);
		// glios = new GlassInvertedObliqueSlope(this,
		// "Glass Inverted Oblique Slope", texture, glass);
		// ssios = new SandstoneInvertedObliqueSlope(this,
		// "Sandstone Inverted Oblique Slope", texture, sandstone);
		// dirios = new DirtInvertedObliqueSlope(this,
		// "Dirt Inverted Oblique Slope", texture, dirt);
		// stios = new StoneInvertedObliqueSlope(this,
		// "Stone Inverted Oblique Slope", texture, stone);
		// saios = new SandInvertedObliqueSlope(this,
		// "Sand Inverted Oblique Slope", texture, sand);
		// snios = new SnowInvertedObliqueSlope(this,
		// "Snow Inverted Oblique Slope", texture, snow);
		// grasios = new GrassInvertedObliqueSlope(this,
		// "Grass Inverted Oblique Slope", texture, grass);
		// bios = new BricksInvertedObliqueSlope(this,
		// "Bricks Inverted Oblique Slope", texture, bricks);
		// gravios = new GravelInvertedObliqueSlope(this,
		// "Gravel Inverted Oblique Slope", texture, gravel);
		// goios = new GoldInvertedObliqueSlope(this,
		// "Gold Inverted Oblique Slope", texture, gold);
		// iios = new IronInvertedObliqueSlope(this,
		// "Iron Inverted Oblique Slope", texture, iron);
		// oios = new ObsidianInvertedObliqueSlope(this,
		// "Obisidian Inverted Oblique Slope", texture, obsidian);
		// diaios = new DiamondInvertedObliqueSlope(this,
		// "Diamond Inverted Oblique Slope", texture, diamond);
		// nios = new NetherbrickInvertedObliqueSlope(this,
		// "Netherbrick Inverted Oblique Slope", texture, netherbrick);
	}

	public void setupSlopesIntersections() {
		// wsi = new WoodenSlopesIntersection(this,
		// "Wooden SlopesPlugin Intersection", texture, wood);
		// csi = new CobbleSlopesIntersection(this,
		// "Cobblestone SlopesPlugin Intersection", texture, cobble);
		// glsi = new GlassSlopesIntersection(this,
		// "Glass SlopesPlugin Intersection", texture, glass);
		// sssi = new SandstoneSlopesIntersection(this,
		// "Sandstone SlopesPlugin Intersection", texture, sandstone);
		// dirsi = new DirtSlopesIntersection(this,
		// "Dirt SlopesPlugin Intersection", texture, dirt);
		// stsi = new StoneSlopesIntersection(this,
		// "Stone SlopesPlugin Intersection", texture, stone);
		// sasi = new SandSlopesIntersection(this,
		// "Sand SlopesPlugin Intersection", texture, sand);
		// snsi = new SnowSlopesIntersection(this,
		// "Snow SlopesPlugin Intersection", texture, snow);
		// grassi = new GrassSlopesIntersection(this,
		// "Grass SlopesPlugin Intersection", texture, grass);
		// bsi = new BricksSlopesIntersection(this,
		// "Bricks SlopesPlugin Intersection", texture, bricks);
		// gravsi = new GravelSlopesIntersection(this,
		// "Gravel SlopesPlugin Intersection", texture, gravel);
		// gosi = new GoldSlopesIntersection(this,
		// "Gold SlopesPlugin Intersection", texture, gold);
		// isi = new IronSlopesIntersection(this,
		// "Iron SlopesPlugin Intersection", texture, iron);
		// osi = new ObsidianSlopesIntersection(this,
		// "Obisidian SlopesPlugin Intersection", texture, obsidian);
		// diasi = new DiamondSlopesIntersection(this,
		// "Diamond SlopesPlugin Intersection", texture, diamond);
		// nsi = new NetherbrickSlopesIntersection(this,
		// "Netherbrick SlopesPlugin Intersection", texture, netherbrick);
	}

	public void setupInvertedSlopesIntersections() {
		// wisi = new WoodenInvertedSlopesIntersection(this,
		// "Wooden Inverted SlopesPlugin Intersection", texture, wood);
		// cisi = new CobbleInvertedSlopesIntersection(this,
		// "Cobblestone Inverted SlopesPlugin Intersection", texture, cobble);
		// glisi = new GlassInvertedSlopesIntersection(this,
		// "Glass Inverted SlopesPlugin Intersection", texture, glass);
		// ssisi = new SandstoneInvertedSlopesIntersection(this,
		// "Sandstone Inverted SlopesPlugin Intersection", texture, sandstone);
		// dirisi = new DirtInvertedSlopesIntersection(this,
		// "Dirt Inverted SlopesPlugin Intersection", texture, dirt);
		// stisi = new StoneInvertedSlopesIntersection(this,
		// "Stone Inverted SlopesPlugin Intersection", texture, stone);
		// saisi = new SandInvertedSlopesIntersection(this,
		// "Sand Inverted SlopesPlugin Intersection", texture, sand);
		// snisi = new SnowInvertedSlopesIntersection(this,
		// "Snow Inverted SlopesPlugin Intersection", texture, snow);
		// grasisi = new GrassInvertedSlopesIntersection(this,
		// "Grass Inverted SlopesPlugin Intersection", texture, grass);
		// bisi = new BricksInvertedSlopesIntersection(this,
		// "Bricks Inverted SlopesPlugin Intersection", texture, bricks);
		// gravisi = new GravelInvertedSlopesIntersection(this,
		// "Gravel Inverted SlopesPlugin Intersection", texture, gravel);
		// goisi = new GoldInvertedSlopesIntersection(this,
		// "Gold Inverted SlopesPlugin Intersection", texture, gold);
		// iisi = new IronInvertedSlopesIntersection(this,
		// "Iron Inverted SlopesPlugin Intersection", texture, iron);
		// oisi = new ObsidianInvertedSlopesIntersection(this,
		// "Obisidian Inverted SlopesPlugin Intersection", texture, obsidian);
		// diaisi = new DiamondInvertedSlopesIntersection(this,
		// "Diamond Inverted SlopesPlugin Intersection", texture, diamond);
		// nisi = new NetherbrickInvertedSlopesIntersection(this,
		// "Netherbrick Inverted SlopesPlugin Intersection", texture,
		// netherbrick);
	}

	public void setupSlopedCeilingRecipes() {
		// final ItemStack wscis = new SpoutItemStack(wsc, 4);
		// final SpoutShapedRecipe wscr = new SpoutShapedRecipe(wscis);
		// wscr.shape("AAA", " A ", "  A");
		// wscr.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wscr);
		//
		// final ItemStack cscis = new SpoutItemStack(csc, 4);
		// final SpoutShapedRecipe cscr = new SpoutShapedRecipe(cscis);
		// cscr.shape("AAA", " A ", "  A");
		// cscr.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(cscr);
		//
		// final ItemStack glscis = new SpoutItemStack(glsc, 4);
		// final SpoutShapedRecipe glscr = new SpoutShapedRecipe(glscis);
		// glscr.shape("AAA", " A ", "  A");
		// glscr.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(glscr);
		//
		// final ItemStack ssscis = new SpoutItemStack(sssc, 4);
		// final SpoutShapedRecipe ssscr = new SpoutShapedRecipe(ssscis);
		// ssscr.shape("AAA", " A ", "  A");
		// ssscr.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ssscr);
		//
		// final ItemStack dirscis = new SpoutItemStack(dirsc, 4);
		// final SpoutShapedRecipe dirscr = new SpoutShapedRecipe(dirscis);
		// dirscr.shape("AAA", " A ", "  A");
		// dirscr.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(dirscr);
		//
		// final ItemStack stscis = new SpoutItemStack(stsc, 4);
		// final SpoutShapedRecipe stscr = new SpoutShapedRecipe(stscis);
		// stscr.shape("AAA", " A ", "  A");
		// stscr.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stscr);
		//
		// final ItemStack sascis = new SpoutItemStack(sasc, 4);
		// final SpoutShapedRecipe sascr = new SpoutShapedRecipe(sascis);
		// sascr.shape("AAA", " A ", "  A");
		// sascr.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sascr);
		//
		// final ItemStack snscis = new SpoutItemStack(snsc, 4);
		// final SpoutShapedRecipe snscr = new SpoutShapedRecipe(snscis);
		// snscr.shape("AAA", " A ", "  A");
		// snscr.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(snscr);
		//
		// final ItemStack grasscis = new SpoutItemStack(grassc, 4);
		// final SpoutShapedRecipe grasscr = new SpoutShapedRecipe(grasscis);
		// grasscr.shape("AAA", " A ", "  A");
		// grasscr.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grasscr);
		//
		// final ItemStack bscis = new SpoutItemStack(bsc, 4);
		// final SpoutShapedRecipe bscr = new SpoutShapedRecipe(bscis);
		// bscr.shape("AAA", " A ", "  A");
		// bscr.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(bscr);
		//
		// final ItemStack gravscis = new SpoutItemStack(gravsc, 4);
		// final SpoutShapedRecipe gravscr = new SpoutShapedRecipe(gravscis);
		// gravscr.shape("AAA", " A ", "  A");
		// gravscr.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gravscr);
		//
		// final ItemStack goscis = new SpoutItemStack(gosc, 4);
		// final SpoutShapedRecipe goscr = new SpoutShapedRecipe(goscis);
		// goscr.shape("AAA", " A ", "  A");
		// goscr.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(goscr);
		//
		// final ItemStack iscis = new SpoutItemStack(isc, 4);
		// final SpoutShapedRecipe iscr = new SpoutShapedRecipe(iscis);
		// iscr.shape("AAA", " A ", "  A");
		// iscr.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(iscr);
		//
		// final ItemStack oscis = new SpoutItemStack(osc, 4);
		// final SpoutShapedRecipe oscr = new SpoutShapedRecipe(oscis);
		// oscr.shape("AAA", " A ", "  A");
		// oscr.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(oscr);
		//
		// final ItemStack diascis = new SpoutItemStack(diasc, 4);
		// final SpoutShapedRecipe diascr = new SpoutShapedRecipe(diascis);
		// diascr.shape("AAA", " A ", "  A");
		// diascr.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diascr);
		//
		// final ItemStack nscis = new SpoutItemStack(nsc, 4);
		// final SpoutShapedRecipe nscr = new SpoutShapedRecipe(nscis);
		// nscr.shape("AAA", " A ", "  A");
		// nscr.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(nscr);
	}

	public void setupSlopedAngleRecipes() {
		// final ItemStack wsais = new SpoutItemStack(wsa, 4);
		// final SpoutShapedRecipe wsar = new SpoutShapedRecipe(wsais);
		// wsar.shape(" A ", "AAA");
		// wsar.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wsar);
		//
		// final ItemStack csais = new SpoutItemStack(csa, 4);
		// final SpoutShapedRecipe csar = new SpoutShapedRecipe(csais);
		// csar.shape(" A ", "AAA");
		// csar.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(csar);
		//
		// final ItemStack glsais = new SpoutItemStack(glsa, 4);
		// final SpoutShapedRecipe glsar = new SpoutShapedRecipe(glsais);
		// glsar.shape(" A ", "AAA");
		// glsar.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(glsar);
		//
		// final ItemStack sssais = new SpoutItemStack(sssa, 4);
		// final SpoutShapedRecipe sssar = new SpoutShapedRecipe(sssais);
		// sssar.shape(" A ", "AAA");
		// sssar.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sssar);
		//
		// final ItemStack dirsais = new SpoutItemStack(dirsa, 4);
		// final SpoutShapedRecipe dirsar = new SpoutShapedRecipe(dirsais);
		// dirsar.shape(" A ", "AAA");
		// dirsar.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(dirsar);
		//
		// final ItemStack stsais = new SpoutItemStack(stsa, 4);
		// final SpoutShapedRecipe stsar = new SpoutShapedRecipe(stsais);
		// stsar.shape(" A ", "AAA");
		// stsar.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stsar);
		//
		// final ItemStack sasais = new SpoutItemStack(sasa, 4);
		// final SpoutShapedRecipe sasar = new SpoutShapedRecipe(sasais);
		// sasar.shape(" A ", "AAA");
		// sasar.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sasar);
		//
		// final ItemStack snsais = new SpoutItemStack(snsa, 4);
		// final SpoutShapedRecipe snsar = new SpoutShapedRecipe(snsais);
		// snsar.shape(" A ", "AAA");
		// snsar.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(snsar);
		//
		// final ItemStack grassais = new SpoutItemStack(grassa, 4);
		// final SpoutShapedRecipe grassar = new SpoutShapedRecipe(grassais);
		// grassar.shape(" A ", "AAA");
		// grassar.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grassar);
		//
		// final ItemStack bsais = new SpoutItemStack(bsa, 4);
		// final SpoutShapedRecipe bsar = new SpoutShapedRecipe(bsais);
		// bsar.shape(" A ", "AAA");
		// bsar.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(bsar);
		//
		// final ItemStack gravsais = new SpoutItemStack(gravsa, 4);
		// final SpoutShapedRecipe gravsar = new SpoutShapedRecipe(gravsais);
		// gravsar.shape(" A ", "AAA");
		// gravsar.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gravsar);
		//
		// final ItemStack gosais = new SpoutItemStack(gosa, 4);
		// final SpoutShapedRecipe gosar = new SpoutShapedRecipe(gosais);
		// gosar.shape(" A ", "AAA");
		// gosar.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gosar);
		//
		// final ItemStack isais = new SpoutItemStack(isa, 4);
		// final SpoutShapedRecipe isar = new SpoutShapedRecipe(isais);
		// isar.shape(" A ", "AAA");
		// isar.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(isar);
		//
		// final ItemStack osais = new SpoutItemStack(osa, 4);
		// final SpoutShapedRecipe osar = new SpoutShapedRecipe(osais);
		// osar.shape(" A ", "AAA");
		// osar.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(osar);
		//
		// final ItemStack diasais = new SpoutItemStack(diasa, 4);
		// final SpoutShapedRecipe diasar = new SpoutShapedRecipe(diasais);
		// diasar.shape(" A ", "AAA");
		// diasar.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diasar);
		//
		// final ItemStack nsais = new SpoutItemStack(nsa, 4);
		// final SpoutShapedRecipe nsar = new SpoutShapedRecipe(nsais);
		// nsar.shape(" A ", "AAA");
		// nsar.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(nsar);
	}

	public void setupCeilingAngleRecipes() {
		// final ItemStack wcais = new SpoutItemStack(wca, 4);
		// final SpoutShapedRecipe wcar = new SpoutShapedRecipe(wcais);
		// wcar.shape("AAA", " A ");
		// wcar.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wcar);
		//
		// final ItemStack ccais = new SpoutItemStack(cca, 4);
		// final SpoutShapedRecipe ccar = new SpoutShapedRecipe(ccais);
		// ccar.shape("AAA", " A ");
		// ccar.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ccar);
		//
		// final ItemStack glcais = new SpoutItemStack(glca, 4);
		// final SpoutShapedRecipe glcar = new SpoutShapedRecipe(glcais);
		// glcar.shape("AAA", " A ");
		// glcar.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(glcar);
		//
		// final ItemStack sscais = new SpoutItemStack(ssca, 4);
		// final SpoutShapedRecipe sscar = new SpoutShapedRecipe(sscais);
		// sscar.shape("AAA", " A ");
		// sscar.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sscar);
		//
		// final ItemStack dircais = new SpoutItemStack(dirca, 4);
		// final SpoutShapedRecipe dircar = new SpoutShapedRecipe(dircais);
		// dircar.shape("AAA", " A ");
		// dircar.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(dircar);
		//
		// final ItemStack stcais = new SpoutItemStack(stca, 4);
		// final SpoutShapedRecipe stcar = new SpoutShapedRecipe(stcais);
		// stcar.shape("AAA", " A ");
		// stcar.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stcar);
		//
		// final ItemStack sacais = new SpoutItemStack(saca, 4);
		// final SpoutShapedRecipe sacar = new SpoutShapedRecipe(sacais);
		// sacar.shape("AAA", " A ");
		// sacar.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sacar);
		//
		// final ItemStack sncais = new SpoutItemStack(snca, 4);
		// final SpoutShapedRecipe sncar = new SpoutShapedRecipe(sncais);
		// sncar.shape("AAA", " A ");
		// sncar.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sncar);
		//
		// final ItemStack grascais = new SpoutItemStack(grasca, 4);
		// final SpoutShapedRecipe grascar = new SpoutShapedRecipe(grascais);
		// grascar.shape("AAA", " A ");
		// grascar.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grascar);
		//
		// final ItemStack bcais = new SpoutItemStack(bca, 4);
		// final SpoutShapedRecipe bcar = new SpoutShapedRecipe(bcais);
		// bcar.shape("AAA", " A ");
		// bcar.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(bcar);
		//
		// final ItemStack gravcais = new SpoutItemStack(gravca, 4);
		// final SpoutShapedRecipe gravcar = new SpoutShapedRecipe(gravcais);
		// gravcar.shape("AAA", " A ");
		// gravcar.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gravcar);
		//
		// final ItemStack gocais = new SpoutItemStack(goca, 4);
		// final SpoutShapedRecipe gocar = new SpoutShapedRecipe(gocais);
		// gocar.shape("AAA", " A ");
		// gocar.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gocar);
		//
		// final ItemStack icais = new SpoutItemStack(ica, 4);
		// final SpoutShapedRecipe icar = new SpoutShapedRecipe(icais);
		// icar.shape("AAA", " A ");
		// icar.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(icar);
		//
		// final ItemStack ocais = new SpoutItemStack(oca, 4);
		// final SpoutShapedRecipe ocar = new SpoutShapedRecipe(ocais);
		// ocar.shape("AAA", " A ");
		// ocar.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ocar);
		//
		// final ItemStack diacais = new SpoutItemStack(diaca, 4);
		// final SpoutShapedRecipe diacar = new SpoutShapedRecipe(diacais);
		// diacar.shape("AAA", " A ");
		// diacar.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diacar);
		//
		// final ItemStack ncais = new SpoutItemStack(nca, 4);
		// final SpoutShapedRecipe ncar = new SpoutShapedRecipe(ncais);
		// ncar.shape("AAA", " A ");
		// ncar.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ncar);
	}

	public void setupSlantedCornerRecipes() {
		// final ItemStack wscis = new SpoutItemStack(wsc, 4);
		// final SpoutShapedRecipe wscr = new SpoutShapedRecipe(wscis);
		// wscr.shape("AAA", " A ", "  A");
		// wscr.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wscr);
		//
		// final ItemStack cscis = new SpoutItemStack(csc, 4);
		// final SpoutShapedRecipe cscr = new SpoutShapedRecipe(cscis);
		// cscr.shape("AAA", " A ", "  A");
		// cscr.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(cscr);
		//
		// final ItemStack glscis = new SpoutItemStack(glsc, 4);
		// final SpoutShapedRecipe glscr = new SpoutShapedRecipe(glscis);
		// glscr.shape("AAA", " A ", "  A");
		// glscr.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(glscr);
		//
		// final ItemStack ssscis = new SpoutItemStack(sssc, 4);
		// final SpoutShapedRecipe ssscr = new SpoutShapedRecipe(ssscis);
		// ssscr.shape("AAA", " A ", "  A");
		// ssscr.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ssscr);
		//
		// final ItemStack dirscis = new SpoutItemStack(dirsc, 4);
		// final SpoutShapedRecipe dirscr = new SpoutShapedRecipe(dirscis);
		// dirscr.shape("AAA", " A ", "  A");
		// dirscr.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(dirscr);
		//
		// final ItemStack stscis = new SpoutItemStack(stsc, 4);
		// final SpoutShapedRecipe stscr = new SpoutShapedRecipe(stscis);
		// stscr.shape("AAA", " A ", "  A");
		// stscr.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stscr);
		//
		// final ItemStack sascis = new SpoutItemStack(sasc, 4);
		// final SpoutShapedRecipe sascr = new SpoutShapedRecipe(sascis);
		// sascr.shape("AAA", " A ", "  A");
		// sascr.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sascr);
		//
		// final ItemStack snscis = new SpoutItemStack(snsc, 4);
		// final SpoutShapedRecipe snscr = new SpoutShapedRecipe(snscis);
		// snscr.shape("AAA", " A ", "  A");
		// snscr.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(snscr);
		//
		// final ItemStack grasscis = new SpoutItemStack(grassc, 4);
		// final SpoutShapedRecipe grasscr = new SpoutShapedRecipe(grasscis);
		// grasscr.shape("AAA", " A ", "  A");
		// grasscr.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grasscr);
		//
		// final ItemStack bscis = new SpoutItemStack(bsc, 4);
		// final SpoutShapedRecipe bscr = new SpoutShapedRecipe(bscis);
		// bscr.shape("AAA", " A ", "  A");
		// bscr.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(bscr);
		//
		// final ItemStack gravscis = new SpoutItemStack(gravsc, 4);
		// final SpoutShapedRecipe gravscr = new SpoutShapedRecipe(gravscis);
		// gravscr.shape("AAA", " A ", "  A");
		// gravscr.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gravscr);
		//
		// final ItemStack goscis = new SpoutItemStack(gosc, 4);
		// final SpoutShapedRecipe goscr = new SpoutShapedRecipe(goscis);
		// goscr.shape("AAA", " A ", "  A");
		// goscr.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(goscr);
		//
		// final ItemStack iscis = new SpoutItemStack(isc, 4);
		// final SpoutShapedRecipe iscr = new SpoutShapedRecipe(iscis);
		// iscr.shape("AAA", " A ", "  A");
		// iscr.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(iscr);
		//
		// final ItemStack oscis = new SpoutItemStack(osc, 4);
		// final SpoutShapedRecipe oscr = new SpoutShapedRecipe(oscis);
		// oscr.shape("AAA", " A ", "  A");
		// oscr.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(oscr);
		//
		// final ItemStack diascis = new SpoutItemStack(diasc, 4);
		// final SpoutShapedRecipe diascr = new SpoutShapedRecipe(diascis);
		// diascr.shape("AAA", " A ", "  A");
		// diascr.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diascr);
		//
		// final ItemStack nscis = new SpoutItemStack(nsc, 4);
		// final SpoutShapedRecipe nscr = new SpoutShapedRecipe(nscis);
		// nscr.shape("AAA", " A ", "  A");
		// nscr.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(nscr);
	}

	public void setupCeilingSlantedCornerRecipes() {
		// final ItemStack wcscis = new SpoutItemStack(wcsc, 4);
		// final SpoutShapedRecipe wcscr = new SpoutShapedRecipe(wcscis);
		// wcscr.shape("AAA", " A ", " A ");
		// wcscr.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wcscr);
		//
		// final ItemStack ccscis = new SpoutItemStack(ccsc, 4);
		// final SpoutShapedRecipe ccscr = new SpoutShapedRecipe(ccscis);
		// ccscr.shape("AAA", " A ", " A ");
		// ccscr.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ccscr);
		//
		// final ItemStack glcscis = new SpoutItemStack(glcsc, 4);
		// final SpoutShapedRecipe glcscr = new SpoutShapedRecipe(glcscis);
		// glcscr.shape("AAA", " A ", " A ");
		// glcscr.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(glcscr);
		//
		// final ItemStack sscscis = new SpoutItemStack(sscsc, 4);
		// final SpoutShapedRecipe sscscr = new SpoutShapedRecipe(sscscis);
		// sscscr.shape("AAA", " A ", " A ");
		// sscscr.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sscscr);
		//
		// final ItemStack dircscis = new SpoutItemStack(dircsc, 4);
		// final SpoutShapedRecipe dircscr = new SpoutShapedRecipe(dircscis);
		// dircscr.shape("AAA", " A ", " A ");
		// dircscr.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(dircscr);
		//
		// final ItemStack stcscis = new SpoutItemStack(stcsc, 4);
		// final SpoutShapedRecipe stcscr = new SpoutShapedRecipe(stcscis);
		// stcscr.shape("AAA", " A ", " A ");
		// stcscr.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stcscr);
		//
		// final ItemStack sacscis = new SpoutItemStack(sacsc, 4);
		// final SpoutShapedRecipe sacscr = new SpoutShapedRecipe(sacscis);
		// sacscr.shape("AAA", " A ", " A ");
		// sacscr.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sacscr);
		//
		// final ItemStack sncscis = new SpoutItemStack(sncsc, 4);
		// final SpoutShapedRecipe sncscr = new SpoutShapedRecipe(sncscis);
		// sncscr.shape("AAA", " A ", " A ");
		// sncscr.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sncscr);
		//
		// final ItemStack grascscis = new SpoutItemStack(grascsc, 4);
		// final SpoutShapedRecipe grascscr = new SpoutShapedRecipe(grascscis);
		// grascscr.shape("AAA", " A ", " A ");
		// grascscr.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grascscr);
		//
		// final ItemStack bcscis = new SpoutItemStack(bcsc, 4);
		// final SpoutShapedRecipe bcscr = new SpoutShapedRecipe(bcscis);
		// bcscr.shape("AAA", " A ", " A ");
		// bcscr.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(bcscr);
		//
		// final ItemStack gravcscis = new SpoutItemStack(gravcsc, 4);
		// final SpoutShapedRecipe gravcscr = new SpoutShapedRecipe(gravcscis);
		// gravcscr.shape("AAA", " A ", " A ");
		// gravcscr.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gravcscr);
		//
		// final ItemStack gocscis = new SpoutItemStack(gocsc, 4);
		// final SpoutShapedRecipe gocscr = new SpoutShapedRecipe(gocscis);
		// gocscr.shape("AAA", " A ", " A ");
		// gocscr.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gocscr);
		//
		// final ItemStack icscis = new SpoutItemStack(icsc, 4);
		// final SpoutShapedRecipe icscr = new SpoutShapedRecipe(icscis);
		// icscr.shape("AAA", " A ", " A ");
		// icscr.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(icscr);
		//
		// final ItemStack ocscis = new SpoutItemStack(ocsc, 4);
		// final SpoutShapedRecipe ocscr = new SpoutShapedRecipe(ocscis);
		// ocscr.shape("AAA", " A ", " A ");
		// ocscr.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ocscr);
		//
		// final ItemStack diacscis = new SpoutItemStack(diacsc, 4);
		// final SpoutShapedRecipe diacscr = new SpoutShapedRecipe(diacscis);
		// diacscr.shape("AAA", " A ", " A ");
		// diacscr.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diacscr);
		//
		// final ItemStack ncscis = new SpoutItemStack(ncsc, 4);
		// final SpoutShapedRecipe ncscr = new SpoutShapedRecipe(ncscis);
		// ncscr.shape("AAA", " A ", " A ");
		// ncscr.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ncscr);
	}

	public void setupObliqueSlopeRecipes() {
		// final ItemStack wosis = new SpoutItemStack(wos, 4);
		// final SpoutShapedRecipe wosr = new SpoutShapedRecipe(wosis);
		// wosr.shape("  A", "AAA");
		// wosr.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wosr);
		//
		// final ItemStack cosis = new SpoutItemStack(cos, 4);
		// final SpoutShapedRecipe cosr = new SpoutShapedRecipe(cosis);
		// cosr.shape("  A", "AAA");
		// cosr.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(cosr);
		//
		// final ItemStack glosis = new SpoutItemStack(glos, 4);
		// final SpoutShapedRecipe glosr = new SpoutShapedRecipe(glosis);
		// glosr.shape("  A", "AAA");
		// glosr.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(glosr);
		//
		// final ItemStack ssosis = new SpoutItemStack(ssos, 4);
		// final SpoutShapedRecipe ssosr = new SpoutShapedRecipe(ssosis);
		// ssosr.shape("  A", "AAA");
		// ssosr.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ssosr);
		//
		// final ItemStack dirosis = new SpoutItemStack(diros, 4);
		// final SpoutShapedRecipe dirosr = new SpoutShapedRecipe(dirosis);
		// dirosr.shape("  A", "AAA");
		// dirosr.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(dirosr);
		//
		// final ItemStack stosis = new SpoutItemStack(stos, 4);
		// final SpoutShapedRecipe stosr = new SpoutShapedRecipe(stosis);
		// stosr.shape("  A", "AAA");
		// stosr.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stosr);
		//
		// final ItemStack saosis = new SpoutItemStack(saos, 4);
		// final SpoutShapedRecipe saosr = new SpoutShapedRecipe(saosis);
		// saosr.shape("  A", "AAA");
		// saosr.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(saosr);
		//
		// final ItemStack snosis = new SpoutItemStack(snos, 4);
		// final SpoutShapedRecipe snosr = new SpoutShapedRecipe(snosis);
		// snosr.shape("  A", "AAA");
		// snosr.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(snosr);
		//
		// final ItemStack grasosis = new SpoutItemStack(grasos, 4);
		// final SpoutShapedRecipe grasosr = new SpoutShapedRecipe(grasosis);
		// grasosr.shape("  A", "AAA");
		// grasosr.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grasosr);
		//
		// final ItemStack bosis = new SpoutItemStack(bos, 4);
		// final SpoutShapedRecipe bosr = new SpoutShapedRecipe(bosis);
		// bosr.shape("  A", "AAA");
		// bosr.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(bosr);
		//
		// final ItemStack gravosis = new SpoutItemStack(gravos, 4);
		// final SpoutShapedRecipe gravosr = new SpoutShapedRecipe(gravosis);
		// gravosr.shape("  A", "AAA");
		// gravosr.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gravosr);
		//
		// final ItemStack goosis = new SpoutItemStack(goos, 4);
		// final SpoutShapedRecipe goosr = new SpoutShapedRecipe(goosis);
		// goosr.shape("  A", "AAA");
		// goosr.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(goosr);
		//
		// final ItemStack iosis = new SpoutItemStack(ios, 4);
		// final SpoutShapedRecipe iosr = new SpoutShapedRecipe(iosis);
		// iosr.shape("  A", "AAA");
		// iosr.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(iosr);
		//
		// final ItemStack oosis = new SpoutItemStack(oos, 4);
		// final SpoutShapedRecipe oosr = new SpoutShapedRecipe(oosis);
		// oosr.shape("  A", "AAA");
		// oosr.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(oosr);
		//
		// final ItemStack diaosis = new SpoutItemStack(diaos, 4);
		// final SpoutShapedRecipe diaosr = new SpoutShapedRecipe(diaosis);
		// diaosr.shape("  A", "AAA");
		// diaosr.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diaosr);
		//
		// final ItemStack nosis = new SpoutItemStack(nos, 4);
		// final SpoutShapedRecipe nosr = new SpoutShapedRecipe(nosis);
		// nosr.shape("  A", "AAA");
		// nosr.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(nosr);
	}

	public void setupInvertedObliqueSlopeRecipes() {
		// final ItemStack wiosis = new SpoutItemStack(wios, 4);
		// final SpoutShapedRecipe wiosr = new SpoutShapedRecipe(wiosis);
		// wiosr.shape("AAA", "  A");
		// wiosr.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wiosr);
		//
		// final ItemStack ciosis = new SpoutItemStack(cios, 4);
		// final SpoutShapedRecipe ciosr = new SpoutShapedRecipe(ciosis);
		// ciosr.shape("AAA", "  A");
		// ciosr.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ciosr);
		//
		// final ItemStack gliosis = new SpoutItemStack(glios, 4);
		// final SpoutShapedRecipe gliosr = new SpoutShapedRecipe(gliosis);
		// gliosr.shape("AAA", "  A");
		// gliosr.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gliosr);
		//
		// final ItemStack ssiosis = new SpoutItemStack(ssios, 4);
		// final SpoutShapedRecipe ssiosr = new SpoutShapedRecipe(ssiosis);
		// ssiosr.shape("AAA", "  A");
		// ssiosr.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ssiosr);
		//
		// final ItemStack diriosis = new SpoutItemStack(dirios, 4);
		// final SpoutShapedRecipe diriosr = new SpoutShapedRecipe(diriosis);
		// diriosr.shape("AAA", "  A");
		// diriosr.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diriosr);
		//
		// final ItemStack stiosis = new SpoutItemStack(stios, 4);
		// final SpoutShapedRecipe stiosr = new SpoutShapedRecipe(stiosis);
		// stiosr.shape("AAA", "  A");
		// stiosr.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stiosr);
		//
		// final ItemStack saiosis = new SpoutItemStack(saios, 4);
		// final SpoutShapedRecipe saiosr = new SpoutShapedRecipe(saiosis);
		// saiosr.shape("AAA", "  A");
		// saiosr.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(saiosr);
		//
		// final ItemStack sniosis = new SpoutItemStack(snios, 4);
		// final SpoutShapedRecipe sniosr = new SpoutShapedRecipe(sniosis);
		// sniosr.shape("AAA", "  A");
		// sniosr.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sniosr);
		//
		// final ItemStack grasiosis = new SpoutItemStack(grasios, 4);
		// final SpoutShapedRecipe grasiosr = new SpoutShapedRecipe(grasiosis);
		// grasiosr.shape("AAA", "  A");
		// grasiosr.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grasiosr);
		//
		// final ItemStack biosis = new SpoutItemStack(bios, 4);
		// final SpoutShapedRecipe biosr = new SpoutShapedRecipe(biosis);
		// biosr.shape("AAA", "  A");
		// biosr.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(biosr);
		//
		// final ItemStack graviosis = new SpoutItemStack(gravios, 4);
		// final SpoutShapedRecipe graviosr = new SpoutShapedRecipe(graviosis);
		// graviosr.shape("AAA", "  A");
		// graviosr.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(graviosr);
		//
		// final ItemStack goiosis = new SpoutItemStack(goios, 4);
		// final SpoutShapedRecipe goiosr = new SpoutShapedRecipe(goiosis);
		// goiosr.shape("AAA", "  A");
		// goiosr.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(goiosr);
		//
		// final ItemStack iiosis = new SpoutItemStack(iios, 4);
		// final SpoutShapedRecipe iiosr = new SpoutShapedRecipe(iiosis);
		// iiosr.shape("AAA", "  A");
		// iiosr.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(iiosr);
		//
		// final ItemStack oiosis = new SpoutItemStack(oios, 4);
		// final SpoutShapedRecipe oiosr = new SpoutShapedRecipe(oiosis);
		// oiosr.shape("AAA", "  A");
		// oiosr.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(oiosr);
		//
		// final ItemStack diaiosis = new SpoutItemStack(diaios, 4);
		// final SpoutShapedRecipe diaiosr = new SpoutShapedRecipe(diaiosis);
		// diaiosr.shape("AAA", "  A");
		// diaiosr.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diaiosr);
		//
		// final ItemStack niosis = new SpoutItemStack(nios, 4);
		// final SpoutShapedRecipe niosr = new SpoutShapedRecipe(niosis);
		// niosr.shape("AAA", "  A");
		// niosr.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(niosr);
	}

	public void setupSlopesIntersectionRecipes() {
		// final ItemStack wsiis = new SpoutItemStack(wsi, 4);
		// final SpoutShapedRecipe wsir = new SpoutShapedRecipe(wsiis);
		// wsir.shape("AA ", "A A");
		// wsir.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wsir);
		//
		// final ItemStack csiis = new SpoutItemStack(csi, 4);
		// final SpoutShapedRecipe csir = new SpoutShapedRecipe(csiis);
		// csir.shape("AA ", "A A");
		// csir.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(csir);
		//
		// final ItemStack glsiis = new SpoutItemStack(glsi, 4);
		// final SpoutShapedRecipe glsir = new SpoutShapedRecipe(glsiis);
		// glsir.shape("AA ", "A A");
		// glsir.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(glsir);
		//
		// final ItemStack sssiis = new SpoutItemStack(sssi, 4);
		// final SpoutShapedRecipe sssir = new SpoutShapedRecipe(sssiis);
		// sssir.shape("AA ", "A A");
		// sssir.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sssir);
		//
		// final ItemStack dirsiis = new SpoutItemStack(dirsi, 4);
		// final SpoutShapedRecipe dirsir = new SpoutShapedRecipe(dirsiis);
		// dirsir.shape("AA ", "A A");
		// dirsir.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(dirsir);
		//
		// final ItemStack stsiis = new SpoutItemStack(stsi, 4);
		// final SpoutShapedRecipe stsir = new SpoutShapedRecipe(stsiis);
		// stsir.shape("AA ", "A A");
		// stsir.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stsir);
		//
		// final ItemStack sasiis = new SpoutItemStack(sasi, 4);
		// final SpoutShapedRecipe sasir = new SpoutShapedRecipe(sasiis);
		// sasir.shape("AA ", "A A");
		// sasir.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(sasir);
		//
		// final ItemStack snsiis = new SpoutItemStack(snsi, 4);
		// final SpoutShapedRecipe snsir = new SpoutShapedRecipe(snsiis);
		// snsir.shape("AA ", "A A");
		// snsir.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(snsir);
		//
		// final ItemStack grassiis = new SpoutItemStack(grassi, 4);
		// final SpoutShapedRecipe grassir = new SpoutShapedRecipe(grassiis);
		// grassir.shape("AA ", "A A");
		// grassir.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grassir);
		//
		// final ItemStack bsiis = new SpoutItemStack(bsi, 4);
		// final SpoutShapedRecipe bsir = new SpoutShapedRecipe(bsiis);
		// bsir.shape("AA ", "A A");
		// bsir.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(bsir);
		//
		// final ItemStack gravsiis = new SpoutItemStack(gravsi, 4);
		// final SpoutShapedRecipe gravsir = new SpoutShapedRecipe(gravsiis);
		// gravsir.shape("AA ", "A A");
		// gravsir.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gravsir);
		//
		// final ItemStack gosiis = new SpoutItemStack(gosi, 4);
		// final SpoutShapedRecipe gosir = new SpoutShapedRecipe(gosiis);
		// gosir.shape("AA ", "A A");
		// gosir.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gosir);
		//
		// final ItemStack isiis = new SpoutItemStack(isi, 4);
		// final SpoutShapedRecipe isir = new SpoutShapedRecipe(isiis);
		// isir.shape("AA ", "A A");
		// isir.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(isir);
		//
		// final ItemStack osiis = new SpoutItemStack(osi, 4);
		// final SpoutShapedRecipe osir = new SpoutShapedRecipe(osiis);
		// osir.shape("AA ", "A A");
		// osir.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(osir);
		//
		// final ItemStack diasiis = new SpoutItemStack(diasi, 4);
		// final SpoutShapedRecipe diasir = new SpoutShapedRecipe(diasiis);
		// diasir.shape("AA ", "A A");
		// diasir.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diasir);
		//
		// final ItemStack nsiis = new SpoutItemStack(nsi, 4);
		// final SpoutShapedRecipe nsir = new SpoutShapedRecipe(nsiis);
		// nsir.shape("AA ", "A A");
		// nsir.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(nsir);
	}

	public void setupInvertedSlopesIntersectionRecipes() {
		// final ItemStack wisiis = new SpoutItemStack(wisi, 4);
		// final SpoutShapedRecipe wisir = new SpoutShapedRecipe(wisiis);
		// wisir.shape("A A", "AA ");
		// wisir.setIngredient('A', MaterialData.wood);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(wisir);
		//
		// final ItemStack cisiis = new SpoutItemStack(cisi, 4);
		// final SpoutShapedRecipe cisir = new SpoutShapedRecipe(cisiis);
		// cisir.shape("A A", "AA ");
		// cisir.setIngredient('A', MaterialData.cobblestone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(cisir);
		//
		// final ItemStack glisiis = new SpoutItemStack(glisi, 4);
		// final SpoutShapedRecipe glisir = new SpoutShapedRecipe(glisiis);
		// glisir.shape("A A", "AA ");
		// glisir.setIngredient('A', MaterialData.glass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(glisir);
		//
		// final ItemStack ssisiis = new SpoutItemStack(ssisi, 4);
		// final SpoutShapedRecipe ssisir = new SpoutShapedRecipe(ssisiis);
		// ssisir.shape("A A", "AA ");
		// ssisir.setIngredient('A', MaterialData.sandstone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(ssisir);
		//
		// final ItemStack dirisiis = new SpoutItemStack(dirisi, 4);
		// final SpoutShapedRecipe dirisir = new SpoutShapedRecipe(dirisiis);
		// dirisir.shape("A A", "AA ");
		// dirisir.setIngredient('A', MaterialData.dirt);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(dirisir);
		//
		// final ItemStack stisiis = new SpoutItemStack(stisi, 4);
		// final SpoutShapedRecipe stisir = new SpoutShapedRecipe(stisiis);
		// stisir.shape("A A", "AA ");
		// stisir.setIngredient('A', MaterialData.stone);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(stisir);
		//
		// final ItemStack saisiis = new SpoutItemStack(saisi, 4);
		// final SpoutShapedRecipe saisir = new SpoutShapedRecipe(saisiis);
		// saisir.shape("A A", "AA ");
		// saisir.setIngredient('A', MaterialData.sand);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(saisir);
		//
		// final ItemStack snisiis = new SpoutItemStack(snisi, 4);
		// final SpoutShapedRecipe snisir = new SpoutShapedRecipe(snisiis);
		// snisir.shape("A A", "AA ");
		// snisir.setIngredient('A', MaterialData.snow);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(snisir);
		//
		// final ItemStack grasisiis = new SpoutItemStack(grasisi, 4);
		// final SpoutShapedRecipe grasisir = new SpoutShapedRecipe(grasisiis);
		// grasisir.shape("A A", "AA ");
		// grasisir.setIngredient('A', MaterialData.grass);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(grasisir);
		//
		// final ItemStack bisiis = new SpoutItemStack(bisi, 4);
		// final SpoutShapedRecipe bisir = new SpoutShapedRecipe(bisiis);
		// bisir.shape("A A", "AA ");
		// bisir.setIngredient('A', MaterialData.brick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(bisir);
		//
		// final ItemStack gravisiis = new SpoutItemStack(gravisi, 4);
		// final SpoutShapedRecipe gravisir = new SpoutShapedRecipe(gravisiis);
		// gravisir.shape("A A", "AA ");
		// gravisir.setIngredient('A', MaterialData.gravel);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(gravisir);
		//
		// final ItemStack goisiis = new SpoutItemStack(goisi, 4);
		// final SpoutShapedRecipe goisir = new SpoutShapedRecipe(goisiis);
		// goisir.shape("A A", "AA ");
		// goisir.setIngredient('A', MaterialData.goldBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(goisir);
		//
		// final ItemStack iisiis = new SpoutItemStack(iisi, 4);
		// final SpoutShapedRecipe iisir = new SpoutShapedRecipe(iisiis);
		// iisir.shape("A A", "AA ");
		// iisir.setIngredient('A', MaterialData.ironBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(iisir);
		//
		// final ItemStack oisiis = new SpoutItemStack(oisi, 4);
		// final SpoutShapedRecipe oisir = new SpoutShapedRecipe(oisiis);
		// oisir.shape("A A", "AA ");
		// oisir.setIngredient('A', MaterialData.obsidian);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(oisir);
		//
		// final ItemStack diaisiis = new SpoutItemStack(diaisi, 4);
		// final SpoutShapedRecipe diaisir = new SpoutShapedRecipe(diaisiis);
		// diaisir.shape("A A", "AA ");
		// diaisir.setIngredient('A', MaterialData.diamondBlock);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(diaisir);
		//
		// final ItemStack nisiis = new SpoutItemStack(nisi, 4);
		// final SpoutShapedRecipe nisir = new SpoutShapedRecipe(nisiis);
		// nisir.shape("A A", "AA ");
		// nisir.setIngredient('A', MaterialData.netherBrick);
		// SpoutManager.getMaterialManager().registerSpoutRecipe(nisir);
	}
}
