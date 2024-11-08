
package net.mcreator.catastrophemod.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.catastrophemod.entity.model.AccursedWitchModel;
import net.mcreator.catastrophemod.entity.layer.AccursedWitchLayer;
import net.mcreator.catastrophemod.entity.AccursedWitchEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class AccursedWitchRenderer extends GeoEntityRenderer<AccursedWitchEntity> {
	public AccursedWitchRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new AccursedWitchModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new AccursedWitchLayer(this));
	}

	@Override
	public RenderType getRenderType(AccursedWitchEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, AccursedWitchEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
