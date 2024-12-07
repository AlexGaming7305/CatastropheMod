package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AccursedWitchManaDrainProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof AccursedWitchEntity) {
			if (entity instanceof Player) {
				if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana >= 20) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.HAUNTED_GLIMMER.get()), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ()), 20, 0.2, 0.5, 0.2, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mana_is_drained")),
									SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mana_is_drained")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					{
						double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana - 20;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					sourceentity.getPersistentData().putBoolean("accursed_witch_mana_drain_attack", true);
				} else if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana < 20
						&& (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Mana != 0) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.HAUNTED_GLIMMER.get()), (sourceentity.getX()), (sourceentity.getY() + 1), (sourceentity.getZ()), 20, 0.2, 0.5, 0.2, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(sourceentity.getX(), sourceentity.getY(), sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mana_is_drained")),
									SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:mana_is_drained")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					{
						double _setval = 0;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
