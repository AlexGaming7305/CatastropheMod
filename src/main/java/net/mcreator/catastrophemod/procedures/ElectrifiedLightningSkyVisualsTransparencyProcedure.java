package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.CatastropheModMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ElectrifiedLightningSkyVisualsTransparencyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (CatastropheModModVariables.MapVariables.get(world).electrified_storm == true) {
			if (!world.isClientSide()) {
				if (Math.random() < 0.005) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "/playsound catastrophe_mod:electrified_storm_rumble weather @s");
						}
					}
				}
				if (CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals == false) {
					if (Math.random() < 0.005) {
						CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals = true;
						CatastropheModModVariables.MapVariables.get(world).syncData(world);
						{
							double _setval = 1;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fade_variable = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_storm_ambience")), SoundSource.WEATHER, 1,
										(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_storm_ambience")), SoundSource.WEATHER, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1),
										false);
							}
						}
						CatastropheModMod.queueServerWork(10, () -> {
							CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals = false;
							CatastropheModModVariables.MapVariables.get(world).syncData(world);
						});
					}
				}
			}
			if (CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals == true) {
				CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals_transparency = CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals_transparency + 25;
				CatastropheModModVariables.MapVariables.get(world).syncData(world);
				{
					double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).fade_variable - 0.1;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.fade_variable = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals == false) {
				CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals_transparency = 250;
				CatastropheModModVariables.MapVariables.get(world).syncData(world);
				{
					double _setval = 0;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.fade_variable = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
