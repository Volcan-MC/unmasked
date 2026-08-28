package aspen.apostasy.unmasked.datagen;

import aspen.apostasy.unmasked.registry.UnmaskedEnchantments;
import aspen.apostasy.unmasked.registry.UnmaskedTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EnchantmentTags;

import java.util.concurrent.CompletableFuture;

public class UnmaskedEnchantmentTagProvider extends FabricTagProvider<Enchantment> {
    public UnmaskedEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ENCHANTMENT, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup registries) {
        this.getTagBuilder(EnchantmentTags.NON_TREASURE)
                .add(UnmaskedEnchantments.SHROUD.getValue())
                .add(UnmaskedEnchantments.IMPERSONATE.getValue());

        this.getTagBuilder(UnmaskedTags.MOD_ENCHANTMENTS)
                .add(UnmaskedEnchantments.SHROUD.getValue())
                .add(UnmaskedEnchantments.IMPERSONATE.getValue());
    }

    public String getName() {
        return "Unmasked Enchantment Tags";
    }
}
