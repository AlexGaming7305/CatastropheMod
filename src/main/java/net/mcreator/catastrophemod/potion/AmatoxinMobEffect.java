
package net.mcreator.catastrophemod.potion;

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
		AmatoxinOnEffectActiveTickProcedure.execute(entity.level(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}