package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ParryModeProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity(),
					event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, DamageSource damagesource, Entity entity, Entity immediatesourceentity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, damagesource, entity, immediatesourceentity, sourceentity, amount);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
DamageSource damagesource,
Entity entity,
Entity immediatesourceentity,
Entity sourceentity,
double amount
) {
if(
damagesource == null ||
entity == null ||
immediatesourceentity == null ||
sourceentity == null
) return ;
ItemStack shield_held = ItemStack.EMPTY;Entity parried_projectile = null;
if (!world.isClientSide()) {if (!(damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:unparriable_damage")))&&immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:unparriable_projectiles"))))) {if (!((immediatesourceentity instanceof Projectile _projEnt? _projEnt.getDeltaMovement().length():0)>0)) {if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new CatastropheModModVariables.PlayerVariables())).parry_mode!=0) {{
double _setval = 0;
entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.parry_mode = _setval;
capability.syncPlayerVariables(entity);
});
}
if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) { shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY);}else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) { shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY);}if(event != null && event.isCancelable()) {
event.setCanceled(true);
}entity.invulnerableTime = 25;
if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:guard_break_damage")))) {if (((LivingEntity) entity).getAttribute(CatastropheModModAttributes.PARRYDAMAGE.get()).getBaseValue()!=0) {sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sugarcoated"))), entity), (float)(*1.5+(*1.5*((LivingEntity) entity).getAttribute(CatastropheModModAttributes.PARRYDAMAGE.get()).getBaseValue())/ 100));}else{sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sugarcoated"))), entity), (float)(*1.5));}if(entity instanceof Player _player)
_player.getCooldowns().addCooldown(shield_held.getItem(), 100);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
SoundSource.PLAYERS, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
SoundSource.PLAYERS, 1, 1, false);
}
}
}else{if (((LivingEntity) entity).getAttribute(CatastropheModModAttributes.PARRYDAMAGE.get()).getBaseValue()!=0) {sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sugarcoated"))), entity), (float)(+(*((LivingEntity) entity).getAttribute(CatastropheModModAttributes.PARRYDAMAGE.get()).getBaseValue())/ 100));}else{sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:sugarcoated"))), entity), (float));}}if (shield_held.getItem() == CatastropheModModItems.NATURITE_SHIELD.get()) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,100,0));}{
ItemStack _ist = shield_held;
if(_ist.hurt((int)amount, RandomSource.create(), null)) {
_ist.shrink(1);
_ist.setDamageValue(0);
}
}if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:parry_melee_attack")),
SoundSource.PLAYERS, 1, (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:parry_melee_attack")),
SoundSource.PLAYERS, 1, (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
}
}
if (world instanceof ServerLevel _level)
_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DELETED_MOD_ELEMENT.get()), (entity.getX()+entity.getLookAngle().x), (entity.getY()+1.5), (entity.getZ()+entity.getLookAngle().z), 1, 0, 0, 0, 0);{
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
CatastropheModMod.queueServerWork(10, () -> {
{
boolean _setval = false;
entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.screenshake = _setval;
capability.syncPlayerVariables(entity);
});
}
});
if (damagesource.is(TagKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:guard_break_damage")))) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\u00A7cGuard Broken!"), true);}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\u00A7eParry!"), true);}if (!(entity instanceof ServerPlayer _plr40 && _plr40.level() instanceof ServerLevel && _plr40.getAdvancements()
.getOrStartProgress(_plr40.server.getAdvancements().getAdvancement(new ResourceLocation("catastrophe_mod:im_not_gonna_sugarcoat_it"))).isDone())) {if(entity instanceof ServerPlayer _player) {
Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("catastrophe_mod:im_not_gonna_sugarcoat_it"));
AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
if (!_ap.isDone()) {
for (String criteria : _ap.getRemainingCriteria())
_player.getAdvancements().award(_adv, criteria);
}
}}}}else{if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
.orElse(new CatastropheModModVariables.PlayerVariables())).parry_mode!=0) {{
double _setval = 0;
entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.parry_mode = _setval;
capability.syncPlayerVariables(entity);
});
}
if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) { shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY);}else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) { shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY);}parried_projectile = immediatesourceentity;if(event != null && event.isCancelable()) {
event.setCanceled(true);
}entity.invulnerableTime = 25;
if(!parried_projectile.level().isClientSide()) parried_projectile.discard();if (parried_projectile.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:guard_break_projectiles")))) {if (((LivingEntity) entity).getAttribute(CatastropheModModAttributes.PARRYDAMAGE.get()).getBaseValue()!=0) {{
Entity _shootFrom = entity;
Level projectileLevel = _shootFrom.level();
if (!projectileLevel.isClientSide()) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
entityToSpawn.setOwner(shooter);
entityToSpawn.setBaseDamage(damage);
entityToSpawn.setKnockback(knockback);
return entityToSpawn;
}
}.getArrow(projectileLevel, entity, (float)((*1.5)/ 2+(((*1.5)/ 2)*((LivingEntity) entity).getAttribute(CatastropheModModAttributes.PARRYDAMAGE.get()).getBaseValue())/ 100), 0);
_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
projectileLevel.addFreshEntity(_entityToSpawn);
}
}}else{{
Entity _shootFrom = entity;
Level projectileLevel = _shootFrom.level();
if (!projectileLevel.isClientSide()) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
entityToSpawn.setOwner(shooter);
entityToSpawn.setBaseDamage(damage);
entityToSpawn.setKnockback(knockback);
return entityToSpawn;
}
}.getArrow(projectileLevel, entity, (float)((*1.5)/ 2), 0);
_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
projectileLevel.addFreshEntity(_entityToSpawn);
}
}}if(entity instanceof Player _player)
_player.getCooldowns().addCooldown(shield_held.getItem(), 100);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
SoundSource.PLAYERS, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.shield.break")),
SoundSource.PLAYERS, 1, 1, false);
}
}
}else{if (((LivingEntity) entity).getAttribute(CatastropheModModAttributes.PARRYDAMAGE.get()).getBaseValue()!=0) {{
Entity _shootFrom = entity;
Level projectileLevel = _shootFrom.level();
if (!projectileLevel.isClientSide()) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
entityToSpawn.setOwner(shooter);
entityToSpawn.setBaseDamage(damage);
entityToSpawn.setKnockback(knockback);
return entityToSpawn;
}
}.getArrow(projectileLevel, entity, (float)(/ 2+((/ 2)*((LivingEntity) entity).getAttribute(CatastropheModModAttributes.PARRYDAMAGE.get()).getBaseValue())/ 100), 0);
_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
projectileLevel.addFreshEntity(_entityToSpawn);
}
}}else{{
Entity _shootFrom = entity;
Level projectileLevel = _shootFrom.level();
if (!projectileLevel.isClientSide()) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
AbstractArrow entityToSpawn = new Arrow(EntityType.ARROW, level);
entityToSpawn.setOwner(shooter);
entityToSpawn.setBaseDamage(damage);
entityToSpawn.setKnockback(knockback);
return entityToSpawn;
}
}.getArrow(projectileLevel, entity, (float)(/ 2), 0);
_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
projectileLevel.addFreshEntity(_entityToSpawn);
}
}}}{
ItemStack _ist = shield_held;
if(_ist.hurt((int)amount, RandomSource.create(), null)) {
_ist.shrink(1);
_ist.setDamageValue(0);
}
}if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:parry_projectile")),
SoundSource.PLAYERS, 1, (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:parry_projectile")),
SoundSource.PLAYERS, 1, (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
}
}
if (world instanceof ServerLevel _level)
_level.sendParticles((SimpleParticleType) (CatastropheModModParticleTypes.DELETED_MOD_ELEMENT.get()), (entity.getX()+entity.getLookAngle().x), (entity.getY()+1.5), (entity.getZ()+entity.getLookAngle().z), 1, 0, 0, 0, 0);{
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
CatastropheModMod.queueServerWork(10, () -> {
{
boolean _setval = false;
entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.screenshake = _setval;
capability.syncPlayerVariables(entity);
});
}
});
if (immediatesourceentity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("catastrophe_mod:guard_break_projectiles")))) {if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\u00A7cGuard Broken!"), true);}else{if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("\u00A7eParry!"), true);}if (!(entity instanceof ServerPlayer _plr77 && _plr77.level() instanceof ServerLevel && _plr77.getAdvancements()
.getOrStartProgress(_plr77.server.getAdvancements().getAdvancement(new ResourceLocation("catastrophe_mod:im_not_gonna_sugarcoat_it"))).isDone())) {if(entity instanceof ServerPlayer _player) {
Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("catastrophe_mod:im_not_gonna_sugarcoat_it"));
AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
if (!_ap.isDone()) {
for (String criteria : _ap.getRemainingCriteria())
_player.getAdvancements().award(_adv, criteria);
}
}}}}}}
}
}
