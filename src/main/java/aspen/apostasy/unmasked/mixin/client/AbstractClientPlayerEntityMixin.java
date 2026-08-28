package aspen.apostasy.unmasked.mixin.client;

import aspen.apostasy.unmasked.Unmasked;
import aspen.apostasy.unmasked.components.entity.ImpersonateComponent;
import aspen.apostasy.unmasked.item.MaskItem;
import aspen.apostasy.unmasked.registry.UnmaskedEnchantmentEffects;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerSkinType;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.item.MaceItem;
import net.minecraft.util.AssetInfo;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Optional;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin {

    @ModifyReturnValue(method = "getSkin", at = @At(value = "RETURN"))
    private SkinTextures unmasked$editSkin(SkinTextures original) {
        AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) (Object) this;

        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(player);

        if (component.isPresent()) {
            if (component.get().isEquipped(itemStack -> {
                if (itemStack.getItem() instanceof MaskItem) {
                    if (EnchantmentHelper.hasAnyEnchantmentsWith(itemStack, UnmaskedEnchantmentEffects.IMPERSONATE)) {
                        return ImpersonateComponent.KEY.get(player).isMasked();
                    }
                }
                return false;
            })) {
                return new SkinTextures(
                        new AssetInfo.TextureAsset() {
                            @Override
                            public Identifier texturePath() {
                                return Unmasked.id("textures/entity/impersonate.png");
                            }

                            @Override
                            public Identifier id() {
                                return Unmasked.id("impersonate");
                            }
                        },
                        original.cape(),
                        original.elytra(),
                        PlayerSkinType.SLIM,
                        original.secure()
                );
            }
        }
        return original;
    }
}
