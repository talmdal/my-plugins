/*
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/>
 * MoreDiamonds plugin is licensed under the GNU Lesser General Public License.
 *
 * MoreDiamonds plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MoreDiamonds plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.morediamonds;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

public class MoreDiamondsListener implements Listener {
    private final MoreDiamondsPlugin plugin;

    public MoreDiamondsListener(final MoreDiamondsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWorldInit(final WorldInitEvent event) {
        event.getWorld().getPopulators().add(new MoreDiamondsPopulator(plugin));
    }
}
