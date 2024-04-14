package net.mcreator.catastrophemod.item.model;

public class FlamestrikeItemModel extends GeoModel<FlamestrikeItem> {
	@Override
	public ResourceLocation getAnimationResource(FlamestrikeItem animatable) {
		return new ResourceLocation("catastrophe_mod", "animations/flamestrike.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlamestrikeItem animatable) {
		return new ResourceLocation("catastrophe_mod", "geo/flamestrike.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlamestrikeItem animatable) {
		return new ResourceLocation("catastrophe_mod", "textures/item/flamestrike.png");
	}
}