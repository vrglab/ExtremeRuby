package com.Vrglab.World.Items.Armor;

import com.Vrglab.World.Items.ExItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;
import org.Vrglab.Modloader.CreationHelpers.TypeTransformer;

import java.util.function.Supplier;

public enum ArmorMaterials implements net.minecraft.item.ArmorMaterial {
    RUBY("ruby", 46,   new int[]{4, 7, 9, 4}, 22, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F, 0.2F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{(Item)TypeTransformer.ObjectToType.accept(ExItems.RUBY)});
    }),

    OBSIDIAN("obsidian", 66,   new int[]{5, 8, 10, 5}, 35, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F, 0.9F, () -> {
        return Ingredient.ofItems(new ItemConvertible[]{(Item)TypeTransformer.ObjectToType.accept(ExItems.RUBY)});
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
    private final Lazy<Ingredient> repairIngredientSupplier;


    ArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier ingredients) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        repairIngredientSupplier = new Lazy<>(ingredients);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return  BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
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
