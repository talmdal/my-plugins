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

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.MaterialData;

public class CompressedCoalSmeltingListener implements Listener {
    public Coal2DiamondPlugin plugin;

    public CompressedCoalSmeltingListener(final Coal2DiamondPlugin instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerSmelt(final FurnaceSmeltEvent event) {
        ItemStack source = event.getSource();
        if (source.getTypeId() == plugin.compressedCoal.getRawId() && source.getDurability() == plugin.compressedCoal.getRawData()) {
            event.setResult(new SpoutItemStack(MaterialData.diamond, 1));
        }
    }
}
