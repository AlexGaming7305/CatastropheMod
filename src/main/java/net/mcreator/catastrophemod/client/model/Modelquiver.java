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

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelquiver<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("catastrophe_mod", "modelquiver"), "main");
	public final ModelPart quiver;

	public Modelquiver(ModelPart root) {
		this.quiver = root.getChild("quiver");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition quiver = partdefinition.addOrReplaceChild("quiver", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition part = quiver.addOrReplaceChild("part", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, -6.0F, -1.5F, 4.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 3.5F, 0.0F, 0.0F, 0.3927F));
		PartDefinition arrow1 = part.addOrReplaceChild("arrow1", CubeListBuilder.create().texOffs(14, 16).addBox(-2.5F, -4.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.0F, -7.0F, 0.5F, 0.0F, 0.2182F, 0.2182F));
		PartDefinition cube_r1 = arrow1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(9, 27).addBox(-2.5F, -2.0F, -2.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r2 = arrow1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(14, 16).addBox(-2.5F, -6.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition arrow2 = part.addOrReplaceChild("arrow2", CubeListBuilder.create().texOffs(14, 16).addBox(-2.5F, -4.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, -7.0F, -0.5F, 0.0F, -0.2182F, -0.2182F));
		PartDefinition cube_r3 = arrow2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(9, 27).addBox(-2.5F, -2.0F, -2.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.5F, -1.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition cube_r4 = arrow2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 16).addBox(-2.5F, -6.0F, 0.0F, 5.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		quiver.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
