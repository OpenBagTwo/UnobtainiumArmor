package net.openbagtwo.unobtainiumarmor.materials;

import java.util.Map;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import net.openbagtwo.unobtainiumarmor.items.InfinionicGem;

public class InfinionicLayer implements ArmorMaterial {

  public static final Map<String, Item> INFINIONIC_GEMS = Map.of(
      "infinionic_gem_red", new InfinionicGem(),
      "infinionic_gem_yellow", new InfinionicGem(),
      "infinionic_gem_green", new InfinionicGem(),
      "infinionic_gem_blue", new InfinionicGem(),
      "infinionic_gem_purple", new InfinionicGem()
      );
  public static final InfinionicLayer INFINIONIC_LAYER = new InfinionicLayer();
  public static final SoundEvent EUGH = registerEquipSound("infinionic_armor_equip");

  public static SoundEvent registerEquipSound(String sound_name) {
    Identifier sound_id = new Identifier(UnobtainiumArmorMod.MOD_ID, sound_name);
    return Registry.register(Registry.SOUND_EVENT, sound_id, new SoundEvent(sound_id));
  }

  private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
  private static final int[] PROTECTION_VALUES = new int[] {1, 2, 200, 10};

  @Override
  public int getDurability(EquipmentSlot slot) {
    return BASE_DURABILITY[slot.getEntitySlotId()] * 6;  // slighly sub-Gold
  }

  @Override
  public int getProtectionAmount(EquipmentSlot slot) {
    return PROTECTION_VALUES[slot.getEntitySlotId()];
  }

  @Override
  public int getEnchantability() {
    return 99;
  }

  @Override
  public SoundEvent getEquipSound() {
    return EUGH;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return Ingredient.ofItems(Items.GOLD_INGOT);
  }

  @Override
  public String getName() {
    return "infinionic_armor";
  }

  @Override
  public float getToughness() {
    return 20.0F;
  }

  @Override
  public float getKnockbackResistance() {
    return 0.999F;
  }
}
