package aspen.apostasy.unmasked;

import aspen.apostasy.unmasked.datagen.*;
import aspen.apostasy.unmasked.registry.UnmaskedEnchantments;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class UnmaskedDataGenerator implements DataGeneratorEntrypoint {
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(UnmaskedDynamicRegistryProvider::new);

		pack.addProvider(UnmaskedItemTagProvider::new);
		pack.addProvider(UnmaskedEnchantmentTagProvider::new);

		pack.addProvider(UnmaskedModelProvider::new);
		pack.addProvider(UnmaskedLanguageProvider::new);
	}

	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, UnmaskedEnchantments::bootstrap);
	}
}
