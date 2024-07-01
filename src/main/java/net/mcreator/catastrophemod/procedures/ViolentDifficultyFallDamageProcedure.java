package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ViolentDifficultyFallDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, double amount) {
		execute(null, damagesource, entity, amount);
	}

private static void execute(
@Nullable Event event,
DamageSource damagesource,
Entity entity,
double amount
) {
if(
damagesource == null ||
entity == null
) return ;
if (entity instanceof Player&&==true&&amount>=5&&damagesource.is(DamageTypes.FALL)) {if(entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,(int)(20*amount),(int)Math.floor((0+amount/ 5)-1)));if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal("fall in violent"), false);}
}
}
