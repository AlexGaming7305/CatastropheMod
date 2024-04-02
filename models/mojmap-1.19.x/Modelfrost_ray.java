// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelfrost_ray<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "frost_ray"), "main");
	private final ModelPart frost_ray;

	public Modelfrost_ray(ModelPart root) {
		this.frost_ray = root.getChild("frost_ray");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition frost_ray = partdefinition.addOrReplaceChild("frost_ray", CubeListBuilder.create()
				.texOffs(-146, -146).addBox(-1.0F, -5.0F, -161.0F, 0.0F, 5.0F, 162.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = frost_ray
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(-146, -146).addBox(2.5F, -3.5F, -161.0F, 0.0F, 5.0F, 162.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		frost_ray.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.frost_ray.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.frost_ray.xRot = headPitch / (180F / (float) Math.PI);
	}
}