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

public abstract class SlopesIntersection extends GenericCustomBlock {
    public static SlopesIntersectionDesign sid;

    public SlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new SlopesIntersectionDesign(plugin, tex, subtex));
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

final class WoodenSlopesIntersection extends SlopesIntersection {
    public WoodenSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class CobbleSlopesIntersection extends SlopesIntersection {
    public CobbleSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class GlassSlopesIntersection extends SlopesIntersection {
    public GlassSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class SandstoneSlopesIntersection extends SlopesIntersection {
    public SandstoneSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class DirtSlopesIntersection extends SlopesIntersection {
    public DirtSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class StoneSlopesIntersection extends SlopesIntersection {
    public StoneSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class SandSlopesIntersection extends SlopesIntersection {
    public SandSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class SnowSlopesIntersection extends SlopesIntersection {
    public SnowSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class GrassSlopesIntersection extends SlopesIntersection {
    public GrassSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class BricksSlopesIntersection extends SlopesIntersection {
    public BricksSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class GravelSlopesIntersection extends SlopesIntersection {
    public GravelSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class GoldSlopesIntersection extends SlopesIntersection {
    public GoldSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class IronSlopesIntersection extends SlopesIntersection {
    public IronSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class ObsidianSlopesIntersection extends SlopesIntersection {
    public ObsidianSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class DiamondSlopesIntersection extends SlopesIntersection {
    public DiamondSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}

final class NetherbrickSlopesIntersection extends SlopesIntersection {
    public NetherbrickSlopesIntersection(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sid = new SlopesIntersectionDesign(plugin, tex, subtex);
    }
}
