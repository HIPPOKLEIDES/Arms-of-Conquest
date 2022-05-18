package com.conquestreforged.arms.init;

import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.armor.*;
import com.conquestreforged.arms.items.armor.materials.ArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.conquestreforged.arms.ArmsOfConquest.MOD_ID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    
    public static Item spear_iron = new ModSpear(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "spear_iron"));

    public static Item centurion_helmet = new FlatCrestHelmet(ArmorMaterials.centurion_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "centurion_helmet"));
    public static Item corinthian_helmet = new StraightCrestHelmet(ArmorMaterials.corinthian_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "corinthian_helmet"));
    public static Item jaguar_helmet = new StraightCrestHelmet(ArmorMaterials.jaguar_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "jaguar_helmet"));
    public static Item gladiator_helmet = new StraightCrestHelmet(ArmorMaterials.gladiator_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "gladiator_helmet"));
    public static Item eagle_helmet = new StraightCrestHelmet(ArmorMaterials.eagle_helmet,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "eagle_helmet"));


    public static Item winged_hussar_helmet = new WingedHussarHelmet(ArmorMaterials.winged_hussar,EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_helmet"));
    public static Item winged_hussar_chest = new WingedHussarChest(ArmorMaterials.winged_hussar,EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_chest"));
    public static Item winged_hussar_pants = new WingedHussarPants(ArmorMaterials.winged_hussar,EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_pants"));
    public static Item winged_hussar_boots = new WingedHussarBoots(ArmorMaterials.winged_hussar,EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(1).durability(100)).setRegistryName(new ResourceLocation(MOD_ID, "winged_hussar_boots"));


    @SubscribeEvent
    public static void init(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(spear_iron, centurion_helmet, corinthian_helmet, jaguar_helmet, gladiator_helmet, eagle_helmet, winged_hussar_chest, winged_hussar_pants, winged_hussar_boots, winged_hussar_helmet);
    }
}
