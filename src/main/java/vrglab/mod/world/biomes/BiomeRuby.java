package vrglab.mod.world.biomes;

import java.rmi.registry.Registry;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import vrglab.mod.entity.EntityGhost;
import vrglab.mod.entity.EntityVillagerRuby;
import vrglab.mod.init.BlockInit;
import vrglab.mod.util.handlers.EnumHandler;

public class BiomeRuby extends Biome 
{

	

	public BiomeRuby() 
	{
		super(new BiomeProperties("Ruby").setBaseHeight(1.5f).setHeightVariation(1.0f).setTemperature(0.6f).setRainDisabled().setWaterColor(16725548));
		
		topBlock = BlockInit.GRAS_RUBY.getDefaultState();
	
		
		
		
		this.decorator.dirtGen = new WorldGenMinable(STONE, 0);
		this.decorator.cactusGen = new WorldGenMinable(topBlock, 0);
		
		
		this.decorator.treesPerChunk = 4;
		
		
		
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityZombie.class, 10, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityVillagerRuby.class, 10, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityGhost.class, 10, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 10, 1, 5));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityCreeper.class, 10, 1, 5));
	}

}
