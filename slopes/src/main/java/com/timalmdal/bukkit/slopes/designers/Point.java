package com.timalmdal.bukkit.slopes.designers;

import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Vertex;

public class Point {
	private final float x;
	private final float y;
	private final float z;
	private int quad;
	private int order;

	public Point(final float x, final float y, final float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public Point setQuad(final int quadIndex) {
		quad = quadIndex;
		return this;
	}

	public Point setOrder(final int order) {
		this.order = order;
		return this;
	}

	public Vertex generateVertex(final SubTexture subTexture) {
		return new Vertex(order, quad, x, y, z, subTexture);
	}
}
