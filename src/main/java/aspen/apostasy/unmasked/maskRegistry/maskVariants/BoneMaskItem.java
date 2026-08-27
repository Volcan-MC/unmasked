package aspen.apostasy.unmasked.maskRegistry.maskVariants;

import aspen.apostasy.unmasked.Unmasked;
import aspen.apostasy.unmasked.client.MaskModel;

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
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class BoneMaskItem extends TrinketItem implements TrinketRenderer {

    private static final Identifier TEXTURE = Identifier.of(Unmasked.MOD_ID, "textures/entity/trinket/bone.png");
    private BipedEntityModel<BipedEntityRenderState> model;

    public BoneMaskItem(Settings settings) {
        super(settings);
    }



    @Override
    @Environment(EnvType.CLIENT)
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntityRenderState> contextModel, MatrixStack matrices, OrderedRenderCommandQueue queue, int light, LivingEntityRenderState state, float limbAngle, float limbDistance) {
        if (state instanceof BipedEntityRenderState bipedEntityRenderState) {
            BipedEntityModel<BipedEntityRenderState> model = this.getModel();
            model.setAngles(bipedEntityRenderState);
            TrinketRenderer.followBodyRotations(contextModel, model);
            queue.submitModel(model, bipedEntityRenderState, matrices, model.getLayer(TEXTURE), light, OverlayTexture.packUv(OverlayTexture.getU(0), OverlayTexture.getV(false)), -1, null, state.outlineColor, null);
        }
    }

    @Environment(EnvType.CLIENT)
    private BipedEntityModel<BipedEntityRenderState> getModel() {
        if (this.model == null) {
            this.model = new MaskModel(MaskModel.getTexturedModelData().createModel());
        }

        return this.model;
    }
}