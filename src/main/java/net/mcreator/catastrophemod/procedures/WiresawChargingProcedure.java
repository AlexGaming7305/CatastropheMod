package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.init.CatastropheModModItems;
import net.mcreator.catastrophemod.CatastropheModMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class WiresawChargingProcedure {
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
		double raytrace_distance = 0;
		double damage_distance = 0;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.WIRESAW.get()) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).wiresaw_active == true) {
				if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).wiresaw_fuel_drain == false) {
					if ((entity instanceof LivingEntity _entUseItem2 ? _entUseItem2.getUseItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("fuel") > 0) {
						(entity instanceof LivingEntity _entUseItem6 ? _entUseItem6.getUseItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("fuel",
								((entity instanceof LivingEntity _entUseItem4 ? _entUseItem4.getUseItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("fuel") - 1));
					}
					{
						boolean _setval = true;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.wiresaw_fuel_drain = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					CatastropheModMod.queueServerWork(20, () -> {
						{
							boolean _setval = false;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.wiresaw_fuel_drain = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
				if ((entity instanceof LivingEntity _entUseItem9 ? _entUseItem9.getUseItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("fuel") > 0) {
					if (!world.isClientSide()) {
						if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).wiresaw_loop_cooldown == false) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:wiresaw_loop")), SoundSource.PLAYERS, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.95, 1));
								} else {
									_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:wiresaw_loop")), SoundSource.PLAYERS, 1,
											(float) Mth.nextDouble(RandomSource.create(), 0.95, 1), false);
								}
							}
							{
								boolean _setval = true;
								entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.wiresaw_loop_cooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							CatastropheModMod.queueServerWork(50, () -> {
								{
									boolean _setval = false;
									entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.wiresaw_loop_cooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							});
						}
					}
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity) {
									if (entityiterator.isAlive()) {
										entityiterator.hurt(new DamageSource(
												world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:split_in_two"))), entity), 2);
									}
								}
							}
						}
					}
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity) {
									if (entityiterator.isAlive()) {
										entityiterator.hurt(new DamageSource(
												world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:split_in_two"))), entity), 2);
									}
								}
							}
						}
					}
					{
						final Vec3 _center = new Vec3(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity) {
									if (entityiterator.isAlive()) {
										entityiterator.hurt(new DamageSource(
												world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:split_in_two"))), entity), 2);
									}
								}
							}
						}
					}
					for (int index0 = 0; index0 < 2; index0++) {
						world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.RUSTY_SPARK.get()), x, (y + 1.2), z,
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
										+ Mth.nextInt(RandomSource.create(), (int) (-0.5), 1)) - entity.getX()) * Mth.nextDouble(RandomSource.create(), 0.5, 1)),
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
										+ Mth.nextInt(RandomSource.create(), (int) (-0.5), 1)) - entity.getY()) * Mth.nextDouble(RandomSource.create(), 0.5, 1)),
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
										+ Mth.nextInt(RandomSource.create(), (int) (-0.5), 1)) - entity.getZ()) * Mth.nextDouble(RandomSource.create(), 0.5, 1)));
					}
				}
			}
		}
	}
}
