// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelArmageddon_Robot<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "armageddon_robot"), "main");
	private final ModelPart Armageddon_Robot;
	private final ModelPart Head;
	private final ModelPart Right_Arm;
	private final ModelPart Left_Arm;
	private final ModelPart Right_Leg;
	private final ModelPart Left_Leg;

	public ModelArmageddon_Robot(ModelPart root) {
		this.Armageddon_Robot = root.getChild("Armageddon_Robot");
		this.Head = root.getChild("Head");
		this.Right_Arm = root.getChild("Right_Arm");
		this.Left_Arm = root.getChild("Left_Arm");
		this.Right_Leg = root.getChild("Right_Leg");
		this.Left_Leg = root.getChild("Left_Leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Armageddon_Robot = partdefinition.addOrReplaceChild("Armageddon_Robot",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-12.0F, -70.0F, -2.0F, 24.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(92, 128)
						.addBox(-12.0F, -70.0F, -6.0F, 10.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 128)
						.addBox(2.0F, -70.0F, -6.0F, 10.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(54, 62)
						.addBox(-8.0F, -60.0F, -2.0F, 16.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 32)
						.addBox(-10.0F, -50.0F, -4.0F, 20.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(68, 0)
						.addBox(-8.0F, -48.0F, -2.0F, 16.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(136, 58)
						.addBox(-4.0F, -74.0F, 0.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = Armageddon_Robot.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 48).addBox(-56.0F, -26.0F, 8.0F, 32.0F, 10.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r2 = Armageddon_Robot.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(72, 14)
						.addBox(-32.0F, -44.0F, 8.0F, 22.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(120, 128)
						.addBox(-10.0F, -72.0F, 8.0F, 10.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 20)
						.addBox(-20.0F, -36.0F, 8.0F, 34.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(68, 44)
						.addBox(-10.0F, -58.0F, 8.0F, 22.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(54, 32)
						.addBox(20.0F, -30.0F, 8.0F, 32.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -26.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition cube_r3 = Armageddon_Robot.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(52, 82)
						.addBox(0.0F, -38.0F, 8.0F, 22.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(128, 94)
						.addBox(-10.0F, -68.0F, 8.0F, 10.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
						.addBox(-20.0F, -30.0F, 8.0F, 30.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(36, 94)
						.addBox(-20.0F, -54.0F, 8.0F, 20.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 0.829F));

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(58, 0)
						.addBox(-4.0F, -8.0F, -8.0F, 8.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(106, 64)
						.addBox(-6.0F, -10.0F, -2.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(112, 80)
						.addBox(-6.0F, -10.0F, -6.0F, 12.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(26, 74)
						.addBox(-6.0F, -12.0F, -2.0F, 4.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(0, 72)
						.addBox(2.0F, -12.0F, -2.0F, 4.0F, 2.0F, 18.0F, new CubeDeformation(0.0F)).texOffs(128, 12)
						.addBox(-2.0F, -12.0F, -2.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(136, 110)
						.addBox(-6.0F, -10.0F, 4.0F, 12.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(72, 24)
						.addBox(-6.0F, -10.0F, 6.0F, 12.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -50.0F, 3.0F));

		PartDefinition Right_Arm = partdefinition.addOrReplaceChild("Right_Arm",
				CubeListBuilder.create().texOffs(0, 92)
						.addBox(-6.0F, -6.0F, -6.0F, 6.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 142)
						.addBox(-6.0F, 4.0F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(104, 104)
						.addBox(-8.0F, 22.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 114)
						.addBox(-10.0F, -2.0F, -6.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-12.0F, -42.0F, 2.0F));

		PartDefinition Left_Arm = partdefinition.addOrReplaceChild("Left_Arm",
				CubeListBuilder.create().texOffs(88, 82)
						.addBox(0.0F, -6.0F, -6.0F, 6.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(108, 12)
						.addBox(6.0F, -2.0F, -6.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(140, 140)
						.addBox(2.0F, 4.0F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(72, 104)
						.addBox(0.0F, 22.0F, -4.0F, 8.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offset(12.0F, -42.0F, 2.0F));

		PartDefinition Right_Leg = partdefinition.addOrReplaceChild("Right_Leg",
				CubeListBuilder.create().texOffs(48, 124)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 28.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(106, 46)
						.addBox(-4.0F, 28.0F, -5.0F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(122, 30)
						.addBox(-4.0F, 36.0F, -5.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(132, 42)
						.addBox(-4.0F, 40.0F, -5.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(5.0F, -20.0F, 3.0F));

		PartDefinition Left_Leg = partdefinition.addOrReplaceChild("Left_Leg",
				CubeListBuilder.create().texOffs(32, 124)
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 28.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(26, 106)
						.addBox(-4.0F, 28.0F, -5.0F, 8.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(120, 0)
						.addBox(-4.0F, 36.0F, -5.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 132)
						.addBox(-4.0F, 40.0F, -5.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-5.0F, -20.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Armageddon_Robot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.Right_Leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.Right_Arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Left_Leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Left_Arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}