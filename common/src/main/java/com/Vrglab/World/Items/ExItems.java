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
    public static Object OBSIDIANBITS = Registry.RegisterItem("obsidianbits", ExtremeRubyMod.MOD_ID,
            ()->new Item(getBaseSettings()));


    /**** TOOLS ****/

    /** RUBY **/
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

    /** OBSIDIAN **/
    public static Object OBSIDIAN_SWORD = Registry.RegisterItem("obsidian_sword", ExtremeRubyMod.MOD_ID,
            ()->new SwordItem(ToolMaterials.OBSIDIAN, 8, -2f, getBaseSettings()));
    public static Object OBSIDIAN_PICKAXE = Registry.RegisterItem("obsidian_pickaxe", ExtremeRubyMod.MOD_ID,
            ()->new PickaxeItem(ToolMaterials.OBSIDIAN, 3, -2.4f, getBaseSettings()));
    public static Object OBSIDIAN_AXE = Registry.RegisterItem("obsidian_axe", ExtremeRubyMod.MOD_ID,
            ()->new AxeItem(ToolMaterials.OBSIDIAN, 10, -3, getBaseSettings()));
    public static Object OBSIDIAN_SHOVEL = Registry.RegisterItem("obsidian_shovel", ExtremeRubyMod.MOD_ID,
            ()->new ShovelItem(ToolMaterials.OBSIDIAN, 2, -1, getBaseSettings()));
    public static Object OBSIDIAN_HOE = Registry.RegisterItem("obsidian_hoe", ExtremeRubyMod.MOD_ID,
            ()->new HoeItem(ToolMaterials.OBSIDIAN, 2, -1, getBaseSettings()));

    /**** ARMOUR ****/

    /** RUBY **/
    public static Object RUBY_HELMET = Registry.RegisterItem("ruby_helmet", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.RUBY, EquipmentSlot.HEAD, getBaseSettings()));
    public static Object RUBY_CHESTPLATE = Registry.RegisterItem("ruby_chestplate", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.RUBY, EquipmentSlot.CHEST, getBaseSettings()));
    public static Object RUBY_LEGGINGS = Registry.RegisterItem("ruby_leggings", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.RUBY, EquipmentSlot.LEGS, getBaseSettings()));
    public static Object RUBY_BOOTS = Registry.RegisterItem("ruby_boots", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.RUBY, EquipmentSlot.FEET, getBaseSettings()));


    /** OBSIDIAN **/
    public static Object OBSIDIAN_HELMET = Registry.RegisterItem("obsidian_helmet", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.OBSIDIAN, EquipmentSlot.HEAD, getBaseSettings()));
    public static Object OBSIDIAN_CHESTPLATE = Registry.RegisterItem("obsidian_chestplate", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.OBSIDIAN, EquipmentSlot.CHEST, getBaseSettings()));
    public static Object OBSIDIAN_LEGGINGS = Registry.RegisterItem("obsidian_leggings", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.OBSIDIAN, EquipmentSlot.LEGS, getBaseSettings()));
    public static Object OBSIDIAN_BOOTS = Registry.RegisterItem("obsidian_boots", ExtremeRubyMod.MOD_ID,
            ()->new RubyArmorItem(ArmorMaterials.OBSIDIAN, EquipmentSlot.FEET, getBaseSettings()));

    private static Item.Settings getBaseSettings(){
        return new Item.Settings().group(ExItemGroups.EXTREME_RUBY_CREATIVE_GROUP);
    }
    public static void init(){
    }
}
