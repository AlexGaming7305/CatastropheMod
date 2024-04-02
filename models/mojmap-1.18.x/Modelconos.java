// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelconos<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "conos"), "main");
	private final ModelPart conos;

	public Modelconos(ModelPart root) {
		this.conos = root.getChild("conos");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition conos = partdefinition.addOrReplaceChild("conos",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-19.0F, -39.0F, -20.0F, 38.0F, 36.0F, 40.0F, new CubeDeformation(0.0F)).texOffs(86, 76)
						.addBox(-23.0F, -42.0F, 1.0F, 20.0F, 19.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(0, 76)
						.addBox(0.0F, -19.0F, -21.0F, 20.0F, 19.0F, 23.0F, new CubeDeformation(0.0F)).texOffs(0, 147)
						.addBox(8.0F, -35.0F, 8.0F, 14.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(116, 0)
						.addBox(8.0F, -12.0F, 8.0F, 14.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(116, 118)
						.addBox(-21.0F, -16.0F, 8.0F, 14.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(58, 118)
						.addBox(-21.0F, -28.0F, -22.0F, 14.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)).texOffs(0, 118)
						.addBox(3.0F, -41.0F, -22.0F, 14.0F, 14.0F, 15.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		conos.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.conos.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.conos.xRot = headPitch / (180F / (float) Math.PI);
	}
}