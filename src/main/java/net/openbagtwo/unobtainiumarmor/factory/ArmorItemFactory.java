package net.openbagtwo.unobtainiumarmor.factory;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.openbagtwo.unobtainiumarmor.items.MythrilArmorItem;
import ru.betterend.item.ArmoredElytra;

import java.util.*;

import static net.openbagtwo.unobtainiumarmor.factory.MaterialFactory.getMaterialIngredient;

public class ArmorItemFactory {

    private final String _name;

    private final MaterialFactory _material;

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

    private ElytraProperties _elytraProperties = null;

    private boolean _registerIngredient = false;

    private boolean _isMythril = false;

    private ArmorItemFactory(String name, ArmorMaterial material){
        this._name = name;
        this._material = new MaterialFactory(material);
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
        item_factory._registerIngredient = true;
        return item_factory;
    }

    public static ArmorItemFactory makeArmorSet(String name){
        return makeArmorSet(name, name);
    }

    private ArmoredElytra makeArmoredElytra(Item chestplate){
        return new ArmoredElytra(
                this._name + "_elytra",
                this._material,
                this._elytraProperties.repairItem,
                (int) (chestplate.getMaxDamage() * this._elytraProperties.durabilityMultiplier),
                this._elytraProperties.movementFactor,
                this._elytraProperties.fireproof
        );
    }

    public ArmorItemFactory setElytraProperties(Item repairItem, double movementFactor, boolean fireproof, double durabilityMultiplier){
        this._elytraProperties = new ElytraProperties();
        this._elytraProperties.repairItem = repairItem;
        this._elytraProperties.movementFactor = movementFactor;
        this._elytraProperties.fireproof = fireproof;
        this._elytraProperties.durabilityMultiplier = durabilityMultiplier;
        return this;
    }

    public ArmorItemFactory setElytraProperties(double movementFactor, boolean fireproof, double durabilityMultiplier){
        return this.setElytraProperties(getMaterialIngredient(this._material), movementFactor, fireproof, durabilityMultiplier);
    }

    public ArmorItemFactory setElytraProperties(Item repairItem, double movementFactor, boolean fireproof){
        return this.setElytraProperties(repairItem, movementFactor, fireproof, 1.0);
    }

    public ArmorItemFactory setElytraProperties(double movementFactor, boolean fireproof){
        return this.setElytraProperties(
                getMaterialIngredient(this._material),
                movementFactor,
                fireproof,
                1.0
        );
    }

    public ArmorItemFactory makeMythril(){
        this._isMythril = true;
        return this;
    }

    public Map<String, Item> getItemsForRegistration(){
        HashMap<String, Item> items = new HashMap<>();
        if (this._registerIngredient) {
            items.put(this._material.getName(), getMaterialIngredient(this._material));
        }
        for (Map.Entry<EquipmentSlot, String> slot : SLOT_MAP.entrySet()) {
            ArmorItem armorItem;
            if (this._isMythril){
                armorItem = new MythrilArmorItem(this._material, slot.getKey());
            } else {
                armorItem = new ArmorItem(
                        this._material,
                        slot.getKey(),
                        new FabricItemSettings().group(ItemGroup.COMBAT)
                );
            }
            items.put(this._name + "_" + slot.getValue(), armorItem);
        }
        if (this._elytraProperties != null){
            items.put(
                    this._name + "_elytra",
                    this.makeArmoredElytra(items.get(this._name + "_chestplate"))
            );
        }
        return items;
    }

    public ArmorItemFactory setDurability(Map<EquipmentSlot, Integer> durability){
        this._material.setDurability(durability);
        return this;
    }

    public ArmorItemFactory setProtection(Map<EquipmentSlot, Integer> protection){
        this._material.setProtection(protection);
        return this;
    }

    public ArmorItemFactory setEnchantability(int enchantability){
        this._material.setEnchantability(enchantability);
        return this;
    }

    public ArmorItemFactory setToughness(float toughness){
        this._material.setToughness(toughness);
        return this;
    }

    public ArmorItemFactory setKnockbackResistance(float knockbackResistance){
        this._material.setKnockbackResistance(knockbackResistance);
        return this;
    }

    public ArmorItemFactory setEquipSound(SoundEvent equipSound){
        this._material.setEquipSound(equipSound);
        return this;
    }
}
