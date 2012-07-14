package com.timalmdal.bukkit.slopes.designers;

import org.bukkit.block.BlockFace;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

import com.timalmdal.bukkit.slopes.SlopesPlugin.SlopeSubTexture;

public class AbstractSlopesBlockDesign extends GenericBlockDesign {

	public static QuadList quadBuilder() {
		return new QuadList();
	}

	private final SubTexture subTexture;

	public AbstractSlopesBlockDesign(final Plugin plugin, final Texture texture, final SlopeSubTexture slopeTexture) {
		setTexture(plugin, texture);
		subTexture = texture.getSubTexture(slopeTexture.getTextureIndex());

		setRenderPass(1);
	}

	protected void setQuads(final BlockFace orientation, final QuadList quadList) {
		setQuadNumber(quadList.size());
		quadList.generate(this, subTexture);
	}

}
