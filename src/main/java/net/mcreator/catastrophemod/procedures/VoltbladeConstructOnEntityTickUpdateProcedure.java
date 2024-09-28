package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.entity.VoltbladeEntity;
import net.mcreator.catastrophemod.entity.SurgeBreakerEntity;
import net.mcreator.catastrophemod.entity.ArcStrikerEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.List;
import java.util.Comparator;

public class VoltbladeConstructOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity nightfallsdemiseowner = null;
		double lifetime = 0;
		entity.getPersistentData().putDouble("X", (entity.getX()));
		entity.getPersistentData().putDouble("Y", (entity.getY()));
		entity.getPersistentData().putDouble("Z", (entity.getZ()));
		if ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null) {
			entity.getPersistentData().putDouble("voltbladeai", 65);
		}
		if (entity.getPersistentData().getDouble("voltbladeai") == 0) {
			entity.getPersistentData().putDouble("voltbladeai", 65);
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				if (entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() <= 5
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() <= 5
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() <= 5
						&& entity.getPersistentData().getDouble("X") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() >= -5
						&& entity.getPersistentData().getDouble("Y") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() >= -5
						&& entity.getPersistentData().getDouble("Z") - (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() >= -5) {
					if (entity instanceof VoltbladeEntity) {
						((VoltbladeEntity) entity).setAnimation("animation.voltblade_construct.slash");
					}
					CatastropheModMod.queueServerWork(23, () -> {
					});
					CatastropheModMod.queueServerWork(25, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											if (!(entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof ArcStrikerEntity || entityiterator instanceof VoltbladeEntity)) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity), 5);
											}
										}
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(38, () -> {
					});
					CatastropheModMod.queueServerWork(40, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							{
								final Vec3 _center = new Vec3(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getY()),
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											if (!(entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof ArcStrikerEntity || entityiterator instanceof VoltbladeEntity)) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity), 5);
											}
										}
									}
								}
							}
						}
					});
				} else {
					if (entity instanceof VoltbladeEntity) {
						((VoltbladeEntity) entity).setAnimation("animation.voltblade_construct.spin");
					}
					CatastropheModMod.queueServerWork(15, () -> {
						entity.getPersistentData().putBoolean("whirlwind", true);
					});
					CatastropheModMod.queueServerWork(20, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											if (!(entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof ArcStrikerEntity || entityiterator instanceof VoltbladeEntity)) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity), 4);
											}
										}
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(30, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											if (!(entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof ArcStrikerEntity || entityiterator instanceof VoltbladeEntity)) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity), 4);
											}
										}
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(40, () -> {
						if (entity.isAlive()) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											if (!(entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof ArcStrikerEntity || entityiterator instanceof VoltbladeEntity)) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity), 4);
											}
										}
									}
								}
							}
						}
					});
					CatastropheModMod.queueServerWork(50, () -> {
						if (entity.isAlive()) {
							entity.getPersistentData().putBoolean("whirlwind", false);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:blade_swing")), SoundSource.HOSTILE, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
								}
							}
							{
								final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
								List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(6 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
								for (Entity entityiterator : _entfound) {
									if (!(entityiterator == entity)) {
										if (entityiterator instanceof LivingEntity) {
											if (!(entityiterator instanceof SurgeBreakerEntity || entityiterator instanceof ArcStrikerEntity || entityiterator instanceof VoltbladeEntity)) {
												entityiterator.hurt(new DamageSource(
														world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sliced"))), entity), 4);
											}
										}
									}
								}
							}
						}
					});
				}
			}
		} else {
			entity.getPersistentData().putDouble("voltbladeai", (entity.getPersistentData().getDouble("voltbladeai") - 1));
		}
		if (entity.getPersistentData().getBoolean("whirlwind") == true) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				entity.setDeltaMovement(new Vec3((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX() - entity.getX()) * 0.05),
						((((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY() + 0) - entity.getY()) * 0.05), (((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ() - entity.getZ()) * 0.05)));
			}
		}
	}
}
