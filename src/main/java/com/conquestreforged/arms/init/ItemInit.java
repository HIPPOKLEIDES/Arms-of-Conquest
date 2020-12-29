package com.conquestreforged.arms.init;

import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.armor.*;
import com.conquestreforged.arms.items.armor.materials.ArmorMaterials;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    
    public static Item spear_iron = new ModSpear(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "spear_iron"));

    public static Item centurion_helmet = new FlatCrestHelmet(ArmorMaterials.centurion_helmet,EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "centurion_helmet"));
    public static Item corinthian_helmet = new StraightCrestHelmet(ArmorMaterials.corinthian_helmet,EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "corinthian_helmet"));
    public static Item jaguar_helmet = new StraightCrestHelmet(ArmorMaterials.jaguar_helmet,EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "jaguar_helmet"));
    public static Item gladiator_helmet = new StraightCrestHelmet(ArmorMaterials.gladiator_helmet,EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "gladiator_helmet"));
    public static Item eagle_helmet = new StraightCrestHelmet(ArmorMaterials.eagle_helmet,EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "eagle_helmet"));


    public static Item winged_hussar_helmet = new WingedHussarHelmet(ArmorMaterials.winged_hussar,EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_helmet"));
    public static Item winged_hussar_chest = new WingedHussarChest(ArmorMaterials.winged_hussar,EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_chest"));
    public static Item winged_hussar_pants = new WingedHussarPants(ArmorMaterials.winged_hussar,EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_pants"));
    public static Item winged_hussar_boots = new WingedHussarBoots(ArmorMaterials.winged_hussar,EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).maxDamage(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_boots"));


    @SubscribeEvent
    public static void init(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(spear_iron, centurion_helmet, corinthian_helmet, jaguar_helmet, gladiator_helmet, eagle_helmet, winged_hussar_chest, winged_hussar_pants, winged_hussar_boots, winged_hussar_helmet);
    }
}
