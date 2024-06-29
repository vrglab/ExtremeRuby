package com.Vrglab.World.CustomRegistery;

import org.Vrglab.Modloader.enumTypes.IRegistryType;

public enum RegistryTypes implements IRegistryType {
    ITEM_GROUP(0_300)
    ;


    private final int id;

    RegistryTypes(int id) {
        this.id = id;
    }

    @Override
    public int getTypeId() {
        return id;
    }
}
