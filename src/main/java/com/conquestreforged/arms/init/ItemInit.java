package com.conquestreforged.arms.init;

import com.conquestreforged.arms.entities.EntityTypes;
import com.conquestreforged.arms.items.ModBow;
import com.conquestreforged.arms.items.ModCrossbow;
import com.conquestreforged.arms.items.ModShield;
import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.GenericArmorItem;
import com.conquestreforged.arms.items.armor.materials.ArmorMaterials;
import com.conquestreforged.arms.items.armor.models.*;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
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
    public static final List<RegistryObject<Item>> dataGenItemRecipes = new ArrayList<>();


    public static final Item.Properties genericCombatProps = new Item.Properties()
            .tab(CreativeModeTab.TAB_COMBAT)
            .stacksTo(1)
            .durability(100);
    public static final List<ArmorMaterial> metalMaterials = new ArrayList<>(Arrays.asList(
            net.minecraft.world.item.ArmorMaterials.IRON,
            net.minecraft.world.item.ArmorMaterials.DIAMOND,
            net.minecraft.world.item.ArmorMaterials.NETHERITE
    ));
    public static final List<Tier> metalTiers = new ArrayList<>(Arrays.asList(
            Tiers.IRON,
            Tiers.DIAMOND,
            Tiers.NETHERITE
    ));


    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);

    public static final List<RegistryObject<Item>> CENTURION_HELMET = registerArmorModelMultiMaterials(
            "centurion_helmet", genericCombatProps, "centurion_helmet",
            EquipmentSlot.HEAD,
            ModelFlatCrestHelmet.class, ModelFlatCrestHelmet.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_BOOTS = registerArmorModelMultiMaterials(
            "winged_hussar_boots", genericCombatProps, "winged_hussar_boots",
            EquipmentSlot.FEET,
            ModelWingedHussarBoots.class, ModelWingedHussarBoots.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_CHEST = registerArmorModelMultiMaterials(
            "winged_hussar_chest", genericCombatProps, "winged_hussar",
            EquipmentSlot.CHEST,
            ModelWingedHussarChest.class, ModelWingedHussarChest.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_LEGS = registerArmorModelMultiMaterials(
            "winged_hussar_legs", genericCombatProps, "winged_hussar_legs",
            EquipmentSlot.LEGS,
            ModelWingedHussarLegs.class, ModelWingedHussarLegs.LAYER_LOCATION,
            metalMaterials);
    public static final List<RegistryObject<Item>> WINGED_HUSSAR_HELMET = registerArmorModelMultiMaterials(
            "winged_hussar_helmet", genericCombatProps, "winged_hussar_helmet",
            EquipmentSlot.HEAD,
            ModelWingedHussarHelmet.class, ModelWingedHussarHelmet.LAYER_LOCATION,
            metalMaterials);

    public static final RegistryObject<Item> SPEAR_IRON = REGISTER.register("spear_iron", () ->
            new ModSpear(genericCombatProps, EntityTypes.SPEAR_IRON, 7.0F));

    public static final RegistryObject<Item> CRUSADER_CHEST = REGISTER.register("crusader_chest", () ->
            new GenericArmorItem(
                    ArmorMaterials.BRONZE, EquipmentSlot.CHEST, genericCombatProps,
                    constructArmorTexPath("crusader", false)));

    public static final List<RegistryObject<Item>> KNIGHT_ARMORS = registerArmorSetMultiMaterials(
            genericCombatProps, "knight", metalMaterials);

    public static final RegistryObject<Item> NORMAN_SHIELD = registerShield("norman_shield", genericCombatProps);
    public static final RegistryObject<Item> STEPPE_RECURVE_BOW = registerBow("steppe_recurve_bow", genericCombatProps);
    public static final RegistryObject<Item> LIGHT_CROSSBOW = registerCrossBow("light_crossbow", genericCombatProps);
    public static final List<RegistryObject<Item>> BASTARD_SWORD = registerSwordssFullSet("bastard_sword", 3, -2.4F, genericCombatProps, metalTiers);

    //public static Item corinthian_helmet = new StraightCrestHelmet(ArmorMaterials.corinthian_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "corinthian_helmet"));
    //public static Item jaguar_helmet = new StraightCrestHelmet(ArmorMaterials.jaguar_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "jaguar_helmet"));
    //public static Item gladiator_helmet = new StraightCrestHelmet(ArmorMaterials.gladiator_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "gladiator_helmet"));
    //public static Item eagle_helmet = new StraightCrestHelmet(ArmorMaterials.eagle_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "eagle_helmet"));


    //public static Item winged_hussar_helmet = new WingedHussarHelmet(ArmorMaterials.winged_hussar,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_helmet"));
    //public static Item winged_hussar_chest = new WingedHussarChest(ArmorMaterials.winged_hussar,EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_chest"));
    //public static Item winged_hussar_pants = new WingedHussarPants(ArmorMaterials.winged_hussar,EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_pants"));
    //public static Item winged_hussar_boots = new WingedHussarBoots(ArmorMaterials.winged_hussar,EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_boots"));

    private static List<RegistryObject<Item>> registerSwordssFullSet(String name, int damage, float speed, Item.Properties props, List<Tier> tiers) {
        List<RegistryObject<Item>> swordsList = new ArrayList<>();

        tiers.forEach(tier -> {
            if (Tiers.IRON.equals(tier)) {
                swordsList.add(REGISTER.register(name, () -> new SwordItem(tier, damage, speed, props)));
            } else if (Tiers.DIAMOND.equals(tier)) {
                swordsList.add(REGISTER.register("refined_" + name, () -> new SwordItem(tier, damage, speed, props)));
            } else if (Tiers.NETHERITE.equals(tier)) {
                swordsList.add(REGISTER.register("exquisite_" + name, () -> new SwordItem(tier, damage, speed, props)));
            }
        });
        dataGenItemModels.addAll(swordsList);
        dataGenItemRecipes.addAll(swordsList);
        return swordsList;
    }

    private static RegistryObject<Item> registerCrossBow(String name, Item.Properties props) {
        RegistryObject<Item> item = REGISTER.register(name, () -> new ModCrossbow(props));
        dataGenItemRecipes.add(item);
        return item;
    }

    private static RegistryObject<Item> registerBow(String name, Item.Properties props) {
        RegistryObject<Item> item = REGISTER.register(name, () -> new ModBow(props));
        dataGenItemRecipes.add(item);
        return item;
    }

    private static RegistryObject<Item> registerShield(String name, Item.Properties props) {
        RegistryObject<Item> item = REGISTER.register(name, () -> new ModShield(props));
        dataGenItemRecipes.add(item);
        return item;
    }

    private static List<RegistryObject<Item>> registerArmorModelMultiMaterials(String name, Item.Properties props, String texture, EquipmentSlot slot, Class modelClass, ModelLayerLocation layerLocation, List<ArmorMaterial> armorMaterials) {
        List<RegistryObject<Item>> armorsList = new ArrayList<>();
        armorMaterials.forEach(armorMaterial -> {
            switch (armorMaterial.getName()) {
                case "iron":
                    armorsList.add(REGISTER.register(name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorTexPath(texture, false))));
                    break;
                case "bronze":
                    armorsList.add(REGISTER.register(name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorTexPath(texture, false))));
                    break;
                case "diamond":
                    armorsList.add(REGISTER.register("refined_" + name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorTexPath(texture, false))));
                    break;
                case "netherite":
                    armorsList.add(REGISTER.register("exquisite_" + name, () ->
                            new ArmorModelItem(armorMaterial, slot, props, modelClass, layerLocation, constructArmorTexPath(texture, false))));
                    break;
            }
        });
        dataGenItemModels.addAll(armorsList);
        dataGenItemRecipes.addAll(armorsList);
        return armorsList;
    }


    private static List<RegistryObject<Item>> registerArmorSetMultiMaterials(Item.Properties props, String texture, List<ArmorMaterial> armorMaterials) {
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
        dataGenItemRecipes.addAll(armorsList);
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
