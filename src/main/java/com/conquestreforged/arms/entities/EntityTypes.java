package com.conquestreforged.arms.entities;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

public class EntityTypes {

    private EntityTypes() {

    }

    public static final EntityType<SpearEntity> SPEAR_IRON = build(
            (MOD_ID + ":" + "spear_iron"),
            EntityType.Builder.<SpearEntity>of(SpearEntity::new, MobCategory.MISC).sized(1.0F, 1.0F).setTrackingRange(256)
    );

    private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder) {
        EntityType<T> type = builder.build(name);
        type.setRegistryName(name);
        return type;
    }
}
