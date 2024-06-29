package com.Vrglab.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import org.Vrglab.fabriclike.Utils.FabricLikeRegisteryCreator;

import java.util.concurrent.CompletableFuture;

public class WorldGenData extends FabricDynamicRegistryProvider {
    public WorldGenData(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        FabricLikeRegisteryCreator.configureBootstrappables(registries, entries);
    }

    @Override
    public String getName() {
        return "World Generation";
    }
}
