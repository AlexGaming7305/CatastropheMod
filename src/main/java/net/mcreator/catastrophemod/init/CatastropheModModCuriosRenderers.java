package net.mcreator.catastrophemod.init;

import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

import net.mcreator.catastrophemod.client.renderer.SeaPendantRenderer;
import net.mcreator.catastrophemod.client.renderer.PacifyingSightRenderer;
import net.mcreator.catastrophemod.client.renderer.GoldenBraceletRenderer;
import net.mcreator.catastrophemod.client.renderer.AmuletOfWeakeningRenderer;
import net.mcreator.catastrophemod.client.renderer.AmuletOfVitalityRenderer;
import net.mcreator.catastrophemod.client.model.Modelsea_pendant;
import net.mcreator.catastrophemod.client.model.Modelpacifying_sight;
import net.mcreator.catastrophemod.client.model.Modelgolden_necklace;
import net.mcreator.catastrophemod.client.model.Modelamulet_of_weakening;
import net.mcreator.catastrophemod.client.model.Modelamulet_of_vitality;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatastropheModModCuriosRenderers {
	@SubscribeEvent
	public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(CatastropheModModLayerDefinitions.GOLDEN_BRACELET, Modelgolden_necklace::createBodyLayer);
		evt.registerLayerDefinition(CatastropheModModLayerDefinitions.SEA_PENDANT, Modelsea_pendant::createBodyLayer);
		evt.registerLayerDefinition(CatastropheModModLayerDefinitions.AMULET_OF_VITALITY, Modelamulet_of_vitality::createBodyLayer);
		evt.registerLayerDefinition(CatastropheModModLayerDefinitions.PACIFYING_SIGHT, Modelpacifying_sight::createBodyLayer);
		evt.registerLayerDefinition(CatastropheModModLayerDefinitions.AMULET_OF_WEAKENING, Modelamulet_of_weakening::createBodyLayer);
	}

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent evt) {
		CuriosRendererRegistry.register(CatastropheModModItems.GOLDEN_BRACELET.get(), GoldenBraceletRenderer::new);
		CuriosRendererRegistry.register(CatastropheModModItems.SEA_PENDANT.get(), SeaPendantRenderer::new);
		CuriosRendererRegistry.register(CatastropheModModItems.AMULET_OF_VITALITY.get(), AmuletOfVitalityRenderer::new);
		CuriosRendererRegistry.register(CatastropheModModItems.PACIFYING_SIGHT.get(), PacifyingSightRenderer::new);
		CuriosRendererRegistry.register(CatastropheModModItems.AMULET_OF_WEAKENING.get(), AmuletOfWeakeningRenderer::new);
	}
}
