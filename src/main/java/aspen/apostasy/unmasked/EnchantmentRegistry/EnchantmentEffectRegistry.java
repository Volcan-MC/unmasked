package aspen.apostasy.unmasked.EnchantmentRegistry;

import aspen.apostasy.unmasked.EnchantmentRegistry.custom.Veil;
import aspen.apostasy.unmasked.Unmasked;
import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EnchantmentEffectRegistry {
    public static final MapCodec<? extends EnchantmentEntityEffect> VEIL =
            registerEntityEffect("veil_enchantment", Veil.CODEC);


    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Unmasked.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
    }
}
