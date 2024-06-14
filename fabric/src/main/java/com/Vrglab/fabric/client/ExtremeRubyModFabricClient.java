package com.Vrglab.fabric.client;

import com.Vrglab.ExtremeRubyMod;
import net.fabricmc.api.ClientModInitializer;
import org.Vrglab.fabriclike.Utils.FabricLikeRegisteryCreator;

public final class ExtremeRubyModFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FabricLikeRegisteryCreator.CreateClient(ExtremeRubyMod.MOD_ID);
    }
}
