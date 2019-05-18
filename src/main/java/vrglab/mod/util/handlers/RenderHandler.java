package vrglab.mod.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import vrglab.mod.entity.EntityGhost;
import vrglab.mod.entity.EntityVillagerRuby;
import vrglab.mod.entity.render.RenderGhost;
import vrglab.mod.entity.render.RenderVillagerRuby;

public class RenderHandler 
{
    public static void registerEntityRenders()
    {
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new IRenderFactory<EntityGhost>()
    	{

			@Override
			public Render<? super EntityGhost> createRenderFor(RenderManager manager) {
				
				return new RenderGhost(manager);
			};
    		
    	
    
        });
    	
    	
    	RenderingRegistry.registerEntityRenderingHandler(EntityVillagerRuby.class, new IRenderFactory<EntityVillagerRuby>()
    	{

			@Override
			public Render<? super EntityVillagerRuby> createRenderFor(RenderManager manager) 
			{
				
				return new RenderVillagerRuby(manager);
			};
    		
    	
    
        });
    }
}
