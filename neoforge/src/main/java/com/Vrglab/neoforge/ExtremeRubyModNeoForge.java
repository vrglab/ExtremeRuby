package com.Vrglab.neoforge;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.Items.Armor.InfusedElytra;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;
import org.Vrglab.neoforge.Utils.NeoForgeRegistryCreator;

@Mod(ExtremeRubyMod.MOD_ID)
public class ExtremeRubyModNeoForge {

    public ExtremeRubyModNeoForge() {
        NeoForgeRegistryCreator.Create(ModLoadingContext.get().getActiveContainer().getEventBus(), ExtremeRubyMod.MOD_ID);
        ExtremeRubyMod.init();
    }
}
