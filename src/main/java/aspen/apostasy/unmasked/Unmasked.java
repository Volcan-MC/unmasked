package aspen.apostasy.unmasked;

import aspen.apostasy.unmasked.EnchantmentRegistry.EnchantmentEffectRegistry;
import aspen.apostasy.unmasked.maskRegistry.MaskRegistryClass;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unmasked implements ModInitializer {
	public static final String MOD_ID = "unmasked";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		MaskRegistryClass.registerMaskItems();
		EnchantmentEffectRegistry.registerEnchantmentEffects();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
