package net.openbagtwo.unobtainiumarmor.items;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.openbagtwo.unobtainiumarmor.materials.CitrineMaterial;
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

public class CythrilArmorItem extends ArmorItem implements IAnimatable {
    public CythrilArmorItem(EquipmentSlot slot) {
        super(CitrineMaterial.CITRINE_MATERIAL, slot, new Settings().group(ItemGroup.COMBAT));
    }

    public static final CythrilArmorItem CYTHRIL_HELMET = new CythrilArmorItem(EquipmentSlot.HEAD);
    public static final CythrilArmorItem CYTHRIL_CHESTPLATE = new CythrilArmorItem(EquipmentSlot.CHEST);
    public static final CythrilArmorItem CYTHRIL_LEGGINGS = new CythrilArmorItem(EquipmentSlot.LEGS);
    public static final CythrilArmorItem CYTHRIL_BOOTS = new CythrilArmorItem(EquipmentSlot.FEET);
    public static final ArmorItem CYTHRIL_ELYTRA = new ArmoredElytra(
            "citrine_elytra",
            CitrineMaterial.CITRINE_MATERIAL,
            CitrineMaterial.CITRINE,
            CYTHRIL_CHESTPLATE.getMaxDamage(),
            0.97,
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
                CYTHRIL_HELMET,
                CYTHRIL_CHESTPLATE,
                CYTHRIL_LEGGINGS,
                CYTHRIL_BOOTS,
                CYTHRIL_ELYTRA
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
