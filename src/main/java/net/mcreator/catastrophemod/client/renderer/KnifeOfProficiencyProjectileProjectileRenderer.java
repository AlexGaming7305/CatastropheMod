package net.mcreator.catastrophemod.client.renderer;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.catastrophemod.entity.KnifeOfProficiencyProjectileProjectileEntity;
import net.mcreator.catastrophemod.client.model.Modelknife_of_proficiency;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class KnifeOfProficiencyProjectileProjectileRenderer extends EntityRenderer<KnifeOfProficiencyProjectileProjectileEntity> {
	private static final ResourceLocation texture = new ResourceLocation("catastrophe_mod:textures/entities/knife_of_proficiency.png");
	private final Modelknife_of_proficiency model;

	public KnifeOfProficiencyProjectileProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelknife_of_proficiency(context.bakeLayer(Modelknife_of_proficiency.LAYER_LOCATION));
	}

	@Override
	public void render(KnifeOfProficiencyProjectileProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(KnifeOfProficiencyProjectileProjectileEntity entity) {
		return texture;
	}
}
