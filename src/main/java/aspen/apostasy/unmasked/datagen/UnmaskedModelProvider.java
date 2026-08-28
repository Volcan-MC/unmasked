package aspen.apostasy.unmasked.datagen;

import aspen.apostasy.unmasked.registry.UnmaskedItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class UnmaskedModelProvider extends FabricModelProvider {
    public UnmaskedModelProvider(FabricDataOutput output) {
        super(output);
    }

    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {}

    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        UnmaskedItems.MASKS.forEach(item -> itemModelGenerator.register(item, Models.GENERATED));
    }

    public String getName() {
        return "Unmasked Models";
    }
}
