package com.Vrglab.World.Items;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.CustomRegistery.RegistryTypes;
import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.Vrglab.Modloader.CreationHelpers.TypeTransformer;
import org.Vrglab.Modloader.Registration.Registry;
import org.Vrglab.Utils.Utils;

public class ExItemGroups {
    public static CreativeModeTab EXTREME_RUBY_CREATIVE_GROUP = CreativeModeTab.builder(null, -1).title(Component.translatable("itemGroup.extreme_ruby.creative_tab")).icon(()->new ItemStack(() ->(Item)Utils.convertToMcSafeType(ExItems.RUBY))).build();

    public static void init() {
        Registry.SimpleRegister(RegistryTypes.ITEM_GROUP, ExtremeRubyMod.MOD_ID, "item_group", EXTREME_RUBY_CREATIVE_GROUP);
    }
}
