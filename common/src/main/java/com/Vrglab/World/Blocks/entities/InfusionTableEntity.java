package com.Vrglab.World.Blocks.entities;

import com.Vrglab.World.Blocks.ExBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.Vrglab.Utils.Utils;

public class InfusionTableEntity extends BlockEntity {

    public InfusionTableEntity(BlockPos blockPos, BlockState blockState) {
        super(Utils.convertToMcSafeType(ExBlocks.INFUSION_TABLE_ENTITY), blockPos, blockState);
    }
}
