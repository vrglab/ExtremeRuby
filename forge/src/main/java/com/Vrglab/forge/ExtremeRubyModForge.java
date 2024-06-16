package com.Vrglab.forge;

import com.Vrglab.World.loottable.LootTableReplacebles;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.Vrglab.ExtremeRubyMod;
import org.Vrglab.forge.Utils.ForgeRegistryCreator;
import software.bernie.geckolib3.GeckoLib;

@Mod(ExtremeRubyMod.MOD_ID)
public final class ExtremeRubyModForge {
    public ExtremeRubyModForge() {
        ForgeRegistryCreator.Create(FMLJavaModLoadingContext.get().getModEventBus(), ExtremeRubyMod.MOD_ID);
        ExtremeRubyMod.init();
        GeckoLib.initialize();
    }

    @SubscribeEvent
    public void lootTableLoadEvent(LootTableLoadEvent e){
        if (e.getName().equals(LootTableReplacebles.ORIGINAL_OBSIDIAN)) {
            e.setTable(e.getLootTableManager().getTable(LootTableReplacebles.NEW_OBSIDIAN));
        }
    }
}
