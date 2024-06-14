package com.Vrglab.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.Vrglab.ExtremeRubyMod;

@Mod(ExtremeRubyMod.MOD_ID)
public final class ExtremeRubyModForge {
    public ExtremeRubyModForge() {

        EventBuses.registerModEventBus(ExtremeRubyMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        ExtremeRubyMod.init();
    }
}
