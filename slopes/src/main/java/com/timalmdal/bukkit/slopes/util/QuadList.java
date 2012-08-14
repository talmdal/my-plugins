package com.timalmdal.bukkit.slopes.util;

import java.util.ArrayList;
import java.util.List;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.SubTexture;

public class QuadList {
	private final List<QuadDefinition> quads = new ArrayList<QuadDefinition>();

	public static QuadList quadBuilder() {
		return new QuadList();
	}

	public QuadList add(final Point... vertices) {
		return add(TextureOffset.Default, vertices);
	}

	public QuadList add(final TextureOffset textureOffset, final Point... vertices) {
		if (vertices.length < 3 || vertices.length > 4) {
			throw new IllegalArgumentException("Invalid vertex index: " + vertices.length);
		}

		final QuadDefinition quadDefn = new QuadDefinition(textureOffset, vertices).setQuadIndex(quads.size());
		quads.add(quadDefn);

		return this;
	}

	public int size() {
		return quads.size();
	}

	public void generate(final GenericBlockDesign designer, final SubTexture subTexture) {
		for (final QuadDefinition quad : quads) {
			int order = 0;
			final SubTexture sideTexture = TextureOffset.Default.equals(quad.getTextureOffset()) ? subTexture : quad.getSubTexture(subTexture);

			for (final Point descriptor : quad) {
				designer.setVertex(descriptor.setOrder(order++).setQuad(quad.getQuadIndex()).generateVertex(sideTexture));
			}
		}
	}
}
