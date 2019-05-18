package vrglab.mod.entity.ai;

import javax.security.auth.Destroyable;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.renderer.DestroyBlockProgress;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityAIBlockBreaker extends EntityAIBase
{

	@Override
	public boolean shouldExecute() 
	{
		return false;
	}



	@Override
	public void resetTask() {
		
		super.resetTask();
	}
	
	@Override
	public void startExecuting() 
	{	
		super.startExecuting();
	}
	
	public static void Blocks()
	{
		DestroyBlockProgress();
	}



	private static void DestroyBlockProgress() {
		// TODO Auto-generated method stub
		
	}

}