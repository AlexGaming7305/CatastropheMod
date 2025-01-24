
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.ElectrifiedOnEffectActiveTickProcedure;
import net.mcreator.catastrophemod.procedures.ElectrifiedEffectStartedappliedProcedure;

public class ElectrifiedMobEffect extends MobEffect {
	public ElectrifiedMobEffect() {
		super(MobEffectCategory.HARMFUL, -10027009);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.electrified";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ElectrifiedEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ElectrifiedOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
