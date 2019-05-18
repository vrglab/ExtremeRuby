package vrglab.mod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import vrglab.mod.init.BiomeInit;
import vrglab.mod.init.EntityInit;
import vrglab.mod.init.ModRecipes;
import vrglab.mod.proxy.CommonProxy;
import vrglab.mod.util.Reference;
import vrglab.mod.util.handlers.RegistryHandler;
import vrglab.mod.util.handlers.RenderHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main 
{
     @Instance
     public static Main instance;
     
     
     public static final CreativeTabs Rubytab = new vrglab.mod.tabs.Rubytab("rubytab");
     
     @SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
     public static CommonProxy proxy;
     
     @EventHandler
     public static void preInit(FMLPreInitializationEvent event)   
     {
    	 RegistryHandler.preInitRegistries(); 
    }
     
     @EventHandler
     public static void init(FMLInitializationEvent event)  
     {
    	 ModRecipes.init();
    	 
    	 RegistryHandler.InitRegistries();
     }
     
     
     @EventHandler
     public static void postInit(FMLPostInitializationEvent event)  
     {
    	 RegistryHandler.postInitRegistries();
     }
}
