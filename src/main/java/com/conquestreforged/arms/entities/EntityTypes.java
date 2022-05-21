package com.conquestreforged.arms.entities;

import com.conquestreforged.arms.init.ItemInit;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

public class EntityTypes {

    private EntityTypes() {

    }

    public static final EntityType<SpearEntity> SPEAR_IRON = build(
            (MOD_ID + ":" + "spear_iron"),
            EntityType.Builder.<SpearEntity>of((entityType, world) -> new SpearEntity(
                    entityType, world, ItemInit.SPEAR_IRON.get()), MobCategory.MISC)
                    .sized(1.0F, 1.0F).setTrackingRange(256)
    );

    private static <T extends Entity> EntityType<T> build(String name, EntityType.Builder<T> builder) {
        EntityType<T> type = builder.build(name);
        type.setRegistryName(name);
        return type;
    }
}
