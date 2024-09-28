package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.entity.VoltbladeEntity;
import net.mcreator.catastrophemod.entity.SurgeBreakerEntity;
import net.mcreator.catastrophemod.entity.ArcStrikerEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class ArcStrikerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double lightninghitbox = 0;
		if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) && entity.getPersistentData().getBoolean("lightningcooldown") == false) {
			if (entity.isAlive()) {
				entity.getPersistentData().putDouble("arcstrikerx", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()));
				entity.getPersistentData().putDouble("arcstrikery", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()));
				entity.getPersistentData().putDouble("arcstrikerz", ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()));
			}
		}
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("arcstrikerai", 60);
			entity.getPersistentData().putDouble("arcstrikerx", 0);
			entity.getPersistentData().putDouble("arcstrikery", 0);
			entity.getPersistentData().putDouble("arcstrikerz", 0);
		}
		if (entity.getPersistentData().getDouble("arcstrikerai") == 0) {
			entity.getPersistentData().putDouble("arcstrikerai", 60);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity instanceof ArcStrikerEntity) {
					((ArcStrikerEntity) entity).setAnimation("animation.arc_striker.lightning");
				}
				CatastropheModMod.queueServerWork(15, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL,
										new Vec3((entity.getPersistentData().getDouble("arcstrikerx")), (entity.getPersistentData().getDouble("arcstrikery")), (entity.getPersistentData().getDouble("arcstrikerz"))), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(), "/photon fx photon:lightning_telegraph block ~ ~0.5 ~");
					entity.getPersistentData().putBoolean("lightningcooldown", true);
				});
				CatastropheModMod.queueServerWork(35, () -> {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
						if (entity.isAlive()) {
							for (int index0 = 0; index0 < 10; index0++) {
								{
									final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("arcstrikerx")), (entity.getPersistentData().getDouble("arcstrikery")), (entity.getPersistentData().getDouble("arcstrikerz")));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (!(entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof ArcStrikerEntity || entityiterator instanceof VoltbladeEntity)) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:electricity"))), entity), 8);
												if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
													_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 100, 0));
											}
										}
									}
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getPersistentData().getDouble("arcstrikerx")), (entity.getPersistentData().getDouble("arcstrikery")), (entity.getPersistentData().getDouble("arcstrikerz")));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									{
										double _setval = 3;
										entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.intensity_timer = _setval;
											capability.syncPlayerVariables(entityiterator);
										});
									}
									{
										boolean _setval = true;
										entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.screenshake = _setval;
											capability.syncPlayerVariables(entityiterator);
										});
									}
									CatastropheModMod.queueServerWork(40, () -> {
										{
											boolean _setval = false;
											entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.screenshake = _setval;
												capability.syncPlayerVariables(entityiterator);
											});
										}
									});
								}
							}
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = CatastropheModModEntities.ELECTRIFIED_LIGHTNING.get().spawn(_level,
										BlockPos.containing(entity.getPersistentData().getDouble("arcstrikerx"), entity.getPersistentData().getDouble("arcstrikery"), entity.getPersistentData().getDouble("arcstrikerz")), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
								}
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getPersistentData().getDouble("arcstrikerx"), entity.getPersistentData().getDouble("arcstrikery"), entity.getPersistentData().getDouble("arcstrikerz")),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.HOSTILE, 3, 1);
								} else {
									_level.playLocalSound((entity.getPersistentData().getDouble("arcstrikerx")), (entity.getPersistentData().getDouble("arcstrikery")), (entity.getPersistentData().getDouble("arcstrikerz")),
											ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:electrified_lightning_strikes")), SoundSource.HOSTILE, 3, 1, false);
								}
							}
							entity.getPersistentData().putBoolean("lightningcooldown", false);
						}
					}
				});
			}
		} else {
			entity.getPersistentData().putDouble("arcstrikerai", (entity.getPersistentData().getDouble("arcstrikerai") - 1));
		}
	}
}
