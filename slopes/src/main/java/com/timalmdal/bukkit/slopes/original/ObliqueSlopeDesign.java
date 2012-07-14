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

public class ObliqueSlopeDesign extends GenericBlockDesign {
    public ObliqueSlopeDesign(final Plugin plugin, final Texture tex, final SubTexture subtex) {
        this.setTexture(plugin, tex);
        setQuadNumber(7);

        final Quad backR = new Quad(0, subtex);
        backR.addVertex(0, 1f, 1f, 0f);
        backR.addVertex(1, 0f, 1f, 0f);
        backR.addVertex(2, 0f, 0f, 0f);
        backR.addVertex(3, 1f, 0f, 0f);

        final Quad backL = new Quad(1, subtex);
        backL.addVertex(0, 0f, 1f, 0f);
        backL.addVertex(1, 0f, 1f, 1f);
        backL.addVertex(2, 0f, 0f, 1f);
        backL.addVertex(3, 0f, 0f, 0f);

        final Quad front = new Quad(2, subtex);
        front.addVertex(0, 0f, 1f, 1f);
        front.addVertex(1, 0.5f, 1f, 0.5f);
        front.addVertex(2, 1f, 1f, 0f);
        front.addVertex(3, 1f, 0f, 1f);

        final Quad frontR = new Quad(3, subtex);
        frontR.addVertex(0, 1f, 0.5f, 0.5f);
        frontR.addVertex(1, 1f, 1f, 0f);
        frontR.addVertex(2, 1f, 0f, 0f);
        frontR.addVertex(3, 1f, 0f, 1f);

        final Quad frontL = new Quad(4, subtex);
        frontL.addVertex(0, 0.5f, 0.5f, 1f);
        frontL.addVertex(1, 0f, 1f, 1f);
        frontL.addVertex(2, 0f, 0f, 1f);
        frontL.addVertex(3, 1f, 0f, 1f);

        final Quad up = new Quad(5, subtex);
        up.addVertex(0, 0.5f, 1f, 0.5f);
        up.addVertex(1, 0f, 1f, 1f);
        up.addVertex(2, 0f, 1f, 0f);
        up.addVertex(3, 1f, 1f, 0f);

        final Quad down = new Quad(6, subtex);
        down.addVertex(0, 1f, 0f, 1f);
        down.addVertex(1, 0f, 0f, 1f);
        down.addVertex(2, 0f, 0f, 0f);
        down.addVertex(3, 1f, 0f, 0f);

        this.setQuad(backR).setQuad(backL).setQuad(front).setQuad(frontR).setQuad(frontL);
        this.setQuad(up).setQuad(down);

        setRenderPass(1);
    }
}