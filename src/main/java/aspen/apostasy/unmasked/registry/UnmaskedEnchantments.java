package aspen.apostasy.unmasked.registry;

import aspen.apostasy.unmasked.Unmasked;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Unit;

/**
 * SHROUD -
 * Hides name tag, unless having taken damage, then name tag is exposed for a bit
 *
 * GUISE -
 * Hides skin maybe
 */
public class UnmaskedEnchantments {
    public static final RegistryKey<Enchantment> SHROUD = create("shroud");
    public static final RegistryKey<Enchantment> IMPERSONATE = create("impersonate");

    private static RegistryKey<Enchantment> create(String name) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Unmasked.id(name));
    }

    public static void bootstrap(Registerable<Enchantment> registerable) {
        RegistryEntryLookup<Item> ITEM = registerable.getRegistryLookup(RegistryKeys.ITEM);

        registerable.register(SHROUD, Enchantment.builder(Enchantment.definition(
                                ITEM.getOrThrow(UnmaskedTags.MASKS),
                                4,
                                1,
                                Enchantment.leveledCost(5, 0),
                                Enchantment.leveledCost(12, 0),
                                4,
                                AttributeModifierSlot.MAINHAND
                        ))
                        .addNonListEffect(UnmaskedEnchantmentEffects.SHROUD, Unit.INSTANCE)
                        .build(SHROUD.getValue())
        );

        registerable.register(IMPERSONATE, Enchantment.builder(Enchantment.definition(
                                ITEM.getOrThrow(UnmaskedTags.MASKS),
                                4,
                                1,
                                Enchantment.leveledCost(5, 0),
                                Enchantment.leveledCost(12, 0),
                                4,
                                AttributeModifierSlot.MAINHAND
                        ))
                        .addNonListEffect(UnmaskedEnchantmentEffects.IMPERSONATE, Unit.INSTANCE)
                        .build(IMPERSONATE.getValue())
        );
    }
}
