package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.ArmsOfConquest;
import com.conquestreforged.arms.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ArmsOfConquest.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemInit.CRUSADER_CHEST.get());
        ItemInit.dataGenItemModels.forEach(registryItem -> simpleItem(registryItem.get()));
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
}
