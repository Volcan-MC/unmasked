package aspen.apostasy.unmasked.registry;

import aspen.apostasy.unmasked.Unmasked;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class UnmaskedComponentTypes {
    public static final ComponentType<Integer> Y_OFFSET = create("y_offset", Codec.INT, PacketCodecs.INTEGER);

    private static <T> ComponentType<T> create(String name, Codec<T> codec, PacketCodec<ByteBuf, T> packetCodec) {
        ComponentType<T> component = ComponentType.<T>builder()
                .codec(codec)
                .packetCodec(packetCodec)
                .build();
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Unmasked.id(name), component);
    }

    public static void init() {}
}
