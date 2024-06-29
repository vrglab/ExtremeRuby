package com.Vrglab.World.Blocks;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.Items.ExItemGroups;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.Vrglab.Modloader.Registration.Registry;
import org.Vrglab.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ExBlocks {

    /** BASIC BLOCKS **/
    public static Object RUBY_BLOCK = Registry.RegisterBlock("ruby_block", ExtremeRubyMod.MOD_ID,
            ()->new Block(BlockBehaviour.Properties.of()), ()->getBaseItemSettings());


    /** ORE BLOCKS**/
    public static Object RUBY_ORE = Registry.RegisterBlock("ruby_ore", ExtremeRubyMod.MOD_ID,
            ()-> new DropExperienceBlock(UniformInt.of(1,7), getToolRequiredSettings(4,4)), ()->getBaseItemSettings());
    public static Object RUBY_ORE_DEEPSLATE = Registry.RegisterBlock("deepslate_ruby_ore", ExtremeRubyMod.MOD_ID,
            ()-> new DropExperienceBlock(UniformInt.of(1,7), getToolRequiredSettings(4,4)), ()->getBaseItemSettings());




    private static Item.Properties getBaseItemSettings() {
        return new Item.Properties();
    }

    private static Item.Properties getBaseItemSettings(ResourceKey<CreativeModeTab> tab){
        return new Item.Properties().arch$tab(tab);
    }

    private static BlockBehaviour.Properties getToolRequiredSettings(float hardness, float resitance){
        return BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(hardness, resitance);
    }

    public static void init() {}

    public static Object[] getAll(){
        List<Object> objs = new ArrayList<>();
        objs.add(RUBY_BLOCK);
        objs.add(RUBY_ORE);
        objs.add(RUBY_ORE_DEEPSLATE);
        return objs.toArray();
    }
}
