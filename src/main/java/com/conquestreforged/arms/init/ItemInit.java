package com.conquestreforged.arms.init;

import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.armor.FlatCrestHelmet;
import com.conquestreforged.arms.items.armor.GenericArmorItem;
import com.conquestreforged.arms.items.armor.materials.ArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

public class ItemInit {

    //Here we store a list of our items that get automatically generated model files
    public static final List<RegistryObject<Item>> dataGenItemModels = new ArrayList<>();
    //Here we store a list of our items that get automatically generated recipe+advancement files
    public static final List<RegistryObject<Item>> dataGenItemRecipos = new ArrayList<>();


    public static final Item.Properties genericCombatProps = new Item.Properties()
            .tab(CreativeModeTab.TAB_COMBAT)
            .stacksTo(1)
            .durability(100);
    public static final List<ArmorMaterial> ironMaterials = new ArrayList<>(Arrays.asList(
            net.minecraft.world.item.ArmorMaterials.IRON,
            net.minecraft.world.item.ArmorMaterials.DIAMOND,
            net.minecraft.world.item.ArmorMaterials.NETHERITE
    ));


    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final RegistryObject<Item> CENTURION_HELMET = REGISTER.register("centurion_helmet", () ->
            new FlatCrestHelmet(ArmorMaterials.centurion_helmet, EquipmentSlot.HEAD, genericCombatProps));

    public static final RegistryObject<Item> SPEAR_IRON = REGISTER.register("spear_iron", () ->
            new ModSpear(genericCombatProps));

    public static final RegistryObject<Item> CRUSADER_CHEST = REGISTER.register("crusader_chest", () ->
            new GenericArmorItem(ArmorMaterials.BRONZE, EquipmentSlot.CHEST, genericCombatProps, constructArmorTexPath("crusader", false)));

    public static final List<RegistryObject<Item>> KNIGHT_ARMORS = registerArmorSetMultiMaterials(genericCombatProps, "knight", ironMaterials);


    //public static Item corinthian_helmet = new StraightCrestHelmet(ArmorMaterials.corinthian_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "corinthian_helmet"));
    //public static Item jaguar_helmet = new StraightCrestHelmet(ArmorMaterials.jaguar_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "jaguar_helmet"));
    //public static Item gladiator_helmet = new StraightCrestHelmet(ArmorMaterials.gladiator_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "gladiator_helmet"));
    //public static Item eagle_helmet = new StraightCrestHelmet(ArmorMaterials.eagle_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "eagle_helmet"));


    //public static Item winged_hussar_helmet = new WingedHussarHelmet(ArmorMaterials.winged_hussar,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_helmet"));
    //public static Item winged_hussar_chest = new WingedHussarChest(ArmorMaterials.winged_hussar,EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_chest"));
    //public static Item winged_hussar_pants = new WingedHussarPants(ArmorMaterials.winged_hussar,EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_pants"));
    //public static Item winged_hussar_boots = new WingedHussarBoots(ArmorMaterials.winged_hussar,EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_boots"));


    private static List<RegistryObject<Item>> registerArmorSetMultiMaterials (Item.Properties props, String texture, List<ArmorMaterial> armorMaterials) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();

        armorMaterials.forEach(armorMaterial -> {
            switch (armorMaterial.getName()) {
                case "iron":
                    armorsList.addAll(registerArmorsFullSet(props, texture, armorMaterial));
                    break;
                case "bronze":
                    armorsList.addAll(registerArmorsFullSet(props, texture, armorMaterial));
                    break;
                case "diamond":
                    armorsList.addAll(registerArmorsFullSet(props, "refined_" + texture, armorMaterial));
                    break;
                case "netherite":
                    armorsList.addAll(registerArmorsFullSet(props, "exquisite_" + texture, armorMaterial));
                    break;
            }
        });
        return armorsList;
    }

    private static List<RegistryObject<Item>> registerArmorsFullSet(Item.Properties props, String texture, ArmorMaterial armorMaterial) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();

        //Helm
        armorsList.add(REGISTER.register(texture + "_helmet", () -> new GenericArmorItem(armorMaterial, EquipmentSlot.HEAD, props, constructArmorTexPath(texture, false))));
        //Chest
        armorsList.add(REGISTER.register(texture + "_chest", () -> new GenericArmorItem(armorMaterial, EquipmentSlot.CHEST, props, constructArmorTexPath(texture, false))));
        //Legs
        armorsList.add(REGISTER.register(texture + "_legs", () -> new GenericArmorItem(armorMaterial, EquipmentSlot.LEGS, props, constructArmorTexPath(texture, true))));
        //Boots
        armorsList.add(REGISTER.register(texture + "_boots", () -> new GenericArmorItem(armorMaterial, EquipmentSlot.FEET, props, constructArmorTexPath(texture, false))));

        dataGenItemModels.addAll(armorsList);
        dataGenItemRecipos.addAll(armorsList);
        return armorsList;
    }

    private static String constructArmorTexPath(String textureName, boolean isPants) {
        String path = MOD_ID + ":" + "textures/models/armor/";

        if (isPants) {
            return path + textureName + "_layer_2.png";
        } else {
            return path + textureName + "_layer_1.png";
        }
    }

}
