package com.conquestreforged.arms.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

public class EntityTypes {

    private EntityTypes() {

    }

    public static final EntityType<SpearEntity> SPEAR_IRON = build(
            (MOD_ID + ":" + "spear_iron"),
            EntityType.Builder.<SpearEntity>create(SpearEntity::new, EntityClassification.MISC).size(1.0F, 1.0F).setTrackingRange(256)
    );

    private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder) {
        EntityType<T> type = builder.build(name);
        type.setRegistryName(name);
        return type;
    }
}
