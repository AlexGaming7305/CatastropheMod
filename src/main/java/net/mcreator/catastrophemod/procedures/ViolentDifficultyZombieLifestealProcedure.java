package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ViolentDifficultyZombieLifestealProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity,
Entity sourceentity,
double amount
) {
if(
entity == null ||
sourceentity == null
) return ;
if ((entity instanceof Player||entity instanceof Villager)&&sourceentity instanceof Zombie&&==true) {if (sourceentity instanceof LivingEntity _entity) _entity.setHealth((float)((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth():-1)+amount));if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 12, 0.25, 1, 0.25, 1);}
}
}
