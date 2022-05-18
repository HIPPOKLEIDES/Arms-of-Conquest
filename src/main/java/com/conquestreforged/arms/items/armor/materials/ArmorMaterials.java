package com.conquestreforged.arms.items.armor.materials;

import com.conquestreforged.arms.ArmsOfConquest;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public enum ArmorMaterials implements ArmorMaterial {

    centurion_helmet("centurion_helmet", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    corinthian_helmet("corinthian_helmet", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    jaguar_helmet("jaguar_helmet", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    eagle_helmet("eagle_helmet", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    gladiator_helmet("gladiator_helmet", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),

    winged_hussar("winged_hussar", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),


    bronze("bronze", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    chainmail1("chainmail1", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    cheap("cheap", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    crusader("crusader", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    dwarven("dwarven", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    elven("elven", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    evil("evil", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    fancy_gambeson("fancy_gambeson", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    fur("fur", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    heavyfootsoldier("heavyfootsoldier", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    heavyhigh("heavyhigh", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    high("high", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    ice("ice", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    iron1("iron1", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    knight("knight", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    leather1("leather1", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    lord("lord", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    majestic("majestic", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    mithril("mithril", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    norman("norman", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    north("north", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    orc("orc", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    rogue("rogue", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    roseplate("roseplate", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    skeletal("skeletal", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    spottedfootsoldier("spottedfootsoldier", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    steel("steel", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    tourney("tourney", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f),
    viking("viking", 800, new int[] {2, 2, 2, 2}, 25, "item.armor.equip_diamond", 0.0f);

    private String name, equipSound;
    private int durability, enchantability;
    private final int[] damageReductionAmountArray;
    private float toughness;
    ArmorMaterials(String name, int durability, int[] damageReductionAmountArray, int enchantability, String equipSound, float toughness) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
    }
    @Override
    public int getDurabilityForSlot(EquipmentSlot equipmentSlotType) {
        return this.durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlotType) {
        return this.damageReductionAmountArray[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.IRON_INGOT);
    }

    @Override
    public String getName() {
        return ArmsOfConquest.MOD_ID+":"+this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
