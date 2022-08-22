package net.openbagtwo.unobtainiumarmor.entity.client.armor;

import net.openbagtwo.unobtainiumarmor.items.MythrilArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class MythrilArmorRenderer extends GeoArmorRenderer<MythrilArmorItem> {
    public MythrilArmorRenderer() {
        super(new MythrilArmorModel());
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
    }

