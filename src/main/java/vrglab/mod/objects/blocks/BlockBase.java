package vrglab.mod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import vrglab.mod.Main;
import vrglab.mod.init.BlockInit;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;

public class BlockBase extends Block implements IHasModel
{
	

	public BlockBase(String name, Material material) 

	{

		super(material);

		setUnlocalizedName(name);

		setRegistryName(name);

		setCreativeTab(Main.Rubytab);

		

		BlockInit.BLOCKS.add(this);

		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(name));

	}

	

	@Override

	public void registerModels() 

	{

		Main.proxy.registerModel(Item.getItemFromBlock(this), 0);

	}
}
