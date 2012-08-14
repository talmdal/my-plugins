package com.timalmdal.bukkit.slopes.designers;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

import com.timalmdal.bukkit.slopes.util.QuadList;
import com.timalmdal.bukkit.slopes.util.SlopeSubTexture;

public class SlopeBlockDesign extends GenericBlockDesign {

	private final SubTexture subTexture;

	public SlopeBlockDesign(final Plugin plugin, final Texture texture, final SlopeSubTexture slopeTexture, final QuadList quadList) {
		super();
		setTexture(plugin, texture);
		setBoundingBox(.25f, 0f, .25f, .75f, .5f, .75f);
		subTexture = texture.getSubTexture(slopeTexture.getTextureIndex());

		setQuadNumber(quadList.size());
		quadList.generate(this, subTexture);

		setRenderPass(1);
	}
}
