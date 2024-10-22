package com.Vrglab.World.Items.Items;

import com.Vrglab.ExtremeRubyMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class CopperUtils {

    public static final int MAX_OXIDATION_STAGE = 3;

    public static void ageCopperItemStack(ItemStack itemStack, Level level, Entity entity, int max_oxizidation_stage) {
        CompoundTag tag = itemStack.getOrCreateTag();
        if (!level.isClientSide && !tag.getBoolean("waxed")) {
            int oxidationStage = tag.getInt("oxidation_stage");

            // Increase the oxidation stage over time (every 6000 ticks, 5 minutes)
            if (level.getGameTime() % 6000 == 0 && oxidationStage < max_oxizidation_stage) {
                tag.putInt("oxidation_stage", oxidationStage + 1); // Increase oxidation stage
                itemStack.setTag(tag); // Set the updated tag
            }
        }
    }

    public static InteractionResult waxCopperTool(UseOnContext context, Supplier<InteractionResult> supper) {
        ItemStack stack = context.getItemInHand();
        CompoundTag tag = stack.getOrCreateTag();

        // If the player is holding honeycomb, prevent further oxidation
        if (context.getPlayer().getItemInHand(context.getHand()).getItem() == Items.HONEYCOMB) {
            tag.putBoolean("waxed", true);
            stack.setTag(tag);
            return InteractionResult.SUCCESS;
        }

        return supper.get();
    }

    public static String GetDescriptionId(ItemStack stack, String Item_name) {
        CompoundTag tag = stack.getOrCreateTag();
        int oxidationStage = tag.getInt("oxidation_stage");

        // Return different translation keys based on oxidation stage
        switch (oxidationStage) {
            case 1:
                return "item." + ExtremeRubyMod.MOD_ID + ".lightly_oxidized_copper_" + Item_name;
            case 2:
                return "item." + ExtremeRubyMod.MOD_ID + ".semi_oxidized_copper_" + Item_name;
            case 3:
                return "item." + ExtremeRubyMod.MOD_ID + ".fully_oxidized_copper_" + Item_name;
            default:
                return "item." + ExtremeRubyMod.MOD_ID + ".copper_" + Item_name;
        }
    }
}
