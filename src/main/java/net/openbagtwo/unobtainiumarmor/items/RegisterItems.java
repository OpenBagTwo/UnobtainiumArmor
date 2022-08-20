package net.openbagtwo.unobtainiumarmor.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import net.openbagtwo.unobtainiumarmor.materials.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import nourl.mythicmetals.item.MythicItems;

import static net.openbagtwo.unobtainiumarmor.items.Alexandrite.ALEXANDRITE;
import static net.openbagtwo.unobtainiumarmor.items.CatsEyeGem.CATS_EYE_GEM;
import static net.openbagtwo.unobtainiumarmor.items.Sapphire.SAPPHIRE;

public class RegisterItems {

    public static final ArmorMaterial unobtainiumMaterial = new UnobtainiumMaterial();
    public static final ArmorMaterial platinumMaterial = new PlatinumMaterial();
    public static final ArmorMaterial alexandriteMaterial = new AlexandriteMaterial();
    public static final ArmorMaterial sapphireMaterial = new SapphireMaterial();
    public static final ArmorMaterial catsEyeMaterial = new CatsEyeMaterial();

    public static final Item UNOBTAINIUM_HELMET = new ArmorItem(unobtainiumMaterial, EquipmentSlot.HEAD, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_CHESTPLATE = new ArmorItem(unobtainiumMaterial, EquipmentSlot.CHEST, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_LEGGINGS = new ArmorItem(unobtainiumMaterial, EquipmentSlot.LEGS, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_BOOTS = new ArmorItem(unobtainiumMaterial, EquipmentSlot.FEET, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));

    public static final Item PLATINUM_HELMET = new ArmorItem(platinumMaterial, EquipmentSlot.HEAD, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_CHESTPLATE = new ArmorItem(platinumMaterial, EquipmentSlot.CHEST, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_LEGGINGS = new ArmorItem(platinumMaterial, EquipmentSlot.LEGS, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_BOOTS = new ArmorItem(platinumMaterial, EquipmentSlot.FEET, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));

    public static final Item ALEXANDRITE_HELMET = new ArmorItem(alexandriteMaterial, EquipmentSlot.HEAD, new Item.Settings().group(ALEXANDRITE.getGroup()));
    public static final Item ALEXANDRITE_CHESTPLATE = new ArmorItem(alexandriteMaterial, EquipmentSlot.CHEST, new Item.Settings().group(ALEXANDRITE.getGroup()));
    public static final Item ALEXANDRITE_LEGGINGS = new ArmorItem(alexandriteMaterial, EquipmentSlot.LEGS, new Item.Settings().group(ALEXANDRITE.getGroup()));
    public static final Item ALEXANDRITE_BOOTS = new ArmorItem(alexandriteMaterial, EquipmentSlot.FEET, new Item.Settings().group(ALEXANDRITE.getGroup()));

    public static final Item SAPPHIRE_HELMET = new ArmorItem(sapphireMaterial, EquipmentSlot.HEAD, new Item.Settings().group(SAPPHIRE.getGroup()));
    public static final Item SAPPHIRE_CHESTPLATE = new ArmorItem(sapphireMaterial, EquipmentSlot.CHEST, new Item.Settings().group(SAPPHIRE.getGroup()));
    public static final Item SAPPHIRE_LEGGINGS = new ArmorItem(sapphireMaterial, EquipmentSlot.LEGS, new Item.Settings().group(SAPPHIRE.getGroup()));
    public static final Item SAPPHIRE_BOOTS = new ArmorItem(sapphireMaterial, EquipmentSlot.FEET, new Item.Settings().group(SAPPHIRE.getGroup()));

    public static final Item CATS_EYE_GEM_HELMET = new ArmorItem(catsEyeMaterial, EquipmentSlot.HEAD, new Item.Settings().group(CATS_EYE_GEM.getGroup()));
    public static final Item CATS_EYE_GEM_CHESTPLATE = new ArmorItem(catsEyeMaterial, EquipmentSlot.CHEST, new Item.Settings().group(CATS_EYE_GEM.getGroup()));
    public static final Item CATS_EYE_GEM_LEGGINGS = new ArmorItem(catsEyeMaterial, EquipmentSlot.LEGS, new Item.Settings().group(CATS_EYE_GEM.getGroup()));
    public static final Item CATS_EYE_GEM_BOOTS = new ArmorItem(catsEyeMaterial, EquipmentSlot.FEET, new Item.Settings().group(CATS_EYE_GEM.getGroup()));


    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "unobtainium_helmet"), UNOBTAINIUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "unobtainium_chestplate"), UNOBTAINIUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "unobtainium_leggings"), UNOBTAINIUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "unobtainium_boots"), UNOBTAINIUM_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "platinum_helmet"), PLATINUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "platinum_chestplate"), PLATINUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "platinum_leggings"), PLATINUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "platinum_boots"), PLATINUM_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "alexandrite"), ALEXANDRITE);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "alexandrite_helmet"), ALEXANDRITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "alexandrite_chestplate"), ALEXANDRITE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "alexandrite_leggings"), ALEXANDRITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "alexandrite_boots"), ALEXANDRITE_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "sapphire_helmet"), SAPPHIRE_HELMET);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "sapphire_chestplate"), SAPPHIRE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "sapphire_leggings"), SAPPHIRE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "sapphire_boots"), SAPPHIRE_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "cats_eye_gem"), CATS_EYE_GEM);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "cats_eye_gem_helmet"), CATS_EYE_GEM_HELMET);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "cats_eye_gem_chestplate"), CATS_EYE_GEM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "cats_eye_gem_leggings"), CATS_EYE_GEM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "cats_eye_gem_boots"), CATS_EYE_GEM_BOOTS);
    }
}
