package vrglab.mod.objects.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import vrglab.mod.Main;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;

public class ToolHoe extends ItemHoe implements IHasModel
{

	public ToolHoe(String name, ToolMaterial material) 
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
