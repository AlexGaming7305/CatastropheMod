package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GuardBreakProcedureProcedure {
	@SubscribeEvent
	public static void whenEntityBlocksWithShield(ShieldBlockEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getDamageSource(), event.getEntity(), event.getDamageSource().getDirectEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity immediatesourceentity) {
		execute(null, world, x, y, z, damagesource, entity, immediatesourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity immediatesourceentity) {
		if (damagesource == null || entity == null || immediatesourceentity == null)
			return;
		if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:guard_break_damage")))
				|| immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:guard_break_projectiles")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem(), 200);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, (float) 1.5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, (float) 1.5, 1, false);
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem(), 200);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, (float) 1.5, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")), SoundSource.PLAYERS, (float) 1.5, 1, false);
					}
				}
			}
		}
	}
}
