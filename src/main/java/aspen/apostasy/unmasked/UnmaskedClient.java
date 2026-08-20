package aspen.apostasy.unmasked;

import aspen.apostasy.unmasked.maskRegistry.MaskRegistryClass;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;

public class UnmaskedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        TrinketRendererRegistry.registerRenderer(MaskRegistryClass.RAVEN_MASK, (TrinketRenderer) MaskRegistryClass.RAVEN_MASK);
        TrinketRendererRegistry.registerRenderer(MaskRegistryClass.DAMAGE_HARPY_MASK, (TrinketRenderer) MaskRegistryClass.DAMAGE_HARPY_MASK);
        TrinketRendererRegistry.registerRenderer(MaskRegistryClass.PAPER_MASK, (TrinketRenderer) MaskRegistryClass.PAPER_MASK);
        TrinketRendererRegistry.registerRenderer(MaskRegistryClass.WARDEN_MASK, (TrinketRenderer) MaskRegistryClass.WARDEN_MASK);
        TrinketRendererRegistry.registerRenderer(MaskRegistryClass.ENDERMAN_MASK, (TrinketRenderer) MaskRegistryClass.ENDERMAN_MASK);
        TrinketRendererRegistry.registerRenderer(MaskRegistryClass.SKELETON_MASK, (TrinketRenderer) MaskRegistryClass.SKELETON_MASK);
        TrinketRendererRegistry.registerRenderer(MaskRegistryClass.OMINOUS_TRIAL_MASK, (TrinketRenderer) MaskRegistryClass.OMINOUS_TRIAL_MASK);
        TrinketRendererRegistry.registerRenderer(MaskRegistryClass.DEFILE_MASK, (TrinketRenderer) MaskRegistryClass.DEFILE_MASK);
    }
}