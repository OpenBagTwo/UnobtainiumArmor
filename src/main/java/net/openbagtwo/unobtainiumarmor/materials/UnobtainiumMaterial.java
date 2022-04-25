package net.openbagtwo.unobtainiumarmor.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import nourl.mythicmetals.item.MythicItems;

public class UnobtainiumMaterial implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {100, 150, 200, 100};

    @Override
    public int getDurability(EquipmentSlot slot) {
        // oh yeah, gonna make em super fragile
        return BASE_DURABILITY[slot.getEntitySlotId()] * 1;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        // Let's have fun with it!
        return SoundEvents.ENTITY_WITHER_SPAWN;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MythicItems.UNOBTAINIUM);
    }

    @Override
    public String getName() {
        return "unobtainium";
    }

    @Override
    public float getToughness() {
        // tough but brittle I guess
        return 100;
    }

    @Override
    public float getKnockbackResistance() {
        // I really don't care enough to be futzing with the mixins
        return 0;
    }
}
