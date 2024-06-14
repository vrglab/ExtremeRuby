package com.Vrglab.World.Items;

import com.Vrglab.ExtremeRubyMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import org.Vrglab.Modloader.Registration.Registry;

public class ExItems {

    public static Object RUBY = Registry.RegisterItem("ruby", ExtremeRubyMod.MOD_ID, ()->new Item(new Item.Settings().group(ExItemGroups.EXTREME_RUBY_CREATIVE_GROUP)));


    public static void init(){
    }
}
