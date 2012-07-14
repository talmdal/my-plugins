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

public abstract class SlopedAngle extends GenericCustomBlock {
    public static SlopedAngleDesign sad;

    public SlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new SlopedAngleDesign(plugin, tex, subtex));
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

final class WoodenSlopedAngle extends SlopedAngle {
    public WoodenSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class CobbleSlopedAngle extends SlopedAngle {
    public CobbleSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class GlassSlopedAngle extends SlopedAngle {
    public GlassSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class SandstoneSlopedAngle extends SlopedAngle {
    public SandstoneSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class DirtSlopedAngle extends SlopedAngle {
    public DirtSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class StoneSlopedAngle extends SlopedAngle {
    public StoneSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class SandSlopedAngle extends SlopedAngle {
    public SandSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class SnowSlopedAngle extends SlopedAngle {
    public SnowSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class GrassSlopedAngle extends SlopedAngle {
    public GrassSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class BricksSlopedAngle extends SlopedAngle {
    public BricksSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class GravelSlopedAngle extends SlopedAngle {
    public GravelSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class GoldSlopedAngle extends SlopedAngle {
    public GoldSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class IronSlopedAngle extends SlopedAngle {
    public IronSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class ObsidianSlopedAngle extends SlopedAngle {
    public ObsidianSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class DiamondSlopedAngle extends SlopedAngle {
    public DiamondSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}

final class NetherbrickSlopedAngle extends SlopedAngle {
    public NetherbrickSlopedAngle(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        sad = new SlopedAngleDesign(plugin, tex, subtex);
    }
}
