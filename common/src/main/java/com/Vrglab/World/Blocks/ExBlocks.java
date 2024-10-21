package com.Vrglab.World.Blocks;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.Utils.Utils;
import com.Vrglab.World.Items.ExItemGroups;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.Vrglab.Modloader.Registration.Registry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExBlocks {

    /** BASIC BLOCKS **/

        /** RUBY BLOCK **/

        public static Object RUBY_BLOCK = Registry.RegisterBlock("ruby_block", ExtremeRubyMod.MOD_ID,
                ()->new Block(BlockBehaviour.Properties.of()), ()->getBaseItemSettings());


    /** ORE BLOCKS**/

        /** RUBY ORES **/
        public static Map<ResourceLocation, Object> RUBY_ORE_SET = createOreSet("ruby",
                new Class[]{DropExperienceBlock.class, DropExperienceBlock.class},
                new BlockBehaviour.Properties[]{getToolRequiredSettings(4,4), getToolRequiredSettings(4,4)},
                new Item.Properties[]{getBaseItemSettings(), getBaseItemSettings()},
                new int[]{1, -20},
                new int[] {10, 7}
                );



    /** CORE **/

    public static void init() {}

    public static Object[] getAll(){
        List<Object> objs = new ArrayList<>();
        objs.add(RUBY_BLOCK);

        mapSet(RUBY_ORE_SET, objs);

        return objs.toArray();
    }



    /** FUNCTIONS AND HELPERS **/

        /** ITEM/BLOCK SETTINGS HELPER FUNCTIONS **/

        private static Item.Properties getBaseItemSettings() {
            return new Item.Properties();
        }

        private static Item.Properties getBaseItemSettings(ResourceKey<CreativeModeTab> tab){
            return new Item.Properties().arch$tab(tab);
        }

        private static BlockBehaviour.Properties getToolRequiredSettings(float hardness, float resitance){
            return BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(hardness, resitance);
        }



        /** Mapping helper **/

        private static void mapSet(Map map, List<Object> obj_list){
            for (var obj:map.values()) {
                obj_list.add(obj);
            }
        }



        /** SET CREATION HELPERS **/

        private static Map<ResourceLocation, Object> createOreSet(String ore_name, Class[] Block_types, BlockBehaviour.Properties[] properties, Item.Properties[] item_properties, int[] lowst_spawn_point, int[] highest_spawn_point) {
            Map<ResourceLocation, Object> map = new HashMap<>();

            map.put(Utils.createLocation(ore_name.toLowerCase() + "_ore"), Registry.RegisterBlock(ore_name.toLowerCase() + "_ore", ExtremeRubyMod.MOD_ID,
                    ()-> Utils.createInstance(Block_types[0], UniformInt.of(lowst_spawn_point[0],highest_spawn_point[0]), properties[0]), ()->item_properties[0]));

            map.put(Utils.createLocation("deepslate" + ore_name.toLowerCase() + "_ore"), Registry.RegisterBlock("deepslate" + ore_name.toLowerCase() + "_ore", ExtremeRubyMod.MOD_ID,
                    ()-> Utils.createInstance(Block_types[1], UniformInt.of(lowst_spawn_point[1],highest_spawn_point[1]), properties[1]), ()->item_properties[1]));

            return map;
        }
}
