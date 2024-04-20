package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModEnchantments;
import net.mcreator.catastrophemod.init.CatastropheModModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WizardryProcedureProcedure {
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
		if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.WIZARDRY.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).WizardryEnchantment == false) {
				{
					boolean _setval = true;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WizardryEnchantment = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 5 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(CatastropheModModEnchantments.WIZARDRY.get());
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WizardryLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).getBaseValue()
						+ 5 * (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(CatastropheModModEnchantments.WIZARDRY.get())));
			}
		} else if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.WIZARDRY.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).WizardryEnchantment == false) {
				{
					boolean _setval = true;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WizardryEnchantment = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 5 * (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(CatastropheModModEnchantments.WIZARDRY.get());
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WizardryLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).getBaseValue()
						+ 5 * (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(CatastropheModModEnchantments.WIZARDRY.get())));
			}
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.WIZARDRY.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0)) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).WizardryEnchantment == true) {
				{
					boolean _setval = false;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WizardryEnchantment = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).getBaseValue()
						- (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).WizardryLevel));
				{
					double _setval = 0;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WizardryLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (!(EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.WIZARDRY.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0)) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).WizardryEnchantment == true) {
				{
					boolean _setval = false;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WizardryEnchantment = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).setBaseValue((((LivingEntity) entity).getAttribute(CatastropheModModAttributes.MANAUSAGEREDUCTION.get()).getBaseValue()
						- (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).WizardryLevel));
				{
					double _setval = 0;
					entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WizardryLevel = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
