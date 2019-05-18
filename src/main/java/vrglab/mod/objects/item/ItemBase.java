package vrglab.mod.objects.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import vrglab.mod.Main;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name) 
    {
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
