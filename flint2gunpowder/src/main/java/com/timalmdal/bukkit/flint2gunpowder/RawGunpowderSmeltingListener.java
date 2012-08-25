/*
 * This file is part of Flint To Gunpowder.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/flint2gunpowder/>
 * Flint To Gunpowder is licensed under the GNU Lesser General Public License.
 *
 * Flint To Gunpowder is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Flint To Gunpowder is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * This file is part of flinttogunpowder.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/flint2gunpowder/>
 * flinttogunpowder is licensed under the GNU Lesser General Public License.
 *
 * flinttogunpowder is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * flinttogunpowder is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.flint2gunpowder;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.material.MaterialData;

public class RawGunpowderSmeltingListener implements Listener {
    public FlintToGunpowderPlugin plugin;

    public RawGunpowderSmeltingListener(final FlintToGunpowderPlugin instance) {
        plugin = instance;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerSmelt(final FurnaceSmeltEvent event) {
        ItemStack source = event.getSource();
        if (source.getTypeId() == plugin.rawGunpowder.getRawId() && source.getDurability() == plugin.rawGunpowder.getRawData()) {
            event.setResult(new SpoutItemStack(MaterialData.gunpowder, 1));
        }
    }
}
