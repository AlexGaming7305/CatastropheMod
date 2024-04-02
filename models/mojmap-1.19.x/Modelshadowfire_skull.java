// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelshadowfire_skull<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "shadowfire_skull"), "main");
	private final ModelPart shadowfire_skull;

	public Modelshadowfire_skull(ModelPart root) {
		this.shadowfire_skull = root.getChild("shadowfire_skull");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition shadowfire_skull = partdefinition.addOrReplaceChild("shadowfire_skull", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-6.0F, -8.0F, -23.0F, 12.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(44, 17).addBox(-4.0F, 2.0F, -23.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(44, 0)
				.addBox(2.0F, 2.0F, -21.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 51)
				.addBox(-4.0F, 2.0F, -21.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(48, 23).mirror()
				.addBox(-10.0F, -5.0F, -20.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(48, 31).addBox(6.0F, -5.0F, -20.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(32, 34).addBox(10.0F, -11.0F, -20.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(32, 20).mirror().addBox(-14.0F, -11.0F, -20.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
				.mirror(false), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		PartDefinition cube_r1 = shadowfire_skull.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -5.0F, -3.0F, 0.0F, 10.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r2 = shadowfire_skull.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -5.0F, -3.0F, 0.0F, 10.0F, 16.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r3 = shadowfire_skull.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 40)
						.addBox(-4.0F, -2.0F, -3.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(18, 41)
						.addBox(2.0F, -2.0F, -3.0F, 2.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(44, 11)
						.addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 8.0F, -18.0F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		shadowfire_skull.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}