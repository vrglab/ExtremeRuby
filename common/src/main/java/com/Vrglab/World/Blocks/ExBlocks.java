package com.Vrglab.World.Blocks;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.Items.ExItemGroups;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import org.Vrglab.Modloader.Registration.Registry;

public class ExBlocks {

    /** BASIC BLOCKS **/
    public static Object RUBY_BLOCK = Registry.RegisterBlock("ruby_block", ExtremeRubyMod.MOD_ID,
            ()->new Block(AbstractBlock.Settings.of(Material.METAL)), getBaseItemSettings());


    /** ORE BLOCKS**/
    public static Object RUBY_ORE = Registry.RegisterBlock("ruby_ore", ExtremeRubyMod.MOD_ID,
            ()-> new OreBlock(getToolRequiredSettings(Material.STONE, 4,4), UniformIntProvider.create(1,7)), getBaseItemSettings());
    public static Object RUBY_ORE_DEEPSLATE = Registry.RegisterBlock("deepslate_ruby_ore", ExtremeRubyMod.MOD_ID,
            ()-> new OreBlock(getToolRequiredSettings(Material.STONE, 4,4), UniformIntProvider.create(1,7)), getBaseItemSettings());




    private static Item.Settings getBaseItemSettings() {
        return new Item.Settings().group(ExItemGroups.EXTREME_RUBY_CREATIVE_GROUP);
    }

    private static AbstractBlock.Settings getToolRequiredSettings(Material mat, float hardness, float resitance){
        return AbstractBlock.Settings.of(mat).requiresTool().strength(hardness, resitance);
    }

    public static void init() {}
}
