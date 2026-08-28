package aspen.apostasy.unmasked.registry;

import aspen.apostasy.unmasked.Unmasked;
import aspen.apostasy.unmasked.item.MaskItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Pair;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class UnmaskedItems {
    public static final List<Item> MASKS = new ArrayList<>();

    public static final Item PAPER_MASK = createMask("paper_mask", Items.AIR, Items.AIR);
    public static final Item DAMAGE_HARPY_MASK = createMask("damage_harpy_mask", Items.FEATHER, Items.LIME_DYE);
    public static final Item ENDERMAN_MASK = createMask("enderman_mask", Items.ENDER_PEARL, Items.ENDER_PEARL);
    public static final Item SKELETON_MASK = createMask("skeleton_mask", Items.BONE, Items.BONE);
    public static final Item WARDEN_MASK = createMask("warden_mask", Items.SCULK_CATALYST, Items.SCULK);
    public static final Item OMINOUS_TRIAL_MASK = createMask("trial_mask", Items.TRIAL_KEY, Items.BREEZE_ROD);
    public static final Item DEFILE_MASK = createMask("defile_mask", Items.INK_SAC, Items.GUNPOWDER);
    public static final Item RAVEN_MASK = createMask("raven_mask", Items.FEATHER, Items.SOUL_SAND);

    private static Item createMask(String name, ItemConvertible primary, ItemConvertible secondary) {
        Item item = Items.register(
                RegistryKey.of(
                        RegistryKeys.ITEM,
                        Unmasked.id(name)
                ),
                settings -> new MaskItem(
                        settings
                                .maxCount(1)
                                .enchantable(4)
                                .component(UnmaskedComponentTypes.Y_OFFSET, 0),
                        Unmasked.id("textures/entity/trinket/" + name + ".png"),
                        new Pair<>(primary, secondary)
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