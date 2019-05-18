package vrglab.mod.entity;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIDefendVillage;
import net.minecraft.entity.ai.EntityAIFollow;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.fixes.SpawnerEntityTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;
import vrglab.mod.entity.ai.EntityAIVillagerRubyAttack;
import vrglab.mod.init.BlockInit;
import vrglab.mod.util.handlers.LootTableHandler;

public class EntityVillagerRuby  extends EntityMob
{
	
	private float villagerWidth = -1.0F;
	private float villagerHeight;
	private boolean isBreakDoorsTaskSet;
	private boolean areAdditionalTasksSet;
	  private int angerLevel;
	  private int randomSoundDelay;
	    private UUID angerTargetUUID;
	    
	  protected static final IAttribute SPAWN_REINFORCEMENTS_CHANCE = (new RangedAttribute((IAttribute)null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).setDescription("Spawn Reinforcements Chance");
	public EntityVillagerRuby(World worldIn) 
	{
		super(worldIn);
	}
	 private final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);

	 
	


	
	@Override
	protected void initEntityAI() 
	{
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
        this.tasks.addTask(3, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
       

        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 0.6D));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
        this.tasks.addTask(2, new EntityAIVillagerRubyAttack(this, 1.0D, false));
        this.applyEntityAI();
	}
	
	
	protected void applyEntityAI()
    {
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityEvoker.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVindicator.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityVex.class, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZombie.class, false));
        this.tasks.addTask(10, new EntityAIAvoidEntity(this, EntityGhost.class, 8.0F, 0.6D, 0.6D));
       
       
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(4.0D);
    }
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
	}
	  public void setBreakDoorsAItask(boolean enabled)
	    {
	        if (this.isBreakDoorsTaskSet != enabled)
	        {
	            this.isBreakDoorsTaskSet = enabled;
	            ((PathNavigateGround)this.getNavigator()).setBreakDoors(enabled);

	            if (enabled)
	            {
	                this.tasks.addTask(1, this.breakDoor);
	            }
	            else
	            {
	                this.tasks.removeTask(this.breakDoor);
	            }
	        }
	    }
	
	@Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        float f = difficulty.getClampedAdditionalDifficulty();
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);

        if (livingdata == null)
        {
            livingdata = new EntityVillagerRuby.GroupData(this.world.rand.nextFloat() < net.minecraftforge.common.ForgeModContainer.zombieBabyChance);
        }

        if (livingdata instanceof EntityVillagerRuby.GroupData)
        {
        	EntityVillagerRuby.GroupData entityvillagerruby$groupdata = (EntityVillagerRuby.GroupData)livingdata;

            if (entityvillagerruby$groupdata.isChild)
            {

                if ((double)this.world.rand.nextFloat() < 0.05D)
                {
                    List<EntityChicken> list = this.world.<EntityChicken>getEntitiesWithinAABB(EntityChicken.class, this.getEntityBoundingBox().grow(5.0D, 3.0D, 5.0D), EntitySelectors.IS_STANDALONE);

                    if (!list.isEmpty())
                    {
                        EntityChicken entitychicken = list.get(0);
                        entitychicken.setChickenJockey(true);
                        this.startRiding(entitychicken);
                    }
                }
                else if ((double)this.world.rand.nextFloat() < 0.05D)
                {
                    EntityChicken entitychicken1 = new EntityChicken(this.world);
                    entitychicken1.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                    entitychicken1.onInitialSpawn(difficulty, (IEntityLivingData)null);
                    entitychicken1.setChickenJockey(true);
                    this.world.spawnEntity(entitychicken1);
                    this.startRiding(entitychicken1);
                }
            }
        }

        this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);

        if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty())
        {
            Calendar calendar = this.world.getCurrentDate();

            if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F)
            {
                this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
                this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
            }
        }

        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
        double d0 = this.rand.nextDouble() * 1.5D * (double)f;

        if (d0 > 1.0D)
        {
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
        }

        if (this.rand.nextFloat() < f * 0.05F)
        {
            this.getEntityAttribute(SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25D + 0.5D, 0));
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
           
        }

        return livingdata;
    }
	 public void onDeath(DamageSource cause)
	    {
	        super.onDeath(cause);

	        if (cause.getTrueSource() instanceof EntityCreeper)
	        {
	            EntityCreeper entitycreeper = (EntityCreeper)cause.getTrueSource();

	            if (entitycreeper.getPowered() && entitycreeper.isAIEnabled())
	            {
	                entitycreeper.incrementDroppedSkulls();
	                ItemStack itemstack = this.getSkullDrop();

	                if (!itemstack.isEmpty())
	                {
	                    this.entityDropItem(itemstack, 0.0F);
	                }
	            }
	        }
	    }
	 private void becomeAngryAt(Entity p_70835_1_)
	    {
	        this.angerLevel = 400 + this.rand.nextInt(400);
	        this.randomSoundDelay = this.rand.nextInt(40);

	        if (p_70835_1_ instanceof EntityLivingBase)
	        {
	            this.setRevengeTarget((EntityLivingBase)p_70835_1_);
	        }
	    }

	    public boolean isAngry()
	    {
	        return this.angerLevel > 0;
	    }

	    
	    public boolean processInteract(EntityPlayer player, EnumHand hand)
	    {
	        return false;
	    }

	  
	    
	    class GroupData implements IEntityLivingData
	    {
	        public boolean isChild;

	        private GroupData(boolean p_i47328_2_)
	        {
	            this.isChild = p_i47328_2_;
	        }
	    }
	    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
	    {
	        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
	    }

	    protected ItemStack getSkullDrop()
	    {
	        return ItemStack.EMPTY;
	    }

	    public boolean isPreventingPlayerRest(EntityPlayer p_191990_1_)
	    {
	        return this.isAngry();
	    }

	    static class AIHurtByAggressor extends EntityAIHurtByTarget
	        {
	            public AIHurtByAggressor(EntityVillagerRuby p_i45828_1_)
	            {
	                super(p_i45828_1_, true);
	            }

	            protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn)
	            {
	                super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);

	                if (creatureIn instanceof EntityPigZombie)
	                {
	                    ((EntityVillagerRuby)creatureIn).becomeAngryAt(entityLivingBaseIn);
	                }
	            }
	        }

	    static class AITargetAggressor extends EntityAINearestAttackableTarget<EntityPlayer>
	        {
	            public AITargetAggressor(EntityVillagerRuby entityVillagerRuby)
	            {
	                super(entityVillagerRuby, EntityPlayer.class, true);
	            }

	        }

	    

	    @Override
	    public boolean getCanSpawnHere() 
	    {
	    	
	    	return BlockInit.GRAS_RUBY != null;
	    }
	

	    
	    

	public EntityVillagerRuby createChild(EntityAgeable ageable) 
      {
	      return new EntityVillagerRuby(world);
      }
      
      @Override
    protected SoundEvent getAmbientSound() 
      {
    	return super.getAmbientSound();
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


	@Override
	protected ResourceLocation getLootTable() {
		
		return LootTableHandler.RubyVilager;
	}


	
	

}
