package com.Vrglab.World.Items.Armor.Models;

import com.Vrglab.Utils.Utils;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animatable.GeoAnimatable;
import net.minecraft.resources.ResourceLocation;

public class CopperArmorModel extends GeoModel {
    @Override
    public ResourceLocation getModelResource(GeoAnimatable animatable) {
        return Utils.createLocation("geo/copper_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeoAnimatable animatable) {
        return Utils.createLocation("textures/armor/copper_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeoAnimatable animatable) {
        return Utils.createLocation("animations/copper_armor.animation.json");
    }
}
