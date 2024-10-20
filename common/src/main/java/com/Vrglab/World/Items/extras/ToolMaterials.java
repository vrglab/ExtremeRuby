package com.Vrglab.World.Items.extras;

import com.Vrglab.World.Items.ExItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.Vrglab.Modloader.CreationHelpers.TypeTransformer;
import org.Vrglab.Utils.Utils;

import java.util.function.Supplier;

public enum ToolMaterials implements Tier {
    RUBY(5, 3031,10.0f, 5.0f, 22, ()-> {
        return Ingredient.of(new ItemLike() {
            @Override
            public Item asItem() {
                return Utils.convertToMcSafeType(ExItems.RUBY);
            }
        });
    }),

    OBSIDIAN(6, 5031,13.0f, 10.0f, 35, ()-> {
        return Ingredient.of(new ItemLike() {
            @Override
            public Item asItem() {
                return Utils.convertToMcSafeType(ExItems.OBSIDIANBITS);
            }
        });
    }),

    AMETHYST(0, 32, 12.0F, 0.0F, 22, () -> {
        return Ingredient.of(new ItemLike[]{Items.AMETHYST_SHARD});
    }),

    REDSTONE(5, 3031,10.0f, 5.0f, 22, ()-> {
        return Ingredient.of(new ItemLike[]{Items.REDSTONE});
    }),

    COPPER(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.of(new ItemLike[]{Items.COPPER_INGOT});
    })
;


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getUses() {
        return this.itemDurability;
    }

    @Override
    public float getSpeed() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient) this.repairIngredient.get();
    }
}
