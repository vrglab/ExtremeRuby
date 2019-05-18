package vrglab.mod.objects.item.food;



import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import vrglab.mod.Main;
import vrglab.mod.init.ItemInit;
import vrglab.mod.util.IHasModel;

public class FoodBase extends ItemFood implements IHasModel 

{

	

	public FoodBase(String name, int amount, float saturation, boolean isAnimalFood) 

	{

		super(amount, saturation, isAnimalFood);

		setUnlocalizedName(name);

		setRegistryName(name);

		setCreativeTab(CreativeTabs.FOOD);

		

		ItemInit.ITEMS.add(this);

	}



	@Override

	public void registerModels() 

	{

		Main.proxy.registerItemRenderer(this, 0, "inventory");

	}
}
