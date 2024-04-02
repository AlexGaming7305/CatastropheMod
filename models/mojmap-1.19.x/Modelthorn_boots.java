// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelthorn_boots<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "thorn_boots"), "main");
	private final ModelPart left_shoe;
	private final ModelPart right_shoe;

	public Modelthorn_boots(ModelPart root) {
		this.left_shoe = root.getChild("left_shoe");
		this.right_shoe = root.getChild("right_shoe");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_shoe = partdefinition.addOrReplaceChild("left_shoe", CubeListBuilder.create().texOffs(0, 16)
				.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)),
				PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition cube_r1 = left_shoe.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(32, 12).mirror()
						.addBox(-3.0F, -3.0F, 4.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-4.0F, 8.0F, 4.0F, 1.5708F, 1.1781F, 1.5708F));

		PartDefinition cube_r2 = left_shoe
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, -1.0F, 0.0F, 6.0F, 4.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(2.0F, 7.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition right_shoe = partdefinition.addOrReplaceChild("right_shoe",
				CubeListBuilder.create().texOffs(0, 16).mirror()
						.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition cube_r3 = right_shoe.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(32, 12).mirror()
						.addBox(-3.0F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 8.0F, 4.0F, 1.5708F, 1.1781F, 1.5708F));

		PartDefinition cube_r4 = right_shoe.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(32, 12).mirror()
						.addBox(-4.0F, -1.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-2.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_shoe.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_shoe.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}