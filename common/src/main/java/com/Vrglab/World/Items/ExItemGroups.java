package com.Vrglab.World.Items;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.Blocks.ExBlocks;
import org.Vrglab.Helpers.CreativeModeTabBuilder;
import org.Vrglab.Modloader.Registration.Registry;

public class ExItemGroups {
    public static Object EXTREME_RUBY_CREATIVE_GROUP = Registry.RegisterCreativeModeTab("extreme_ruby_creative_tab", ExtremeRubyMod.MOD_ID,
            CreativeModeTabBuilder.create()
                    .setDisplayText("itemGroup.extreme_ruby.creative_tab")
                    .setIcon(ExItems.RUBY)
                    .setEntries(ExItems.getAll(), ExBlocks.getAll())
                    .build()) ;;

    public static void init() {

    }
}
