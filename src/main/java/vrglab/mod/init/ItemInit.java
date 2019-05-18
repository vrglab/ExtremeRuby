package vrglab.mod.init;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import vrglab.mod.objects.Tools.ToolAxe;
import vrglab.mod.objects.Tools.ToolHoe;
import vrglab.mod.objects.Tools.ToolPickaxe;
import vrglab.mod.objects.Tools.ToolShovel;
import vrglab.mod.objects.Tools.ToolSword;
import vrglab.mod.objects.armour.ArmourBase;
import vrglab.mod.objects.blocks.BlockBase;
import vrglab.mod.objects.item.ItemBase;
import vrglab.mod.objects.item.food.FoodBase;


import vrglab.mod.util.Reference;

public class ItemInit 
{
  public static final List<Item> ITEMS = new ArrayList<Item>();
  
  //Material tool
  public static final ToolMaterial TOOL_RUBY = EnumHelper.addToolMaterial("tool_ruby", 3, 15610, 8.0f, 4.0f, 22);
  
  public static final ToolMaterial TOOL_ENDER = EnumHelper.addToolMaterial("tool_ender", 3, 26711, 9.0f, 5.0f, 33);
  
  public static final ToolMaterial TOOL_ASHES = EnumHelper.addToolMaterial("tool_ashes", 1, 234, 6.0f, 3.0f, 1);
  
//Material armour
  public static final ArmorMaterial ARMOUR_RUBY = EnumHelper.addArmorMaterial("armour_ruby", Reference.MODID + ":ruby", 33, new int[]{4, 7, 9, 4}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
  public static final ArmorMaterial ARMOUR_ENDER = EnumHelper.addArmorMaterial("armour_ender", Reference.MODID + ":ender", 33, new int[]{45, 18, 12, 10}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
  public static final ArmorMaterial ARMOUR_ASHES = EnumHelper.addArmorMaterial("armour_ashes", Reference.MODID + ":ashes", 33, new int[]{3, 5, 3, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
  
  //items
  public static final Item RUBY_INGOT = new ItemBase("ruby_ingot");
  public static final Item RUBY = new ItemBase("ruby");
  public static final Item OBSIDIEN_INGOT = new ItemBase("obsidien_ingot");
  public static final Item ASHES = new ItemBase("ashes");
  public static final Item ASHES_ON_FIRE = new ItemBase("ashes_on_fire");
  public static final Item DIAMOND_ASHES = new ItemBase("diamond_ashes");
  public static final Item DIAMOND_NUGGET = new ItemBase("diamond_nugget");
  public static final Item COPPER = new ItemBase("copper");
  
  
  //tools
  public static final Item AXE_RUBY = new ToolAxe("axe_ruby",TOOL_RUBY);
  public static final Item HOE_RUBY = new ToolHoe("hoe_ruby", TOOL_RUBY);
  public static final Item PICKAXE_RUBY = new ToolPickaxe("pickaxe_ruby", TOOL_RUBY);
  public static final Item SHOVEL_RUBY = new ToolShovel("shovel_ruby", TOOL_RUBY);
  public static final Item SWORD_RUBY = new ToolSword("sword_ruby", TOOL_RUBY);
  
  
  public static final Item AXE_ASHES = new ToolAxe("axe_ashes",TOOL_ASHES);
  public static final Item HOE_ASHES = new ToolHoe("hoe_ashes", TOOL_ASHES);
  public static final Item PICKAXE_ASHES = new ToolPickaxe("pickaxe_ashes", TOOL_ASHES);
  public static final Item SHOVEL_ASHES = new ToolShovel("shovel_ashes", TOOL_ASHES);
  public static final Item SWORD_ASHES = new ToolSword("sword_ashes", TOOL_ASHES);
  
  
  public static final Item AXE_ENDER = new ToolAxe("axe_ender",TOOL_ENDER);
  public static final Item HOE_ENDER = new ToolHoe("hoe_ender", TOOL_ENDER);
  public static final Item PICKAXE_ENDER = new ToolPickaxe("pickaxe_ender", TOOL_ENDER);
  public static final Item SHOVEL_ENDER = new ToolShovel("shovel_ender", TOOL_ENDER);
  public static final Item SWORD_ENDER = new ToolSword("sword_ender", TOOL_ENDER);
  
  //armour
  public static final Item HELMET_RUBY = new ArmourBase("helmet_ruby", ARMOUR_RUBY, 1, EntityEquipmentSlot.HEAD);
  public static final Item CHESTPLATE_RUBY = new ArmourBase("chestplate_ruby", ARMOUR_RUBY, 1, EntityEquipmentSlot.CHEST);
  public static final Item LEGGINGS_RUBY = new ArmourBase("leggings_ruby", ARMOUR_RUBY, 2, EntityEquipmentSlot.LEGS);
  public static final Item BOOTS_RUBY = new ArmourBase("boots_ruby", ARMOUR_RUBY, 1, EntityEquipmentSlot.FEET);
  
  
  public static final Item HELMET_ENDER = new ArmourBase("helmet_ender", ARMOUR_ENDER, 1, EntityEquipmentSlot.HEAD);
  public static final Item CHESTPLATE_ENDER = new ArmourBase("chestplate_ender", ARMOUR_ENDER, 1, EntityEquipmentSlot.CHEST);
  public static final Item LEGGINGS_ENDER = new ArmourBase("leggings_ender", ARMOUR_ENDER, 2, EntityEquipmentSlot.LEGS);
  public static final Item BOOTS_ENDER = new ArmourBase("boots_ender", ARMOUR_ENDER, 1, EntityEquipmentSlot.FEET);
  
  public static final Item HELMET_ASHES = new ArmourBase("helmet_ashes", ARMOUR_ASHES, 1, EntityEquipmentSlot.HEAD);
  public static final Item CHESTPLATE_ASHES = new ArmourBase("chestplate_ashes", ARMOUR_ASHES, 1, EntityEquipmentSlot.CHEST);
  public static final Item LEGGINGS_ASHES = new ArmourBase("leggings_ashes", ARMOUR_ASHES, 2, EntityEquipmentSlot.LEGS);
  public static final Item BOOTS_ASHES = new ArmourBase("boots_ashes", ARMOUR_ASHES, 1, EntityEquipmentSlot.FEET);
  
  
  //food
  
  public static final Item EVIL_APPEL = new FoodBase("evil_appel", 4, 4, false);
  public static final Item BECON_RAW = new FoodBase("becon_raw", 5, 4, false);
  public static final Item BECON = new FoodBase("becon", 20, 100, false);
  
 
  
  
  
  
  
  
  
  
  
  
}
