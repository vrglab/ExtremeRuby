package vrglab.mod.world.biomes;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;
import vrglab.mod.entity.EntityGhost;
import vrglab.mod.entity.EntityVillagerRuby;
import vrglab.mod.init.BlockInit;

public class BiomeRubyPlains extends Biome
{



public BiomeRubyPlains() 
{
	super(new BiomeProperties("Ruby_plains").setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(0.8F).setRainfall(0.4F).setWaterColor(16725548));
	
	topBlock = BlockInit.GRAS_RUBY.getDefaultState();

	
	
	
	this.decorator.dirtGen = new WorldGenMinable(STONE, 0);
	this.decorator.cactusGen = new WorldGenMinable(topBlock, 0);
	
	
	this.decorator.treesPerChunk = 4;
	
	
	
	
	this.spawnableCreatureList.add(new SpawnListEntry(EntityZombie.class, 10, 1, 5));
	this.spawnableCreatureList.add(new SpawnListEntry(EntityVillagerRuby.class, 5, 1, 5));
	this.spawnableCreatureList.add(new SpawnListEntry(EntityGhost.class, 10, 1, 5));
	this.spawnableCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 10, 1, 5));
	this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 10, 1, 5));
}

}

