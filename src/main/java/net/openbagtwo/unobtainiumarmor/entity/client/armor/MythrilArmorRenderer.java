package net.openbagtwo.unobtainiumarmor.entity.client.armor;

import net.openbagtwo.unobtainiumarmor.items.MythrilArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MythrilArmorRenderer extends GeoArmorRenderer<MythrilArmorItem> {
    public MythrilArmorRenderer(MythrilArmorModel armorModel) {
        super(armorModel);
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }

    public static final MythrilArmorRenderer MYTHRIL = new MythrilArmorRenderer(MythrilArmorModel.MYTHRIL);

    public static MythrilArmorRenderer createMythrilRenderer(MythrilArmorModel armorModel){
        return new MythrilArmorRenderer(armorModel);
    }

    public static MythrilArmorRenderer createMythrilRenderer(String name){
        MythrilArmorModel armorModel = new MythrilArmorModel().setTexture(name + "_armor_texture");
        return createMythrilRenderer(armorModel);
    }
}

