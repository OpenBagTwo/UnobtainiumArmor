package net.openbagtwo.unobtainiumarmor.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterParticles {

    public static final DefaultParticleType F_RAY = FabricParticleTypes.simple(false);

    public static void register() {
        // Registry.register(Registry.PARTICLE_TYPE, new Identifier(UnobtainiumArmorMod.MOD_ID, "f_ray"), F_RAY);
    }
}
