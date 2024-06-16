package com.Vrglab.fabriclike;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.loottable.LootTableReplacebles;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

public class lootTableModifiers {

    public static void init(){
        LootTableEvents.REPLACE.register(((resourceManager, lootManager, id, original, source) -> {
            if(id.equals(LootTableReplacebles.ORIGINAL_OBSIDIAN)) {
                return lootManager.getTable(LootTableReplacebles.NEW_OBSIDIAN);
            }
            return original;
        }));
    }
}
