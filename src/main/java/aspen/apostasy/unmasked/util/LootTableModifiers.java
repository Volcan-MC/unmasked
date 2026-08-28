package aspen.apostasy.unmasked.util;

import aspen.apostasy.unmasked.registry.UnmaskedTags;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

public class LootTableModifiers implements LootTableEvents.Modify {
    public void modifyLootTable(RegistryKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, RegistryWrapper.WrapperLookup registries) {
        if (key == LootTables.TRIAL_CHAMBERS_REWARD_CHEST) { // temp, enchants are obtained from trail chambers
            RegistryEntryLookup<Enchantment> entryLookup = registries.getOrThrow(RegistryKeys.ENCHANTMENT);

            LootPool.Builder builder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(0.5F))
                    .with(ItemEntry.builder(Items.ENCHANTED_BOOK)
                            .weight(10)
                            .apply(new EnchantRandomlyLootFunction.Builder()
                                    .options(entryLookup.getOrThrow(UnmaskedTags.MOD_ENCHANTMENTS)
                                    )
                            )
                    );

            tableBuilder.pool(builder);
        }
    }
}
