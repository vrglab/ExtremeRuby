package com.Vrglab.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.ModelProvider;
import org.Vrglab.Utils.VLModInfo;
import org.Vrglab.fabriclike.Utils.FabricLikeRegisteryCreator;

public class ExModelProvider extends FabricModelProvider {

    public ExModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        FabricLikeRegisteryCreator.callBlockDataGen(blockStateModelGenerator, VLModInfo.MOD_ID);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        FabricLikeRegisteryCreator.callItemDataGen(itemModelGenerator, VLModInfo.MOD_ID);
    }
}
