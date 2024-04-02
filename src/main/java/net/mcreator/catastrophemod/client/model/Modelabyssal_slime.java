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

// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelabyssal_slime<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("catastrophe_mod", "modelabyssal_slime"), "main");
	public final ModelPart slime;
	public final ModelPart crystals;
	public final ModelPart crystals2;
	public final ModelPart crystals3;
	public final ModelPart crystals4;

	public Modelabyssal_slime(ModelPart root) {
		this.slime = root.getChild("slime");
		this.crystals = root.getChild("crystals");
		this.crystals2 = root.getChild("crystals2");
		this.crystals3 = root.getChild("crystals3");
		this.crystals4 = root.getChild("crystals4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition slime = partdefinition.addOrReplaceChild("slime",
				CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -31.0F, -16.0F, 31.0F, 31.0F, 33.0F, new CubeDeformation(0.0F)).texOffs(36, 92).addBox(-17.0F, -24.0F, -17.0F, 10.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(91, 83)
						.addBox(6.0F, -24.0F, -17.0F, 10.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(95, 0).addBox(-7.0F, -8.0F, -17.0F, 6.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition crystals = partdefinition.addOrReplaceChild("crystals",
				CubeListBuilder.create().texOffs(36, 64).addBox(19.0F, -20.0F, 0.0F, 9.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(74, 96).addBox(19.0F, -27.0F, 3.0F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -6.0F, 15.0F, -0.2418F, 0.7009F, 0.7277F));
		PartDefinition crystals2 = partdefinition.addOrReplaceChild("crystals2",
				CubeListBuilder.create().texOffs(0, 0).addBox(22.0F, -20.0F, -2.0F, 8.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(100, 64).addBox(22.0F, -27.0F, 1.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-30.0F, 19.0F, 18.0F, 0.3054F, 0.6545F, -0.6545F));
		PartDefinition crystals3 = partdefinition.addOrReplaceChild("crystals3",
				CubeListBuilder.create().texOffs(70, 64).addBox(22.0F, -20.0F, 0.0F, 7.0F, 20.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(96, 101).addBox(22.0F, -27.0F, 3.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-12.0F, -2.0F, 20.0F, 0.5451F, 1.0267F, 0.0328F));
		PartDefinition crystals4 = partdefinition.addOrReplaceChild("crystals4",
				CubeListBuilder.create().texOffs(0, 64).addBox(22.0F, -20.0F, -3.0F, 9.0F, 40.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(95, 14).addBox(22.0F, -27.0F, 0.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.0F, 21.0F, 38.0F, -2.094F, 0.8326F, -1.7302F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		slime.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		crystals.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		crystals2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		crystals3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		crystals4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
