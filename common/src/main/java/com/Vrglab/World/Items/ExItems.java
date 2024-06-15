package com.Vrglab.World.Items;

import com.Vrglab.ExtremeRubyMod;
import net.minecraft.item.*;
import org.Vrglab.Modloader.Registration.Registry;

public class ExItems {

    /** INGOT BASED ITEMS **/
    public static Object RUBY = Registry.RegisterItem("ruby", ExtremeRubyMod.MOD_ID, ()->new Item(new Item.Settings().group(ExItemGroups.EXTREME_RUBY_CREATIVE_GROUP)));


    /** TOOLS **/
    public static Object RUBY_SWORD = Registry.RegisterItem("ruby_sword", ExtremeRubyMod.MOD_ID, ()->new SwordItem(ToolMaterials.NETHERITE, 5, -2.6f, new Item.Settings().group(ExItemGroups.EXTREME_RUBY_CREATIVE_GROUP)));

    public static void init(){
    }
}
