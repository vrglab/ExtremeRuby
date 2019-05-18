package vrglab.mod.entity;

import com.mojang.authlib.GameProfile;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import vrglab.mod.entity.ai.EntityAIGhostAttack;



public class EntityJames extends EntityPlayer
{
	
	protected void initEntityAI()
	{

	}
	
	
	
	
	
	
	
	
	
	
	

	public EntityJames(World worldIn, GameProfile gameProfileIn) {
		super(worldIn, gameProfileIn);
		
	}

	@Override
	public boolean isSpectator() {
	
		return false;
	}

	@Override
	public boolean isCreative() {
	
		return false;
	}
	public EntityGhost createChild(EntityAgeable ageable) 
    {
	      return new EntityGhost(world);
    }
    
	
	
	
	
	
    protected SoundEvent getAmbientSound() 
    {
  	return super.getSwimSound();
    }
    
    @Override
  protected SoundEvent getHurtSound(DamageSource source) 
    {
  	return super.getHurtSound(source);
    }
    
    
    @Override
  protected SoundEvent getDeathSound() 
    {
  	return super.getDeathSound();
    }

    
    
public void setCustomer(EntityPlayer player) {
	// TODO Auto-generated method stub
	
}

public EntityPlayer getCustomer() {
	// TODO Auto-generated method stub
	return null;
}

public MerchantRecipeList getRecipes(EntityPlayer player) {
	// TODO Auto-generated method stub
	return null;
}

public void setRecipes(MerchantRecipeList recipeList) {
	// TODO Auto-generated method stub
	
}

public void useRecipe(MerchantRecipe recipe) {
	// TODO Auto-generated method stub
	
}

public void verifySellingItem(ItemStack stack) {
	// TODO Auto-generated method stub
	
}

public World getWorld() {
	// TODO Auto-generated method stub
	return null;
}

public BlockPos getPos() {
	// TODO Auto-generated method stub
	return null;
}
}
