// Made with Blockbench 4.6.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelpoisonous_thorn<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "poisonous_thorn"), "main");
	private final ModelPart poisonous_thorn;

	public Modelpoisonous_thorn(ModelPart root) {
		this.poisonous_thorn = root.getChild("poisonous_thorn");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition poisonous_thorn = partdefinition.addOrReplaceChild(
				"poisonous_thorn", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -12.0F, 0.0F, 12.0F, 12.0F,
						0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 16.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r1 = poisonous_thorn
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -12.0F, 0.0F, 12.0F, 12.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		poisonous_thorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.poisonous_thorn.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.poisonous_thorn.xRot = headPitch / (180F / (float) Math.PI);
	}
}