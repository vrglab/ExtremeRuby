package com.Vrglab.World.Items.Items;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class CopperAxe extends AxeItem {

    public CopperAxe(Tier tier, float f, float g, Properties properties) {
        super(tier, f, g, properties);
    }


    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl) {
        super.inventoryTick(itemStack, level, entity, i, bl);
        CopperUtils.ageCopperItemStack(itemStack, level, entity);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        return CopperUtils.waxCopperTool(useOnContext, ()->super.useOn(useOnContext));
    }

    @Override
    public String getDescriptionId(ItemStack stack) {
        return CopperUtils.GetDescriptionId(stack, "axe");
    }
}
