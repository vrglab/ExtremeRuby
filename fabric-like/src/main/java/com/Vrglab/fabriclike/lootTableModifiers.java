package com.Vrglab.fabriclike;


import com.Vrglab.World.loottable.LootTableReplacebles;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;

public class lootTableModifiers {

    public static void init(){
        LootTableEvents.REPLACE.register(((resourceManager, lootManager, id, original, source) -> {
            if(id.equals(LootTableReplacebles.ORIGINAL_OBSIDIAN)) {
                return lootManager.getLootTable(LootTableReplacebles.NEW_OBSIDIAN);
            }
            return original;
        }));
    }
}
