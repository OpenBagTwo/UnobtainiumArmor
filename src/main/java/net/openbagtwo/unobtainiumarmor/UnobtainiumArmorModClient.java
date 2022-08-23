package net.openbagtwo.unobtainiumarmor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.SpitParticle;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.openbagtwo.unobtainiumarmor.entity.client.armor.CythrilArmorRenderer;
import net.openbagtwo.unobtainiumarmor.entity.client.armor.MythrilArmorRenderer;
import net.openbagtwo.unobtainiumarmor.particle.RegisterParticles;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import static net.openbagtwo.unobtainiumarmor.items.CythrilArmorItem.*;
import static net.openbagtwo.unobtainiumarmor.items.MythrilArmorItem.*;

public class UnobtainiumArmorModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(UnobtainiumArmorMod.MOD_ID, "particle/f_ray"));
        }));

        ParticleFactoryRegistry.getInstance().register(RegisterParticles.F_RAY, SpitParticle.Factory::new);

        GeoArmorRenderer.registerArmorRenderer(
                new MythrilArmorRenderer(),
                MYTHRIL_HELMET,
                MYTHRIL_CHESTPLATE,
                MYTHRIL_LEGGINGS,
                MYTHRIL_BOOTS
        );
        GeoArmorRenderer.registerArmorRenderer(
                new CythrilArmorRenderer(),
                CYTHRIL_HELMET,
                CYTHRIL_CHESTPLATE,
                CYTHRIL_LEGGINGS,
                CYTHRIL_BOOTS
        );
    }
}
