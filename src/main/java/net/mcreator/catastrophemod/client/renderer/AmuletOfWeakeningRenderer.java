package net.mcreator.catastrophemod.client.renderer;

public class AmuletOfWeakeningRenderer implements ICurioRenderer {

	private static final ResourceLocation TEXTURE = new ResourceLocation("catastrophe_mod", "textures/entities/amulet_of_weakening_texture.png");

	private final Modelamulet_of_weakening model;

	public AmuletOfWeakeningRenderer() {
		this.model = new Modelamulet_of_weakening(Minecraft.getInstance().getEntityModels().bakeLayer(CatastropheModModLayerDefinitions.AMULET_OF_WEAKENING));
	}

	@Override
	public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack matrixStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource renderTypeBuffer, int light, float limbSwing,
			float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		LivingEntity entity = slotContext.entity();
		ICurioRenderer.translateIfSneaking(matrixStack, entity);
		ICurioRenderer.rotateIfSneaking(matrixStack, entity);
		this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
		this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(renderTypeBuffer, RenderType.armorCutoutNoCull(TEXTURE), false, stack.hasFoil());
		this.model.renderToBuffer(matrixStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	}

}