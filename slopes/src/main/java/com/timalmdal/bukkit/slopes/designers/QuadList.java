package com.timalmdal.bukkit.slopes.designers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.SubTexture;

public class QuadList {
	private final List<List<Point>> quads = new ArrayList<List<Point>>();

	protected QuadList() {
	}

	public QuadList add(final Point... vertices) {
		if (vertices.length != 4) {
			throw new IllegalArgumentException("Invalid vertex index: " + vertices.length);
		}

		final int quadIndex = quads.size();
		for (int index = 0; index < vertices.length; index++) {
			vertices[index].setQuad(quadIndex).setOrder(index);
		}
		quads.add(Arrays.asList(vertices));

		return this;
	}

	public int size() {
		return quads.size();
	}

	public void generate(final GenericBlockDesign designer, final SubTexture subTexture) {
		for (final List<Point> quad : quads) {
			for (final Point descriptor : quad) {
				designer.setVertex(descriptor.generateVertex(subTexture));
			}
		}
	}
}
