/*
 *
 * Copyright (c) 2012, Tim Almdal <http://www.timalmdal.com/>
 * Difficulty plugin is licensed under the GNU Lesser General Public License.
 *
 * Difficulty plugin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Difficulty plugin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.timalmdal.bukkit.difficulty;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DifficultyCommandExecutor implements CommandExecutor {

    private final DifficultyCommand difficultyPlugin;
    private static final String SERVER_PROPERTIES = "server.properties";

    public DifficultyCommandExecutor(final DifficultyCommand difficultyPlugin) {
        this.difficultyPlugin = difficultyPlugin;
    }

    @Override
    public boolean onCommand(final CommandSender sender, final Command command,
            final String label, final String[] args) {
        boolean result = false;

        switch (args.length) {
        case 0:
            result = displayCurrentDifficulty(sender);
            break;
        case 1:
            if (sender.hasPermission("difficulty.set") || sender.isOp()) {
                try {
                    final Difficulty newDifficulty = Difficulty.valueOf(args[0].toUpperCase());

                    difficultyPlugin.getServer().getWorlds().get(0);
                    for (final World world : difficultyPlugin.getServer().getWorlds()) {
                        world.setDifficulty(newDifficulty);
                        world.save();
                        difficultyPlugin.getLogger().info("World: " + world.getName() + ": " + world.getUID() + ": " + world.getDifficulty());
                    }

                    updateServerProperties(newDifficulty);

                    sender.sendMessage(ChatColor.GREEN + "The server difficulty was set to " + ChatColor.DARK_GREEN + newDifficulty + ChatColor.GREEN + ".");
                    result = true;
                } catch (final IllegalArgumentException e) {
                    sender.sendMessage(ChatColor.RED + "'" + args[0] + "' is not a valid difficulty");
                    result = false;
                } catch (final FileNotFoundException e) {
                    sender.sendMessage(ChatColor.RED + "Unable to find the server properties file");
                    result = true;
                } catch (final IOException e) {
                    sender.sendMessage(ChatColor.RED + "Unable to read or write the server properties file");
                    result = true;
                }

            }
            else {
                result = displayCurrentDifficulty(sender);
            }
            break;
        default:
            sender.sendMessage(ChatColor.RED + "Invalid number of arguments expecting 1, recieved " + args.length);
            result = false;
        }

        return result;
    }

    private void updateServerProperties(final Difficulty newDifficulty) throws IOException, FileNotFoundException {
        // TODO Add a server properties class.
        final Properties serverProperties = new Properties();
        serverProperties.load(new FileReader(SERVER_PROPERTIES));
        serverProperties.setProperty("difficulty", Integer.toString(newDifficulty.getValue()));
        serverProperties.store(new FileWriter(SERVER_PROPERTIES), "");
    }

    private boolean displayCurrentDifficulty(final CommandSender sender) {
        final boolean result = true;

        final Difficulty currentDifficulty = getDifficulty();

        sender.sendMessage(ChatColor.GRAY + "The server difficulty is currently " + ChatColor.DARK_GRAY + currentDifficulty + ChatColor.GRAY + ".");

        return result;
    }

    private Difficulty getDifficulty() {
        return difficultyPlugin.getServer().getWorlds().get(0).getDifficulty();
    }

}
