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

import java.util.ArrayList;

import org.getspout.spoutapi.block.design.GenericBlockDesign;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.block.design.Quad;
import org.getspout.spoutapi.block.design.Vertex;

public class SlopeBlockDesign extends GenericBlockDesign {
	ArrayList<Quad> tempNewQuads  = new ArrayList<Quad>();
	SubTexture subtex;
	
	public SlopeBlockDesign(Texture tex, SubTexture subtex, Direction direction) {
		this.subtex = subtex;	
	}
	
	public void setup(Direction direction, ArrayList<Quad> quads) {
		switch(direction) {
		case EAST:
		default:
			break;
		case SOUTH:
			rotate(Direction.SOUTH, quads);
			break;
		case WEST:
			rotate(Direction.WEST, quads);
			break;
		case NORTH:
			rotate(Direction.NORTH, quads);
			break;
		}

		if(direction != Direction.EAST) {
			for(Quad q : tempNewQuads) {
				this.setQuad(q);
			}
		}
		else {
			for(Quad q : quads) {
				this.setQuad(q);
			}
		}
	}
	
	public void rotate(Direction direction, ArrayList<Quad> quads) {
		double theta;
		
		switch(direction) {
		case SOUTH:
			theta = (3/2)*Math.PI;
			break;
		case WEST:
			theta = Math.PI;
			break;
		case NORTH:
			theta = (1/2)*Math.PI;
			break;
		default:
			theta = 1;
		}
		
		for(int i=0; i<quads.size(); i++) {
			Quad nq = new Quad(i, subtex);
			Quad q = quads.get(i);
			
			for(int j=0; i<4; i++) {
				Vertex v = q.getVertex(i);
				float x = (float)(v.getX()*Math.cos(theta)+v.getZ()*Math.sin(theta));
				float y = v.getY();
				float z = (float)(v.getX()*-Math.sin(theta)+v.getZ()*Math.cos(theta));
				nq.addVertex(j, x, y, z);
			}
			tempNewQuads.set(i, nq);
		}
	}

}
