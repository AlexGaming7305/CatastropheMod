package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WiresawChargingProcedure {
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
double raytrace_distance = 0;double damage_distance = 0;
if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == CatastropheModModItems.WIRESAW.get()||(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).getItem() == CatastropheModModItems.WIRESAW.get()) {if (==true) {if (==false) {{
Entity _ent = entity;
if(!_ent.level().isClientSide() && _ent.getServer() != null) {
_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(
CommandSource.NULL, _ent.position(), _ent.getRotationVector(),
_ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent
), "playsound catastrophe_mod:wiresaw_loop player @s");
}
}CatastropheModMod.queueServerWork(50, () -> {
});
}{
final Vec3 _center = new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getX()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entityiterator == entity)) {if (entityiterator instanceof LivingEntity) {entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:split_in_two"))), entity), 3);}}
}
}{
final Vec3 _center = new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getX()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entityiterator == entity)) {if (entityiterator instanceof LivingEntity) {entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:split_in_two"))), entity), 3);}}
}
}{
final Vec3 _center = new Vec3((entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getX()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getY()), (entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true)
.stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
for (Entity entityiterator : _entfound) {
if (!(entityiterator == entity)) {if (entityiterator instanceof LivingEntity) {entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:split_in_two"))), entity), 3);}}
}
}for (int index0 = 0; index0<2; index0++) {world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.RUSTY_SPARK.get()), x, (y+1.2), z, (((entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getX()+Mth.nextInt(RandomSource.create(), (int)(-0.5), 1))-entity.getX())*Mth.nextDouble(RandomSource.create(), 0.5, 1)), (((entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getY()+Mth.nextInt(RandomSource.create(), (int)(-0.5), 1))-entity.getY())*Mth.nextDouble(RandomSource.create(), 0.5, 1)), (((entity.level().clip(new ClipContext(entity.getEyePosition(1f),entity.getEyePosition(1f)
.add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE,
ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()+Mth.nextInt(RandomSource.create(), (int)(-0.5), 1))-entity.getZ())*Mth.nextDouble(RandomSource.create(), 0.5, 1)));}}}
}
}
