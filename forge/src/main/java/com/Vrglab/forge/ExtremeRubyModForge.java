package com.Vrglab.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.Vrglab.ExtremeRubyMod;
import org.Vrglab.forge.Utils.ForgeRegistryCreator;

@Mod(ExtremeRubyMod.MOD_ID)
public final class ExtremeRubyModForge {
    public ExtremeRubyModForge() {
        ForgeRegistryCreator.Create(FMLJavaModLoadingContext.get().getModEventBus(), ExtremeRubyMod.MOD_ID);
        ExtremeRubyMod.init();
    }
}
