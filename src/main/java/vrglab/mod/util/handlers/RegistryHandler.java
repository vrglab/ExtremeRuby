package vrglab.mod.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vrglab.mod.init.BiomeInit;
import vrglab.mod.init.BlockInit;
import vrglab.mod.init.EntityInit;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;
import vrglab.mod.world.gen.ModWorldGen;
import vrglab.mod.world.gen.WorldGenCustomStructures;
import vrglab.mod.world.types.WorldTypeRuby;


@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
   public static void  onItemRegister(RegistryEvent.Register<Item> event) 
	{
		 event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	   public static void  onBlockRegister(RegistryEvent.Register<Block> event) 
		{
			 event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
			 
		}
	
	@SubscribeEvent
	 public static void  onModelRegister(ModelRegistryEvent event) 
	{
		 for(Item item : ItemInit.ITEMS) 
		 {
			if(item instanceof IHasModel) 
			{
				((IHasModel)item).registerModels();
			}
		 }
		 
		 for(Block block : BlockInit.BLOCKS)
		 {
			 if(block instanceof IHasModel)
			 {
				 ((IHasModel)block).registerModels();
			 }
		 }
	}
	public static void preInitRegistries()
	{
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
	    BiomeInit.registerBioms();
	    System.out.println("all preInit registered");
		
	}
	
	
	public static void InitRegistries()
	{
		
		
		
		
		
		
		System.out.println("all Init registered");
	}
	
	public static void postInitRegistries()
	{
		WorldType RUBY = new WorldTypeRuby();
		
		System.out.println("all PostInit registered");
	}
}
