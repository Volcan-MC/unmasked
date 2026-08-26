package aspen.apostasy.unmasked.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;

@Environment(EnvType.CLIENT)
public class MaskModel extends BipedEntityModel<BipedEntityRenderState> {

    public MaskModel(ModelPart root) {
        super(root);
        this.setVisible(false);
        this.head.visible = true;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0.0F);

        ModelPartData root = modelData.getRoot();
        ModelPartData head = root.getChild("head");

        ModelPartData maskModel = head.addChild(
                "MaskModel",
                ModelPartBuilder.create()
                        .uv(0, 23)
                        .cuboid(
                                -5.0F,
                                -20.0F,
                                -5.0F,
                                0.0F,
                                1.0F,
                                10.0F
                        )

                        .uv(0, 23)
                        .cuboid(
                                5.0F,
                                -20.0F,
                                -5.0F,
                                0.0F,
                                1.0F,
                                10.0F
                        ),

                ModelTransform.origin(
                        0.0F,
                        16.0F,
                        0.0F
                )
        );

        maskModel.addChild(
                "cube_r1",

                ModelPartBuilder.create()
                        .uv(0, 23)
                        .cuboid(
                                0.0F,
                                -0.5F,
                                -5.0F,
                                0.0F,
                                1.0F,
                                10.0F
                        ),

                ModelTransform.of(
                        0.0F,
                        -19.5F,
                        5.0F,
                        0.0F,
                        -1.5708F,
                        0.0F
                )
        );

        maskModel.addChild(
                "cube_r2",

                ModelPartBuilder.create()
                        .uv(0, 0)
                        .cuboid(
                                0.0F,
                                -3.5F,
                                -8.0F,
                                0.0F,
                                7.0F,
                                16.0F
                        ),

                ModelTransform.of(
                        0.0F,
                        -19.5F,
                        -5.0F,
                        0.0F,
                        1.5708F,
                        0.0F
                )
        );

        return TexturedModelData.of(modelData, 64, 64);
    }
}
