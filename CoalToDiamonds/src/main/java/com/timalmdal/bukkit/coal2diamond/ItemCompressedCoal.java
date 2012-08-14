/*
 * This file is part of coal2diamonds.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/CoalToDiamonds/>
 * coal2diamonds is licensed under the GNU Lesser General Public License.
 *
 * coal2diamonds is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * coal2diamonds is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/>
 * CoalToDiamonds plugin is licensed under the GNU Lesser General Public License.
 *
 * CoalToDiamonds plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CoalToDiamonds plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.coal2diamond;

import java.io.InputStream;

import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.material.item.GenericCustomItem;

public class ItemCompressedCoal extends GenericCustomItem {

    public ItemCompressedCoal(final Plugin plugin, final String name, final InputStream input, final String cacheName) {
        super(plugin, name);
        this.setTexture(input, cacheName);
    }
}
