package com.Vrglab.fabric;

import net.fabricmc.api.ModInitializer;

import com.Vrglab.fabriclike.ExtremeRubyModFabricLike;
import org.Vrglab.fabriclike.VLModFabricLike;
import software.bernie.geckolib3.GeckoLib;

public final class ExtremeRubyModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExtremeRubyModFabricLike.init();
        GeckoLib.initialize();
    }
}
