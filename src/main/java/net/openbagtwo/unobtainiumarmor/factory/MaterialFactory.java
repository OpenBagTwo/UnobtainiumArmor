package net.openbagtwo.unobtainiumarmor.factory;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.Map;

public class MaterialFactory implements ArmorMaterial {

    public static Map<EquipmentSlot, Integer> slotValues(int headValue, int chestValue, int legsValue, int feetValue, int multiplier) {
        return Map.of(
                EquipmentSlot.HEAD, headValue * multiplier,
                EquipmentSlot.CHEST, chestValue * multiplier,
                EquipmentSlot.LEGS, legsValue * multiplier,
                EquipmentSlot.FEET, feetValue * multiplier
        );
    }

    public static Map<EquipmentSlot, Integer> slotValues(int headValue, int chestValue, int legsValue, int feetValue) {
        return slotValues(headValue, chestValue, legsValue, feetValue, 1);
    }

    public static Map<EquipmentSlot, Integer> durabilityValues(int multiplier) {
        return slotValues(11, 16, 15, 13, multiplier);
    }

    public static Item getMaterialIngredient(ArmorMaterial armorMaterial){
        return armorMaterial.getRepairIngredient().getMatchingStacks()[0].getItem();
    }

    protected final String name;  // name of the material
    protected final Item ingredient;  // the crafting / repair material

    // using iron values as defaults
    private Map<EquipmentSlot, Integer> durability = durabilityValues(15);
    private Map<EquipmentSlot, Integer> protection = slotValues(2, 6, 5, 2);
    private int enchantability = 14;  // higher is better
    private float toughness = 0; // Diamond = 2
    private float knockbackResistance = 0;  // <1; Fabric tutorial said this needs mixins?
    private SoundEvent equipSound = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;

    private MaterialFactory(String name, Item ingredient){
        this.name = name;
        this.ingredient = ingredient;
    }

    public MaterialFactory(ArmorMaterial otherMaterial){
        this.name = otherMaterial.getName();
        this.ingredient = getMaterialIngredient(otherMaterial);
        this.durability = slotValues(
                otherMaterial.getDurability(EquipmentSlot.HEAD),
                otherMaterial.getDurability(EquipmentSlot.CHEST),
                otherMaterial.getDurability(EquipmentSlot.LEGS),
                otherMaterial.getDurability(EquipmentSlot.FEET)
        );
        this.protection = slotValues(
                otherMaterial.getProtectionAmount(EquipmentSlot.HEAD),
                otherMaterial.getProtectionAmount(EquipmentSlot.CHEST),
                otherMaterial.getProtectionAmount(EquipmentSlot.LEGS),
                otherMaterial.getProtectionAmount(EquipmentSlot.FEET)
        );
        this.enchantability = otherMaterial.getEnchantability();
        this.toughness = otherMaterial.getToughness();
        this.knockbackResistance = otherMaterial.getKnockbackResistance();
        this.equipSound = otherMaterial.getEquipSound();
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return durability.get(slot);
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protection.get(slot);
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ingredient);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return knockbackResistance;
    }

    public static MaterialFactory makeMaterial(String name, Item ingredient){
        return new MaterialFactory(name, ingredient);
    }

    public MaterialFactory setDurability(Map<EquipmentSlot, Integer> durability){
        this.durability = durability;
        return this;
    }

    public MaterialFactory setProtection(Map<EquipmentSlot, Integer> protection){
        this.protection = protection;
        return this;
    }

    public MaterialFactory setEnchantability(int enchantability){
        this.enchantability = enchantability;
        return this;
    }

    public MaterialFactory setToughness(float toughness){
        this.toughness = toughness;
        return this;
    }

    public MaterialFactory setKnockbackResistance(float knockbackResistance){
        this.knockbackResistance = knockbackResistance;
        return this;
    }

    public MaterialFactory setEquipSound(SoundEvent equipSound){
        this.equipSound = equipSound;
        return this;
    }
}
