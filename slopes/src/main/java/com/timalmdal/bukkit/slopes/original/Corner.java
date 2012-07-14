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

public abstract class Corner extends GenericCustomBlock {
    public static CornerDesign cd;

    public Corner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new CornerDesign(plugin, tex, subtex));
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

final class WoodenCorner extends Corner {
    public WoodenCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class CobbleCorner extends Corner {
    public CobbleCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class GlassCorner extends Corner {
    public GlassCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class SandstoneCorner extends Corner {
    public SandstoneCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class DirtCorner extends Corner {
    public DirtCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class StoneCorner extends Corner {
    public StoneCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class SandCorner extends Corner {
    public SandCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class SnowCorner extends Corner {
    public SnowCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class GrassCorner extends Corner {
    public GrassCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class BricksCorner extends Corner {
    public BricksCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class GravelCorner extends Corner {
    public GravelCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class GoldCorner extends Corner {
    public GoldCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class IronCorner extends Corner {
    public IronCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class ObsidianCorner extends Corner {
    public ObsidianCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class DiamondCorner extends Corner {
    public DiamondCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}

final class NetherbrickCorner extends Corner {
    public NetherbrickCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cd = new CornerDesign(plugin, tex, subtex);
    }
}
