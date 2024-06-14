package com.Vrglab.fabriclike;

import com.Vrglab.ExtremeRubyMod;
import org.Vrglab.fabriclike.Utils.FabricLikeRegisteryCreator;
import org.Vrglab.fabriclike.VLModFabricLike;

public final class ExtremeRubyModFabricLike {
    public static void init() {
        FabricLikeRegisteryCreator.Create(ExtremeRubyMod.MOD_ID);
        ExtremeRubyMod.init();
    }
}
