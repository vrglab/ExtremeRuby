package vrglab.mod.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import vrglab.mod.entity.EntityGhost;
import vrglab.mod.entity.EntityVillagerRuby;
import vrglab.mod.entity.model.ModelGhost;
import vrglab.mod.entity.model.ModelVillagerRuby;
import vrglab.mod.util.Reference;

public class RenderGhost extends RenderLiving<EntityGhost>
{
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/ghost.png");

	public RenderGhost(RenderManager manager) 
	{
		super(manager, new ModelGhost(), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityGhost entity) 
	{
		return TEXTURES;
	}
	
	
	@Override
	protected void applyRotations(EntityGhost entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
