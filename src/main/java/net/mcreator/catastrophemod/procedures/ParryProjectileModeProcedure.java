package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ParryProjectileModeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
{
final Vec3 _center = new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getX()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if ((entityiterator instanceof Projectile _projEnt? _projEnt.getDeltaMovement().length():0)>0) {if (!=0) {entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x+(-1)*entityiterator.getDeltaMovement().x()), (entity.getLookAngle().y+(-1)*entityiterator.getDeltaMovement().y()), (entity.getLookAngle().z+(-1)*entityiterator.getDeltaMovement().z())));entity.invulnerableTime = 20;
{
double _setval = 0;
entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
capability.parry_cooldown = _setval;
capability.syncPlayerVariables(entity);
});
}
if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:parry_projectile")),
SoundSource.PLAYERS, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:parry_projectile")),
SoundSource.PLAYERS, 1, 1, false);
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
_player.displayClientMessage(Component.literal("\u00A7eParry!"), true);if (!(entity instanceof ServerPlayer _plr14 && _plr14.level() instanceof ServerLevel && _plr14.getAdvancements()
.getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("catastrophe_mod:im_not_gonna_sugarcoat_it"))).isDone())) {if(entity instanceof ServerPlayer _player) {
Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("catastrophe_mod:im_not_gonna_sugarcoat_it"));
AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
if (!_ap.isDone()) {
for (String criteria : _ap.getRemainingCriteria())
_player.getAdvancements().award(_adv, criteria);
}
}}}}
}
}
}
}
