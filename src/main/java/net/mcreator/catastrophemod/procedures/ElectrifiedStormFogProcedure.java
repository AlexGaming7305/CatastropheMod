package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

import javax.annotation.Nullable;

import com.mojang.blaze3d.shaders.FogShape;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ElectrifiedStormFogProcedure {
	private static ViewportEvent.RenderFog _provider = null;

	private static void setDistance(float start, float end) {
		_provider.setNearPlaneDistance(start);
		_provider.setFarPlaneDistance(end);
		if (!_provider.isCanceled())
			_provider.setCanceled(true);
	}

	private static void setShape(FogShape shape) {
		_provider.setFogShape(shape);
		if (!_provider.isCanceled())
			_provider.setCanceled(true);
	}

	@SubscribeEvent
	public static void renderFog(ViewportEvent.RenderFog event) {
		_provider = event;
		if (_provider.getMode() == FogRenderer.FogMode.FOG_TERRAIN) {
			ClientLevel level = Minecraft.getInstance().level;
			Entity entity = _provider.getCamera().getEntity();
			if (level != null && entity != null) {
				Vec3 entPos = entity.getPosition((float) _provider.getPartialTick());
				execute(_provider, level);
			}
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (CatastropheModModVariables.MapVariables.get(world).electrified_storm == true) {
			setDistance(1, 300);
			setShape(FogShape.CYLINDER);
		}
	}
}
