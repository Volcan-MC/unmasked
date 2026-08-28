package aspen.apostasy.unmasked.datagen;

import aspen.apostasy.unmasked.item.MaskItem;
import aspen.apostasy.unmasked.registry.UnmaskedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class UnmaskedRecipeProvider extends FabricRecipeProvider {
    public UnmaskedRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            public void generate() {
                for (Item item : UnmaskedItems.MASKS) {
                    if (item instanceof MaskItem mask) {
                        if (mask != UnmaskedItems.PAPER_MASK) {
                            createShaped(RecipeCategory.TOOLS, mask)
                                    .pattern(" E ")
                                    .pattern("/p/")
                                    .pattern(" D ")
                                    .input('/', Items.STRING)
                                    .input('p', Items.PAPER)
                                    .input('E', mask.getIngredients().getLeft())
                                    .input('D', mask.getIngredients().getRight())
                                    .criterion("has_paper", conditionsFromItem(Items.PAPER))
                                    .offerTo(exporter);
                        } else {
                            createShaped(RecipeCategory.TOOLS, mask)
                                    .pattern("/p/")
                                    .input('/', Items.STRING)
                                    .input('p', Items.PAPER)
                                    .criterion("has_paper", conditionsFromItem(Items.PAPER))
                                    .offerTo(exporter);
                        }
                    }
                }
            }
        };
    }

    public String getName() {
        return "Unmasked Recipes";
    }
}
