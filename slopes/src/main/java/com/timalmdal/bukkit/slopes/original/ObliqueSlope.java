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

public abstract class ObliqueSlope extends GenericCustomBlock {
    public static ObliqueSlopeDesign osd;

    public ObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new ObliqueSlopeDesign(plugin, tex, subtex));
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

final class WoodenObliqueSlope extends ObliqueSlope {
    public WoodenObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class CobbleObliqueSlope extends ObliqueSlope {
    public CobbleObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class GlassObliqueSlope extends ObliqueSlope {
    public GlassObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class SandstoneObliqueSlope extends ObliqueSlope {
    public SandstoneObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class DirtObliqueSlope extends ObliqueSlope {
    public DirtObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class StoneObliqueSlope extends ObliqueSlope {
    public StoneObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class SandObliqueSlope extends ObliqueSlope {
    public SandObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class SnowObliqueSlope extends ObliqueSlope {
    public SnowObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class GrassObliqueSlope extends ObliqueSlope {
    public GrassObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class BricksObliqueSlope extends ObliqueSlope {
    public BricksObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class GravelObliqueSlope extends ObliqueSlope {
    public GravelObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class GoldObliqueSlope extends ObliqueSlope {
    public GoldObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class IronObliqueSlope extends ObliqueSlope {
    public IronObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class ObsidianObliqueSlope extends ObliqueSlope {
    public ObsidianObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class DiamondObliqueSlope extends ObliqueSlope {
    public DiamondObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class NetherbrickObliqueSlope extends ObliqueSlope {
    public NetherbrickObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        osd = new ObliqueSlopeDesign(plugin, tex, subtex);
    }
}
