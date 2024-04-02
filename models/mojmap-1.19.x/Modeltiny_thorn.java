// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modeltiny_thorn<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "tiny_thorn"), "main");
	private final ModelPart tiny_thorn;

	public Modeltiny_thorn(ModelPart root) {
		this.tiny_thorn = root.getChild("tiny_thorn");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tiny_thorn = partdefinition
				.addOrReplaceChild("tiny_thorn",
						CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r1 = tiny_thorn
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 8).addBox(-4.0F, -8.0F, 0.0F, 8.0F, 8.0F, 0.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		tiny_thorn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.tiny_thorn.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.tiny_thorn.xRot = headPitch / (180F / (float) Math.PI);
	}
}