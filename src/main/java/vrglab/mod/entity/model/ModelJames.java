package vrglab.mod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * NewProject - Undefined
 * Created using Tabula 7.0.1
 */
public class ModelJames extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer handright;
    public ModelRenderer handleft;
    public ModelRenderer leggright;
    public ModelRenderer leggright_1;

    public ModelJames() {
        this.textureWidth = 69;
        this.textureHeight = 69;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(1.5F, -10.5F, -3.6F);
        this.head.addBox(-6.0F, -1.8F, 0.1F, 9, 9, 9, 0.0F);
        this.body = new ModelRenderer(this, 30, 12);
        this.body.setRotationPoint(0.0F, -1.9F, 0.0F);
        this.body.addBox(-6.0F, -0.9F, -2.3F, 12, 15, 7, 0.0F);
        this.leggright = new ModelRenderer(this, 42, 43);
        this.leggright.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leggright.addBox(-5.2F, 12.9F, -0.8F, 5, 11, 4, 0.0F);
        this.leggright_1 = new ModelRenderer(this, 42, 43);
        this.leggright_1.setRotationPoint(0.9F, 0.0F, -0.7F);
        this.leggright_1.addBox(-1.0F, 12.9F, 0.0F, 5, 11, 4, 0.0F);
        this.handright = new ModelRenderer(this, 9, 23);
        this.handright.setRotationPoint(-0.5F, -1.3F, 1.8F);
        this.handright.addBox(6.6F, -0.3F, -3.0F, 4, 13, 4, 0.0F);
        this.setRotateAngle(handright, 0.017976891295541593F, 0.0F, 0.0F);
        this.handleft = new ModelRenderer(this, 9, 23);
        this.handleft.setRotationPoint(-10.4F, -1.9F, -0.4F);
        this.handleft.addBox(0.0F, 0.0F, 0.0F, 4, 13, 4, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.head.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translate(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
        GlStateManager.scale(1.0D, 1.1D, 1.0D);
        GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translate(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
        this.body.render(f5);
        GlStateManager.popMatrix();
        this.leggright.render(f5);
        this.leggright_1.render(f5);
        this.handright.render(f5);
        this.handleft.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
