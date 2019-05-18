package vrglab.mod.objects.blocks.machines.crusher.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import vrglab.mod.objects.blocks.machines.crusher.TileEntityCrusher;

public class SlotCrusherFuel extends Slot 
{
      public SlotCrusherFuel(IInventory inventory, int index, int x, int y) 
      {
		super(inventory, index, x, y);
	  }
      
      @Override
    public boolean isItemValid(ItemStack stack) 
      {
    	return TileEntityCrusher.isItemFuel(stack);
    }
      
      
      @Override
    public int getItemStackLimit(ItemStack stack) 
    {
    	return super.getItemStackLimit(stack);
    }
}
