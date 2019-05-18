package vrglab.mod.objects.Tools;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import vrglab.mod.Main;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;




public class ToolAxe extends ItemAxe implements IHasModel 
{

	public ToolAxe(String name,ToolMaterial material)
	{
		super(material, 6.0f, -3.0f);
		setUnlocalizedName(name);
    	setRegistryName(name);
    	setCreativeTab(Main.Rubytab);
    	
    	ItemInit.ITEMS.add(this);
		
	}
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
