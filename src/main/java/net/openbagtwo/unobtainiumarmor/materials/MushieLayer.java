package net.openbagtwo.unobtainiumarmor.materials;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;

public class MushieLayer implements ArmorMaterial {

    public static final Item GOOMBA_COIN_COIN = new Item(new FabricItemSettings().group(ItemGroup.MISC));
    public static final MushieLayer GOOMBA_LAYER = new MushieLayer();
    public static final SoundEvent MUSHIE_EQUIP_SOUND = registerEquipSound("goomba_armor_equip");

    public static SoundEvent registerEquipSound(String sound_name) {
        Identifier sound_id = new Identifier(UnobtainiumArmorMod.MOD_ID, sound_name);
        return Registry.register(Registry.SOUND_EVENT, sound_id, new SoundEvent(sound_id));
    }

    private static final int[] BASE_DURABILITY = new int[] {13, 15, 16, 11};
    private static final int[] PROTECTION_VALUES = new int[] {3, 6, 8, 3};

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
        return 34;
    }

    @Override
    public SoundEvent getEquipSound() {
        return MUSHIE_EQUIP_SOUND;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(GOOMBA_COIN_COIN);
    }

    @Override
    public String getName() {
        return "goomba";
    }

    @Override
    public float getToughness() {
        return 1.5F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.4F;
    }
}
