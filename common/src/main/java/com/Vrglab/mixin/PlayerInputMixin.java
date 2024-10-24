package com.Vrglab.mixin;

import com.Vrglab.World.Items.Armor.InfusedElytra;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class) // or ClientPlayerEntity for older versions
public abstract class PlayerInputMixin extends Player {


    @Shadow
    private Input input;

    @Shadow
    public ClientPacketListener connection;

    public PlayerInputMixin(Level level, BlockPos blockPos, float f, GameProfile gameProfile) {
        super(level, blockPos, f, gameProfile);
    }

    // Mixin into aiStep to modify Elytra flight initiation based on input
    @Inject(method = "aiStep", at = @At("HEAD"))
    private void onAiStep(CallbackInfo ci) {
        Player player = (Player) (Object) this;

        boolean isJumping = this.input.jumping;
        boolean isFlying = this.getAbilities().flying;

        if (isJumping && !isFlying && !player.isPassenger() && !player.onClimbable()) {
            ItemStack chestItem = player.getItemBySlot(EquipmentSlot.CHEST);

            if ((chestItem.getItem() instanceof ElytraItem && ElytraItem.isFlyEnabled(chestItem)) ||
                    (chestItem.getItem() instanceof InfusedElytra && ElytraItem.isFlyEnabled(chestItem))) {

                if (this._tryToStartFallFlying()) {
                    connection.send(new ServerboundPlayerCommandPacket(player, ServerboundPlayerCommandPacket.Action.START_FALL_FLYING));
                }
            }
        }
    }

    @Redirect(method = "aiStep",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;tryToStartFallFlying()Z"))
    private boolean redirectTryToStartFallFlying(LocalPlayer instance) {
        return _tryToStartFallFlying();
    }

    private boolean _tryToStartFallFlying() {
        Player player = (Player) (Object) this;
        if (!player.onGround() && !player.isFallFlying() && !player.isInWater() && !player.hasEffect(MobEffects.LEVITATION)) {
            ItemStack chestItem = player.getItemBySlot(EquipmentSlot.CHEST);

            if (chestItem.getItem() instanceof ElytraItem && ElytraItem.isFlyEnabled(chestItem)) {
                player.startFallFlying();
                return true;
            }
        }
        return false;
    }
}
