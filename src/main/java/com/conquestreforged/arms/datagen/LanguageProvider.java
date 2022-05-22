package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.ArmsOfConquest;
import com.conquestreforged.arms.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import org.apache.commons.lang3.text.WordUtils;

public class LanguageProvider extends net.minecraftforge.common.data.LanguageProvider {

    public LanguageProvider(DataGenerator gen) {
        super(gen, ArmsOfConquest.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        ItemInit.REGISTER.getEntries().forEach(registryItem -> {
            Item item = registryItem.get();
            add(item, WordUtils.capitalize(item.getRegistryName().toString()
                    .replace(ArmsOfConquest.MOD_ID + ":", "")
                    .replace("_", " ")
            ));
        });
    }
}
