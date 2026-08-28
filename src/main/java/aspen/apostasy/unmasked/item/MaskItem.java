package aspen.apostasy.unmasked.item;

import aspen.apostasy.unmasked.client.model.MaskModel;
import aspen.apostasy.unmasked.registry.UnmaskedComponentTypes;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import org.jspecify.annotations.Nullable;

import java.util.function.Consumer;

public class MaskItem extends TrinketItem implements TrinketRenderer {
    private BipedEntityModel<BipedEntityRenderState> model;

    private final Identifier texture;
    private final Pair<ItemConvertible, ItemConvertible> ingredients;

    public MaskItem(Settings settings, Identifier texture, Pair<ItemConvertible, ItemConvertible> ingredients) {
        super(settings);
        this.texture = texture;
        this.ingredients = ingredients;
    }

    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        int offset = stack.getOrDefault(UnmaskedComponentTypes.Y_OFFSET, 0);

        if (clickType == ClickType.RIGHT) {
            if (offset < 4) {
                stack.set(UnmaskedComponentTypes.Y_OFFSET, offset + 1);
            } else {
                stack.set(UnmaskedComponentTypes.Y_OFFSET, -2);
            }
            return true;
        }

        return false;
    }

    public static void createTooltip(ItemStack instance, Item.TooltipContext context, TooltipDisplayComponent displayComponent, @Nullable PlayerEntity player, TooltipType type, Consumer<Text> textConsumer) {
        if (instance.getItem() instanceof MaskItem) {
            int yO = instance.getOrDefault(UnmaskedComponentTypes.Y_OFFSET, 0);

            textConsumer.accept(Text.literal("Y-Offset: " + yO).formatted(Formatting.GRAY));
        }
    }

    @Environment(EnvType.CLIENT)
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntityRenderState> contextModel, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, LivingEntityRenderState state, float limbAngle, float limbDistance) {
        if (state instanceof BipedEntityRenderState bipedEntityRenderState) {
            matrices.push();
            matrices.translate(0, -(float) stack.getOrDefault(UnmaskedComponentTypes.Y_OFFSET, 0) / 10, 0);

            BipedEntityModel<BipedEntityRenderState> model = this.getModel();
            model.setAngles(bipedEntityRenderState);

            TrinketRenderer.followBodyRotations(contextModel, model);

            queue.submitModel(
                    model,
                    bipedEntityRenderState,
                    matrices,
                    model.getLayer(getTexture()),
                    light,
                    OverlayTexture.packUv(OverlayTexture.getU(0), OverlayTexture.getV(false)),
                    -1,
                    null,
                    state.outlineColor,
                    null
            );
            matrices.pop();
        }
    }

    @Environment(EnvType.CLIENT)
    private BipedEntityModel<BipedEntityRenderState> getModel() {
        if (this.model == null) {
            this.model = new MaskModel(MaskModel.getTexturedModelData().createModel());
        }

        return this.model;
    }

    public Pair<ItemConvertible, ItemConvertible> getIngredients() {
        return ingredients;
    }

    public Identifier getTexture() {
        return texture;
    }
}
