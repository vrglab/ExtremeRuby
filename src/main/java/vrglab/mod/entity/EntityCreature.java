package vrglab.mod.entity;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class EntityCreature extends EntityLiving
{
    public static final UUID FLEEING_SPEED_MODIFIER_UUID = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
    public static final AttributeModifier FLEEING_SPEED_MODIFIER = (new AttributeModifier(FLEEING_SPEED_MODIFIER_UUID, "Fleeing speed bonus", 2.0D, 2)).setSaved(false);
    private BlockPos homePosition = BlockPos.ORIGIN;
    /** If -1 there is no maximum distance */
    private float maximumHomeDistance = -1.0F;
    private final float restoreWaterCost = PathNodeType.WATER.getPriority();

    public EntityCreature(World worldIn)
    {
        super(worldIn);
    }

    public float getBlockPathWeight(BlockPos pos)
    {
        return 0.0F;
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        return super.getCanSpawnHere() && this.getBlockPathWeight(new BlockPos(this.posX, this.getEntityBoundingBox().minY, this.posZ)) >= 0.0F;
    }

    /**
     * if the entity got a PathEntity it returns true, else false
     */
    public boolean hasPath()
    {
        return !this.navigator.noPath();
    }

    public boolean isWithinHomeDistanceCurrentPosition()
    {
        return this.isWithinHomeDistanceFromPosition(new BlockPos(this));
    }

    public boolean isWithinHomeDistanceFromPosition(BlockPos pos)
    {
        if (this.maximumHomeDistance == -1.0F)
        {
            return true;
        }
        else
        {
            return this.homePosition.distanceSq(pos) < (double)(this.maximumHomeDistance * this.maximumHomeDistance);
        }
    }

    /**
     * Sets home position and max distance for it
     */
    public void setHomePosAndDistance(BlockPos pos, int distance)
    {
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }

    public BlockPos getHomePosition()
    {
        return this.homePosition;
    }

    public float getMaximumHomeDistance()
    {
        return this.maximumHomeDistance;
    }

    public void detachHome()
    {
        this.maximumHomeDistance = -1.0F;
    }

    /**
     * Returns whether a home area is defined for this entity.
     */
    public boolean hasHome()
    {
        return this.maximumHomeDistance != -1.0F;
    }

    /**
     * Applies logic related to leashes, for example dragging the entity or breaking the leash.
     */
    protected void updateLeashedState()
    {
        super.updateLeashedState();

        if (this.getLeashed() && this.getLeashedToEntity() != null && this.getLeashedToEntity().world == this.world)
        {
            Entity entity = this.getLeashedToEntity();
            this.setHomePosAndDistance(new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ), 5);
            float f = this.getDistanceToEntity(entity);

           
            {
                if (f > 10.0F)
                {
                    this.clearLeashed(true, true);
                }

                return;
            }
        }
    }

    protected double followLeashSpeed()
    {
        return 1.0D;
    }

    protected void onLeashDistance(float p_142017_1_)
    {
    }
}
