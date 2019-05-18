package vrglab.mod.init;

import akka.io.Tcp.Register;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import vrglab.mod.world.biomes.BiomeRuby;
import vrglab.mod.world.biomes.BiomeRubyPlains;

public class BiomeInit 
{
	
	public static final Biome RUBY = new BiomeRuby();
	public static final Biome RUBY_PLAIN = new BiomeRubyPlains();
	
	
	
	
	
     public static void registerBioms() 
     {
    	 initBiome(RUBY, "Ruby", BiomeType.WARM, Type.HILLS, Type.DRY);
    	 initBiome(RUBY_PLAIN, "Ruby_plains", BiomeType.WARM, Type.PLAINS, Type.PLAINS);
     }
     private static Biome initBiome(Biome biome, String name, BiomeType biomType, Type... types)
     {
    	 biome.setRegistryName(name);
    	 ForgeRegistries.BIOMES.register(biome);
    	 System.out.println("Biome registered");
    	 BiomeDictionary.addTypes(biome, types);
    	 BiomeManager.addBiome(biomType, new BiomeEntry(biome, 10));
    	 BiomeManager.addSpawnBiome(biome);
    	 System.out.println("Biome Added");
    	 return biome;
     }
}
