package com.Vrglab.World.Items.Armor.Models;

import com.Vrglab.Utils.Utils;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.cache.object.BakedGeoModel;
import mod.azure.azurelib.common.internal.common.core.animatable.GeoAnimatable;
import mod.azure.azurelib.common.internal.common.loading.object.BakedAnimations;
import net.minecraft.resources.ResourceLocation;

public class EnderArmorModel extends GeoModel {

    /**
     * Returns the resource path for the {@link BakedGeoModel} (model json file) to render based on the provided animatable
     *
     * @param animatable
     */
    @Override
    public ResourceLocation getModelResource(GeoAnimatable animatable) {
        return Utils.createLocation("geo/ender_armor.geo.json");
    }

    /**
     * Returns the resource path for the texture file to render based on the provided animatable
     *
     * @param animatable
     */
    @Override
    public ResourceLocation getTextureResource(GeoAnimatable animatable) {
        return Utils.createLocation("textures/armor/ender_armor.png");
    }

    /**
     * Returns the resourcepath for the {@link BakedAnimations} (animation json file) to use for animations based on the provided animatable
     *
     * @param animatable
     */
    @Override
    public ResourceLocation getAnimationResource(GeoAnimatable animatable) {
        return Utils.createLocation("animations/ender_armor.animation.json");
    }
}
