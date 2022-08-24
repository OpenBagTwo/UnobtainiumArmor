package net.openbagtwo.unobtainiumarmor.factory;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import ru.betterend.item.ArmoredElytra;

import java.util.*;

public class ArmorItemFactory extends MaterialFactory{

    private static final Map<EquipmentSlot, String> SLOT_MAP = Map.of(
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

    private ArmorItemFactory(ArmorMaterial material){
        super(material);
    }

    public static ArmorItemFactory makeArmorSet(ArmorMaterial material){
        return new ArmorItemFactory(material);
    }

    public static ArmorItemFactory makeArmorSet(String name){
        Item ingredient = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
        ArmorItemFactory item_factory = new ArmorItemFactory(MaterialFactory.makeMaterial(name, ingredient));
        item_factory._registerIngredient = true;
        return item_factory;
    }

    private ArmoredElytra makeArmoredElytra(Item chestplate){
        return new ArmoredElytra(
                this._name + "_elytra",
                this,
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
        return this.setElytraProperties(this._ingredient, movementFactor, fireproof, durabilityMultiplier);
    }

    public ArmorItemFactory setElytraProperties(Item repairItem, double movementFactor, boolean fireproof){
        return this.setElytraProperties(repairItem, movementFactor, fireproof, 1.0);
    }

    public ArmorItemFactory setElytraProperties(double movementFactor, boolean fireproof){
        return this.setElytraProperties(this._ingredient, movementFactor, fireproof, 1.0);
    }

    public Map<String, Item> getItemsForRegistration(){
        HashMap<String, Item> items = new HashMap<>();
        if (this._registerIngredient) {
            items.put(this._name, this._ingredient);
        }
        for (Map.Entry<EquipmentSlot, String> slot : SLOT_MAP.entrySet()) {
            items.put(
                    this._name + "_" + slot.getValue(),
                    new ArmorItem(this, slot.getKey(), new FabricItemSettings().group(ItemGroup.COMBAT))
            );
        }
        if (this._elytraProperties != null){
            items.put(
                    this._name + "_elytra",
                    this.makeArmoredElytra(items.get(this._name + "_chestplate"))
            );
        }
        return items;
    }
}
