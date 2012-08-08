package com.timalmdal.bukkit.slopes.util;

import java.util.Arrays;
import java.util.Iterator;

import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

class QuadDefinition implements Iterable<Point> {
	private final TextureOffset textureOffset;
	private final Point[] points;
	private int quadIndex;

	public QuadDefinition(final TextureOffset textureOffset, final Point[] points) {
		this.textureOffset = textureOffset;
		this.points = Arrays.copyOf(points, points.length);
	}

	public int getQuadIndex() {
		return quadIndex;
	}

	public QuadDefinition setQuadIndex(final int quadIndex) {
		this.quadIndex = quadIndex;
		return this;
	}

	public TextureOffset getTextureOffset() {
		return textureOffset;
	}

	@Override
	public Iterator<Point> iterator() {
		return new Iterator<Point>() {
			private int iteratorIndex = 0;

			@Override
			public boolean hasNext() {
				return iteratorIndex < points.length;
			}

			@Override
			public Point next() {
				return points[iteratorIndex++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public SubTexture getSubTexture(final SubTexture subTexture) {
		final Texture texture = subTexture.getParent();

		int index = 0;
		for (final SubTexture subtexture : texture.subTextures) {
			if (subTexture.equals(subtexture)) {
				break;
			}
			index++;
		}
		return texture.getSubTexture(index + textureOffset.getOffset());
	}

}