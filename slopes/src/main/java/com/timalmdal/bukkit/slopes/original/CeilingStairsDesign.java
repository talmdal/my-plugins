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

public class CeilingStairsDesign extends GenericBlockDesign {
    public CeilingStairsDesign(final Plugin plugin, final Texture tex, final SubTexture subtex) {
        this.setTexture(plugin, tex);
        setQuadNumber(10);

        final Quad right1 = new Quad(0, subtex);
        right1.addVertex(0, 0.5f, 1f, 0f);
        right1.addVertex(1, 0f, 1f, 0f);
        right1.addVertex(2, 0f, 0f, 0f);
        right1.addVertex(3, 0.5f, 0f, 0f);

        final Quad right2 = new Quad(1, subtex);
        right2.addVertex(0, 1f, 1f, 0f);
        right2.addVertex(1, 0.5f, 1f, 0f);
        right2.addVertex(2, 0.5f, 0.5f, 0f);
        right2.addVertex(3, 1f, 0.5f, 0f);

        final Quad left1 = new Quad(2, subtex);
        left1.addVertex(0, 1f, 0.5f, 1f);
        left1.addVertex(1, 0.5f, 0.5f, 1f);
        left1.addVertex(2, 0.5f, 1f, 1f);
        left1.addVertex(3, 1f, 1f, 1f);

        final Quad left2 = new Quad(3, subtex);
        left2.addVertex(0, 0.5f, 0.5f, 1f);
        left2.addVertex(1, 0f, 0.5f, 1f);
        left2.addVertex(2, 0f, 1f, 1f);
        left2.addVertex(3, 0.5f, 1f, 1f);

        final Quad up = new Quad(4, subtex);
        up.addVertex(0, 0f, 1f, 0f);
        up.addVertex(1, 1f, 1f, 0f);
        up.addVertex(2, 1f, 1f, 1f);
        up.addVertex(3, 0f, 1f, 1f);

        final Quad front1 = new Quad(5, subtex);
        front1.addVertex(0, 1f, 1f, 1f);
        front1.addVertex(1, 1f, 1f, 0f);
        front1.addVertex(2, 1f, 0.5f, 0f);
        front1.addVertex(3, 1f, 0.5f, 1f);

        final Quad front2 = new Quad(6, subtex);
        front2.addVertex(0, 0.5f, 0.5f, 1f);
        front2.addVertex(1, 0.5f, 0.5f, 0f);
        front2.addVertex(2, 0.5f, 0f, 0f);
        front2.addVertex(3, 0.5f, 0f, 1f);

        final Quad down1 = new Quad(7, subtex);
        down1.addVertex(0, 1f, 0.5f, 0f);
        down1.addVertex(1, 0.5f, 0.5f, 0f);
        down1.addVertex(2, 0.5f, 0.5f, 1f);
        down1.addVertex(3, 1f, 0.5f, 1f);

        final Quad down2 = new Quad(8, subtex);
        down2.addVertex(0, 0.5f, 0f, 0f);
        down2.addVertex(1, 0f, 0f, 0f);
        down2.addVertex(2, 0f, 0f, 1f);
        down2.addVertex(3, 0.5f, 0f, 1f);

        final Quad back = new Quad(9, subtex);
        back.addVertex(0, 0f, 1f, 0f);
        back.addVertex(1, 0f, 1f, 1f);
        back.addVertex(2, 0f, 0f, 1f);
        back.addVertex(3, 0f, 0f, 0f);

        this.setQuad(right1).setQuad(right2).setQuad(left1).setQuad(left2).setQuad(up);
        this.setQuad(front1).setQuad(front2).setQuad(down1).setQuad(down2).setQuad(back);

        setRenderPass(1);
    }
}
