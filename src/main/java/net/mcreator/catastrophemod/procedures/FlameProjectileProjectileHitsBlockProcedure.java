package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FlameProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)), 8);
				entityiterator.setSecondsOnFire(10);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, y, z, 75, 0, 0, 0, 0.15);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 50, 0, 0, 0, 0.15);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.LAVA, x, y, z, 35, 0.2, 0.2, 0.2, 1);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.FIERY_EXPLOSION.get()), x, y, z, 1, 0, 0, 0, 0);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fire_magic_explodes")), SoundSource.PLAYERS, 2, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:fire_magic_explodes")), SoundSource.PLAYERS, 2, 1, false);
			}
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				{
					double _setval = 2;
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
				CatastropheModMod.queueServerWork(10, () -> {
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
	}
}
