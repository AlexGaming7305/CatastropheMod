package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class CactusCutterEntitySwingsItemProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity,
ItemStack itemstack
) {
if(
entity == null
) return ;
if (==false) {if(entity instanceof Player _player)
_player.getCooldowns().addCooldown(itemstack.getItem(), 40);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_sweet_berry_bush")),
SoundSource.PLAYERS, 1, (float)1.1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.hurt_sweet_berry_bush")),
SoundSource.PLAYERS, 1, (float)1.1, false);
}
}
for (int index0 = 0; index0<4; index0++) {{
Entity _shootFrom = entity;
Level projectileLevel = _shootFrom.level();
if (!projectileLevel.isClientSide()) {
Projectile _entityToSpawn = new Object() {
public Projectile getArrow(Level level, Entity shooter, float damage, int knockback) {
AbstractArrow entityToSpawn = new CactusNeedleEntity(CatastropheModModEntities.CACTUS_NEEDLE.get(), level);
entityToSpawn.setOwner(shooter);
entityToSpawn.setBaseDamage(damage);
entityToSpawn.setKnockback(knockback);
entityToSpawn.setSilent(true);
return entityToSpawn;
}
}.getArrow(projectileLevel, entity, 1, 0);
_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 10);
projectileLevel.addFreshEntity(_entityToSpawn);
}
}}CatastropheModMod.queueServerWork(40, () -> {
});
}
}
}
