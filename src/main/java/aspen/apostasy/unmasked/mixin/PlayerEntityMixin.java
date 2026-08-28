package aspen.apostasy.unmasked.mixin;

import aspen.apostasy.unmasked.components.entity.ImpersonateComponent;
import aspen.apostasy.unmasked.item.MaskItem;
import aspen.apostasy.unmasked.registry.UnmaskedEnchantmentEffects;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(
            method = "shouldRenderName",
            at = @At("HEAD"),
            cancellable = true
    )
    private void unmasked$hideName(CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(player);

        if (component.isEmpty()) {
            return;
        }

        boolean maskHidesName = component.get().isEquipped(stack -> stack.getItem() instanceof MaskItem && EnchantmentHelper.hasAnyEnchantmentsWith(stack, UnmaskedEnchantmentEffects.SHROUD));

        if (maskHidesName) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "damage", at = @At(value = "HEAD"))
    private void unmasked$impersonateDispell(ServerWorld world, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        Entity entity = source.getAttacker();

        if (entity instanceof LivingEntity) {
            ImpersonateComponent component = ImpersonateComponent.KEY.get(player);

            if (component.isMasked()) {
                component.setMaskedTicks((15 * 20));

                world.spawnParticles(
                        ParticleTypes.LARGE_SMOKE,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        15,
                        0.5F,
                        1.5F,
                        0.5F,
                        0
                );
            }
        }
    }
}

// Unmasked to-do's: add command to re-enable nametag when a mask is worn, add mask renderer, balance masks (make enchant dependant)
// no idea how these enchantments will be acquired tho