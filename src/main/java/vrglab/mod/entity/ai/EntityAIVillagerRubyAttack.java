package vrglab.mod.entity.ai;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.monster.EntityZombie;
import vrglab.mod.entity.EntityVillagerRuby;

public class EntityAIVillagerRubyAttack extends EntityAIAttackMelee
{
	private final EntityVillagerRuby villagerRuby;
    private int raiseArmTicks;

      
    
    public EntityAIVillagerRubyAttack(EntityVillagerRuby villagerIn, double speedIn, boolean longMemoryIn)
    {
        super(villagerIn, speedIn, longMemoryIn);
        this.villagerRuby = villagerIn;
    }
    
    
    public void startExecuting()
    {
        super.startExecuting();
        this.raiseArmTicks = 0;
    }
    
    public void resetTask()
    {
        super.resetTask();
    }
    
    public void updateTask()
    {
        super.updateTask();


    }
}
