package com.Vrglab.quilt;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

import com.Vrglab.fabriclike.ExtremeRubyModFabricLike;

public final class ExtremeRubyModQuilt implements ModInitializer {
    @Override
    public void onInitialize(ModContainer mod) {
        ExtremeRubyModFabricLike.init();
    }
}
