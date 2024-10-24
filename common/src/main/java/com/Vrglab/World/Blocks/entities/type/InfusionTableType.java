package com.Vrglab.World.Blocks.entities.type;

import com.Vrglab.World.Blocks.entities.BlockWithEntity;
import com.Vrglab.World.Blocks.entities.InfusionTableEntity;

public class InfusionTableType extends BlockWithEntity<InfusionTableEntity> {
    public InfusionTableType(Properties properties) {
        super(properties, InfusionTableEntity.class);
    }
}
