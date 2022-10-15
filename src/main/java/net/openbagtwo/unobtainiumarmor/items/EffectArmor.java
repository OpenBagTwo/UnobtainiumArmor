package net.openbagtwo.unobtainiumarmor.items;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EffectArmor extends ArmorItem {

  List<StatusEffectInstance> effects;

  public EffectArmor(
      ArmorMaterial material,
      EquipmentSlot slot,
      List<StatusEffectInstance> effects
  ) {
    super(material, slot, new Item.Settings().group(ItemGroup.COMBAT));
    this.effects = effects;
  }

  @Override
  public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    if (world.isClient()) {
      return;
    }
    if (!(entity instanceof LivingEntity)) {
      return;
    }
    if (this.effects.size() == 0){
      return;
    }
    if (this.isWearingFullSet(entity)) {
      applyEffects((LivingEntity) entity, this.effects);
    }
    super.inventoryTick(stack, world, entity, slot, selected);
  }


  private boolean isWearingFullSet(Entity wearer) {
    ArmorMaterial material = this.getMaterial();

    int armorCount = 0;
    for (ItemStack armorPiece: wearer.getArmorItems()) {
      if (armorPiece.getItem() instanceof ArmorItem) {
        if (((ArmorItem) armorPiece.getItem()).getMaterial() == material) {
          armorCount++;
        }
      }
    }
    return (armorCount == 4);
  }

  private static void applyEffects(LivingEntity wearer, List<StatusEffectInstance> statusEffects) {
    for (StatusEffectInstance effect: statusEffects) {
      StatusEffectInstance currentEffectStatus = wearer.getStatusEffect(effect.getEffectType());
      if (currentEffectStatus != null){
        // if wearer already has the effect
        if (currentEffectStatus.getAmplifier() > effect.getAmplifier()) {
          // and it's stronger than what we're trying to apply
          // then skip
          continue;
        }
        if (currentEffectStatus.getAmplifier() == effect.getAmplifier()) {
          // and it's equal inn strength to what we're trying to apply
          if (effect.getDuration() - currentEffectStatus.getDuration() < 20){
            // and applying the current effect would extend the duration by less than one second
            // then skip
            continue;
          }
        }
      }
      wearer.addStatusEffect(new StatusEffectInstance(effect.getEffectType(),
          effect.getDuration(), effect.getAmplifier()));
    }
  }
}
