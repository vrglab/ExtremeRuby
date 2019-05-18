package vrglab.mod.objects.Tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;
import vrglab.mod.Main;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;

public class ToolShovel extends ItemSpade implements IHasModel
{

	public ToolShovel(String name, ToolMaterial material) 
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
