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

public abstract class SlopedFloor extends GenericCustomBlock {
    public static SlopedFloorDesign sfd;

    public SlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new SlopedFloorDesign(plugin, tex, subtex));
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

final class WoodenSlopedFloor extends SlopedFloor {
    public WoodenSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class CobbleSlopedFloor extends SlopedFloor {
    public CobbleSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class GlassSlopedFloor extends SlopedFloor {
    public GlassSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class SandstoneSlopedFloor extends SlopedFloor {
    public SandstoneSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class DirtSlopedFloor extends SlopedFloor {
    public DirtSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class StoneSlopedFloor extends SlopedFloor {
    public StoneSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class SandSlopedFloor extends SlopedFloor {
    public SandSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class SnowSlopedFloor extends SlopedFloor {
    public SnowSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class GrassSlopedFloor extends SlopedFloor {
    public GrassSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class BricksSlopedFloor extends SlopedFloor {
    public BricksSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class GravelSlopedFloor extends SlopedFloor {
    public GravelSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class GoldSlopedFloor extends SlopedFloor {
    public GoldSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class IronSlopedFloor extends SlopedFloor {
    public IronSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class ObsidianSlopedFloor extends SlopedFloor {
    public ObsidianSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class DiamondSlopedFloor extends SlopedFloor {
    public DiamondSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}

final class NetherbrickSlopedFloor extends SlopedFloor {
    public NetherbrickSlopedFloor(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sfd = new SlopedFloorDesign(plugin, tex, subtex);
    }
}
