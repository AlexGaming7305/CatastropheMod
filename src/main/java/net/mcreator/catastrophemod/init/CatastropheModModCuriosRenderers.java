package net.mcreator.catastrophemod.init;

import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

import net.mcreator.catastrophemod.client.renderer.TatteredQuiverRenderer;
import net.mcreator.catastrophemod.client.renderer.QuiverRenderer;
import net.mcreator.catastrophemod.client.model.Modelquiver;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatastropheModModCuriosRenderers {
	@SubscribeEvent
	public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(CatastropheModModLayerDefinitions.QUIVER, Modelquiver::createBodyLayer);
		evt.registerLayerDefinition(CatastropheModModLayerDefinitions.TATTERED_QUIVER, Modelquiver::createBodyLayer);
	}

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent evt) {
		CuriosRendererRegistry.register(CatastropheModModItems.QUIVER.get(), QuiverRenderer::new);
		CuriosRendererRegistry.register(CatastropheModModItems.TATTERED_QUIVER.get(), TatteredQuiverRenderer::new);
	}
}
