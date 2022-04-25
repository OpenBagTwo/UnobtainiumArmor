package net.openbagtwo.unobtainium_armor.items;

import net.openbagtwo.unobtainium_armor.materials.UnobtainiumMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import nourl.mythicmetals.item.MythicItems;

public class RegisterItems {

    public static final ArmorMaterial unobtainiumMaterial = new UnobtainiumMaterial();

    public static final Item UNOBTAINIUM_HELMET = new ArmorItem(unobtainiumMaterial, EquipmentSlot.HEAD, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_CHESTPLATE = new ArmorItem(unobtainiumMaterial, EquipmentSlot.CHEST, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_LEGGINGS = new ArmorItem(unobtainiumMaterial, EquipmentSlot.LEGS, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));
    public static final Item UNOBTAINIUM_BOOTS = new ArmorItem(unobtainiumMaterial, EquipmentSlot.FEET, new Item.Settings().group(MythicItems.UNOBTAINIUM.getGroup()));

    public static void register() {
        Registry.register(Registry.ITEM, new Identifier("unobtainium", "unobtainium_helmet"), UNOBTAINIUM_HELMET);
        Registry.register(Registry.ITEM, new Identifier("unobtainium", "unobtainium_chestplate"), UNOBTAINIUM_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("unobtainium", "unobtainium_leggings"), UNOBTAINIUM_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("unobtainium", "unobtainium_boots"), UNOBTAINIUM_BOOTS);
    }
}
