package net.mcreator.catastrophemod.client.model;

import net.minecraft.world.entity.Entity;
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

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelark_needle_projectile_again<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("catastrophe_mod", "modelark_needle_projectile_again"), "main");
	public final ModelPart arkneedleprojectileagain;

	public Modelark_needle_projectile_again(ModelPart root) {
		this.arkneedleprojectileagain = root.getChild("arkneedleprojectileagain");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition arkneedleprojectileagain = partdefinition.addOrReplaceChild("arkneedleprojectileagain",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, -11.0F, 1.0F, 1.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(0, 2).addBox(-2.0F, -6.0F, 10.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-2.0F, -6.0F, 12.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(4, 4).addBox(0.0F, -6.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -6.0F, 11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(36, 17).addBox(-1.0F, -7.0F, -7.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(18, 23)
						.addBox(-1.0F, -5.0F, -7.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(23, 0).addBox(-2.0F, -6.0F, -7.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 22)
						.addBox(0.0F, -6.0F, -7.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		arkneedleprojectileagain.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.arkneedleprojectileagain.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.arkneedleprojectileagain.xRot = headPitch / (180F / (float) Math.PI);
	}
}
