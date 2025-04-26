package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.CatastropheModMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

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
		double randomx = 0;
		double randomz = 0;
		if (CatastropheModModVariables.MapVariables.get(world).electrified_storm == true) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"weather thunder");
			if (!world.isClientSide()) {
				if (Math.random() < 0.005) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_storm_rumble")), SoundSource.WEATHER, 1,
									Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.2));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_storm_rumble")), SoundSource.WEATHER, 1, Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.2),
									false);
						}
					}
				}
				if (CatastropheModModVariables.MapVariables.get(world).electrified_lightning_sky_visuals == false) {
					if (Math.random() < 0.95) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands()
									.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
											new Vec3((entity.getX() + Mth.nextInt(RandomSource.create(), -50, 50)), (entity.getY() + Mth.nextInt(RandomSource.create(), -10, 10)), (entity.getZ() + Mth.nextInt(RandomSource.create(), -50, 50))),
											Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "photon fx photon:wind block ~ ~ ~");
					}
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
						randomx = entity.getX() + Mth.nextInt(RandomSource.create(), -40, 40);
						randomz = entity.getZ() + Mth.nextInt(RandomSource.create(), -40, 40);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_storm_ambience")), SoundSource.WEATHER, 1,
										Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.2));
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_storm_ambience")), SoundSource.WEATHER, 1,
										Mth.nextInt(RandomSource.create(), (int) 0.8, (int) 1.2), false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(randomx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) randomx, (int) randomz), randomz),
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.WEATHER, 2, 0);
							} else {
								_level.playLocalSound(randomx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) randomx, (int) randomz)), randomz,
										ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.WEATHER, 2, 0, false);
							}
						}
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = CatastropheModModEntities.ELECTRIFIED_LIGHTNING.get().spawn(_level, BlockPos.containing(randomx, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) randomx, (int) randomz), randomz),
									MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						{
							final Vec3 _center = new Vec3(randomx, (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) randomx, (int) randomz)), randomz);
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								{
									double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 3;
									entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.intensity_timer = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
								{
									double _setval = (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 60;
									entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.screenshake_time = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
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
