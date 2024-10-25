package com.Vrglab.Utils;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MixinUtils {

    public static <T extends Item> boolean replacedItemTypeCheck(ItemStack instance, Item checkItem, Class<T> expectedItem) {
        if (checkItem.getClass().isAssignableFrom(expectedItem)) {
            return expectedItem.isAssignableFrom(instance.getItem().getClass());
        }
        return instance.is(checkItem);
    }
}
