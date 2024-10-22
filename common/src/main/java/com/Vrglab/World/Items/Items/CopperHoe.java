package com.Vrglab.World.Items.Items;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CopperHoe extends HoeItem {
    public CopperHoe(Tier tier, int i, float f, Properties properties) {
        super(tier, i, f, properties);
    }


    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl) {
        super.inventoryTick(itemStack, level, entity, i, bl);
        CopperUtils.ageCopperItemStack(itemStack, level, entity, CopperUtils.MAX_OXIDATION_STAGE);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        return CopperUtils.waxCopperTool(useOnContext, ()->super.useOn(useOnContext));
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        return CopperUtils.GetDescriptionId(stack, "hoe");
    }
}
