package com.Vrglab.World.Items.Armor;

import com.Vrglab.World.Items.Armor.Models.AmethystArmorModel;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationController;
import mod.azure.azurelib.common.internal.common.core.animation.RawAnimation;
import net.minecraft.world.item.ArmorMaterial;
import org.Vrglab.AzureLib.Armor.AzureArmor;
import org.Vrglab.Modloader.Types.ICallBack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class AmethystArmor extends AzureArmor {

    public AmethystArmor(ArmorMaterial armorMaterial, Type type, Properties properties) {
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
        return new Supplier<GeoModel<? extends AzureArmor>>() {
            @Override
            public GeoModel<? extends AzureArmor> get() {
                return new AmethystArmorModel();
            }
        };
    }
}
