package com.Vrglab.World.Blocks.entities.type;

import com.Vrglab.ExtremeRubyMod;
import com.Vrglab.World.Blocks.entities.BlockWithEntity;
import com.Vrglab.World.Blocks.entities.InfusionTableEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
public class InfusionTableType extends BlockWithEntity<InfusionTableEntity> {
    public InfusionTableType(Properties properties) {
        super(properties, InfusionTableEntity.class);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.tick(blockState, serverLevel, blockPos, randomSource);

        System.out.println("tick");

    }
}
