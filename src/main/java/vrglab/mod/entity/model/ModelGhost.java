package vrglab.mod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelVillager - Either Mojang or a mod author
 * Created using Tabula 7.0.1
 */
public class ModelGhost extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer coat;
    public ModelRenderer handright;
    public ModelRenderer handright_1;

    public ModelGhost() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.handright = new ModelRenderer(this, -4, 22);
        this.handright.mirror = true;
        this.handright.setRotationPoint(8.2F, 6.4F, -0.5F);
        this.handright.addBox(-1.0F, -4.8F, -6.7F, 3, 4, 7, 0.0F);
        this.body = new ModelRenderer(this, 16, 20);
        this.body.setRotationPoint(0.0F, 1.1F, 0.0F);
        this.body.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.coat = new ModelRenderer(this, 0, 38);
        this.coat.setRotationPoint(0.0F, 1.6F, 0.0F);
        this.coat.addBox(-4.0F, 0.1F, -3.0F, 8, 18, 6, 0.5F);
        this.handright_1 = new ModelRenderer(this, -4, 22);
        this.handright_1.mirror = true;
        this.handright_1.setRotationPoint(-8.9F, 6.4F, -0.2F);
        this.handright_1.addBox(-2.0F, -4.8F, -6.7F, 3, 4, 7, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.head.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.handright.offsetX, this.handright.offsetY, this.handright.offsetZ);
        GlStateManager.translate(this.handright.rotationPointX * f5, this.handright.rotationPointY * f5, this.handright.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.1D, 1.0D);
        GlStateManager.translate(-this.handright.offsetX, -this.handright.offsetY, -this.handright.offsetZ);
        GlStateManager.translate(-this.handright.rotationPointX * f5, -this.handright.rotationPointY * f5, -this.handright.rotationPointZ * f5);
        this.handright.render(f5);
        GlStateManager.popMatrix();
        this.body.render(f5);
        this.coat.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.handright_1.offsetX, this.handright_1.offsetY, this.handright_1.offsetZ);
        GlStateManager.translate(this.handright_1.rotationPointX * f5, this.handright_1.rotationPointY * f5, this.handright_1.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.1D, 1.0D);
        GlStateManager.translate(-this.handright_1.offsetX, -this.handright_1.offsetY, -this.handright_1.offsetZ);
        GlStateManager.translate(-this.handright_1.rotationPointX * f5, -this.handright_1.rotationPointY * f5, -this.handright_1.rotationPointZ * f5);
        this.handright_1.render(f5);
        GlStateManager.popMatrix();
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
    	
    	
    	//head
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	
    	//arms
    	this.handright.rotateAngleX = MathHelper.cos(limbSwing * 0.662F) * 1.4F* limbSwingAmount;
    	this.handright_1.rotateAngleX = MathHelper.cos(limbSwing * 0.662F+ (float)Math.PI) * 1.4F* limbSwingAmount;
    }
}
