package net.openbagtwo.unobtainiumarmor.entity.client.armor;

import net.minecraft.util.Identifier;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import net.openbagtwo.unobtainiumarmor.items.MythrilArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MythrilArmorModel extends AnimatedGeoModel<MythrilArmorItem> {

    private String model = "mythril_armor";
    private String texture = "mythril_armor_texture";
    private String ani = "idle";
    @Override
    public Identifier getModelLocation(MythrilArmorItem object) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, String.format("geo/%s.geo.json", this.model));
    }

    @Override
    public Identifier getTextureLocation(MythrilArmorItem object) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, String.format("textures/models/armor/%s.png", this.texture));
    }

    @Override
    public Identifier getAnimationFileLocation(MythrilArmorItem animatable) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, String.format("animations/%s.json", this.ani));
    }

    public MythrilArmorModel(){}

    public MythrilArmorModel setModel(String name){
        this.model = name;
        return this;
    }
    public MythrilArmorModel setTexture(String name){
        this.texture = name;
        return this;
    }
    public MythrilArmorModel setAnimation(String name){
        this.ani = name;
        return this;
    }

    public static final MythrilArmorModel MYTHRIL = new MythrilArmorModel();

}
