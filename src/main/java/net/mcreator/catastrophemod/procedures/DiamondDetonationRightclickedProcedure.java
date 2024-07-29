package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DiamondDetonationRightclickedProcedure {
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
ItemStack axe = ItemStack.EMPTY;
if (==false) {if (world instanceof ServerLevel _level) {
Entity entityToSpawn = CatastropheModModEntities.DELETED_MOD_ELEMENT.get().spawn(_level, BlockPos.containing(x,y+1.5,z), MobSpawnType.MOB_SUMMONED);
if (entityToSpawn != null) {
}
}
if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")),
SoundSource.PLAYERS, 1, (float)1.2);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")),
SoundSource.PLAYERS, 1, (float)1.2, false);
}
}
}else if (==true) {if(entity instanceof Player _player)
_player.getCooldowns().addCooldown(itemstack.getItem(), 50);{
final Vec3 _center = new Vec3(x, y, z);
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if ((entityiterator.getPersistentData().getString("DetonationOwner")).equals(entity.getStringUUID())) {entityiterator.getPersistentData().putDouble("lifetime", 99);}
}
}}
}
}
