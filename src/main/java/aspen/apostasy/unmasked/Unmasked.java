package aspen.apostasy.unmasked;

import aspen.apostasy.unmasked.maskRegistry.MaskRegistryClass;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unmasked implements ModInitializer {
	public static final String MOD_ID = "unmasked";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		MaskRegistryClass.registerMaskItems();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
