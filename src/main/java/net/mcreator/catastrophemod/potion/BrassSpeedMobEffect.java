
package net.mcreator.catastrophemod.potion;

public class BrassSpeedMobEffect extends MobEffect {
	public BrassSpeedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13262);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.brass_speed";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		BrassSpeedEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BrassSpeedEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}