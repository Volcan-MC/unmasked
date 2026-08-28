package aspen.apostasy.unmasked.datagen;

import aspen.apostasy.unmasked.registry.UnmaskedItems;
import aspen.apostasy.unmasked.registry.UnmaskedTags;
import dev.emi.trinkets.TrinketsMain;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class UnmaskedItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public UnmaskedItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup registries) {
        for (Item item : UnmaskedItems.MASKS) {
            this.valueLookupBuilder(TagKey.of(RegistryKeys.ITEM, Identifier.of(TrinketsMain.MOD_ID, "head/face")))
                    .add(item)
                    .setReplace(false);

            this.valueLookupBuilder(UnmaskedTags.MASKS)
                    .add(item)
                    .setReplace(false);
        }
    }

    @Override
    public String getName() {
        return "Unmasked Item Tags";
    }
}
