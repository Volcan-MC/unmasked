package aspen.apostasy.unmasked.registry;

import aspen.apostasy.unmasked.Unmasked;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class UnmaskedTags {
    public static final TagKey<Item> MASKS = TagKey.of(RegistryKeys.ITEM, Unmasked.id("masks"));

    public static final TagKey<Enchantment> MOD_ENCHANTMENTS = TagKey.of(RegistryKeys.ENCHANTMENT, Unmasked.id("mod_enchants"));
}
