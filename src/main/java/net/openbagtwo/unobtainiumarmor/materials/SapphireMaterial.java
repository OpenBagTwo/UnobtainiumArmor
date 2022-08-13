package net.openbagtwo.unobtainiumarmor.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.openbagtwo.unobtainiumarmor.items.Sapphire.SAPPHIRE;

public class SapphireMaterial implements ArmorMaterial {
    // Let's make it hilariously useless
    private static final int[] BASE_DURABILITY = new int[] {1, 1, 1, 1};
    private static final int[] PROTECTION_VALUES = new int[] {1, 1, 1, 1};

    @Override
    public int getDurability(EquipmentSlot slot) {

        return BASE_DURABILITY[slot.getEntitySlotId()] * 16;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 64;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BLOCK_NOTE_BLOCK_DIDGERIDOO;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(SAPPHIRE);
    }

    @Override
    public String getName() {
        return "sapphire";
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
