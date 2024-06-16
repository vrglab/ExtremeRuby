package com.Vrglab.World.Items;

import com.Vrglab.ExtremeRubyMod;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.Vrglab.Modloader.CreationHelpers.TypeTransformer;

public class ExItemGroups {
    public static ItemGroup EXTREME_RUBY_CREATIVE_GROUP = CreativeTabRegistry.create(new Identifier(ExtremeRubyMod.MOD_ID, "creative_tab"), ()->new ItemStack((Item)TypeTransformer.ObjectToType.accept(ExItems.RUBY)));

    public static void init() {
    }
}
