package net.mcreator.catastrophemod.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.4.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelFire_Wyvern<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("catastrophe_mod", "model_fire_wyvern"), "main");
	public final ModelPart Fire_Wyvern;
	public final ModelPart Right_Wing;
	public final ModelPart Left_Wing;

	public ModelFire_Wyvern(ModelPart root) {
		this.Fire_Wyvern = root.getChild("Fire_Wyvern");
		this.Right_Wing = root.getChild("Right_Wing");
		this.Left_Wing = root.getChild("Left_Wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Fire_Wyvern = partdefinition.addOrReplaceChild("Fire_Wyvern",
				CubeListBuilder.create().texOffs(0, 36).addBox(-3.0F, -15.0F, -14.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(18, 36).addBox(-3.0F, -12.0F, -17.0F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(10, 14)
						.addBox(-3.0F, -13.0F, -17.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 12).addBox(1.0F, -13.0F, -17.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-3.0F, -10.0F, -8.0F, 6.0F, 6.0F, 17.0F, new CubeDeformation(0.0F)).texOffs(29, 5).addBox(1.0F, -3.0F, 2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-1.0F, -10.0F, 9.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(29, 0).addBox(-3.0F, -3.0F, 2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = Fire_Wyvern.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(45, 43).addBox(-3.0F, -9.0F, 1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition cube_r2 = Fire_Wyvern.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(0, 23).addBox(-1.0F, -19.0F, 2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(47, 15).addBox(1.0F, -9.0F, 1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 0.0F, 0.0F));
		PartDefinition cube_r3 = Fire_Wyvern.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(30, 23).addBox(-3.0F, -6.0F, -15.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.0F));
		PartDefinition cube_r4 = Fire_Wyvern.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 4).addBox(1.0F, -8.0F, -18.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 4).addBox(-3.0F, -8.0F, -18.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.829F, 0.0F, 0.0F));
		PartDefinition Right_Wing = partdefinition.addOrReplaceChild("Right_Wing",
				CubeListBuilder.create().texOffs(0, 2).addBox(-7.0F, -1.0F, -5.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(17, 43).addBox(-6.0F, -1.0F, -4.0F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(6, 30)
						.addBox(-2.0F, -1.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 30).addBox(-6.0F, -1.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(45, 44)
						.addBox(-7.0F, -1.0F, -4.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, 16.0F, 0.0F));
		PartDefinition cube_r5 = Right_Wing.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(29, 0).addBox(-9.0F, -9.0F, -16.0F, 8.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(29, 15).addBox(-10.0F, -9.0F, -17.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0F, 8.0F, 0.0F, 0.0F, 0.6545F, 0.0F));
		PartDefinition Left_Wing = partdefinition.addOrReplaceChild("Left_Wing",
				CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -5.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(34, 43).addBox(6.0F, -1.0F, -4.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(35, 35)
						.addBox(0.0F, -1.0F, -4.0F, 6.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(29, 10).addBox(0.0F, -1.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(6, 23)
						.addBox(4.0F, -1.0F, 3.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, 16.0F, 0.0F));
		PartDefinition cube_r6 = Left_Wing.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, -9.0F, -16.0F, 9.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(29, 13).addBox(0.0F, -9.0F, -17.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.0F, 8.0F, 0.0F, 0.0F, -0.6981F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Fire_Wyvern.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Right_Wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Left_Wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Right_Wing.zRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.Left_Wing.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}
