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

    protected final String _name;  // name of the material
    protected final Item _ingredient;  // the crafting / repair material

    // using iron values as defaults
    private Map<EquipmentSlot, Integer> _durability = durabilityValues(15);
    private Map<EquipmentSlot, Integer> _protection = slotValues(2, 6, 5, 2);
    private int _enchantability = 14;  // higher is better
    private float _toughness = 0; // Diamond = 2
    private float _knockbackResistance = 0;  // <1; Fabric tutorial said this needs mixins?
    private SoundEvent _equipSound = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;

    private MaterialFactory(String name, Item ingredient){
        this._name = name;
        this._ingredient = ingredient;
    }

    public MaterialFactory(ArmorMaterial otherMaterial){
        this._name = otherMaterial.getName();
        this._ingredient = getMaterialIngredient(otherMaterial);
        this._durability = slotValues(
                otherMaterial.getDurability(EquipmentSlot.HEAD),
                otherMaterial.getDurability(EquipmentSlot.CHEST),
                otherMaterial.getDurability(EquipmentSlot.LEGS),
                otherMaterial.getDurability(EquipmentSlot.FEET)
        );
        this._protection = slotValues(
                otherMaterial.getProtectionAmount(EquipmentSlot.HEAD),
                otherMaterial.getProtectionAmount(EquipmentSlot.CHEST),
                otherMaterial.getProtectionAmount(EquipmentSlot.LEGS),
                otherMaterial.getProtectionAmount(EquipmentSlot.FEET)
        );
        this._enchantability = otherMaterial.getEnchantability();
        this._toughness = otherMaterial.getToughness();
        this._knockbackResistance = otherMaterial.getKnockbackResistance();
        this._equipSound = otherMaterial.getEquipSound();
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return _durability.get(slot);
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return _protection.get(slot);
    }

    @Override
    public int getEnchantability() {
        return _enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return _equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(_ingredient);
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public float getToughness() {
        return _toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return _knockbackResistance;
    }

    public static MaterialFactory makeMaterial(String name, Item ingredient){
        return new MaterialFactory(name, ingredient);
    }

    public MaterialFactory setDurability(Map<EquipmentSlot, Integer> durability){
        this._durability = durability;
        return this;
    }

    public MaterialFactory setProtection(Map<EquipmentSlot, Integer> protection){
        this._protection = protection;
        return this;
    }

    public MaterialFactory setEnchantability(int enchantability){
        this._enchantability = enchantability;
        return this;
    }

    public MaterialFactory setToughness(float toughness){
        this._toughness = toughness;
        return this;
    }

    public MaterialFactory setKnockbackResistance(float knockbackResistance){
        this._knockbackResistance = knockbackResistance;
        return this;
    }

    public MaterialFactory setEquipSound(SoundEvent equipSound){
        this._equipSound = equipSound;
        return this;
    }
}
