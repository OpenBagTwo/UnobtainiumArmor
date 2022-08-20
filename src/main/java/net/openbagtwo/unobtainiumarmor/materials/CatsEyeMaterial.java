package net.openbagtwo.unobtainiumarmor.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.openbagtwo.unobtainiumarmor.items.CatsEyeGem;
import nourl.mythicmetals.item.MythicItems;

public class CatsEyeMaterial implements ArmorMaterial {

    private static final int[] BASE_DURABILITY = new int[] {4, 3, 2, 1};
    private static final int[] PROTECTION_VALUES = new int[] {1, 1, 1, 1};

    @Override
    public int getDurability(EquipmentSlot slot) {

        return BASE_DURABILITY[slot.getEntitySlotId()] * 9;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 2;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ENTITY_CAT_PURREOW;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(CatsEyeGem.CATS_EYE_GEM);
    }

    @Override
    public String getName() {
        return "cats_eye_gem";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
