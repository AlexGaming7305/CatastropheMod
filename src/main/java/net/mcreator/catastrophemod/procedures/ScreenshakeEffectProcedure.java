package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.CameraType;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class ScreenshakeEffectProcedure {
	private static ViewportEvent.ComputeCameraAngles _provider = null;

	private static void setAngles(float yaw, float pitch, float roll) {
		_provider.setYaw(yaw);
		_provider.setPitch(pitch);
		_provider.setRoll(roll);
	}

	@SubscribeEvent
	public static void computeCameraangles(ViewportEvent.ComputeCameraAngles event) {
		_provider = event;
		ClientLevel level = Minecraft.getInstance().level;
		Entity entity = _provider.getCamera().getEntity();
		if (level != null && entity != null) {
			Vec3 entPos = entity.getPosition((float) _provider.getPartialTick());
			execute(_provider, entity);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time != 0) {
				{
					double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time - 1;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.screenshake_time = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				setAngles(
						(float) (entity.getYRot()
								+ Mth.nextDouble(RandomSource.create(), (-1) * (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer,
										1 * (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer)),
						(float) (entity.getXRot()
								+ Mth.nextDouble(RandomSource.create(), (-0.5) * (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer,
										0.5 * (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer)),
						(float) Mth.nextDouble(RandomSource.create(), (-0.8) * (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer,
								0.8 * (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer));
			}
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time == 0) {
				{
					double _setval = 0;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.intensity_timer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
