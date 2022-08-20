package net.openbagtwo.unobtainiumarmor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.SpitParticle;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.openbagtwo.unobtainiumarmor.particle.RegisterParticles;

public class UnobtainiumArmorModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> {
            registry.register(new Identifier(UnobtainiumArmorMod.MOD_ID, "particle/f_ray"));
        }));

        ParticleFactoryRegistry.getInstance().register(RegisterParticles.F_RAY, SpitParticle.Factory::new);
    }
}
