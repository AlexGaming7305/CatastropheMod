
package net.mcreator.catastrophemod.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.catastrophemod.entity.model.ElectrifiedSwordProjectileModel;
import net.mcreator.catastrophemod.entity.layer.ElectrifiedSwordProjectileLayer;
import net.mcreator.catastrophemod.entity.ElectrifiedSwordProjectileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ElectrifiedSwordProjectileRenderer extends GeoEntityRenderer<ElectrifiedSwordProjectileEntity> {
	public ElectrifiedSwordProjectileRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ElectrifiedSwordProjectileModel());
		this.shadowRadius = 0.5f;
		this.addRenderLayer(new ElectrifiedSwordProjectileLayer(this));
	}

	@Override
	public RenderType getRenderType(ElectrifiedSwordProjectileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, ElectrifiedSwordProjectileEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
