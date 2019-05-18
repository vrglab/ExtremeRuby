package vrglab.mod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import vrglab.mod.init.ItemInit;

public class Rubytab extends CreativeTabs
{
     public Rubytab(String label) { super ("rubytab");
     this.setBackgroundImageName("ruby.png"); }
      public ItemStack getTabIconItem() {return new ItemStack(ItemInit.RUBY);}

}
