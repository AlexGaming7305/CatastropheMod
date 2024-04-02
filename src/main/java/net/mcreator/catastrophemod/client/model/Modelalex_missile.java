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

// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelalex_missile<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("catastrophe_mod", "modelalex_missile"), "main");
	public final ModelPart alex_missile;

	public Modelalex_missile(ModelPart root) {
		this.alex_missile = root.getChild("alex_missile");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition alex_missile = partdefinition.addOrReplaceChild("alex_missile",
				CubeListBuilder.create().texOffs(27, 44).addBox(-1.0F, -7.0F, -11.0F, 2.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(0, 23).addBox(-1.0F, -9.0F, -5.0F, 2.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, -5.0F, -5.0F, 2.0F, 2.0F, 21.0F, new CubeDeformation(0.0F)).texOffs(25, 23).addBox(-3.0F, -7.0F, -5.0F, 2.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(25, 0)
						.addBox(1.0F, -7.0F, -5.0F, 2.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		alex_missile.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.alex_missile.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.alex_missile.xRot = headPitch / (180F / (float) Math.PI);
	}
}
