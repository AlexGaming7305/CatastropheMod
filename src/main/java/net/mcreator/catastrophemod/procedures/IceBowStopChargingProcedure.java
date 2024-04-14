package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class IceBowStopChargingProcedure {
	@SubscribeEvent
	public static void onUseItemStop(LivingEntityUseItemEvent.Stop event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.ICE_BOW.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.ICE_BOW.get()) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).ice_bow_charge >= 22) {
				{
					boolean _setval = true;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ice_bow_ready = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:ice_bow_shoots")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:ice_bow_shoots")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.SNOWFLAKE.get()), (entity.getX() + (entity.getLookAngle().x * 1) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * 1) / 2),
							(entity.getZ() + (entity.getLookAngle().z * 1) / 2), 15, 0.2, 0.2, 0.2, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.SNOWFLAKE.get()), (entity.getX() + (entity.getLookAngle().x * 3) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * 3) / 2),
							(entity.getZ() + (entity.getLookAngle().z * 3) / 2), 15, 0.2, 0.2, 0.2, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.SNOWFLAKE.get()), (entity.getX() + (entity.getLookAngle().x * 5) / 2), (entity.getY() + 1.5 + (entity.getLookAngle().y * 5) / 2),
							(entity.getZ() + (entity.getLookAngle().z * 5) / 2), 15, 0.2, 0.2, 0.2, 0.1);
			}
			{
				boolean _setval = false;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ice_bow_load = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ice_bow_charge = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
