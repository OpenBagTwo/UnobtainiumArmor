package net.openbagtwo.unobtainiumarmor.entity.client.armor;

import net.minecraft.util.Identifier;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import net.openbagtwo.unobtainiumarmor.items.CythrilArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CythrilArmorModel extends AnimatedGeoModel<CythrilArmorItem> {
    @Override
    public Identifier getModelLocation(CythrilArmorItem object) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, "geo/mythril_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CythrilArmorItem object) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, "textures/models/armor/cythril_armor_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CythrilArmorItem animatable) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, "animations/idle.json");
    }
}
