package vrglab.mod.entity.ai;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.monster.EntityZombie;
import vrglab.mod.entity.EntityGhost;
import vrglab.mod.entity.EntityVillagerRuby;

public class EntityAIGhostAttack extends EntityAIAttackMelee
{
	private final EntityGhost ghost;
    private int raiseArmTicks;

      
    
    public EntityAIGhostAttack(EntityGhost ghostIn, double speedIn, boolean longMemoryIn)
    {
        super(ghostIn, speedIn, longMemoryIn);
        this.ghost = ghostIn;
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
