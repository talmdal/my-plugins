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

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.inventory.CraftFurnaceRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;

public class Coal2DiamondPlugin extends JavaPlugin {
    private static final String ICON = "compressedCoal.png";

    public ItemCompressedCoal compressedCoal;

    @Override
    public void onEnable() {
        compressedCoal = new ItemCompressedCoal(this, "compressedCoal", this.getResource(ICON), ICON);
        MaterialData.addCustomItem(compressedCoal);

        SpoutManager.getMaterialManager().registerSpoutRecipe(
                new SpoutShapedRecipe(new SpoutItemStack(compressedCoal, 1))
                        .shape("AAA", "AAA", "AAA")
                        .setIngredient('A', MaterialData.coal));

        Bukkit.getServer().getPluginManager().registerEvents(new CompressedCoalSmeltingListener(this), this);
        getServer().addRecipe(new CraftFurnaceRecipe(new SpoutItemStack(MaterialData.diamond, 1),
                new SpoutItemStack(compressedCoal)));
    }
}
