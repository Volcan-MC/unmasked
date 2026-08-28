package aspen.apostasy.unmasked.registry;

import aspen.apostasy.unmasked.Unmasked;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

public class UnmaskedTags {
    public static final TagKey<Item> MASKS = TagKey.of(RegistryKeys.ITEM, Unmasked.id("masks"));
}
