package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.ArmsOfConquest;
import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.util.ModItemProperties;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ArmsOfConquest.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemInit.CRUSADER_CHEST.get());
        ItemInit.dataGenItemModels.forEach(registryItem -> {
            Item item = registryItem.get();
            if (item instanceof SwordItem) {
                swordItem(item);
            } else if (item instanceof AxeItem) {
                axeItem(item);
            } else {
                simpleItem(item);
            }
        });
        shieldItem(ItemInit.NORMAN_SHIELD.get());
    }

    private ItemModelBuilder simpleItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ArmsOfConquest.MOD_ID, "item/" + item.getRegistryName().getPath()
                .replace("refined_", "")
                .replace("exquisite_", "")
                )
        );
    }

    private ItemModelBuilder axeItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(ArmsOfConquest.MOD_ID + ":item/axe"))
                .texture("layer0", new ResourceLocation(ArmsOfConquest.MOD_ID, "item/" + item.getRegistryName().getPath()
                                .replace("refined_", "")
                                .replace("exquisite_", "")
                        )
                );
    }

    private ItemModelBuilder swordItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(ArmsOfConquest.MOD_ID + ":item/sword"))
                .texture("layer0", new ResourceLocation(ArmsOfConquest.MOD_ID, "item/" + item.getRegistryName().getPath()
                        .replace("refined_", "")
                        .replace("exquisite_", "")
                        )
                );
    }

    private ItemModelBuilder shieldItem(Item item) {
        ItemModelBuilder modelNormal = withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(ArmsOfConquest.MOD_ID + ":item/shield"))
                .texture("layer0", new ResourceLocation(ArmsOfConquest.MOD_ID, "item/" + item.getRegistryName().getPath()));

        ModelFile modelBlocking = singleTexture(item.getRegistryName().getPath() + "_blocking", modLoc("item/shield_blocking"), "layer0", modLoc("item/" + item.getRegistryName().getPath()));

        //ItemModelBuilder modelBlocking = withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(ArmsOfConquest.MOD_ID + ":item/" + item.getRegistryName().getPath() + "_blocking"))
        //        .texture("layer0", new ResourceLocation(ArmsOfConquest.MOD_ID, "item/" + item.getRegistryName().getPath()));


        return modelNormal.override()
                .predicate(new ResourceLocation("blocking"), 1)
                .model(modelBlocking)
                .end();
    }
}
