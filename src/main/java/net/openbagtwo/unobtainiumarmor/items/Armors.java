package net.openbagtwo.unobtainiumarmor.items;

import net.minecraft.sound.SoundEvents;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import net.openbagtwo.unobtainiumarmor.factory.ArmorItemFactory;
import net.openbagtwo.unobtainiumarmor.factory.MaterialFactory;
import net.openbagtwo.unobtainiumarmor.materials.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import nourl.mythicmetals.item.MythicItems;
import ru.betterend.item.ArmoredElytra;

import java.util.HashMap;
import java.util.Map;

import static net.openbagtwo.unobtainiumarmor.factory.MaterialFactory.durabilityValues;
import static net.openbagtwo.unobtainiumarmor.factory.MaterialFactory.slotValues;
import static net.openbagtwo.unobtainiumarmor.items.Bumblenado.BUMBLENADO_GEM;
import static net.openbagtwo.unobtainiumarmor.items.Sapphire.SAPPHIRE;

public class Armors {

    public static final Map<String, Item> UNOBTAINIUM = ArmorItemFactory.makeArmorSet(
            MaterialFactory.makeMaterial("unobtainium", MythicItems.UNOBTAINIUM
            ).setDurability(durabilityValues(1)
            ).setProtection(slotValues(100, 200, 150, 100)
            ).setEnchantability(15).setToughness(100).setEquipSound(
                    SoundEvents.ENTITY_WITHER_SPAWN
            )
    ).getItemsForRegistration();

    public static final Map<String, Item> ALEXANDRITE = (
            (ArmorItemFactory) ArmorItemFactory.makeArmorSet("alexandrite"
            ).setDurability(durabilityValues(16)
            ).setProtection(slotValues(1, 2, 2, 1)
            ).setEnchantability(36).setEquipSound(SoundEvents.BLOCK_NOTE_BLOCK_HARP)
    ).getItemsForRegistration();

    public static final Map<String, Item> CATS_EYE = (
            (ArmorItemFactory) ArmorItemFactory.makeArmorSet("cats_eye_gem"
            ).setDurability(slotValues(4, 3, 2, 1, 9)
            ).setProtection(slotValues(1, 1, 1, 1)
            ).setEnchantability(2).setEquipSound(SoundEvents.ENTITY_CAT_PURREOW)
    ).setElytraProperties(0.999, false
    ).getItemsForRegistration();

    public static Map<String, Item> allItems(){
        HashMap<String, Item> allItems = new HashMap<>();
        allItems.putAll(UNOBTAINIUM);
        allItems.putAll(ALEXANDRITE);
        allItems.putAll(CATS_EYE);
        return allItems;
    }
    public static final ArmorMaterial platinumMaterial = new PlatinumMaterial();
    public static final ArmorMaterial sapphireMaterial = new SapphireMaterial();
    public static final ArmorMaterial bumblenadoMaterial = new BumblenadoMaterial();

    public static final Item PLATINUM_HELMET = new ArmorItem(platinumMaterial, EquipmentSlot.HEAD, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_CHESTPLATE = new ArmorItem(platinumMaterial, EquipmentSlot.CHEST, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_LEGGINGS = new ArmorItem(platinumMaterial, EquipmentSlot.LEGS, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_BOOTS = new ArmorItem(platinumMaterial, EquipmentSlot.FEET, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));

    public static final Item SAPPHIRE_HELMET = new ArmorItem(sapphireMaterial, EquipmentSlot.HEAD, new Item.Settings().group(SAPPHIRE.getGroup()));
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(sapphireMaterial, EquipmentSlot.CHEST, new Item.Settings().group(SAPPHIRE.getGroup()));
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(sapphireMaterial, EquipmentSlot.LEGS, new Item.Settings().group(SAPPHIRE.getGroup()));
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(sapphireMaterial, EquipmentSlot.FEET, new Item.Settings().group(SAPPHIRE.getGroup()));

    public static final Item BUMBLENADO_HELMET = new ArmorItem(bumblenadoMaterial, EquipmentSlot.HEAD, new Item.Settings().group(BUMBLENADO_GEM.getGroup()));
    public static final Item BUMBLENADO_CHESTPLATE = new ArmorItem(bumblenadoMaterial, EquipmentSlot.CHEST, new Item.Settings().group(BUMBLENADO_GEM.getGroup()));
    public static final Item BUMBLENADO_LEGGINGS = new ArmorItem(bumblenadoMaterial, EquipmentSlot.LEGS, new Item.Settings().group(BUMBLENADO_GEM.getGroup()));
    public static final Item BUMBLENADO_BOOTS = new ArmorItem(bumblenadoMaterial, EquipmentSlot.FEET, new Item.Settings().group(BUMBLENADO_GEM.getGroup()));

    public static final Item BUMBLENADO_ELYTRA = new ArmoredElytra("bumblenado_elytra", bumblenadoMaterial, BUMBLENADO_GEM, BUMBLENADO_CHESTPLATE.getMaxDamage(), 0.83, true);

    public static void register() {
        for (Map.Entry<String, Item> item : allItems().entrySet()){
            Registry.register(
                    Registry.ITEM,
                    new Identifier(UnobtainiumArmorMod.MOD_ID, item.getKey()),
                    item.getValue()
            );
        }

        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "platinum_helmet"), PLATINUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "platinum_chestplate"), PLATINUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "platinum_leggings"), PLATINUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "platinum_boots"), PLATINUM_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "sapphire"), SAPPHIRE);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "sapphire_helmet"), SAPPHIRE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "sapphire_boots"), SAPPHIRE_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "bumblenado_gem"), BUMBLENADO_GEM);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "bumblenado_helmet"), BUMBLENADO_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "bumblenado_chestplate"), BUMBLENADO_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "bumblenado_leggings"), BUMBLENADO_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "bumblenado_boots"), BUMBLENADO_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "bumblenado_elytra"), BUMBLENADO_ELYTRA);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "mythril_helmet"), MythrilArmorItem.MYTHRIL_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "mythril_chestplate"), MythrilArmorItem.MYTHRIL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "mythril_leggings"), MythrilArmorItem.MYTHRIL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "mythril_boots"), MythrilArmorItem.MYTHRIL_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "mythril_elytra"), MythrilArmorItem.MYTHRIL_ELYTRA);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "goomba_coin_coin"), MushieItem.GOOMBA_COIN_COIN);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "goomba_helmet"), MushieItem.GOOMBA_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "goomba_chestplate"), MushieItem.GOOMBA_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "goomba_leggings"), MushieItem.GOOMBA_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "goomba_boots"), MushieItem.GOOMBA_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "goomba_elytra"), MushieItem.GOOMBA_ELYTRA);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "citrine_crystal"), CitrineMaterial.CITRINE);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "citrine_helmet"), CythrilArmorItem.CYTHRIL_HELMET);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "citrine_chestplate"), CythrilArmorItem.CYTHRIL_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "citrine_leggings"), CythrilArmorItem.CYTHRIL_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "citrine_boots"), CythrilArmorItem.CYTHRIL_BOOTS);
        Registry.register(Registry.ITEM, new Identifier(UnobtainiumArmorMod.MOD_ID, "citrine_elytra"), CythrilArmorItem.CYTHRIL_ELYTRA);
    }
}
