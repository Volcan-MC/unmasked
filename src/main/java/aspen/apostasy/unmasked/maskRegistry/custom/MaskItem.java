package aspen.apostasy.unmasked.maskRegistry.custom;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipData;

import java.util.Optional;

public class MaskItem extends TrinketItem {

    public MaskItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        return super.getTooltipData(stack);
    }
}