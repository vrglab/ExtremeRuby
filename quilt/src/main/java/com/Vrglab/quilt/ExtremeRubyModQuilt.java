package com.Vrglab.quilt;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import com.Vrglab.fabriclike.ExtremeRubyModFabricLike;
import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

public final class ExtremeRubyModQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        ExtremeRubyModFabricLike.init();
        GeckoLib.initialize();
    }
}
