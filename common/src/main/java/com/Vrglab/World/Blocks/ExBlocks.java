package com.Vrglab.World.Blocks;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.Items.ExItemGroups;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import org.Vrglab.Modloader.Registration.Registry;

public class ExBlocks {

    public static Object RUBY_BLOCK = Registry.RegisterBlock("ruby_block", ExtremeRubyMod.MOD_ID, ()->new Block(AbstractBlock.Settings.of(Material.METAL)), new Item.Settings().group(ExItemGroups.EXTREME_RUBY_CREATIVE_GROUP));

    public static void init() {}
}
