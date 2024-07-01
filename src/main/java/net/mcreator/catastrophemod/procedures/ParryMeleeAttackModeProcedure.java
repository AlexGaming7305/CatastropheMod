package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ParryMeleeAttackModeProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, immediatesourceentity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (!((immediatesourceentity instanceof Projectile _projEnt ? _projEnt.getDeltaMovement().length() : 0) > 0)) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).parry_melee_attack_mode != 0) {
				{
					double _setval = 0;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.parry_melee_attack_mode = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
				entity.invulnerableTime = 20;
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
					if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) {
						sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity),
								(float) ((amount * (50 + (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get()) * 10)) / 100));
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
							if (_ist.hurt((int) amount, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					} else {
						sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity),
								(float) ((amount * 50) / 100));
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
							if (_ist.hurt((int) amount, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem) {
					if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
						sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity),
								(float) ((amount * (50 + (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get()) * 10)) / 100));
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							if (_ist.hurt((int) amount, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					} else {
						sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:crushed"))), entity),
								(float) ((amount * 50) / 100));
						{
							ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
							if (_ist.hurt((int) amount, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:parry_melee_attack")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:parry_melee_attack")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				{
					boolean _setval = true;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.parry_screen_flash = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CatastropheModMod.queueServerWork(10, () -> {
					{
						boolean _setval = false;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.parry_screen_flash = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7eParry!"), true);
				if (!(entity instanceof ServerPlayer _plr32 && _plr32.level() instanceof ServerLevel
						&& _plr32.getAdvancements().getOrStartProgress(_plr32.server.getAdvancements().getAdvancement(new ResourceLocation("catastrophe_mod:im_not_gonna_sugarcoat_it"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("catastrophe_mod:im_not_gonna_sugarcoat_it"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
				{
					double _setval = 0;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.parry_cooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
