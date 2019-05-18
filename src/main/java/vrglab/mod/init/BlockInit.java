package vrglab.mod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import vrglab.mod.objects.blocks.BlockBase;
import vrglab.mod.objects.blocks.Ores.CopperOre;
import vrglab.mod.objects.blocks.Ores.EnderOre;
import vrglab.mod.objects.blocks.Ores.RubyOre;
import vrglab.mod.objects.blocks.machines.crafter.BlockCrafter;
import vrglab.mod.objects.blocks.machines.crusher.BlockCrusher;


public class BlockInit 
{
 public static final List<Block> BLOCKS = new ArrayList<Block>();
 
 //blocks
 public static final Block BLOCK_RUBY = new BlockBase("block_ruby", Material.IRON);
 public static final Block BLOCK_ASHES = new BlockBase("block_ashes", Material.GRASS);
 
 //ore
 public static final Block COPPER_ORE = new CopperOre("copper_ore", Material.ROCK);
 public static final Block RUBY_ORE = new RubyOre("ruby_ore", Material.ROCK);
 public static final Block ENDER_ORE = new EnderOre("ender_ore", Material.ROCK);


//biome blocks
 public static final Block GRAS_RUBY = new BlockBase("gras_ruby", Material.GRASS);
 
 
 //functional
 
 public static final Block CRUSHER = new BlockCrusher("crusher");
 public static final Block CRAFTER = new BlockCrafter("crafter");
 



 
 


 
}
