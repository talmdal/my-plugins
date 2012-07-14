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

public abstract class SlopedCeiling extends GenericCustomBlock {
    public static SlopedCeilingDesign scd;

    public SlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new SlopedCeilingDesign(plugin, tex, subtex));
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

final class WoodenSlopedCeiling extends SlopedCeiling {
    public WoodenSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class CobbleSlopedCeiling extends SlopedCeiling {
    public CobbleSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class GlassSlopedCeiling extends SlopedCeiling {
    public GlassSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class SandstoneSlopedCeiling extends SlopedCeiling {
    public SandstoneSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class DirtSlopedCeiling extends SlopedCeiling {
    public DirtSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class StoneSlopedCeiling extends SlopedCeiling {
    public StoneSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class SandSlopedCeiling extends SlopedCeiling {
    public SandSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class SnowSlopedCeiling extends SlopedCeiling {
    public SnowSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class GrassSlopedCeiling extends SlopedCeiling {
    public GrassSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class BricksSlopedCeiling extends SlopedCeiling {
    public BricksSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class GravelSlopedCeiling extends SlopedCeiling {
    public GravelSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class GoldSlopedCeiling extends SlopedCeiling {
    public GoldSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class IronSlopedCeiling extends SlopedCeiling {
    public IronSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class ObsidianSlopedCeiling extends SlopedCeiling {
    public ObsidianSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class DiamondSlopedCeiling extends SlopedCeiling {
    public DiamondSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}

final class NetherbrickSlopedCeiling extends SlopedCeiling {
    public NetherbrickSlopedCeiling(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        scd = new SlopedCeilingDesign(plugin, tex, subtex);
    }
}
