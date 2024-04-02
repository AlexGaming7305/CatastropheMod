// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelicicle<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "icicle"), "main");
	private final ModelPart icicle;

	public Modelicicle(ModelPart root) {
		this.icicle = root.getChild("icicle");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition icicle = partdefinition.addOrReplaceChild("icicle",
				CubeListBuilder.create().texOffs(15, 3)
						.addBox(-2.0F, -6.0F, -5.0F, 1.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(7, 23)
						.addBox(-2.0F, -4.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(7, 0)
						.addBox(-3.0F, -7.0F, 8.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(2, 0)
						.addBox(-4.0F, -6.0F, 8.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.0F, -6.0F, 8.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(0, 22)
						.addBox(-2.0F, -7.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(21, 20)
						.addBox(-2.0F, -3.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(14, 19)
						.addBox(-4.0F, -5.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(15, 6)
						.addBox(-3.0F, -6.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(15, 0)
						.addBox(-1.0F, -6.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
						.addBox(-1.0F, -4.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.0F, -4.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 16)
						.addBox(-2.0F, -5.0F, -10.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(7, 17)
						.addBox(0.0F, -5.0F, 3.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 16.0F, -4.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r1 = icicle
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -3.0F, -5.0F, 1.0F, 3.0F, 13.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		icicle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.icicle.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.icicle.xRot = headPitch / (180F / (float) Math.PI);
	}
}