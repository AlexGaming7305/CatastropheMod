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
public class ModelDestroyer_Head<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("catastrophe_mod", "model_destroyer_head"), "main");
	public final ModelPart Destroyer_Head;

	public ModelDestroyer_Head(ModelPart root) {
		this.Destroyer_Head = root.getChild("Destroyer_Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Destroyer_Head = partdefinition.addOrReplaceChild("Destroyer_Head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-21.0F, -39.0F, -21.0F, 42.0F, 39.0F, 42.0F, new CubeDeformation(0.0F)).texOffs(139, 52).addBox(-19.0F, -27.0F, -50.0F, 2.0F, 17.0F, 29.0F, new CubeDeformation(0.0F)).texOffs(50, 93)
						.addBox(-22.0F, -21.0F, -44.0F, 3.0F, 11.0F, 44.0F, new CubeDeformation(0.0F)).texOffs(0, 81).addBox(19.0F, -22.0F, -44.0F, 3.0F, 12.0F, 44.0F, new CubeDeformation(0.0F)).texOffs(20, 81)
						.addBox(-17.0F, -27.0F, -38.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(15, 17).addBox(-14.0F, -27.0F, -60.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(9.0F, -27.0F, -60.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 81).addBox(12.0F, -27.0F, -38.0F, 5.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 137)
						.addBox(17.0F, -27.0F, -50.0F, 2.0F, 17.0F, 29.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition cube_r1 = Destroyer_Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(100, 81).addBox(32.0F, -27.0F, -69.0F, 2.0F, 17.0F, 29.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));
		PartDefinition cube_r2 = Destroyer_Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(115, 127).addBox(-36.0F, -27.0F, -68.0F, 2.0F, 17.0F, 29.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Destroyer_Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Destroyer_Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Destroyer_Head.xRot = headPitch / (180F / (float) Math.PI);
	}
}
