package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ArmsOfConquest;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ArmsOfConquest.MOD_ID);

    public static final RegistryObject<RecipeSerializer<ArmorStationRecipe>> ARMS_STATION_SERIALIZER =
            SERIALIZERS.register("arms_station", () -> ArmorStationRecipe.Serializer.INSTANCE);

    public static void register (IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
