// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelLava_Brute<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "lava_brute"), "main");
	private final ModelPart Lava_Brute;
	private final ModelPart Right_Arm;
	private final ModelPart Left_Arm;
	private final ModelPart Right_Leg;
	private final ModelPart left_Leg;
	private final ModelPart Head;

	public ModelLava_Brute(ModelPart root) {
		this.Lava_Brute = root.getChild("Lava_Brute");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Left_Arm = root.getChild("Left_Arm");
		this.Right_Leg = root.getChild("Right_Leg");
		this.left_Leg = root.getChild("left_Leg");
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Lava_Brute = partdefinition.addOrReplaceChild("Lava_Brute",
				CubeListBuilder.create().texOffs(37, 34)
						.addBox(-6.0F, -23.0F, -2.0F, 12.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-8.0F, -32.0F, -4.0F, 16.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Right_Arm = partdefinition.addOrReplaceChild("Right_Arm",
				CubeListBuilder.create().texOffs(28, 48)
						.addBox(-6.0F, 4.0F, -2.0F, 6.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(42, 18)
						.addBox(-7.0F, -5.0F, -3.0F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-8.0F, -3.0F, 0.0F));

		PartDefinition Left_Arm = partdefinition.addOrReplaceChild("Left_Arm",
				CubeListBuilder.create().texOffs(50, 48)
						.addBox(0.0F, 4.0F, -2.0F, 6.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 39)
						.addBox(0.0F, -5.0F, -3.0F, 7.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, -3.0F, 0.0F));

		PartDefinition Right_Leg = partdefinition.addOrReplaceChild("Right_Leg", CubeListBuilder.create().texOffs(63, 0)
				.addBox(-3.0F, 0.0F, -2.0F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, 10.0F, 0.0F));

		PartDefinition left_Leg = partdefinition.addOrReplaceChild("left_Leg", CubeListBuilder.create().texOffs(0, 55)
				.addBox(-2.0F, 0.0F, -2.0F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 10.0F, 0.0F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 18)
				.addBox(-5.0F, -10.0F, -6.0F, 10.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -8.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Lava_Brute.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.Right_Leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.Right_Arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_Leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Left_Arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}