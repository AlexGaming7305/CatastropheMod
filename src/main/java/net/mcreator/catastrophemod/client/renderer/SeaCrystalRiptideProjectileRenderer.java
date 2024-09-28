
package net.mcreator.catastrophemod.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.catastrophemod.entity.model.SeaCrystalRiptideProjectileModel;
import net.mcreator.catastrophemod.entity.layer.SeaCrystalRiptideProjectileLayer;
import net.mcreator.catastrophemod.entity.SeaCrystalRiptideProjectileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SeaCrystalRiptideProjectileRenderer extends GeoEntityRenderer<SeaCrystalRiptideProjectileEntity> {
	public SeaCrystalRiptideProjectileRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SeaCrystalRiptideProjectileModel());
		this.shadowRadius = 0f;
		this.addRenderLayer(new SeaCrystalRiptideProjectileLayer(this));
	}

	@Override
	public RenderType getRenderType(SeaCrystalRiptideProjectileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, SeaCrystalRiptideProjectileEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
