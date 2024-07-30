
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.StunnedEffectStartedappliedProcedure;
import net.mcreator.catastrophemod.procedures.StunnedEffectExpiresProcedure;

public class StunnedMobEffect extends MobEffect {
	public StunnedMobEffect() {
		super(MobEffectCategory.HARMFUL, -5029632);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.stunned";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		StunnedEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		StunnedEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
