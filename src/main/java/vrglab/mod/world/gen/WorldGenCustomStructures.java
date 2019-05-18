package vrglab.mod.world.gen;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomeHell;
import net.minecraft.world.biome.BiomeHellDecorator;
import net.minecraft.world.biome.BiomeHills;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import scala.actors.threadpool.Arrays;
import vrglab.mod.init.BlockInit;
import vrglab.mod.world.biomes.BiomeRuby;
import vrglab.mod.world.biomes.BiomeRubyPlains;
import vrglab.mod.world.gen.genorators.WorldGenStructure;

public class WorldGenCustomStructures implements IWorldGenerator
{
    public static final  WorldGenStructure VILLAGERVILLAGE = new WorldGenStructure("villager_village");
    public static final  WorldGenStructure VILLAGERVILLAGERUBY = new WorldGenStructure("villager_village_ruby");
    
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,IChunkProvider chunkProvider) 
    {
       
    	switch(world.provider.getDimension())
    	{
    	case 1:
    		
    		
    		break;
    		
    	case 0:
    		
    		generateStructure(VILLAGERVILLAGE, world, random, chunkX, chunkZ, 1000, Blocks.STONE, BiomeHills.class);
    		generateStructure(VILLAGERVILLAGE, world, random, chunkX, chunkZ, 1000, Blocks.DIRT, BiomeForest.class, BiomePlains.class, BiomeSavanna.class);
    		generateStructure(VILLAGERVILLAGE, world, random, chunkX, chunkZ, 1000, Blocks.SAND, BiomeDesert.class);
    		generateStructure(VILLAGERVILLAGERUBY, world, random, chunkX, chunkZ, 1000, BlockInit.GRAS_RUBY, BiomeRubyPlains.class, BiomeRuby.class);
    		
    		
    		break;
    		
    		
    	case -1:
    		
    		generateStructure(VILLAGERVILLAGE, world, random, chunkX, chunkZ, 1000, Blocks.NETHERRACK, BiomeHell.class);
    		generateStructure(VILLAGERVILLAGE, world, random, chunkX, chunkZ, 1000, Blocks.NETHERRACK, BiomeHellDecorator.class);
    		
    	}
    }
    
    private void  generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock, Class<?>... classes) 
    {
    	ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
    	
    	
    	int x = (chunkX * 16) + random.nextInt(15);
    	int z = (chunkZ * 16) + random.nextInt(15);
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x,y,z);
        
        Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
        
        if(world.getWorldType() != WorldType.FLAT)
        {
        	if(classesList.contains(biome))
        	{
        		if(random.nextInt(chance) == 0)
        		{
        			generator.generate(world, random, pos);
        		}
        	}
        }
    }
    
private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
{
	int y = world.getHeight();
	boolean foundGround = false;
	
	while(!foundGround && y-- >= 0)
	{
		Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
		foundGround = block == topBlock;
	}
	return y;
}

   
   
}
