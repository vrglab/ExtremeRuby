package com.Vrglab.World.Blocks.entities;

import com.Vrglab.Utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public abstract class BlockWithEntity<T extends BlockEntity> extends Block implements BlockEntityType.BlockEntitySupplier {
    private Class<T> entity_type;

    public BlockWithEntity(Properties properties, Class<T> entity_type) {
        super(properties);
        this.entity_type = entity_type;
    }

    @Override
    public BlockEntity create(BlockPos blockPos, BlockState blockState) {
        return (BlockEntity) Utils.createInstance(entity_type, blockPos, blockState);
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider(BlockState blockState, Level level, BlockPos blockPos) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        return blockEntity instanceof MenuProvider ? (MenuProvider)blockEntity : null;
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }


}
