
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.BleedingOnEffectActiveTickProcedure;
import net.mcreator.catastrophemod.procedures.BleedingActiveTickConditionProcedure;

public class BleedingMobEffect extends MobEffect {
	public BleedingMobEffect() {
		super(MobEffectCategory.HARMFUL, -8454134);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.bleeding";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BleedingOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return BleedingActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
