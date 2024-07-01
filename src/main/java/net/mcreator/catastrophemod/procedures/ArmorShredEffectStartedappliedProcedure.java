package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.CatastropheModMod;

public class ArmorShredEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double damage = 0;
		Entity projectile = null;
		if (entity.getPersistentData().getBoolean("armor_shred_stack_start") == true) {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue()
					- ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.ARMOR_SHRED.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.ARMOR_SHRED.get()).getAmplifier() : 0) + 1) * 2));
			entity.getPersistentData().putDouble("armor_shred_level",
					(((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(CatastropheModModMobEffects.ARMOR_SHRED.get()) ? _livEnt.getEffect(CatastropheModModMobEffects.ARMOR_SHRED.get()).getAmplifier() : 0) + 1) * 2));
			entity.getPersistentData().putBoolean("armor_shred_stack_start", false);
		} else {
			entity.getPersistentData().putDouble("armor_shred_level", (entity.getPersistentData().getDouble("armor_shred_level") + 2));
			CatastropheModMod.queueServerWork(1, () -> {
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).setBaseValue((((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.ARMOR).getBaseValue()
						- (entity.getPersistentData().getDouble("armor_shred_level") - (entity.getPersistentData().getDouble("armor_shred_level") - 2))));
			});
		}
	}
}
