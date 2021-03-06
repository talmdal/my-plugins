/*
 * This file is part of Difficulty Plugin.
 *
 * Copyright (c) 2012, Tim Almdal <http://www.spout.org/>
 * Difficulty Plugin is licensed under the GNU Lesser General Public License.
 *
 * Difficulty Plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Difficulty Plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.difficulty;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DifficultyCommand extends JavaPlugin {
    @SuppressWarnings("unused")
    private PluginManager pluginManager;

    @Override
    public void onDisable() {
        pluginManager = null;
        super.onDisable();
    }

    @Override
    public void onEnable() {
        pluginManager = getServer().getPluginManager();
        getCommand("difficulty").setExecutor(new DifficultyCommandExecutor(this));

        getServer().dispatchCommand(getServer().getConsoleSender(), "difficulty");
    }
}
