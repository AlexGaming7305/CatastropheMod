package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class ShieldParryOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack shield_held = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) {
					shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) {
					shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
				}
				if (!(entity instanceof Player _plrCldCheck11 && _plrCldCheck11.getCooldowns().isOnCooldown(shield_held.getItem())) && !(entity instanceof LivingEntity _livEnt12 && _livEnt12.isBlocking())) {
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(shield_held.getItem(), 20);
					if (world.getDifficulty() == Difficulty.EASY) {
						{
							double _setval = 12;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.parry_mode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (world.getDifficulty() == Difficulty.NORMAL) {
						{
							double _setval = 10;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.parry_mode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (world.getDifficulty() == Difficulty.HARD) {
						{
							double _setval = 8;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.parry_mode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (shield_held.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()) {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.OFF_HAND, true);
					} else if (shield_held.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:punch")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:punch")), SoundSource.PLAYERS, 1, (float) Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
						}
					}
				}
			}
		}
	}
}
