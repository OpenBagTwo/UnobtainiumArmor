package net.openbagtwo.unobtainiumarmor.materials;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class CitrineMaterial implements ArmorMaterial {

    public static final Item CITRINE = new Item(new FabricItemSettings().group(ItemGroup.MATERIALS));
    public static final CitrineMaterial CITRINE_MATERIAL = new CitrineMaterial();

    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {1, 2, 2, 1};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * 18;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 8;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.BLOCK_BEACON_POWER_SELECT;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(CITRINE);
    }

    @Override
    public String getName() {
        return "citrine";
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
