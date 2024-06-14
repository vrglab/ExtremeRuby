package com.Vrglab.World.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import org.Vrglab.Modloader.CreationHelpers.TypeTransformer;

public class ExItemGroups {
    public static ItemGroup EXTREME_RUBY_CREATIVE_GROUP = new ItemGroup(4, "extremeruby_creative_tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack((Item)TypeTransformer.ObjectToType.accept(ExItems.RUBY));
        }
    };

    public static void init() {
    }
}
