package aspen.apostasy.unmasked.components.entity;

import aspen.apostasy.unmasked.Unmasked;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;
import org.ladysnake.cca.api.v3.component.tick.CommonTickingComponent;

public class ImpersonateComponent implements AutoSyncedComponent, CommonTickingComponent {
    public static final ComponentKey<ImpersonateComponent> KEY = ComponentRegistry.getOrCreate(
            Unmasked.id("impersonate"),
            ImpersonateComponent.class
    );
    private final PlayerEntity player;

    private int maskedTicks = 0;

    public ImpersonateComponent(PlayerEntity player) {
        this.player = player;
    }

    public void tick() {
        if (maskedTicks > 0) {
            maskedTicks--;
            if (maskedTicks == 0) {
                sync();
            }
        }
    }

    public void sync() {
        KEY.sync(player);
    }

    public void readData(ReadView readView) {
        maskedTicks = readView.getInt("MaskedTicks", 0);
    }

    public void writeData(WriteView writeView) {
        writeView.putInt("MaskedTicks", maskedTicks);
    }

    public int getMaskedTicks() {
        return maskedTicks;
    }

    public void setMaskedTicks(int maskedTicks) {
        this.maskedTicks = maskedTicks;
        sync();
    }

    public boolean isMasked() {
        return maskedTicks <= 0;
    }
}
