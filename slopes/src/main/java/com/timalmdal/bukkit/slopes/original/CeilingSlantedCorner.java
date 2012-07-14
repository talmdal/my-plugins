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

public abstract class CeilingSlantedCorner extends GenericCustomBlock {
    public static CeilingSlantedCornerDesign cscd;

    public CeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, false, new CeilingSlantedCornerDesign(plugin, tex, subtex));
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

final class WoodenCeilingSlantedCorner extends CeilingSlantedCorner {
    public WoodenCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class CobbleCeilingSlantedCorner extends CeilingSlantedCorner {
    public CobbleCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class GlassCeilingSlantedCorner extends CeilingSlantedCorner {
    public GlassCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class SandstoneCeilingSlantedCorner extends CeilingSlantedCorner {
    public SandstoneCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class DirtCeilingSlantedCorner extends CeilingSlantedCorner {
    public DirtCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class StoneCeilingSlantedCorner extends CeilingSlantedCorner {
    public StoneCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class SandCeilingSlantedCorner extends CeilingSlantedCorner {
    public SandCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class SnowCeilingSlantedCorner extends CeilingSlantedCorner {
    public SnowCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class GrassCeilingSlantedCorner extends CeilingSlantedCorner {
    public GrassCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class BricksCeilingSlantedCorner extends CeilingSlantedCorner {
    public BricksCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class GravelCeilingSlantedCorner extends CeilingSlantedCorner {
    public GravelCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class GoldCeilingSlantedCorner extends CeilingSlantedCorner {
    public GoldCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class IronCeilingSlantedCorner extends CeilingSlantedCorner {
    public IronCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class ObsidianCeilingSlantedCorner extends CeilingSlantedCorner {
    public ObsidianCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class DiamondCeilingSlantedCorner extends CeilingSlantedCorner {
    public DiamondCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}

final class NetherbrickCeilingSlantedCorner extends CeilingSlantedCorner {
    public NetherbrickCeilingSlantedCorner(final Plugin plugin, final String name, final Texture tex, final SubTexture subtex) {
        super(plugin, name, tex, subtex);
        cscd = new CeilingSlantedCornerDesign(plugin, tex, subtex);
    }
}
