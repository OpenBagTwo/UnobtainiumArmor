package net.openbagtwo.unobtainiumarmor.entity.client.armor;

import net.openbagtwo.unobtainiumarmor.items.CythrilArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class CythrilArmorRenderer extends GeoArmorRenderer<CythrilArmorItem> {
    public CythrilArmorRenderer() {
        super(new CythrilArmorModel());
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

