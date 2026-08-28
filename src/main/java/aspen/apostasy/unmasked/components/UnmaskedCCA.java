package aspen.apostasy.unmasked.components;

import aspen.apostasy.unmasked.components.entity.ImpersonateComponent;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class UnmaskedCCA implements EntityComponentInitializer {
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(ImpersonateComponent.KEY, ImpersonateComponent::new, RespawnCopyStrategy.NEVER_COPY);
    }
}
