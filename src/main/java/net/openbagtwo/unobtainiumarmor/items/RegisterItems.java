package net.openbagtwo.unobtainiumarmor.items;

import net.openbagtwo.unobtainiumarmor.materials.PlatinumMaterial;
import net.openbagtwo.unobtainiumarmor.materials.UnobtainiumMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import nourl.mythicmetals.item.MythicItems;

public class RegisterItems {

    public static final ArmorMaterial unobtainiumMaterial = new UnobtainiumMaterial();
    public static final ArmorMaterial platinumMaterial = new PlatinumMaterial();

    public static final Item UNOBTAINIUM_HELMET = new ArmorItem(unobtainiumMaterial, EquipmentSlot.HEAD, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_CHESTPLATE = new ArmorItem(unobtainiumMaterial, EquipmentSlot.CHEST, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_LEGGINGS = new ArmorItem(unobtainiumMaterial, EquipmentSlot.LEGS, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_BOOTS = new ArmorItem(unobtainiumMaterial, EquipmentSlot.FEET, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));

    public static final Item PLATINUM_HELMET = new ArmorItem(platinumMaterial, EquipmentSlot.HEAD, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_CHESTPLATE = new ArmorItem(platinumMaterial, EquipmentSlot.CHEST, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_LEGGINGS = new ArmorItem(platinumMaterial, EquipmentSlot.LEGS, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));
    public static final Item PLATINUM_BOOTS = new ArmorItem(platinumMaterial, EquipmentSlot.FEET, new Item.Settings().group(MythicItems.PLATINUM_INGOT.getGroup()));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "unobtainium_helmet"), UNOBTAINIUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "unobtainium_chestplate"), UNOBTAINIUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "unobtainium_leggings"), UNOBTAINIUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "unobtainium_boots"), UNOBTAINIUM_BOOTS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "platinum_helmet"), PLATINUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "platinum_chestplate"), PLATINUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "platinum_leggings"), PLATINUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("unobtainiumarmor", "platinum_boots"), PLATINUM_BOOTS);
    }
}
