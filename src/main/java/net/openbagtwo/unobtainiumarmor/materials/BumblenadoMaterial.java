package net.openbagtwo.unobtainiumarmor.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import static net.openbagtwo.unobtainiumarmor.items.Bumblenado.BUMBLENADO_GEM;

public class BumblenadoMaterial implements ArmorMaterial {
    // Adapting from MoreGems' Gilded Carbonado
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {3, 6, 8, 3};

    @Override
    public int getDurability(EquipmentSlot slot) {

        return BASE_DURABILITY[slot.getEntitySlotId()] * 33;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ENTITY_BEE_LOOP_AGGRESSIVE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(BUMBLENADO_GEM);
    }

    @Override
    public String getName() {
        return "bumblenado";
    }

    @Override
    public float getToughness() {
        return 0.75F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.25F;
    }
}
