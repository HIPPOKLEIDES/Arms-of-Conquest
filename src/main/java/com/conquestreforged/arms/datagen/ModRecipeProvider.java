package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.ModShield;
import com.conquestreforged.arms.recipe.ModRecipes;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeConsumer) {
        //armsStation(Ingredient.of(Items.IRON_CHESTPLATE), ItemInit.CRUSADER_CHEST.get()).save(recipeConsumer);

        ItemInit.dataGenItemRecipes.forEach(registryItem -> {
            Item item = registryItem.get();
            if (item instanceof SwordItem) {
                createSwordRecipe(recipeConsumer, (SwordItem) registryItem.get());
            } else if (item instanceof AxeItem) {
                createAxeRecipe(recipeConsumer, (AxeItem) registryItem.get());
            } else if (item instanceof ArmorItem) {
                createArmorRecipe(recipeConsumer, (ArmorItem) registryItem.get());
            } else if (item instanceof ModShield) {
                armsStation(Ingredient.of(Items.SHIELD), item)
                        .unlockedBy("has_" + Items.SHIELD, inventoryTrigger(ItemPredicate.Builder.item().of(Items.SHIELD).build()))
                        .save(recipeConsumer);
            }
        });
    }

    private void createAxeRecipe(Consumer<FinishedRecipe> recipeConsumer, AxeItem result) {
        Item ingredientItem = Items.WOODEN_AXE;
        Tier tier = result.getTier();

        if (Tiers.IRON.equals(tier)) {
            ingredientItem = Items.IRON_AXE;
        } else if (Tiers.DIAMOND.equals(tier)) {
            ingredientItem = Items.DIAMOND_AXE;
        } else if (Tiers.NETHERITE.equals(tier)) {
            ingredientItem = Items.NETHERITE_AXE;
        }

        armsStation(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item().of(ingredientItem).build()))
                .save(recipeConsumer);
    }

    private void createSwordRecipe(Consumer<FinishedRecipe> recipeConsumer, SwordItem result) {
        Item ingredientItem = Items.WOODEN_SWORD;
        Tier tier = result.getTier();

        if (Tiers.IRON.equals(tier)) {
            ingredientItem = Items.IRON_SWORD;
        } else if (Tiers.DIAMOND.equals(tier)) {
            ingredientItem = Items.DIAMOND_SWORD;
        } else if (Tiers.NETHERITE.equals(tier)) {
            ingredientItem = Items.NETHERITE_SWORD;
        }

        armsStation(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item().of(ingredientItem).build()))
                .save(recipeConsumer);
    }

    private void createArmorRecipe(Consumer<FinishedRecipe> recipeConsumer, ArmorItem result) {
        Item ingredientItem;
        switch (result.getMaterial().getName()) {
            default:
            case "bronze":
            case "iron":
                switch(result.getSlot().getName()) {
                    default:
                    case "feet":
                        ingredientItem = (Items.IRON_BOOTS);
                        break;
                    case "legs":
                        ingredientItem = (Items.IRON_LEGGINGS);
                        break;
                    case "chest":
                        ingredientItem = (Items.IRON_CHESTPLATE);
                        break;
                    case "head":
                        ingredientItem = (Items.IRON_HELMET);
                        break;
                }
                break;
            case "diamond":
                switch(result.getSlot().getName()) {
                    default:
                    case "feet":
                        ingredientItem = (Items.DIAMOND_BOOTS);
                        break;
                    case "legs":
                        ingredientItem = (Items.DIAMOND_LEGGINGS);
                        break;
                    case "chest":
                        ingredientItem = (Items.DIAMOND_CHESTPLATE);
                        break;
                    case "head":
                        ingredientItem = (Items.DIAMOND_HELMET);
                        break;
                }
                break;
            case "netherite":
                switch(result.getSlot().getName()) {
                    default:
                    case "feet":
                        ingredientItem = (Items.NETHERITE_BOOTS);
                        break;
                    case "legs":
                        ingredientItem = (Items.NETHERITE_LEGGINGS);
                        break;
                    case "chest":
                        ingredientItem = (Items.NETHERITE_CHESTPLATE);
                        break;
                    case "head":
                        ingredientItem = Items.NETHERITE_HELMET;
                        break;
                }
                break;
        }

        armsStation(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item().of(ingredientItem).build()))
                .save(recipeConsumer);
    }

    public static SingleItemRecipeBuilder armsStation(Ingredient ingredient, ItemLike itemLike) {
        return new SingleItemRecipeBuilder(ModRecipes.ARMS_STATION_SERIALIZER.get(), ingredient, itemLike, 1);
    }
}
