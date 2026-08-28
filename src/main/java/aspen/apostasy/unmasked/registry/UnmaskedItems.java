package aspen.apostasy.unmasked.registry;

import aspen.apostasy.unmasked.Unmasked;
import aspen.apostasy.unmasked.item.MaskItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class UnmaskedItems {
    public static final List<Item> MASKS = new ArrayList<>();

    public static final Item PAPER_MASK = createMask("paper_mask");
    public static final Item DAMAGE_HARPY_MASK = createMask("damage_harpy_mask");
    public static final Item ENDERMAN_MASK = createMask("enderman_mask");
    public static final Item SKELETON_MASK = createMask("skeleton_mask");
    public static final Item WARDEN_MASK = createMask("warden_mask");
    public static final Item OMINOUS_TRIAL_MASK = createMask("trial_mask");
    public static final Item DEFILE_MASK = createMask("defile_mask");
    public static final Item RAVEN_MASK = createMask("raven_mask");

    private static Item createMask(String name) {
        Item item = Items.register(
                RegistryKey.of(
                        RegistryKeys.ITEM,
                        Unmasked.id(name)
                ),
                settings -> new MaskItem(
                        settings
                                .maxCount(1)
                                .enchantable(4),
                        Unmasked.id("textures/entity/trinket/" + name + ".png")
                )
        );
        MASKS.add(item);
        return item;
    }

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            for (Item item : MASKS) {
                entries.add(item);
            }
        });
    }
}