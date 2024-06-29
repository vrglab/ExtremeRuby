package com.Vrglab.fabric.datagen;

import com.Vrglab.ExtremeRubyMod;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataProvider;
import org.Vrglab.Utils.Modinfo;
import org.Vrglab.fabric.VLWorldGen;
import org.Vrglab.fabriclike.Utils.FabricLikeRegisteryCreator;

public class ExDataGen  implements DataGeneratorEntrypoint {
    /**
     * Register {@link DataProvider} with the {@link FabricDataGenerator} during this entrypoint.
     *
     * @param fabricDataGenerator The {@link FabricDataGenerator} instance
     */
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(WorldGenData::new);
    }

    /**
     * Builds a registry containing dynamic registry entries to be generated.
     * Users should call {@link RegistrySetBuilder#add(net.minecraft.resources.ResourceKey, RegistrySetBuilder.RegistryBootstrap)}
     * to register a bootstrap function, which adds registry entries to be generated.
     *
     * <p>This is invoked asynchronously.
     *
     * @param registryBuilder a {@link RegistrySetBuilder} instance
     */
    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        FabricLikeRegisteryCreator.boostrap(registryBuilder, ExtremeRubyMod.MOD_ID);
    }
}
