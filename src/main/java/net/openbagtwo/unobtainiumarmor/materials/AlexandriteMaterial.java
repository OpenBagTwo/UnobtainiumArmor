package net.openbagtwo.unobtainiumarmor.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import nourl.mythicmetals.item.MythicItems;

import static net.openbagtwo.unobtainiumarmor.items.Alexandrite.ALEXANDRITE;

public class AlexandriteMaterial implements ArmorMaterial {
    // Just kind of whatevering this
    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {1, 2, 2, 1};

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
        return 36;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BLOCK_NOTE_BLOCK_HARP;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ALEXANDRITE);
    }

    @Override
    public String getName() {
        return "alexandrite";
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
