package com.Vrglab.World.Items.extras;

import com.Vrglab.World.Items.ExItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;
import org.Vrglab.Modloader.CreationHelpers.TypeTransformer;

import java.util.function.Supplier;

public enum ToolMaterials implements net.minecraft.item.ToolMaterial {
    RUBY(5, 3031,10.0f, 5.0f, 22, ()-> {
        return Ingredient.ofItems(new ItemConvertible[]{(Item)TypeTransformer.ObjectToType.accept(ExItems.RUBY)});
    }),

    OBSIDIAN(6, 5031,13.0f, 10.0f, 35, ()-> {
        return Ingredient.ofItems(new ItemConvertible[]{(Item)TypeTransformer.ObjectToType.accept(ExItems.OBSIDIANBITS)});
    })
;


    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    ToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
