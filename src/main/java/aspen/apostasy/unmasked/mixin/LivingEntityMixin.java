package aspen.apostasy.unmasked.mixin;

import aspen.apostasy.unmasked.EnchantmentRegistry.EnchantmentRegistry;
import aspen.apostasy.unmasked.maskRegistry.MaskRegistryClass;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class LivingEntityMixin {

    @Inject(
            method = "shouldRenderName",
            at = @At("HEAD"),
            cancellable = true
    )
    private void unmasked$hideName(CallbackInfoReturnable<Boolean> cir) {

        PlayerEntity player = (PlayerEntity) (Object) this;

        var component = TrinketsApi.getTrinketComponent(player);

        if (component.isEmpty()) {
            return;
        }

        boolean wearingMask = component.get().isEquipped(stack ->
                (stack.isOf(MaskRegistryClass.RAVEN_MASK)
                        || stack.isOf(MaskRegistryClass.PAPER_MASK)
                        || stack.isOf(MaskRegistryClass.BLINDFOLD)
                        || stack.isOf(MaskRegistryClass.ARMADILLO_MASK)
                        || stack.isOf(MaskRegistryClass.DAMAGE_HARPY_MASK)
                        || stack.isOf(MaskRegistryClass.ALLAY_MASK)
                        || stack.isOf(MaskRegistryClass.ENDERMAN_MASK)
                        || stack.isOf(MaskRegistryClass.BUNNY_MASK)
                        || stack.isOf(MaskRegistryClass.SKELETON_MASK)
                        || stack.isOf(MaskRegistryClass.INFERNAL_MASK)
                        || stack.isOf(MaskRegistryClass.DEFILE_MASK)
                        || stack.isOf(MaskRegistryClass.SPAMTON_MASK)
                        || stack.isOf(MaskRegistryClass.FENCING_MASK)
                        || stack.isOf(MaskRegistryClass.WARDEN_MASK)
                        || stack.isOf(MaskRegistryClass.HELLSPAWN_MASK)
                        || stack.isOf(MaskRegistryClass.STAR_MASK)
                        || stack.isOf(MaskRegistryClass.OMINOUS_TRIAL_MASK))
                        && stack.getEnchantments().getEnchantments().stream()
                        .anyMatch(enchantmentEntry ->
                                enchantmentEntry.getKey()
                                        .map(key -> key.equals(EnchantmentRegistry.VEIL))
                                        .orElse(false)
                        )
        );

        if (wearingMask) {
            cir.setReturnValue(false);
        }
    }
}

// Unmasked to-do's: add command to re-enable nametag when a mask is worn, add mask renderer, balance masks (make enchant dependant)
// no idea how these enchantments will be acquired tho