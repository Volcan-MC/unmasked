package aspen.apostasy.unmasked.datagen;

import aspen.apostasy.unmasked.Unmasked;
import aspen.apostasy.unmasked.registry.UnmaskedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class UnmaskedLanguageProvider extends FabricLanguageProvider {
    public UnmaskedLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        for (Item item : UnmaskedItems.MASKS) {
            translationBuilder.add(item, Unmasked.formatString(Registries.ITEM.getId(item).getPath()));
        }

        translationBuilder.add("enchantment.unmasked.shroud", "Shroud");
        translationBuilder.add("enchantment.unmasked.shroud.desc", "Will mask the user's display name.");

        translationBuilder.add("enchantment.unmasked.impersonate", "Impersonate");
        translationBuilder.add("enchantment.unmasked.impersonate.desc", "Will disguise the user's skin into that of a concealed figure, though the illusion is broken if the user takes damage.");

        translationBuilder.add("advancements.unmasked.masquerade.title", "A Complete Masquerade");
        translationBuilder.add("advancements.unmasked.masquerade.desc", "A million faces, but do you see yourself in a single one of them?");
    }

    public String getName() {
        return "Unmasked Language";
    }
}
