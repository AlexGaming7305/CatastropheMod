// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelshadowfire_soul<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "shadowfire_soul"), "main");
	private final ModelPart shadowfire_soul;

	public Modelshadowfire_soul(ModelPart root) {
		this.shadowfire_soul = root.getChild("shadowfire_soul");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition shadowfire_soul = partdefinition
				.addOrReplaceChild("shadowfire_soul",
						CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 6.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r1 = shadowfire_soul
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 6).addBox(0.0F, -4.0F, -2.0F, 0.0F, 6.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = shadowfire_soul
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(8, 6).addBox(0.0F, -4.0F, -2.0F, 0.0F, 6.0F, 4.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		shadowfire_soul.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}