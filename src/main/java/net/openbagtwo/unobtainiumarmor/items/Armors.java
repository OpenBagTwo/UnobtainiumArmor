package net.openbagtwo.unobtainiumarmor.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.sound.SoundEvents;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import net.openbagtwo.unobtainiumarmor.factory.ArmorItemFactory;
import net.openbagtwo.unobtainiumarmor.factory.MaterialFactory;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.openbagtwo.unobtainiumarmor.materials.InfinionicLayer;
import net.openbagtwo.unobtainiumarmor.materials.MushieLayer;
import nourl.mythicmetals.item.MythicItems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static net.openbagtwo.unobtainiumarmor.blocks.Blocks.BLOCK_ITEMS;
import static net.openbagtwo.unobtainiumarmor.factory.MaterialFactory.durabilityValues;
import static net.openbagtwo.unobtainiumarmor.factory.MaterialFactory.slotValues;
import static net.openbagtwo.unobtainiumarmor.materials.InfinionicLayer.INFINIONIC_GEMS;

public class Armors {

  public static final Map<String, Item> UNOBTAINIUM = ArmorItemFactory.makeArmorSet(
      MaterialFactory.makeMaterial("unobtainium", MythicItems.UNOBTAINIUM
      ).setDurability(durabilityValues(1)
      ).setProtection(slotValues(100, 200, 150, 100)
      ).setEnchantability(15).setToughness(100).setEquipSound(
          SoundEvents.ENTITY_WITHER_SPAWN
      )
  ).getItemsForRegistration();

  public static final Map<String, Item> ALEXANDRITE = ArmorItemFactory.makeArmorSet("alexandrite"
  ).setDurability(durabilityValues(16)
  ).setProtection(slotValues(1, 2, 2, 1)
  ).setEnchantability(36).setEquipSound(SoundEvents.BLOCK_NOTE_BLOCK_HARP
  ).getItemsForRegistration();

  public static final Map<String, Item> CATS_EYE = ArmorItemFactory.makeArmorSet("cats_eye_gem"
  ).setDurability(slotValues(4, 3, 2, 1, 9)
  ).setProtection(slotValues(1, 1, 1, 1)
  ).setEnchantability(2).setEquipSound(SoundEvents.ENTITY_CAT_PURREOW
  ).setElytraProperties(0.999, false
  ).getItemsForRegistration();

  public static final Map<String, Item> MYTHRIL = ArmorItemFactory.makeArmorSet(
      "mythril",
      MaterialFactory.makeMaterial("slime", Items.SLIME_BALL)
          .setDurability(durabilityValues(14))
          .setProtection(slotValues(3, 8, 6, 3))
          .setEnchantability(1)
          .setEquipSound(SoundEvents.ENTITY_SLIME_ATTACK)
          .setKnockbackResistance(0.99F)
  ).setElytraProperties(0.8, false).makeMythril().getItemsForRegistration();

  public static final Map<String, Item> CITRINE = Collections.singletonMap(
      "citrine_crystal",
      new Item(new FabricItemSettings().group(ItemGroup.MATERIALS))
  );
  public static final Map<String, Item> CYTHRIL = ArmorItemFactory.makeArmorSet(
      MaterialFactory.makeMaterial("citrine", CITRINE.values().iterator().next())
  ).setDurability(durabilityValues(18)
  ).setProtection(slotValues(1, 2, 2, 1)
  ).setEnchantability(28
  ).setEquipSound(SoundEvents.BLOCK_BEACON_POWER_SELECT
  ).setElytraProperties(0.97, false
  ).makeMythril().getItemsForRegistration();

  public static final Map<String, Item> PLATINUM = ArmorItemFactory.makeArmorSet(
      MaterialFactory.makeMaterial("platinum", MythicItems.PLATINUM_INGOT
      ).setDurability(durabilityValues(9)
      ).setProtection(slotValues(3, 6, 4, 2)
      ).setEnchantability(24
      ).setEquipSound(SoundEvents.ITEM_ARMOR_EQUIP_GOLD)
  ).getItemsForRegistration();

  public static final Map<String, Item> SAPPHIRE = ArmorItemFactory.makeArmorSet("sapphire"
  ).setDurability(slotValues(1, 1, 1, 1, 16)
  ).setProtection(slotValues(1, 1, 1, 1)
  ).setEnchantability(64).setEquipSound(SoundEvents.BLOCK_NOTE_BLOCK_DIDGERIDOO
  ).makeMythril().getItemsForRegistration();

