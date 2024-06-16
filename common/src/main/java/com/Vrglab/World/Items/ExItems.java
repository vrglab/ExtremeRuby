package com.Vrglab.World.Items;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.Items.Armor.ArmorMaterials;
import com.Vrglab.World.Items.Armor.RubyArmorItem;
import com.Vrglab.World.Items.extras.ToolMaterials;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import org.Vrglab.Modloader.Registration.Registry;

public class ExItems {

    /** INGOT BASED ITEMS **/
    public static Object RUBY = Registry.RegisterItem("ruby", ExtremeRubyMod.MOD_ID,
            ()->new Item(getBaseSettings()));


    /** TOOLS **/
    public static Object RUBY_SWORD = Registry.RegisterItem("ruby_sword", ExtremeRubyMod.MOD_ID,
            ()->new SwordItem(ToolMaterials.RUBY, 5, -2.9f, getBaseSettings()));
    public static Object RUBY_PICKAXE = Registry.RegisterItem("ruby_pickaxe", ExtremeRubyMod.MOD_ID,
            ()->new PickaxeItem(ToolMaterials.RUBY, 3, -2f, getBaseSettings()));
    public static Object RUBY_AXE = Registry.RegisterItem("ruby_axe", ExtremeRubyMod.MOD_ID,
            ()->new AxeItem(ToolMaterials.RUBY, 8, -2, getBaseSettings()));
    public static Object RUBY_SHOVEL = Registry.RegisterItem("ruby_shovel", ExtremeRubyMod.MOD_ID,
            ()->new ShovelItem(ToolMaterials.RUBY, 2, -1, getBaseSettings()));
    public static Object RUBY_HOE = Registry.RegisterItem("ruby_hoe", ExtremeRubyMod.MOD_ID,
            ()->new HoeItem(ToolMaterials.RUBY, 2, -1, getBaseSettings()));

    /** ARMOUR **/
    public static Object RUBY_HELMET = Registry.RegisterItem("ruby_helmet", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.RUBY, EquipmentSlot.HEAD, getBaseSettings()));
    public static Object RUBY_CHESTPLATE = Registry.RegisterItem("ruby_chestplate", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.RUBY, EquipmentSlot.CHEST, getBaseSettings()));
    public static Object RUBY_LEGGINGS = Registry.RegisterItem("ruby_leggings", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.RUBY, EquipmentSlot.LEGS, getBaseSettings()));
    public static Object RUBY_BOOTS = Registry.RegisterItem("ruby_boots", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.RUBY, EquipmentSlot.FEET, getBaseSettings()));


    private static Item.Settings getBaseSettings(){
        return new Item.Settings().group(ExItemGroups.EXTREME_RUBY_CREATIVE_GROUP);
    }
    public static void init(){
    }
}
