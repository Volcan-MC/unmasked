package aspen.apostasy.unmasked;

import aspen.apostasy.unmasked.registry.UnmaskedItems;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.item.Item;

public class UnmaskedClient implements ClientModInitializer {
    public void onInitializeClient() {
        for (Item item : UnmaskedItems.MASKS) {
            TrinketRendererRegistry.registerRenderer(item, (TrinketRenderer) item);
        }
    }
}