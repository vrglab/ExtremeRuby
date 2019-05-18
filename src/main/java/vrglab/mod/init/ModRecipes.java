package vrglab.mod.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ModRecipes 
{

		public static void init() 
		{
			GameRegistry.addSmelting(Blocks.COAL_BLOCK,new ItemStack(Blocks.DIAMOND_BLOCK), 100f);
			GameRegistry.addSmelting(ItemInit.BECON_RAW,new ItemStack(ItemInit.BECON), 164f);
		
		}
	
	
	
	
	
}
