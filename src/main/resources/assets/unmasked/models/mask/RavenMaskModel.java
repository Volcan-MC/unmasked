// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class CustomModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custommodel"), "main");
	private final ModelPart MaskModel;

	public CustomModel(ModelPart root) {
		this.MaskModel = root.getChild("MaskModel");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition MaskModel = partdefinition.addOrReplaceChild("MaskModel", CubeListBuilder.create().texOffs(0, 23).addBox(-5.0F, -20.0F, -5.0F, 0.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(5.0F, -20.0F, -5.0F, 0.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition cube_r1 = MaskModel.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -0.5F, -5.0F, 0.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.5F, 5.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition cube_r2 = MaskModel.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -3.5F, -8.0F, 0.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.5F, -5.0F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		MaskModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}