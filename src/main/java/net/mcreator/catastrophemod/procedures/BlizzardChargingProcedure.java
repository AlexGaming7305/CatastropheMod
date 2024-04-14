package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BlizzardChargingProcedure {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.BLIZZARD.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.BLIZZARD.get()) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).blizzard_load == true) {
				if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).blizzard_loop_cooldown == false) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "playsound catastrophe_mod:blizzard_loop player @s");
						}
					}
					{
						boolean _setval = true;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.blizzard_loop_cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					CatastropheModMod.queueServerWork(260, () -> {
						{
							boolean _setval = false;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.blizzard_loop_cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
				if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana > 2) {
					for (int index0 = 0; index0 < 2; index0++) {
						world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.SNOWFLAKE.get()), x, (y + 1.1), z,
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getX()) * 0.05),
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getY()) * 0.05),
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getZ()) * 0.05));
					}
					for (int index1 = 0; index1 < 2; index1++) {
						world.addParticle(ParticleTypes.SNOWFLAKE, x, (y + 1.1), z,
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getX()) * 0.05),
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getY()) * 0.05),
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getZ()) * 0.05));
					}
					for (int index2 = 0; index2 < 2; index2++) {
						world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.BLIZZARD_WIND.get()), x, (y + 1.1), z,
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getX()) * 0.05),
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getY()) * 0.05),
								(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(12)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
										+ Mth.nextInt(RandomSource.create(), 0, 2)) - entity.getZ()) * 0.05));
					}
					for (int index3 = 0; index3 < 8; index3++) {
						raytrace_distance = raytrace_distance + 1;
						{
							final Vec3 _center = new Vec3(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytrace_distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getZ()));
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof LivingEntity) {
									if (!(entity == entityiterator)) {
										entityiterator.setTicksFrozen(150);
									}
								}
							}
						}
					}
					if (entity.getPersistentData().getDouble("ice") == 15) {
						entity.getPersistentData().putBoolean("activate", true);
						entity.getPersistentData().putDouble("ice", 0);
						if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana > 2) {
							for (int index4 = 0; index4 < 8; index4++) {
								damage_distance = damage_distance + 1;
								{
									final Vec3 _center = new Vec3(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(damage_distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(damage_distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(damage_distance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getZ()));
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
											.toList();
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof LivingEntity) {
											if (!(entity == entityiterator)) {
											}
										}
									}
								}
							}
						}
					} else {
						entity.getPersistentData().putDouble("ice", (entity.getPersistentData().getDouble("ice") + 1));
					}
				}
			}
		}
	}
}
