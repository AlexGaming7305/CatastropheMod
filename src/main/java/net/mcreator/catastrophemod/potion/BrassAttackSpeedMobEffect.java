
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.BrassAttackSpeedEffectStartedappliedProcedure;
import net.mcreator.catastrophemod.procedures.BrassAttackSpeedEffectExpiresProcedure;

public class BrassAttackSpeedMobEffect extends MobEffect {
	public BrassAttackSpeedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13262);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.brass_attack_speed";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		BrassAttackSpeedEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BrassAttackSpeedEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
