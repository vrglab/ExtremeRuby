package com.Vrglab.fabric;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.Utils.Utils;
import com.Vrglab.World.CustomRegistery.RegistryTypes;
import net.fabricmc.api.ModInitializer;

import com.Vrglab.fabriclike.ExtremeRubyModFabricLike;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroupBuilderImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import org.Vrglab.Modloader.Registration.Registry;
import org.Vrglab.Modloader.Types.ICallBack;
import org.Vrglab.fabriclike.VLModFabricLike;

public final class ExtremeRubyModFabric implements ModInitializer {
    @Override
    public void onInitialize() {

        Registry.initRegistry(new ICallBack() {
            @Override
            public Object accept(Object... objects) {
                return (Object)net.minecraft.core.Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Utils.createLocation(objects[0].toString()),(CreativeModeTab)objects[1]);
            }
        }, RegistryTypes.ITEM_GROUP, ExtremeRubyMod.MOD_ID);
        ExtremeRubyModFabricLike.init();
    }
}
