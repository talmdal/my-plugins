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
import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;

public class CeilingSlantedCornerDesign extends GenericBlockDesign {
    public CeilingSlantedCornerDesign(final Plugin plugin, final Texture tex, final SubTexture subtex) {
        this.setTexture(plugin, tex);
        setQuadNumber(4);

        final Quad right = new Quad(0, subtex);
        right.addVertex(0, 1f, 1f, 0f);
        right.addVertex(1, 0f, 1f, 0f);
        right.addVertex(2, 0f, 0.5f, 0f);
        right.addVertex(3, 0f, 0f, 0f);

        final Quad left = new Quad(1, subtex);
        left.addVertex(0, 0f, 1f, 0f);
        left.addVertex(1, 0f, 1f, 1f);
        left.addVertex(2, 0f, 0f, 0f);
        left.addVertex(3, 0f, 0.5f, 0f);

        final Quad front = new Quad(2, subtex);
        front.addVertex(0, 0f, 1f, 1f);
        front.addVertex(1, 0.5f, 1f, 0.5f);
        front.addVertex(2, 1f, 1f, 0f);
        front.addVertex(3, 0f, 0f, 0f);

        final Quad up = new Quad(3, subtex);
        up.addVertex(0, 0.5f, 1f, 0.5f);
        up.addVertex(1, 0f, 1f, 1f);
        up.addVertex(2, 0f, 1f, 0f);
        up.addVertex(3, 1f, 1f, 0f);

        this.setQuad(right).setQuad(left).setQuad(front).setQuad(up);

        setRenderPass(1);
    }
}