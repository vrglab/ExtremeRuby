package com.Vrglab;

import com.Vrglab.World.Blocks.ExBlocks;
import com.Vrglab.World.Gen.ExWorldGen;
import com.Vrglab.World.Items.ExItemGroups;
import com.Vrglab.World.Items.ExItems;
import com.Vrglab.World.Rendering.ExGeckoRenderers;

public final class ExtremeRubyMod {
    public static final String MOD_ID = "extreme_ruby";

    public static void init() {
        ExItemGroups.init();
        ExItems.init();
        ExBlocks.init();
        ExWorldGen.init();
        ExGeckoRenderers.init();
    }
}
