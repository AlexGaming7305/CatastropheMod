
package net.mcreator.catastrophemod.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.catastrophemod.entity.model.CharredMantisModel;
import net.mcreator.catastrophemod.entity.layer.CharredMantisLayer;
import net.mcreator.catastrophemod.entity.CharredMantisEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CharredMantisRenderer extends GeoEntityRenderer<CharredMantisEntity> {
	public CharredMantisRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CharredMantisModel());
		this.shadowRadius = 1.4f;
		this.addRenderLayer(new CharredMantisLayer(this));
	}

	@Override
	public RenderType getRenderType(CharredMantisEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, CharredMantisEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(CharredMantisEntity entityLivingBaseIn) {
		return 0.0F;
	}
}