package vrglab.mod.objects.armour;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import vrglab.mod.Main;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;

public class ArmourBase extends ItemArmor  implements IHasModel
{

	public ArmourBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) 
	{
		super(materialIn, renderIndexIn, equipmentSlotIn);
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
