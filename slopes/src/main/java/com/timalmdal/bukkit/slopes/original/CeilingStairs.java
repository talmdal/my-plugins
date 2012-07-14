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

public abstract class CeilingStairs extends GenericCustomBlock {
    public static CeilingStairsDesign csd;

    public CeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new CeilingStairsDesign(plugin, tex, subtex));
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

final class WoodenCeilingStairs extends CeilingStairs {
    public WoodenCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class CobbleCeilingStairs extends CeilingStairs {
    public CobbleCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class GlassCeilingStairs extends CeilingStairs {
    public GlassCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class SandstoneCeilingStairs extends CeilingStairs {
    public SandstoneCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class DirtCeilingStairs extends CeilingStairs {
    public DirtCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class StoneCeilingStairs extends CeilingStairs {
    public StoneCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class SandCeilingStairs extends CeilingStairs {
    public SandCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class SnowCeilingStairs extends CeilingStairs {
    public SnowCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class GrassCeilingStairs extends CeilingStairs {
    public GrassCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class BricksCeilingStairs extends CeilingStairs {
    public BricksCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class GravelCeilingStairs extends CeilingStairs {
    public GravelCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class GoldCeilingStairs extends CeilingStairs {
    public GoldCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class IronCeilingStairs extends CeilingStairs {
    public IronCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class ObsidianCeilingStairs extends CeilingStairs {
    public ObsidianCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class DiamondCeilingStairs extends CeilingStairs {
    public DiamondCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}

final class NetherbrickCeilingStairs extends CeilingStairs {
    public NetherbrickCeilingStairs(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        csd = new CeilingStairsDesign(plugin, tex, subtex);
    }
}
