package net.openbagtwo.unobtainiumarmor;

import net.fabricmc.api.ModInitializer;
import net.openbagtwo.unobtainiumarmor.items.RegisterItems;
import net.openbagtwo.unobtainiumarmor.particle.RegisterParticles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnobtainiumArmorMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("unobtainium-armor-mod");


	@Override
	public void onInitialize() {
		RegisterItems.register();
		RegisterParticles.register();
		LOGGER.info("UnobtainiumArmor mod initialized.");
	}
}