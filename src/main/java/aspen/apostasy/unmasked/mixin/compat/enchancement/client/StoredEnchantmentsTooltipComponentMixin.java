package aspen.apostasy.unmasked.mixin.compat.enchancement.client;

import aspen.apostasy.unmasked.Unmasked;
import aspen.apostasy.unmasked.registry.UnmaskedItems;
import moriyashiine.enchancement.client.gui.tooltip.StoredEnchantmentsTooltipComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(StoredEnchantmentsTooltipComponent.class)
public abstract class StoredEnchantmentsTooltipComponentMixin {
    @Shadow @Final private static Map<ItemStack, Identifier> TEXTURE_MAP;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void dingus$addIcon(CallbackInfo ci) {
        Map<ItemStack, Identifier> map = TEXTURE_MAP;

        for (Item item : UnmaskedItems.MASKS) {
            map.put(item.getDefaultStack(), Unmasked.id("container/slot/mask"));
        }
    }
}