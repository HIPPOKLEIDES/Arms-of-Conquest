package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.init.ItemInit;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeConsumer) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.IRON_CHESTPLATE), ItemInit.CRUSADER_CHEST.get())
                .unlockedBy("has_iron_armor", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.IRON_CHESTPLATE).build()))
                .save(recipeConsumer);
        ItemInit.dataGenItemRecipos.forEach(registryItem -> {
            if (registryItem.get() instanceof ArmorItem) {
                createArmorStoneCutterRecipe(recipeConsumer, (ArmorItem) registryItem.get());
            }
        });
    }

    private void createArmorStoneCutterRecipe (Consumer<FinishedRecipe> recipeConsumer, ArmorItem result) {
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

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ingredientItem).build()))
                .save(recipeConsumer);
    }
}
