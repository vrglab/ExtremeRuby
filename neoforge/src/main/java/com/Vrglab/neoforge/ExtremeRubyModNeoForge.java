package com.Vrglab.neoforge;

import com.Vrglab.ExtremeRubyMod;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import org.Vrglab.neoforge.Utils.NeoForgeRegistryCreator;

@Mod(ExtremeRubyMod.MOD_ID)
public class ExtremeRubyModNeoForge {

    public ExtremeRubyModNeoForge() {
        NeoForgeRegistryCreator.Create(ModLoadingContext.get().getActiveContainer().getEventBus(), ExtremeRubyMod.MOD_ID);
        ExtremeRubyMod.init();
    }
}
