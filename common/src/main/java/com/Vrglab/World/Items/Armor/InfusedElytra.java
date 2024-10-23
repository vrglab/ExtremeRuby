package com.Vrglab.World.Items.Armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class InfusedElytra extends ElytraItem {

    private static final UUID DEFENSE_MODIFIER_UUID = UUID.fromString("92A0F7A1-CF31-4A5B-BD35-6A19A2B5C3FA");
    private static final UUID KNOCKBACK_RESISTANCE_MODIFIER_UUID = UUID.fromString("B4A1C3A1-E274-4F5C-925F-09F2F0C74E30");

    private Item _valid_infusion_item;
    private float _defense_modifier, _knockback_resistance;

    public InfusedElytra(Properties properties, Item valid_infusion_item, float defense_modifier, float knockback_resistance) {
        super(properties);
        _valid_infusion_item = valid_infusion_item;
        _defense_modifier = defense_modifier;
        _knockback_resistance = knockback_resistance;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        if (equipmentSlot == EquipmentSlot.CHEST) {
            builder.put(Attributes.ARMOR, new AttributeModifier(DEFENSE_MODIFIER_UUID, "Elytra defense boost", _defense_modifier, AttributeModifier.Operation.ADDITION));
            builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_MODIFIER_UUID, "Elytra knockback resistance", _knockback_resistance, AttributeModifier.Operation.ADDITION));
        }

        return builder.build();
    }

    @Override
    public boolean isValidRepairItem(ItemStack itemStack, ItemStack itemStack2) {
        return (itemStack2.is(_valid_infusion_item) || super.isValidRepairItem(itemStack, itemStack2));
    }
}
