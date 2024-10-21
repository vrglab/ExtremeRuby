package com.Vrglab.World.Items;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.Utils.Utils;
import com.Vrglab.World.Items.Armor.AmethystArmor;
import com.Vrglab.World.Items.Armor.ArmorMaterials;
import com.Vrglab.World.Items.Armor.BaseArmorClass;
import com.Vrglab.World.Items.Armor.RedstoneArmor;
import com.Vrglab.World.Items.extras.ToolMaterials;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import org.Vrglab.Modloader.Registration.Registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExItems {

    /** INGOT BASED ITEMS **/
        public static Object RUBY = createItem("ruby", getBaseSettings());

        public static Object OBSIDIANBITS = createItem("obsidianbits", getBaseSettings().fireResistant());


    /**** TOOLS ****/

        /** RUBY **/

        public static Map<ResourceLocation, Object> RUBY_TOOL_SET = createToolSet("ruby", ToolMaterials.RUBY, new int[]{5, 3, 8, 2, 2}, new float[]{-2.9f, -2f, -2f, -1f, -1f}, getBaseSettings());

        /** OBSIDIAN **/

        public static Map<ResourceLocation, Object> OBSIDIAN_TOOL_SET = createToolSet("obsidian", ToolMaterials.OBSIDIAN, new int[]{8, 3, 10, 2, 2}, new float[]{-2f, -2.4f, -3f, -1f, -1f}, getBaseSettings().fireResistant());

        /** AMETHYST **/

        public static Map<ResourceLocation, Object> AMETHYST_TOOL_SET = createToolSet("amethyst", ToolMaterials.AMETHYST, new int[]{2, 1, 3, 1, 1}, new float[]{-1f, -1.4f, -2f, 0, 0}, getBaseSettings());


        /** REDSTONE **/

        public static Map<ResourceLocation, Object> REDSTONE_TOOL_SET = createToolSet("redstone", ToolMaterials.REDSTONE, new int[]{8, 3, 10, 2, 2}, new float[]{-2f, -2.4f, -3f, -1f, -1f}, getBaseSettings());

        /** ENDER **/

        public static Map<ResourceLocation, Object> ENDER_TOOL_SET = createToolSet("ender", ToolMaterials.ENDER, new int[]{5, 3, 8, 2, 2}, new float[]{-2.9f, -2f, -2f, -1f, -1f}, getBaseSettings());


    /**** ARMOR ****/

        /** RUBY **/

        public static Map<ResourceLocation, Object> RUBY_ARMOR_SET = createArmorSet("ruby", ArmorMaterials.RUBY, getBaseSettings());


        /** OBSIDIAN **/

        public static Map<ResourceLocation, Object> OBSIDIAN_ARMOR_SET = createArmorSet("obsidian", ArmorMaterials.OBSIDIAN, getBaseSettings().fireResistant());



        /** AMETHYST **/

        public static Map<ResourceLocation, Object> AMETHYST_ARMOR_SET = createArmorSet("amethyst", ArmorMaterials.AMETHYST, AmethystArmor.class, getBaseSettings());


        /** REDSTONE **/

        public static Map<ResourceLocation, Object> REDSTONE_ARMOR_SET = createArmorSet("redstone", ArmorMaterials.REDSTONE, RedstoneArmor.class, getBaseSettings());

        /** ENDER **/

        public static Map<ResourceLocation, Object> ENDER_ARMOR_SET = createArmorSet("ender", ArmorMaterials.ENDER, BaseArmorClass.class, getBaseSettings());



    /* CORE */

    public static void init(){
    }

    public static Object[] getAll(){
        List<Object> objs = new ArrayList<>();

        objs.add(RUBY);
        objs.add(OBSIDIANBITS);

        mapSet(RUBY_TOOL_SET, RUBY_ARMOR_SET, objs);
        mapSet(OBSIDIAN_TOOL_SET, OBSIDIAN_ARMOR_SET, objs);
        mapSet(AMETHYST_TOOL_SET, AMETHYST_ARMOR_SET, objs);
        mapSet(REDSTONE_TOOL_SET, REDSTONE_ARMOR_SET, objs);

        return objs.toArray();
    }


    /** FUNCTIONS AND HELPERS **/

        /** ITEM SETTINGS HELPER FUNCTIONS **/

        private static Item.Properties getBaseSettings(){
            return new Item.Properties();
        }
        private static Item.Properties getBaseSettings(ResourceKey<CreativeModeTab> tab){
            return new Item.Properties().arch$tab(tab);
        }


        /** INGOT CREATION HELPER **/

        private static <T extends Item> Object createItem(String name, Class<T> clazz, Object... item_args){
            return Registry.RegisterItem(name, ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(clazz, item_args));
        }

        private static <T extends Item> Object createItem(String name, Item.Properties settings, Class<T> clazz){
            return createItem(name, clazz, settings);
        }

        private static Object createItem(String name, Item.Properties settings){
            return createItem(name, settings, Item.class);
        }


        /** TOOL SET CREATION HELPERS **/

        private static Map<ResourceLocation, Object> createToolSet(String name, ToolMaterials material, int[] attack_damages, float[] attack_speeds, Item.Properties[] item_properties, Class[] classes) {
            Map<ResourceLocation, Object> map = new HashMap<>();
            map.put(Utils.createLocation(name.toLowerCase()+ "_sword"), Registry.RegisterItem(name.toLowerCase() + "_sword", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(classes[0], material, attack_damages[0], attack_speeds[0], item_properties[0])));

            map.put(Utils.createLocation(name.toLowerCase() + "_pickaxe"),Registry.RegisterItem(name.toLowerCase() + "_pickaxe", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(classes[1], material, attack_damages[1], attack_speeds[1], item_properties[1])));

            map.put(Utils.createLocation(name.toLowerCase() + "_axe"),  Registry.RegisterItem(name.toLowerCase() + "_axe", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(classes[2], material, (float)attack_damages[2], attack_speeds[2], item_properties[2])));

            map.put(Utils.createLocation(name.toLowerCase() + "_shovel"),    Registry.RegisterItem(name.toLowerCase() + "_shovel", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(classes[3], material, (float)attack_damages[3], attack_speeds[3], item_properties[3])));

            map.put(Utils.createLocation(name.toLowerCase() + "_hoe"), Registry.RegisterItem(name.toLowerCase() + "_hoe", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(classes[4], material, attack_damages[4], attack_speeds[4], item_properties[4])));

            return map;
        }

        private static Map<ResourceLocation, Object> createToolSet(String name, ToolMaterials material, int[] attack_damages, float[] attack_speeds, Item.Properties item_properties) {
            return createToolSet(name, material, attack_damages, attack_speeds,
                    new Item.Properties[]{item_properties, item_properties, item_properties, item_properties,item_properties},
                    new Class[]{SwordItem.class, PickaxeItem.class, AxeItem.class, ShovelItem.class, HoeItem.class}
            );
        }

        private static Map<ResourceLocation, Object> createToolSet(String name, ToolMaterials material, int[] attack_damages, float[] attack_speeds, Item.Properties item_properties, Class[] classes) {
            return createToolSet(name, material, attack_damages, attack_speeds,
                    new Item.Properties[]{item_properties, item_properties, item_properties, item_properties,item_properties},
                    classes
            );
        }


        /** ARMOR CREATION HELPERS **/

        private static <T extends ArmorItem> Map<ResourceLocation, Object> createArmorSet(String name, ArmorMaterials material, Class<T> armor_class, Item.Properties[] item_properties) {
            Map<ResourceLocation, Object> map = new HashMap<>();

            map.put(Utils.createLocation(name.toLowerCase()+ "_helmet"),  Registry.RegisterItem(name.toLowerCase()+ "_helmet", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(armor_class, material, ArmorItem.Type.HELMET, item_properties[0])));

            map.put(Utils.createLocation(name.toLowerCase()+ "_chestplate"), Registry.RegisterItem(name.toLowerCase()+ "_chestplate", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(armor_class, material, ArmorItem.Type.CHESTPLATE, item_properties[1])));

            map.put(Utils.createLocation(name.toLowerCase()+ "_leggings"), Registry.RegisterItem(name.toLowerCase()+ "_leggings", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(armor_class, material, ArmorItem.Type.LEGGINGS, item_properties[2])));

            map.put(Utils.createLocation(name.toLowerCase()+ "_boots"), Registry.RegisterItem(name.toLowerCase()+ "_boots", ExtremeRubyMod.MOD_ID,
                    ()->Utils.createInstance(armor_class, material, ArmorItem.Type.BOOTS, item_properties[3])));
            return map;
        }

        private static  <T extends ArmorItem> Map<ResourceLocation, Object> createArmorSet(String name, ArmorMaterials material, Class<T> armor_class, Item.Properties item_properties) {
            return createArmorSet(name, material, armor_class, new Item.Properties[]{item_properties, item_properties, item_properties, item_properties,item_properties});
        }

        private static  <T extends ArmorItem> Map<ResourceLocation, Object> createArmorSet(String name, ArmorMaterials material, Item.Properties item_properties) {
            return createArmorSet(name, material, BaseArmorClass.class, new Item.Properties[]{item_properties, item_properties, item_properties, item_properties,item_properties});
        }



        /** get all mapping helper **/

        private static void mapItems(Map map, List<Object> obj_list){
            for (var obj:map.values()) {
                obj_list.add(obj);
            }
        }

        private static void mapSet(Map item_map, Map armor_map,List<Object> obj_list){
            mapItems(item_map, obj_list);
            mapItems(armor_map, obj_list);
        }
}
