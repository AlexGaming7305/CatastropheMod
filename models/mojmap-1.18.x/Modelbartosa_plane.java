// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbartosa_plane<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bartosa_plane"), "main");
	private final ModelPart bartosaplane;
	private final ModelPart propeler;

	public Modelbartosa_plane(ModelPart root) {
		this.bartosaplane = root.getChild("bartosaplane");
		this.propeler = root.getChild("propeler");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bartosaplane = partdefinition.addOrReplaceChild("bartosaplane",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-8.0F, -3.0F, -24.0F, 16.0F, 2.0F, 42.0F, new CubeDeformation(0.0F)).texOffs(128, 39)
						.addBox(-8.0F, -5.0F, -13.0F, 16.0F, 2.0F, 20.0F, new CubeDeformation(0.0F)).texOffs(0, 86)
						.addBox(-8.0F, -21.0F, 4.0F, 16.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(125, 0)
						.addBox(-8.0F, -1.0F, -15.0F, 16.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(0, 86)
						.addBox(-10.0F, -18.0F, -24.0F, 2.0F, 15.0F, 42.0F, new CubeDeformation(0.0F)).texOffs(0, 65)
						.addBox(-53.0F, -12.0F, -14.0F, 43.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(88, 101)
						.addBox(-22.0F, -10.0F, -21.0F, 12.0F, 12.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(74, 0)
						.addBox(10.0F, -10.0F, -21.0F, 12.0F, 12.0F, 27.0F, new CubeDeformation(0.0F)).texOffs(0, 44)
						.addBox(10.0F, -12.0F, -14.0F, 43.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(82, 44)
						.addBox(8.0F, -18.0F, -24.0F, 2.0F, 15.0F, 42.0F, new CubeDeformation(0.0F)).texOffs(46, 101)
						.addBox(-10.0F, -18.0F, 18.0F, 20.0F, 15.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(142, 140)
						.addBox(-10.0F, -21.0F, 15.0F, 20.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(128, 61)
						.addBox(-10.0F, -18.0F, 32.0F, 20.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(74, 140)
						.addBox(10.0F, -18.0F, 32.0F, 20.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(139, 101)
						.addBox(-30.0F, -18.0F, 32.0F, 20.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-8.0F, -18.0F, -29.0F, 16.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bartosaplane
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(0, 20).addBox(-8.0F, -27.0F, -12.0F, 16.0F, 15.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r2 = bartosaplane
				.addOrReplaceChild("cube_r2",
						CubeListBuilder.create().texOffs(74, 0).addBox(-1.0F, -48.0F, 22.0F, 2.0F, 15.0F, 11.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition propeler = partdefinition.addOrReplaceChild("propeler",
				CubeListBuilder.create().texOffs(0, 44)
						.addBox(-1.0F, -11.0F, -36.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 65)
						.addBox(-1.0F, -17.0F, -36.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(46, 86)
						.addBox(-7.0F, -11.0F, -36.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bartosaplane.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		propeler.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.bartosaplane.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.bartosaplane.xRot = headPitch / (180F / (float) Math.PI);
		this.propeler.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.propeler.xRot = headPitch / (180F / (float) Math.PI);
	}
}