  // Adapting from MoreGems' Gilded Carbonado
  public static final Map<String, Item> BUMBLENADO = ArmorItemFactory.makeArmorSet("bumblenado"
  ).setDurability(durabilityValues(33)
  ).setProtection(slotValues(3, 8, 6, 3)
  ).setEnchantability(10
  ).setEquipSound(SoundEvents.ENTITY_BEE_LOOP_AGGRESSIVE
  ).setToughness(0.75F
  ).setKnockbackResistance(0.25F
  ).setElytraProperties(0.87, true
  ).getItemsForRegistration();

  public static final Map<String, Item> MUSHIE_COIN_COIN = Collections.singletonMap(
      "goomba_coin_coin",
      MushieLayer.GOOMBA_COIN_COIN
  );
  public static final Map<String, Item> MUSHIE = ArmorItemFactory.makeArmorSet(
      "goomba", MushieLayer.GOOMBA_LAYER
  ).setElytraProperties(0.93, false
  ).getItemsForRegistration();

  public static final Map<String, Item> TOPAZ = ArmorItemFactory.makeArmorSet("topaz"
  ).setEquipSound(SoundEvents.BLOCK_TUFF_STEP
  ).setElytraProperties(0.95, false
  ).makeMythril(
  ).getItemsForRegistration();

  public static final Map<String, Item> INFINITY = ArmorItemFactory.makeArmorSet(
      MaterialFactory.makeMaterial("infinity", Items.GHAST_TEAR)
  ).setEquipSound(SoundEvents.UI_TOAST_CHALLENGE_COMPLETE
  ).makeMythril(
  ).getItemsForRegistration();

  public static final Map<String, Item> CATS_EYE_GEMM_ORE = ArmorItemFactory.makeArmorSet(
      MaterialFactory.makeMaterial(
          "cats_eye_gemm_ore",
          BLOCK_ITEMS.get("cats_eye_gemm_ore")
      )
  ).setEquipSound(SoundEvents.BLOCK_COPPER_BREAK
  ).setElytraProperties(0.99, true
  ).getItemsForRegistration();

  public static final Map<String, Item> TANZANITE = ArmorItemFactory.makeArmorSet("tanzanite"
  ).setEquipSound(SoundEvents.BLOCK_NOTE_BLOCK_GUITAR
  ).setElytraProperties(0.95, false
  ).getItemsForRegistration();

  public static final Map<String, Item> END_ARMOR = ArmorItemFactory.makeArmorSet(
      MaterialFactory.makeMaterial("end_armor", Items.ENDER_EYE)
  ).setEquipSound(SoundEvents.ENTITY_PARROT_IMITATE_ENDER_DRAGON
  ).setElytraProperties(0.82, true
  ).makeMythril(
  ).getItemsForRegistration();

  public static final Map<String, Item> INFINIONIC_ARMOR = ArmorItemFactory.makeArmorSet(
      "infinionic_armor", InfinionicLayer.INFINIONIC_LAYER
  ).getItemsForRegistration();

  public static Map<String, Item> allItems() {
    HashMap<String, Item> allItems = new HashMap<>();
    allItems.putAll(UNOBTAINIUM);
    allItems.putAll(ALEXANDRITE);
    allItems.putAll(CATS_EYE);
    allItems.putAll(MYTHRIL);
    allItems.putAll(CITRINE);
    allItems.putAll(CYTHRIL);
    allItems.putAll(PLATINUM);
    allItems.putAll(SAPPHIRE);
    allItems.putAll(BUMBLENADO);
    allItems.putAll(MUSHIE_COIN_COIN);
    allItems.putAll(MUSHIE);
    allItems.putAll(TOPAZ);
    allItems.putAll(INFINITY);
    allItems.putAll(CATS_EYE_GEMM_ORE);
    allItems.putAll(TANZANITE);
    allItems.putAll(END_ARMOR);
    allItems.putAll(INFINIONIC_GEMS);
    allItems.putAll(INFINIONIC_ARMOR);
    return allItems;
  }

  public static void register() {
    for (Map.Entry<String, Item> item : allItems().entrySet()) {
      Registry.register(
          Registry.ITEM,
          new Identifier(UnobtainiumArmorMod.MOD_ID, item.getKey()),
          item.getValue()
      );
    }
  }
}
