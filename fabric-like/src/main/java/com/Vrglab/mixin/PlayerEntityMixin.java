package com.Vrglab.mixin;


import com.Vrglab.World.Items.Armor.InfusedElytra;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class PlayerEntityMixin {

    @Inject(method = "tryToStartFallFlying", at = @At("HEAD"), cancellable = true)
    private void tryToStartFallFlying(CallbackInfoReturnable<Boolean> cir) {
         Player player = (Player)(Object)this;
        ItemStack chestItem = player.getItemBySlot(EquipmentSlot.CHEST);
        if (chestItem.getItem() instanceof ElytraItem && ElytraItem.isFlyEnabled(chestItem)) {
            player.startFallFlying();
            cir.setReturnValue(true);
        }
    }
}
