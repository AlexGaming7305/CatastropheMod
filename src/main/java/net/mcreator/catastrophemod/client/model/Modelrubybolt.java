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

// Made with Blockbench 4.6.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelrubybolt<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("catastrophe_mod", "modelrubybolt"), "main");
	public final ModelPart rubybolt;

	public Modelrubybolt(ModelPart root) {
		this.rubybolt = root.getChild("rubybolt");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition rubybolt = partdefinition.addOrReplaceChild("rubybolt",
				CubeListBuilder.create().texOffs(13, 18).addBox(-1.0F, -1.0F, -6.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(11, 10).addBox(-2.0F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(11, 0)
						.addBox(0.0F, -1.0F, -4.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 10).addBox(-1.0F, -2.0F, -4.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		rubybolt.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.rubybolt.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.rubybolt.xRot = headPitch / (180F / (float) Math.PI);
	}
}
