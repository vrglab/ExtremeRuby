package com.Vrglab.mixin;


import com.Vrglab.Utils.MixinUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public class PlayerEntityMixin {

    @Redirect(method = "tryToStartFallFlying",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"))
    private boolean onAiStep(ItemStack instance, Item item) {
        return MixinUtils.replacedItemTypeCheck(instance, item, ElytraItem.class);
    }
}
