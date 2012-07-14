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

public abstract class InvertedObliqueSlope extends GenericCustomBlock {
    public static InvertedObliqueSlopeDesign iosd;

    public InvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new InvertedObliqueSlopeDesign(plugin, tex, subtex));
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

final class WoodenInvertedObliqueSlope extends InvertedObliqueSlope {
    public WoodenInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class CobbleInvertedObliqueSlope extends InvertedObliqueSlope {
    public CobbleInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class GlassInvertedObliqueSlope extends InvertedObliqueSlope {
    public GlassInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class SandstoneInvertedObliqueSlope extends InvertedObliqueSlope {
    public SandstoneInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class DirtInvertedObliqueSlope extends InvertedObliqueSlope {
    public DirtInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class StoneInvertedObliqueSlope extends InvertedObliqueSlope {
    public StoneInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class SandInvertedObliqueSlope extends InvertedObliqueSlope {
    public SandInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class SnowInvertedObliqueSlope extends InvertedObliqueSlope {
    public SnowInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class GrassInvertedObliqueSlope extends InvertedObliqueSlope {
    public GrassInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class BricksInvertedObliqueSlope extends InvertedObliqueSlope {
    public BricksInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class GravelInvertedObliqueSlope extends InvertedObliqueSlope {
    public GravelInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class GoldInvertedObliqueSlope extends InvertedObliqueSlope {
    public GoldInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class IronInvertedObliqueSlope extends InvertedObliqueSlope {
    public IronInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class ObsidianInvertedObliqueSlope extends InvertedObliqueSlope {
    public ObsidianInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class DiamondInvertedObliqueSlope extends InvertedObliqueSlope {
    public DiamondInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}

final class NetherbrickInvertedObliqueSlope extends InvertedObliqueSlope {
    public NetherbrickInvertedObliqueSlope(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        iosd = new InvertedObliqueSlopeDesign(plugin, tex, subtex);
    }
}
