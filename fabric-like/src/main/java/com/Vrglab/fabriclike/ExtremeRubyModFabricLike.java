package com.Vrglab.fabriclike;

import com.Vrglab.ExtremeRubyMod;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import org.Vrglab.fabriclike.Utils.FabricLikeRegisteryCreator;
import org.Vrglab.fabriclike.VLModFabricLike;

public final class ExtremeRubyModFabricLike {
    public static void init() {
        FabricLikeRegisteryCreator.Create(ExtremeRubyMod.MOD_ID);
        ExtremeRubyMod.init();
        lootTableModifiers.init();
    }
}
