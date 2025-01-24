
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.AmatoxinOnEffectActiveTickProcedure;
import net.mcreator.catastrophemod.procedures.AmatoxinActiveTickConditionProcedure;

public class AmatoxinMobEffect extends MobEffect {
	public AmatoxinMobEffect() {
		super(MobEffectCategory.HARMFUL, -16737997);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.amatoxin";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AmatoxinOnEffectActiveTickProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return AmatoxinActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
