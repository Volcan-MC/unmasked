package aspen.apostasy.unmasked.datagen;

import aspen.apostasy.unmasked.Unmasked;
import aspen.apostasy.unmasked.registry.UnmaskedItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

@SuppressWarnings({"removal"})
public class UnmaskedAdvancementProvider extends FabricAdvancementProvider {
    public UnmaskedAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    public void generateAdvancement(RegistryWrapper.WrapperLookup registryLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry masquerade = Advancement.Builder.createUntelemetered()
                .parent(Identifier.ofVanilla("adventure/root"))
                .display(
                        UnmaskedItems.PAPER_MASK,
                        Text.translatable("advancements.unmasked.masquerade.title"),
                        Text.translatable("advancements.unmasked.masquerade.desc"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                ).requirements(AdvancementRequirements.allOf(List.of("e")))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .criterion("e", InventoryChangedCriterion.Conditions.items(
                        UnmaskedItems.DAMAGE_HARPY_MASK,
                        UnmaskedItems.DEFILE_MASK,
                        UnmaskedItems.ENDERMAN_MASK,
                        UnmaskedItems.OMINOUS_TRIAL_MASK,
                        UnmaskedItems.PAPER_MASK,
                        UnmaskedItems.RAVEN_MASK,
                        UnmaskedItems.SKELETON_MASK,
                        UnmaskedItems.WARDEN_MASK
                ))
                .build(Unmasked.id("masquerade"));

        consumer.accept(masquerade);
    }

    public String getName() {
        return "Unmasked Advancements";
    }
}
