package com.Vrglab.World.Gen;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.Blocks.ExBlocks;
import net.minecraft.world.gen.GenerationStep;
import org.Vrglab.Modloader.CreationHelpers.*;
import org.Vrglab.Modloader.Registration.Registry;
import org.Vrglab.Modloader.enumTypes.GenReplaceables;
import org.Vrglab.Modloader.enumTypes.VinillaBiomeTypes;

public class ExOreGen {

    /** CONFIGURED FEATS **/
    public static Object RUBY_ORE_CONFIGURED = Registry.RegisterOreConfiguredFeature("ruby_ore_configured", ExtremeRubyMod.MOD_ID,
            ()->OreGenFeatCreationHelper.create().addMatchCase(GenReplaceables.STONE_ORE_REPLACEABLES, ExBlocks.RUBY_ORE).build(), 4);
    public static Object DEEPSLATE_RUBY_ORE_CONFIGURED = Registry.RegisterOreConfiguredFeature("deepslate_ruby_ore_configured", ExtremeRubyMod.MOD_ID,
            ()->OreGenFeatCreationHelper.create().addMatchCase(GenReplaceables.DEEPSLATE_ORE_REPLACEABLES, ExBlocks.RUBY_ORE_DEEPSLATE).build(), 4);


    /** PLACED FEATS **/
    public static Object RUBY_ORE_PLACED = Registry.RegisterPlacedFeature("ruby_ore_placed", ExtremeRubyMod.MOD_ID, RUBY_ORE_CONFIGURED, PlacementModifierCreationHelper.create().
        CountModifier(5).HeightRangePlacement(-80,80).build());
    public static Object DEEPSLATE_RUBY_ORE_PLACED = Registry.RegisterPlacedFeature("deepslate_ruby_ore_placed", ExtremeRubyMod.MOD_ID, DEEPSLATE_RUBY_ORE_CONFIGURED, PlacementModifierCreationHelper.create().
            CountModifier(7).HeightRangePlacement(-80,80).build());

    public static void init(){
        Registry.AddBiomeModification("ruby_ore_biom_mod", ExtremeRubyMod.MOD_ID, VinillaBiomeTypes.OVERWORLD, GenerationStep.Feature.UNDERGROUND_ORES, RUBY_ORE_PLACED);
        Registry.AddBiomeModification("deepslate_ruby_ore_biom_mod", ExtremeRubyMod.MOD_ID, VinillaBiomeTypes.OVERWORLD, GenerationStep.Feature.UNDERGROUND_ORES, DEEPSLATE_RUBY_ORE_PLACED);
    }
}
