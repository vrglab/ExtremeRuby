package com.Vrglab.World.Items.Armor;

import com.Vrglab.World.Items.ExItems;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.Vrglab.Modloader.CreationHelpers.TypeTransformer;
import org.Vrglab.Utils.Utils;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ArmorMaterials implements ArmorMaterial {
    RUBY("ruby", 46,   new int[]{4, 7, 9, 4}, 22, SoundEvents.ARMOR_EQUIP_DIAMOND, 4.0F, 0.2F, () -> {
        return Ingredient.of(new ItemLike[]{Utils.convertToMcSafeType(ExItems.RUBY)});
    }),

    OBSIDIAN("obsidian", 66,   new int[]{5, 8, 8, 5}, 35, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, () -> {
        return Ingredient.of(new ItemLike[]{Utils.convertToMcSafeType(ExItems.OBSIDIANBITS)});
    }),

    AMETHYST("amethyst", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.AMETHYST_BLOCK_STEP, 0.0F, 0.0F, () -> {
        return Ingredient.of(new ItemLike[]{Items.AMETHYST_SHARD});
    }),

    REDSTONE("redstone", 33, new int[]{3, 6, 9, 3}, 10, SoundEvents.ARMOR_EQUIP_GENERIC, 6.0F, 0.2F, () -> {
        return Ingredient.of(new ItemLike[]{Items.REDSTONE});
    })
    ;

    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredientSupplier;


    ArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier ingredients) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        repairIngredientSupplier = ingredients;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return  BASE_DURABILITY[type.getSlot().getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
