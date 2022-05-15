package net.openbagtwo.unobtainiumarmor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.openbagtwo.unobtainiumarmor.items.RegisterItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnobtainiumArmorMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("unobtainium-armor-mod");

	public static final DefaultParticleType F_RAY = FabricParticleTypes.simple(false);
	@Override
	public void onInitialize() {
		Registry.register(Registry.PARTICLE_TYPE, new Identifier("unobtainiumarmor", "f_ray"), F_RAY);
		RegisterItems.register();
		LOGGER.info("UnobtainiumArmor mod initialized.");
	}
}