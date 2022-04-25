package net.openbagtwo.unobtainium_armor.materials;

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
        return BASE_DURABILITY[slot.getEntitySlotId()] * 1;  // oh yeah, gonna make em super fragile
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
        return SoundEvents.ENTITY_WITHER_SPAWN;  // why not!
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
        return 100;  // tough but brittle I guess
    }

    @Override
    public float getKnockbackResistance() {
        return 100;  // OP oh yeah
    }
}
