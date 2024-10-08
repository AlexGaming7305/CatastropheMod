package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.init.CatastropheModModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ReinforcedArmorSetbonusProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, Entity sourceentity, double amount) {
		execute(null, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		Entity projectile = null;
		if ((sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == CatastropheModModItems.REINFORCED_IRON_ARMOR_HELMET.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == CatastropheModModItems.REINFORCED_IRON_ARMOR_CHESTPLATE.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == CatastropheModModItems.REINFORCED_IRON_ARMOR_LEGGINGS.get()
				&& (sourceentity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == CatastropheModModItems.REINFORCED_IRON_ARMOR_BOOTS.get()) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof SwordItem
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof ShovelItem
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof HoeItem
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof TridentItem) {
				LivingHurtEvent event2 = (LivingHurtEvent) event;
				damage = amount + (amount * 15) / 100;
				event2.setAmount((float) damage);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.BLEEDING.get(), 60, 0));
			}
		}
	}
}
