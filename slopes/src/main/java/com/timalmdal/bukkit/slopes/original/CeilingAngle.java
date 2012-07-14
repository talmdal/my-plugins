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
package com.timalmdal.bukkit.slopes.original;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.Texture;

import com.timalmdal.bukkit.slopes.SlopesPlugin;
import com.timalmdal.bukkit.slopes.SlopesPlugin.SlopeSubTexture;

public abstract class CeilingAngle extends SlopeBlock {

	public CeilingAngle(final Plugin plugin, final Texture tex, final SlopeSubTexture subTexture) {
		// TODO move some of this fluff into SlopeBlock
		super(plugin, subTexture.getDisplayName(" Ceiling Angle"),
				new CeilingAngleDesign(plugin, tex, tex.getSubTexture(subTexture.getTextureIndex()), Direction.EAST),
				tex, tex.getSubTexture(subTexture.getTextureIndex()));
	}
}
