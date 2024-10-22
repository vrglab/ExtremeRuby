package com.Vrglab.World.Items.Armor;

import com.Vrglab.World.Items.Armor.Models.CopperArmorModel;
import com.Vrglab.World.Items.Items.CopperUtils;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationController;
import mod.azure.azurelib.common.internal.common.core.animation.RawAnimation;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.Vrglab.AzureLib.Armor.AzureArmor;
import org.Vrglab.Modloader.Types.ICallBack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CopperArmor extends AzureArmor {


    public CopperArmor(ArmorMaterial armorMaterial, Type type, Properties properties) {
        super(armorMaterial, type, properties);
    }

    @Override
    public ICallBack getControllers() {
        List<AnimationController> controllerList = new ArrayList<>();
        controllerList.add(new AnimationController(this, "idleController", 0, event -> {
            return event.setAndContinue(RawAnimation.begin().thenLoop("idle"));
        }));
        return new ICallBack() {
            @Override
            public Object accept(Object... args) {
                return controllerList;
            }
        };
    }

    @Override
    public Supplier<GeoModel<? extends AzureArmor>> getModel() {
        return () -> new CopperArmorModel();
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        return CopperUtils.waxCopperTool(useOnContext, ()->super.useOn(useOnContext));
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl) {
        super.inventoryTick(itemStack, level, entity, i, bl);
        CopperUtils.ageCopperItemStack(itemStack, level, entity);
    }

    @Override
    public String getDescriptionId(ItemStack itemStack) {
        return CopperUtils.GetDescription(itemStack, this.getEquipmentSlot());
    }
}
