package aspen.apostasy.unmasked.registry;

import aspen.apostasy.unmasked.Unmasked;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Unit;

public class UnmaskedEnchantmentEffects {
    public static final ComponentType<Unit> SHROUD = create("shroud");
    public static final ComponentType<Unit> IMPERSONATE = create("impersonate");

    private static ComponentType<Unit> create(String name) {
        ComponentType<Unit> unit = ComponentType.<Unit>builder()
                .codec(Unit.CODEC)
                .packetCodec(Unit.PACKET_CODEC)
                .build();
        return Registry.register(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE, Unmasked.id(name), unit);
    }

    public static void init() {}
}
