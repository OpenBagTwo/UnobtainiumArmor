package net.openbagtwo.unobtainiumarmor.entity.client.armor;

import net.minecraft.util.Identifier;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import net.openbagtwo.unobtainiumarmor.items.MythrilArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MythrilArmorModel extends AnimatedGeoModel<MythrilArmorItem> {
    @Override
    public Identifier getModelLocation(MythrilArmorItem object) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, "geo/mythril_armor.geo.json");
    }

    @Override
    public Identifier getTextureLocation(MythrilArmorItem object) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, "textures/models/armor/mythril_armor_texture.png");
    }

    @Override
    public Identifier getAnimationFileLocation(MythrilArmorItem animatable) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, "animations/idle.json");
    }
}
