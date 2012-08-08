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
package com.timalmdal.bukkit.slopes.designers;

import org.bukkit.block.BlockFace;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.Texture;

import com.timalmdal.bukkit.slopes.util.Point;
import com.timalmdal.bukkit.slopes.util.QuadList;
import com.timalmdal.bukkit.slopes.util.SlopeSubTexture;
import com.timalmdal.bukkit.slopes.util.TextureOffset;

public class SlantedCornerDesign extends AbstractBlockDesign {
	// TODO look at build different directional designs and then don't auto...
	// rotate, so maybe we can get away with less quads
	private static final QuadList QUAD_LIST_SOUTH = AbstractBlockDesign.quadBuilder()
			.add(TextureOffset.Bottom,
					new Point(0.0f, 0.0f, 1.0f), new Point(0.0f, 0.0f, 0.0f), new Point(1.0f, 0.0f, 0.0f), new Point(0.001f, 0.0f, 1.0f)) // bottom
			.add(new Point(0.0f, 0.0f, 0.0f), new Point(0.0f, 1.0f, 0.0f), new Point(.001f, 1.0f, 0.0f), new Point(1.0f, 0.0f, 0.0f)) // north
			.add(new Point(0.0f, 0.0f, 1.0f), new Point(0.0f, 1.0f, 0.001f), new Point(0.0f, 1.0f, 0.0f), new Point(0.0f, 0.0f, 0.0f)) // west
			.add(TextureOffset.Top,
					new Point(0.5f, 0.0f, 0.5f), new Point(0.0f, 1.0f, 0.0f), new Point(0.0f, 1.0f, 0.001f), new Point(0.0f, 0.0f, 1.0f)) // southwest
			.add(TextureOffset.Top,
					new Point(1.0f, 0.0f, 0.0f), new Point(0.0f, 1.0f, 0.0f), new Point(0.0f, 1.0f, 0.001f), new Point(0.5f, 0.0f, 0.5f)) // southeast
	;

	public SlantedCornerDesign(final Plugin plugin, final Texture texture, final SlopeSubTexture slopeTexture) {
		super(plugin, texture, slopeTexture);
		setBrightness(1.0F);
		setBoundingBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

		setQuads(BlockFace.SOUTH, QUAD_LIST_SOUTH);
	}
}
