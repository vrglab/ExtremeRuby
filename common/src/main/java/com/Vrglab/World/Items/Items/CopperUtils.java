package com.Vrglab.World.Items.Items;

import com.Vrglab.ExtremeRubyMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.Random;
import java.util.function.Supplier;

public class CopperUtils {

    public static final int MAX_OXIDATION_STAGE = 3;
    public static final String OXIDATION_KEY = "oxidation_stage";
    public static final String WAX_KEY = "waxed";
    private static final int OXI_CYCLE_TICKS = 3000;

    private static final int OXIDATION_TICKS_PER_STAGE_MIN = 50 * 24000; // 50 Minecraft days for minimum stage change
    private static final int OXIDATION_TICKS_PER_STAGE_MAX = 80 * 24000; // 80 Minecraft days for maximum stage change

    private static final Random random = new Random();

    public static void ageCopperItemStack(ItemStack itemStack, Level level, Entity entity) {
        if (!level.isClientSide) {
            CompoundTag tag = itemStack.getOrCreateTag();

            if (tag.getBoolean(WAX_KEY)) {
                return;
            }

            int oxidationStage = tag.getInt(OXIDATION_KEY);

            if (oxidationStage < MAX_OXIDATION_STAGE) {
                long currentTime = level.getGameTime();

                long lastOxidizedTick = tag.getLong("last_oxidized_tick");

                if (currentTime - lastOxidizedTick >= OXI_CYCLE_TICKS) {
                    tag.putInt(OXIDATION_KEY, oxidationStage + 1);
                    tag.putLong("last_oxidized_tick", currentTime);
                    itemStack.setTag(tag);
                }
            }
        }
    }

    public static InteractionResult waxCopperTool(UseOnContext context, Supplier<InteractionResult> supper) {
        ItemStack stack = context.getItemInHand();
        CompoundTag tag = stack.getOrCreateTag();

        // If the player is holding honeycomb in the off hand, prevent further oxidation
        if (context.getPlayer().getOffhandItem().getItem() == Items.HONEYCOMB) {
            tag.putBoolean(WAX_KEY, true);
            stack.setTag(tag);
            context.getPlayer().getOffhandItem().shrink(1);
            return InteractionResult.SUCCESS;
        }

        return supper.get();
    }

    public static String GetDescriptionId(ItemStack stack, String Item_name) {
        CompoundTag tag = stack.getOrCreateTag();
        int oxidationStage = tag.getInt(OXIDATION_KEY);

        if (tag.getBoolean(WAX_KEY)) {
            return "item." + ExtremeRubyMod.MOD_ID + ".waxed_copper_" + Item_name;
        }

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
    public static String GetDescription(ItemStack stack, EquipmentSlot slot) {
        CompoundTag tag = stack.getOrCreateTag();
        int oxidationStage = tag.getInt(OXIDATION_KEY);

        switch (slot) {
            case HEAD:
                if (tag.getBoolean(WAX_KEY)) {
                    return "item." + ExtremeRubyMod.MOD_ID + ".waxed_copper_helmet";
                }
                return switch (oxidationStage) {
                    case 1 -> "item." + ExtremeRubyMod.MOD_ID + ".lightly_oxidized_copper_helemt";
                    case 2 -> "item." + ExtremeRubyMod.MOD_ID + ".semi_oxidized_copper_helemt";
                    case 3 -> "item." + ExtremeRubyMod.MOD_ID + ".fully_oxidized_copper_helemt";
                    default -> "item." + ExtremeRubyMod.MOD_ID + ".copper_helemt";
                };
            case CHEST:
                if (tag.getBoolean(WAX_KEY)) {
                    return "item." + ExtremeRubyMod.MOD_ID + ".waxed_copper_chestplate";
                }
                return switch (oxidationStage) {
                    case 1 -> "item." + ExtremeRubyMod.MOD_ID + ".lightly_oxidized_copper_chestplate";
                    case 2 -> "item." + ExtremeRubyMod.MOD_ID + ".semi_oxidized_copper_chestplate";
                    case 3 -> "item." + ExtremeRubyMod.MOD_ID + ".fully_oxidized_copper_chestplate";
                    default -> "item." + ExtremeRubyMod.MOD_ID + ".copper_chestplate";
                };
            case LEGS:
                if (tag.getBoolean(WAX_KEY)) {
                    return "item." + ExtremeRubyMod.MOD_ID + ".waxed_copper_leggings";
                }
                return switch (oxidationStage) {
                    case 1 -> "item." + ExtremeRubyMod.MOD_ID + ".lightly_oxidized_copper_leggings";
                    case 2 -> "item." + ExtremeRubyMod.MOD_ID + ".semi_oxidized_copper_leggings";
                    case 3 -> "item." + ExtremeRubyMod.MOD_ID + ".fully_oxidized_copper_leggings";
                    default -> "item." + ExtremeRubyMod.MOD_ID + ".copper_leggings";
                };
            case FEET:
                if (tag.getBoolean(WAX_KEY)) {
                    return "item." + ExtremeRubyMod.MOD_ID + ".waxed_copper_boots";
                }
                return switch (oxidationStage) {
                    case 1 -> "item." + ExtremeRubyMod.MOD_ID + ".lightly_oxidized_copper_boots";
                    case 2 -> "item." + ExtremeRubyMod.MOD_ID + ".semi_oxidized_copper_boots";
                    case 3 -> "item." + ExtremeRubyMod.MOD_ID + ".fully_oxidized_copper_boots";
                    default -> "item." + ExtremeRubyMod.MOD_ID + ".copper_boots";
                };
        }
        return "item." + ExtremeRubyMod.MOD_ID + ".copper_armor";
    }
}
