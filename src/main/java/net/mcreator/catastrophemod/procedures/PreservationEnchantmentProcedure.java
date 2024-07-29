package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PreservationEnchantmentProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
Entity entity
) {
if(
entity == null
) return ;
if (==false) {if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.DELETED_MOD_ELEMENT.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY)) != 0) {(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).setDamageValue((int)((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getDamageValue()-1));}if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.DELETED_MOD_ELEMENT.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY)) != 0) {(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).setDamageValue((int)((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).getDamageValue()-1));}if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.DELETED_MOD_ELEMENT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET):ItemStack.EMPTY)) != 0) {(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET):ItemStack.EMPTY).setDamageValue((int)((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET):ItemStack.EMPTY).getDamageValue()-1));}if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.DELETED_MOD_ELEMENT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS):ItemStack.EMPTY)) != 0) {(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS):ItemStack.EMPTY).setDamageValue((int)((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS):ItemStack.EMPTY).getDamageValue()-1));}if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.DELETED_MOD_ELEMENT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST):ItemStack.EMPTY)) != 0) {(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST):ItemStack.EMPTY).setDamageValue((int)((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST):ItemStack.EMPTY).getDamageValue()-1));}if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.DELETED_MOD_ELEMENT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD):ItemStack.EMPTY)) != 0) {(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD):ItemStack.EMPTY).setDamageValue((int)((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD):ItemStack.EMPTY).getDamageValue()-1));}CatastropheModMod.queueServerWork(40, () -> {
});
}
}
}
