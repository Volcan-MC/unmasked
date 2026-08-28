package aspen.apostasy.unmasked;

import aspen.apostasy.unmasked.registry.UnmaskedComponentTypes;
import aspen.apostasy.unmasked.registry.UnmaskedEnchantmentEffects;
import aspen.apostasy.unmasked.registry.UnmaskedItems;
import aspen.apostasy.unmasked.util.LootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unmasked implements ModInitializer {
	public static final String MOD_ID = "unmasked";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		UnmaskedEnchantmentEffects.init();
		UnmaskedComponentTypes.init();
		UnmaskedItems.init();

		LootTableEvents.MODIFY.register(new LootTableModifiers());

		LOGGER.info("Unmasked Init Complete !!!!!!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}

	// @author AcoYT
	// Imported from AcornLib 1.0.5+1.21.11
	public static String formatString(String text) {
		if (text == null || text.isEmpty()) return text;

		StringBuilder builder = new StringBuilder();

		boolean formatNext = false;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.toCharArray()[i];
			if (i == 0) {
				ch = Character.toUpperCase(ch);
			} else if (ch == '_' || ch == '/' || ch == '.') {
				ch = ' ';
				formatNext = true;
			} else if (formatNext) {
				ch = Character.toUpperCase(ch);
				formatNext = false;
			}

			builder.append(ch);
		}

		return builder.toString();
	}
}
