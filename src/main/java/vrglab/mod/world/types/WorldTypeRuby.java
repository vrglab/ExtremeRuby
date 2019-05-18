package vrglab.mod.world.types;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;
import vrglab.mod.init.BiomeInit;

public class WorldTypeRuby extends WorldType
{

	public WorldTypeRuby() 
	{
		super("Ruby");
	}
	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer, ChunkGeneratorSettings chunkSettings) {
		
		return super.getBiomeLayer(worldSeed, parentLayer, chunkSettings);
	}
}
