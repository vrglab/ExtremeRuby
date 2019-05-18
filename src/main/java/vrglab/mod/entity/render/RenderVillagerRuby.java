package vrglab.mod.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.stats.RecipeBook;
import net.minecraft.util.ResourceLocation;
import vrglab.mod.entity.EntityVillagerRuby;
import vrglab.mod.entity.model.ModelVillagerRuby;
import vrglab.mod.util.Reference;

public class RenderVillagerRuby extends RenderLiving<EntityVillagerRuby>
{
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/villager_ruby.png");

	public RenderVillagerRuby(RenderManager manager) 
	{
		super(manager, new ModelVillagerRuby(), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityVillagerRuby entity) 
	{
		return TEXTURES;
	}
	
	
	@Override
	protected void applyRotations(EntityVillagerRuby entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
