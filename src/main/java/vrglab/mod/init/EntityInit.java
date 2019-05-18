package vrglab.mod.init;

 

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import vrglab.mod.Main;
import vrglab.mod.entity.EntityGhost;
import vrglab.mod.entity.EntityVillagerRuby;
import vrglab.mod.util.Reference;

public class EntityInit 
{
	
   public static void registerEntities()
   {
         registerEntity("ruby_villager", EntityVillagerRuby.class, Reference.ENTITY_VILLAGER_RUBY, 50, 16724531, 11489946);
         registerEntity("EntityGhost", EntityGhost.class, Reference.ENTITY_GHOST, 100, 15264500, 2567470);
         registerEntity("EntityJames", EntityGhost.class, Reference.ENTITY_JAMES, 120, 15264500, 2567470);
   }
         
  
private static void  registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) 
  {
	  EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
  }
}
