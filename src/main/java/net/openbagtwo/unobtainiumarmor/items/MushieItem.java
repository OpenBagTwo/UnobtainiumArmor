package net.openbagtwo.unobtainiumarmor.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import ru.betterend.item.ArmoredElytra;

import static net.openbagtwo.unobtainiumarmor.materials.MushieLayer.GOOMBA_LAYER;

public class MushieItem {

    public static final Item GOOMBA_COIN_COIN = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Item GOOMBA_HELMET = new ArmorItem(GOOMBA_LAYER, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item GOOMBA_CHESTPLATE = new ArmorItem(GOOMBA_LAYER, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item GOOMBA_LEGGINGS = new ArmorItem(GOOMBA_LAYER, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item GOOMBA_BOOTS = new ArmorItem(GOOMBA_LAYER, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

    public static final Item GOOMBA_ELYTRA = new ArmoredElytra("goomba_elytra", GOOMBA_LAYER, GOOMBA_COIN_COIN, GOOMBA_CHESTPLATE.getMaxDamage(), 0.93, false);

}
