package net.openbagtwo.unobtainiumarmor.items;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.openbagtwo.unobtainiumarmor.materials.SlimeMaterial;
import ru.betterend.item.ArmoredElytra;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Arrays;
import java.util.List;

public class MythrilArmorItem extends ArmorItem implements IAnimatable {
    public MythrilArmorItem(EquipmentSlot slot) {
        super(SlimeMaterial.SLIME_MATERIAL, slot, new Item.Settings().group(ItemGroup.COMBAT));
    }

    public static final MythrilArmorItem MYTHRIL_HELMET = new MythrilArmorItem(EquipmentSlot.HEAD);
    public static final MythrilArmorItem MYTHRIL_CHESTPLATE = new MythrilArmorItem(EquipmentSlot.CHEST);
    public static final MythrilArmorItem MYTHRIL_LEGGINGS = new MythrilArmorItem(EquipmentSlot.LEGS);
    public static final MythrilArmorItem MYTHRIL_BOOTS = new MythrilArmorItem(EquipmentSlot.FEET);
    public static final ArmorItem MYTHRIL_ELYTRA = new ArmoredElytra(
            "mythril_elytra",
            SlimeMaterial.SLIME_MATERIAL,
            Items.SLIME_BALL,
            MYTHRIL_CHESTPLATE.getMaxDamage(),
            0.8,
            false
    );

    private final AnimationFactory factory = new AnimationFactory(this);

    // Predicate runs every frame
    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        // This is all the extradata this event carries. The livingentity is the entity
        // that's wearing the armor. The itemstack and equipmentslottype are self
        // explanatory.
        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);

        // Always loop the animation but later on in this method we'll decide whether or
        // not to actually play it
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));

        // If the living entity is an armorstand just play the animation nonstop
        if (livingEntity instanceof ArmorStandEntity) {
            return PlayState.CONTINUE;
        }

        List<Item> armorList = Arrays.asList(
                MYTHRIL_BOOTS,
                MYTHRIL_HELMET,
                MYTHRIL_LEGGINGS,
                MYTHRIL_CHESTPLATE,
                MYTHRIL_ELYTRA
        );

        // this block appears to do absolutely nothing
        boolean isWearingAll = true;
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                if (livingEntity.getEquippedStack(slot) == null){
                    isWearingAll = false;
                    break;
                }
                Item equipped_item = livingEntity.getEquippedStack(slot).getItem();
                if (!armorList.contains(equipped_item)){
                    isWearingAll = false;
                    break;
                }
            }
        }

        return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
    }

    // All you need to do here is add your animation controllers to the
    // AnimationData
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}
