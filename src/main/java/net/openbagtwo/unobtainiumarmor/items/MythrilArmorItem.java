package net.openbagtwo.unobtainiumarmor.items;
import java.util.Collections;
import java.util.List;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class MythrilArmorItem extends EffectArmor implements IAnimatable {

    public MythrilArmorItem(ArmorMaterial material, EquipmentSlot slot, List<StatusEffectInstance> effects) {
        super(material, slot, effects);
    }

    public MythrilArmorItem(ArmorMaterial material, EquipmentSlot slot) {
        super(material, slot, Collections.emptyList());
    }

    private final AnimationFactory factory = new AnimationFactory(this);

    // Predicate runs every frame
    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {

        LivingEntity livingEntity = event.getExtraDataOfType(LivingEntity.class).get(0);

        // Will this need to be adjusted when doing actual animations?
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));

        // If the living entity is an armorstand just play the animation nonstop
        if (livingEntity instanceof ArmorStandEntity) {
            return PlayState.CONTINUE;
        }

        // the example has a section that determines whether the entity is wearing
        // all armor layers, but I really can't tell if it's actually doing anything
        // as everything seems to work fine without it.

        return PlayState.STOP;
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
