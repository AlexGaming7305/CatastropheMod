// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelghost_phantom<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "ghost_phantom"), "main");
	private final ModelPart ghost_phantom;

	public Modelghost_phantom(ModelPart root) {
		this.ghost_phantom = root.getChild("ghost_phantom");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ghost_phantom = partdefinition.addOrReplaceChild("ghost_phantom", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.0F, 7.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition body = ghost_phantom.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 8).addBox(
				-3.0F, -2.0F, -8.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -1.0F, 4.0F));

		PartDefinition head = ghost_phantom.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
				.addBox(-4.0F, -2.25F, -5.0F, 7.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.5F, -0.75F, -4.0F));

		PartDefinition left_wing = ghost_phantom.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(23, 12)
				.addBox(0.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.5F, -3.0F, -4.0F));

		PartDefinition left_wing_tip = ghost_phantom.addOrReplaceChild("left_wing_tip", CubeListBuilder.create()
				.texOffs(16, 24).addBox(0.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.5F, -3.0F, -4.0F));

		PartDefinition right_wing = ghost_phantom.addOrReplaceChild("right_wing",
				CubeListBuilder.create().texOffs(23, 12).mirror()
						.addBox(-6.0F, 0.0F, 0.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-2.5F, -3.0F, -4.0F));

		PartDefinition right_wing_tip = ghost_phantom.addOrReplaceChild("right_wing_tip",
				CubeListBuilder.create().texOffs(16, 24).mirror()
						.addBox(-13.0F, 0.0F, 0.0F, 13.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-8.5F, -3.0F, -4.0F));

		PartDefinition tail = ghost_phantom.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(3, 20).addBox(
				-2.0F, 0.0F, 0.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -3.0F, 5.0F));

		PartDefinition tail2 = ghost_phantom.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(4, 29).addBox(
				-1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -2.5F, 11.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		ghost_phantom.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.ghost_phantom.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.ghost_phantom.xRot = headPitch / (180F / (float) Math.PI);
	}
}