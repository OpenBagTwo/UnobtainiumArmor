package net.openbagtwo.unobtainiumarmor.factory;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.openbagtwo.unobtainiumarmor.items.EffectArmor;
import net.openbagtwo.unobtainiumarmor.items.MythrilArmorItem;
import ru.betterend.item.ArmoredElytra;

import java.util.*;

import static net.openbagtwo.unobtainiumarmor.factory.MaterialFactory.getMaterialIngredient;

public class ArmorItemFactory {

    private final String name;

    private final MaterialFactory material;

    public static final Map<EquipmentSlot, String> SLOT_MAP = Map.of(
            EquipmentSlot.HEAD, "helmet",
            EquipmentSlot.CHEST, "chestplate",
            EquipmentSlot.LEGS, "leggings",
            EquipmentSlot.FEET, "boots"
    );

    private static class ElytraProperties {
        Item repairItem;
        double movementFactor;  // Determines how fast you lose momentum. Between 0 and 1 but < 0.9 is brutal.
        boolean fireproof;
        double durabilityMultiplier;  // Durability compared to chestplate. Should be <= 1.
    }

    private ElytraProperties elytraProperties = null;

    private boolean registerIngredient = false;

    private boolean isMythril = false;

    private ArrayList<StatusEffectInstance> effects = new ArrayList<>();

    private ArmorItemFactory(String name, ArmorMaterial material){
        this.name = name;
        this.material = new MaterialFactory(material);
    }

    public static ArmorItemFactory makeArmorSet(String name, ArmorMaterial material) {
        return new ArmorItemFactory(name, material);
    }

    public static ArmorItemFactory makeArmorSet(ArmorMaterial material) {
        return makeArmorSet(material.getName(), material);
    }

    public static ArmorItemFactory makeArmorSet(String armorName, String ingredientName){
        Item ingredient = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
        ArmorItemFactory item_factory = makeArmorSet(
                armorName,
                MaterialFactory.makeMaterial(ingredientName, ingredient)
        );
        item_factory.registerIngredient = true;
        return item_factory;
    }

    public static ArmorItemFactory makeArmorSet(String name){
        return makeArmorSet(name, name);
    }

    private ArmoredElytra makeArmoredElytra(Item chestplate){
        return new ArmoredElytra(
                this.name + "_elytra",
                this.material,
                this.elytraProperties.repairItem,
                (int) (chestplate.getMaxDamage() * this.elytraProperties.durabilityMultiplier),
                this.elytraProperties.movementFactor,
                this.elytraProperties.fireproof
        );
    }

    public ArmorItemFactory setElytraProperties(Item repairItem, double movementFactor, boolean fireproof, double durabilityMultiplier){
        this.elytraProperties = new ElytraProperties();
        this.elytraProperties.repairItem = repairItem;
        this.elytraProperties.movementFactor = movementFactor;
        this.elytraProperties.fireproof = fireproof;
        this.elytraProperties.durabilityMultiplier = durabilityMultiplier;
        return this;
    }

    public ArmorItemFactory setElytraProperties(double movementFactor, boolean fireproof, double durabilityMultiplier){
        return this.setElytraProperties(getMaterialIngredient(this.material), movementFactor, fireproof, durabilityMultiplier);
    }

    public ArmorItemFactory setElytraProperties(Item repairItem, double movementFactor, boolean fireproof){
        return this.setElytraProperties(repairItem, movementFactor, fireproof, 1.0);
    }

    public ArmorItemFactory setElytraProperties(double movementFactor, boolean fireproof){
        return this.setElytraProperties(
                getMaterialIngredient(this.material),
                movementFactor,
                fireproof,
                1.0
        );
    }

    public ArmorItemFactory makeMythril(){
        this.isMythril = true;
        return this;
    }

    public ArmorItemFactory addEffect(StatusEffect effect, int amplifier, int duration) {
        this.effects.add(
            new StatusEffectInstance(
                effect,
                duration,
                amplifier,
                false,
                true,
                true)
        );
        return this;
    }

    public ArmorItemFactory addEffect(StatusEffect effect, int amplifier) {
        return addEffect(effect, amplifier, 1);
    }

    public ArmorItemFactory addEffect(StatusEffect effect) {
        return addEffect(effect, 0, 1);
    }

    public Map<String, Item> getItemsForRegistration(){
        HashMap<String, Item> items = new HashMap<>();
        if (this.registerIngredient) {
            items.put(this.material.getName(), getMaterialIngredient(this.material));
        }
        for (Map.Entry<EquipmentSlot, String> slot : SLOT_MAP.entrySet()) {
            ArmorItem armorItem;
            List<StatusEffectInstance> pieceEffects = Collections.emptyList();
            if (slot.getKey() == EquipmentSlot.HEAD) {
                pieceEffects = this.effects;
            }
            if (this.isMythril){
                armorItem = new MythrilArmorItem(this.material, slot.getKey(), pieceEffects);
            } else {
                armorItem = new EffectArmor(this.material, slot.getKey(), pieceEffects);
            }
            items.put(this.name + "_" + slot.getValue(), armorItem);
        }
        if (this.elytraProperties != null){
            items.put(
                    this.name + "_elytra",
                    this.makeArmoredElytra(items.get(this.name + "_chestplate"))
            );
        }
        return items;
    }

    public ArmorItemFactory setDurability(Map<EquipmentSlot, Integer> durability){
        this.material.setDurability(durability);
        return this;
    }

    public ArmorItemFactory setProtection(Map<EquipmentSlot, Integer> protection){
        this.material.setProtection(protection);
        return this;
    }

    public ArmorItemFactory setEnchantability(int enchantability){
        this.material.setEnchantability(enchantability);
        return this;
    }

    public ArmorItemFactory setToughness(float toughness){
        this.material.setToughness(toughness);
        return this;
    }

    public ArmorItemFactory setKnockbackResistance(float knockbackResistance){
        this.material.setKnockbackResistance(knockbackResistance);
        return this;
    }

    public ArmorItemFactory setEquipSound(SoundEvent equipSound){
        this.material.setEquipSound(equipSound);
        return this;
    }
}
