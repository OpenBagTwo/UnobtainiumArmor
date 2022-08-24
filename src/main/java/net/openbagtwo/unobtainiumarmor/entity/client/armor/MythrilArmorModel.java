package net.openbagtwo.unobtainiumarmor.entity.client.armor;

import net.minecraft.util.Identifier;
import net.openbagtwo.unobtainiumarmor.UnobtainiumArmorMod;
import net.openbagtwo.unobtainiumarmor.items.MythrilArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MythrilArmorModel extends AnimatedGeoModel<MythrilArmorItem> {

    private String _model = "mythril_armor";
    private String _texture = "mythril_armor_texture";
    private String _ani = "idle";
    @Override
    public Identifier getModelLocation(MythrilArmorItem object) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, String.format("geo/%s.geo.json", this._model));
    }

    @Override
    public Identifier getTextureLocation(MythrilArmorItem object) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, String.format("textures/models/armor/%s.png", this._texture));
    }

    @Override
    public Identifier getAnimationFileLocation(MythrilArmorItem animatable) {
        return new Identifier(UnobtainiumArmorMod.MOD_ID, String.format("animations/%s.json", this._ani));
    }

    private MythrilArmorModel(){}

    public MythrilArmorModel setModel(String name){
        this._model = name;
        return this;
    }
    public MythrilArmorModel setTexture(String name){
        this._texture = name;
        return this;
    }
    public MythrilArmorModel setAnimation(String name){
        this._ani = name;
        return this;
    }

    public static MythrilArmorModel MYTHRIL = new MythrilArmorModel();

}
