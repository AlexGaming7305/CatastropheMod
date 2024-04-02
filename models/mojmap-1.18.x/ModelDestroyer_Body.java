// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelDestroyer_Body<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "destroyer_body"), "main");
	private final ModelPart Destroyer_Body;

	public ModelDestroyer_Body(ModelPart root) {
		this.Destroyer_Body = root.getChild("Destroyer_Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Destroyer_Body = partdefinition.addOrReplaceChild("Destroyer_Body", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-19.0F, -37.0F, -19.0F, 37.0F, 37.0F, 38.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Destroyer_Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Destroyer_Body.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Destroyer_Body.xRot = headPitch / (180F / (float) Math.PI);
	}
}