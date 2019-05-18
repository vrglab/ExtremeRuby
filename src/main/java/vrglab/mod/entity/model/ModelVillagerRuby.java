package vrglab.mod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelZombie - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
public class ModelVillagerRuby extends ModelBase {
    public ModelRenderer frontrightarm;
    public ModelRenderer frontrightlegg;
    public ModelRenderer body;
    public ModelRenderer frontleftarm;
    public ModelRenderer frontleftlegg;
    public ModelRenderer head;
    public ModelRenderer nose;

    public ModelVillagerRuby() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.frontrightlegg = new ModelRenderer(this, 0, 16);
        this.frontrightlegg.setRotationPoint(-1.9F, 12.0F, 0.1F);
        this.frontrightlegg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.nose = new ModelRenderer(this, 24, 0);
        this.nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.frontrightarm = new ModelRenderer(this, 40, 16);
        this.frontrightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.frontrightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(frontrightarm, -0.05235987755982988F, -0.10000736613927509F, 0.10000736613927509F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.frontleftlegg = new ModelRenderer(this, 0, 16);
        this.frontleftlegg.mirror = true;
        this.frontleftlegg.setRotationPoint(1.9F, 12.0F, 0.1F);
        this.frontleftlegg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.frontleftarm = new ModelRenderer(this, 40, 16);
        this.frontleftarm.mirror = true;
        this.frontleftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.frontleftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(frontleftarm, -0.06981317007977318F, 0.16982053621904827F, -0.0651007810993885F);
        this.head.addChild(this.nose);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.frontrightlegg.render(f5);
        this.frontrightarm.render(f5);
        this.body.render(f5);
        this.head.render(f5);
        this.frontleftlegg.render(f5);
        this.frontleftarm.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

@Override
public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,float headPitch, float scaleFactor, Entity entityIn) 
{
	
	//leggs
	this.frontleftlegg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F* limbSwingAmount;
	this.frontrightlegg.rotateAngleX = MathHelper.cos(limbSwing * 0.662F+ (float)Math.PI) * 1.4F* limbSwingAmount;
	
	//head
	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
	this.head.rotateAngleX = headPitch * 0.017453292F;
	
	//arms
	this.frontleftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F* limbSwingAmount;
	this.frontrightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.662F+ (float)Math.PI) * 1.4F* limbSwingAmount;
}
   

}
