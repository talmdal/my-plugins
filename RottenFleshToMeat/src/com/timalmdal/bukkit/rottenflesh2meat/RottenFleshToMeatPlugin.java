/*
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/>
 * RottenFleshToMeat plugin is licensed under the GNU Lesser General Public License.
 *
 * RottenFleshToMeat plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * RottenFleshToMeat plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.rottenflesh2meat;

import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;

public class RottenFleshToMeatPlugin extends JavaPlugin {
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        final SpoutItemStack rawBeef = new SpoutItemStack(MaterialData.rawBeef, 1);

        SpoutManager.getMaterialManager().registerSpoutRecipe(new SpoutShapedRecipe(rawBeef)
                .shape("AAA", "ABA", "ABA")
                .setIngredient('A', MaterialData.rottenFlesh)
                .setIngredient('B', MaterialData.wheat));
    }
}
