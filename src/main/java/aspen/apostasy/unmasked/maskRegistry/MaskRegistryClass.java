package aspen.apostasy.unmasked.maskRegistry;

import aspen.apostasy.unmasked.Unmasked;
import aspen.apostasy.unmasked.maskRegistry.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class MaskRegistryClass {

    // Basic Masks

    public static final Item PAPER_MASK = registerItem("paper_mask", PaperMaskItem::new);

    public static final Item BLINDFOLD = registerItem("blindfold", MaskItem::new);

    // Flying Entity Masks

    public static final Item RAVEN_MASK = registerItem("raven_mask", MaskItem::new);

    public static final Item DAMAGE_HARPY_MASK = registerItem("damage_harpy_mask", DamageMaskItem::new);

    public static final Item ALLAY_MASK = registerItem("allay_mask", MaskItem::new);

    // End Masks

    public static final Item ENDERMAN_MASK = registerItem("enderman_mask", EndermanMaskItem::new);

    // Overworld Masks

    public static final Item BUNNY_MASK = registerItem("bunny_mask", MaskItem::new);

    public static final Item ARMADILLO_MASK = registerItem("armadillo_mask", MaskItem::new);

    public static final Item SKELETON_MASK = registerItem("skeleton_mask", BoneMaskItem::new);

    public static final Item INFERNAL_MASK = registerItem("infernal_mask", MaskItem::new);

    public static final Item WARDEN_MASK = registerItem("warden_mask", WardenMaskItem::new);

    public static final Item OMINOUS_TRIAL_MASK = registerItem("ominous_trial_mask", TrialMaskItem::new);

    // External Masks

    public static final Item DEFILE_MASK = registerItem("defile_mask", DefileMaskItem::new);

    public static final Item STAR_MASK = registerItem("star_mask", MaskItem::new);

    public static final Item HELLSPAWN_MASK = registerItem("hellspawn_mask", MaskItem::new);

    public static final Item FENCING_MASK = registerItem("fencing_mask", MaskItem::new);

    public static final Item SPAMTON_MASK = registerItem("spamton_mask", MaskItem::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Unmasked.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Unmasked.MOD_ID, name)))));
    }
    public static void registerMaskItems() {

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAVEN_MASK);
            entries.add(DAMAGE_HARPY_MASK);
            entries.add(ALLAY_MASK);
            entries.add(ENDERMAN_MASK);
            entries.add(DEFILE_MASK);
            entries.add(SPAMTON_MASK);
            entries.add(BUNNY_MASK);
            entries.add(ARMADILLO_MASK);
            entries.add(SKELETON_MASK);
            entries.add(INFERNAL_MASK);
            entries.add(PAPER_MASK);
        });
    }
}