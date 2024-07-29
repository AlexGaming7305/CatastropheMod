package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GravitationalRefluxEnchantmentProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity
) {
if(
entity == null
) return ;
if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.DELETED_MOD_ELEMENT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET):ItemStack.EMPTY)) != 0) {if (==false) {((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue((((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).getBaseValue()-0.05));}}if (!(EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.DELETED_MOD_ELEMENT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET):ItemStack.EMPTY)) != 0)) {if (==true) {((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue((((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).getBaseValue()+0.05));}}
}
}
