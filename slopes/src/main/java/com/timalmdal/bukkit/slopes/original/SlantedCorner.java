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

import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.block.design.SubTexture;
import org.getspout.spoutapi.block.design.Texture;
import org.getspout.spoutapi.material.block.GenericCustomBlock;
import org.getspout.spoutapi.player.SpoutPlayer;

public abstract class SlantedCorner extends GenericCustomBlock {
    public static SlantedCornerDesign scd;

    public SlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new SlantedCornerDesign(plugin, tex, subtex));
    }

    @Override
    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final int changedId) {
    }

    @Override
    public void onBlockPlace(final World world, final int x, final int y, final int z) {
    }

    @Override
    public void onBlockPlace(final World world, final int x, final int y, final int z, final LivingEntity living) {
    }

    @Override
    public void onBlockDestroyed(final World world, final int x, final int y, final int z) {

    }

    @Override
    public boolean onBlockInteract(final World world, final int x, final int y, final int z, final SpoutPlayer player) {
        return true;
    }

    @Override
    public void onEntityMoveAt(final World world, final int x, final int y, final int z, final Entity entity) {
    }

    @Override
    public void onBlockClicked(final World world, final int x, final int y, final int z, final SpoutPlayer player) {
    }

    @Override
    public boolean isProvidingPowerTo(final World world, final int x, final int y, final int z, final BlockFace face) {
        return false;
    }

    @Override
    public boolean isIndirectlyProvidingPowerTo(final World world, final int x, final int y, final int z, final BlockFace face) {
        return false;
    }
}

final class WoodenSlantedCorner extends SlantedCorner {
    public WoodenSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class CobbleSlantedCorner extends SlantedCorner {
    public CobbleSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class GlassSlantedCorner extends SlantedCorner {
    public GlassSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class SandstoneSlantedCorner extends SlantedCorner {
    public SandstoneSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class DirtSlantedCorner extends SlantedCorner {
    public DirtSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class StoneSlantedCorner extends SlantedCorner {
    public StoneSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class SandSlantedCorner extends SlantedCorner {
    public SandSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class SnowSlantedCorner extends SlantedCorner {
    public SnowSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class GrassSlantedCorner extends SlantedCorner {
    public GrassSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class BricksSlantedCorner extends SlantedCorner {
    public BricksSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class GravelSlantedCorner extends SlantedCorner {
    public GravelSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class GoldSlantedCorner extends SlantedCorner {
    public GoldSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class IronSlantedCorner extends SlantedCorner {
    public IronSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class ObsidianSlantedCorner extends SlantedCorner {
    public ObsidianSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class DiamondSlantedCorner extends SlantedCorner {
    public DiamondSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}

final class NetherbrickSlantedCorner extends SlantedCorner {
    public NetherbrickSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlantedCornerDesign(plugin, tex, subtex);
    }
}
