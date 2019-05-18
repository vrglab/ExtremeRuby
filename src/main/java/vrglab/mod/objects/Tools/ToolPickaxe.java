package vrglab.mod.objects.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;
import vrglab.mod.Main;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;

public class ToolPickaxe extends ItemPickaxe implements IHasModel
{

	public ToolPickaxe(String name, ToolMaterial material) 
	{
		super(material);
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
