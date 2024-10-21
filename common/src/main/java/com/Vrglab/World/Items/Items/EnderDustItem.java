package com.Vrglab.World.Items.Items;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EnderDustItem extends Item {
    public EnderDustItem(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl) {
        super.inventoryTick(itemStack, level, entity, i, bl);

        if (!level.isClientSide && entity instanceof Player player) {
            level.getEntities(player, player.getBoundingBox().inflate(16), e -> e instanceof EnderMan)
                    .forEach(e -> {
                        EnderMan enderman = (EnderMan) e;
                        if (enderman.getTarget() == player) {
                            enderman.setTarget(null);
                        }
                    });
        }
    }
}
