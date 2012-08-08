package com.timalmdal.bukkit.slopes.designers;

import org.bukkit.block.BlockFace;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

import com.timalmdal.bukkit.slopes.util.QuadList;
import com.timalmdal.bukkit.slopes.util.SlopeSubTexture;

public class AbstractBlockDesign extends GenericBlockDesign {

	public static QuadList quadBuilder() {
		return new QuadList();
	}

	private final SubTexture subTexture;

	public AbstractBlockDesign(final Plugin plugin, final Texture texture, final SlopeSubTexture slopeTexture) {
		super();
		setTexture(plugin, texture);
		setBoundingBox(.25f, 0f, .25f, .75f, .5f, .75f);
		subTexture = texture.getSubTexture(slopeTexture.getTextureIndex());

		setRenderPass(1);
	}

	protected void setQuads(final BlockFace orientation, final QuadList quadList) {
		setQuadNumber(quadList.size());
		quadList.generate(this, subTexture);
	}

}
