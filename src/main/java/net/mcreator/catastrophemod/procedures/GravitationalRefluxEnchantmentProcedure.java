package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModEnchantments;

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

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.GRAVITATIONAL_REFLUX.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).gravitational_reflux_enchantment == false) {
				{
					boolean _setval = true;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gravitational_reflux_enchantment = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue((((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).getBaseValue() - 0.05));
			}
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.GRAVITATIONAL_REFLUX.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0)) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).gravitational_reflux_enchantment == true) {
				{
					boolean _setval = false;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.gravitational_reflux_enchantment = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue((((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).getBaseValue() + 0.05));
			}
		}
	}
}
