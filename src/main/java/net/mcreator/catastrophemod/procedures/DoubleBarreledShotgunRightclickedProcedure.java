package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DoubleBarreledShotgunRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (itemstack.getOrCreateTag().getDouble("ammo") == 0) {
				{
					boolean _setval = true;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.out_of_ammo_timer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				CatastropheModMod.queueServerWork(10, () -> {
					{
						boolean _setval = false;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.out_of_ammo_timer = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:gun_clicks")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:gun_clicks")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cOut of Ammo!"), true);
			}
		}
		if (itemstack.getOrCreateTag().getDouble("ammo") > 0) {
			{
				double _setval = 2;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.intensity_timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = true;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.screenshake = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			CatastropheModMod.queueServerWork(15, () -> {
				{
					boolean _setval = false;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.screenshake = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
			if (itemstack.getItem() instanceof DoubleBarreledShotgunItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "animation.double_barreled_shotgun.fire");
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 16);
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			itemstack.getOrCreateTag().putDouble("ammo", (itemstack.getOrCreateTag().getDouble("ammo") - 1));
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:double_barreled_shotgun_shoots")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:double_barreled_shotgun_shoots")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			entity.setDeltaMovement(new Vec3(((-0.75) * entity.getLookAngle().x), ((-0.375) * entity.getLookAngle().y), ((-0.75) * entity.getLookAngle().z)));
			if (itemstack.getOrCreateTag().getBoolean("copper_round") == true) {
				for (int index0 = 0; index0 < 2; index0++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new CopperRoundProjectileEntity(CatastropheModModEntities.COPPER_ROUND_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 2, 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 8);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			} else if (itemstack.getOrCreateTag().getBoolean("scrap_round") == true) {
				for (int index1 = 0; index1 < 2; index1++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new ScrapRoundProjectileEntity(CatastropheModModEntities.SCRAP_ROUND_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) 2.5, 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 8);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			} else if (itemstack.getOrCreateTag().getBoolean("crystal_round") == true) {
				for (int index2 = 0; index2 < 2; index2++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
									AbstractArrow entityToSpawn = new CrystalRoundProjectileProjectileEntity(CatastropheModModEntities.CRYSTAL_ROUND_PROJECTILE_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 2, 0, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 8);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			} else if (itemstack.getOrCreateTag().getBoolean("electrified_round") == true) {
				for (int index3 = 0; index3 < 2; index3++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new ElectrifiedRoundProjectileProjectileEntity(CatastropheModModEntities.ELECTRIFIED_ROUND_PROJECTILE_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, (float) 2.5, 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 8);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			} else if (itemstack.getOrCreateTag().getBoolean("venomous_round") == true) {
				for (int index4 = 0; index4 < 2; index4++) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
									AbstractArrow entityToSpawn = new VenomousBulletProjectileProjectileEntity(CatastropheModModEntities.VENOMOUS_BULLET_PROJECTILE_PROJECTILE.get(), level);
									entityToSpawn.setOwner(shooter);
									entityToSpawn.setBaseDamage(damage);
									entityToSpawn.setKnockback(knockback);
									entityToSpawn.setSilent(true);
									return entityToSpawn;
								}
							}.getArrow(projectileLevel, entity, 3, 0);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, 8);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
				}
			}
		}
	}
}
