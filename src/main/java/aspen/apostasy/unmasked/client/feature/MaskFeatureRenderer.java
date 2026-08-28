package aspen.apostasy.unmasked.client.feature;

import aspen.apostasy.unmasked.client.model.MaskModel;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;

public class MaskFeatureRenderer extends FeatureRenderer<BipedEntityRenderState, MaskModel> {
    public MaskFeatureRenderer(FeatureRendererContext<BipedEntityRenderState, MaskModel> context) {
        super(context);
    }

    public void render(MatrixStack matrices, OrderedRenderCommandQueue queue, int light, BipedEntityRenderState state, float limbAngle, float limbDistance) {
        // insert render method from MaskItem.java
        // note that this isn't wired onto the player model yet, i'll do it when i get home
    }
}
