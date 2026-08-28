package aspen.apostasy.unmasked.mixin.compat.enchancement;

import aspen.apostasy.unmasked.registry.UnmaskedItems;
import moriyashiine.enchancement.common.screenhandler.EnchantingTableScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(EnchantingTableScreenHandler.class)
public abstract class EnchantingTableScreenHandlerMixin {
    @Shadow @Final public static Map<Item, EnchantingTableScreenHandler.EnchantingMaterial> ENCHANTING_MATERIAL_MAP;

    @Inject(method = "<init>(ILnet/minecraft/entity/player/PlayerInventory;)V", at = @At(value = "TAIL"))
    private void unmasked$addMasks(int syncId, PlayerInventory playerInventory, CallbackInfo ci) {
        for (Item item : UnmaskedItems.MASKS) {
            ENCHANTING_MATERIAL_MAP.put(item, new EnchantingTableScreenHandler.EnchantingMaterial(Ingredient.ofItem(
                    Items.PAPER
            )));
        }
    }
}