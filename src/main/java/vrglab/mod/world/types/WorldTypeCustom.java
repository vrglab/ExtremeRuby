package vrglab.mod.world.types;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import vrglab.mod.init.BiomeInit;

public class WorldTypeCustom extends WorldType
{

	public WorldTypeCustom() 
	{
		super("Ruby");
	}
	@Override
	public BiomeProvider getBiomeProvider(World world)
	{
		return new BiomeProviderSingle(BiomeInit.RUBY);
	}

}
