
package net.mcreator.catastrophemod.potion;

public class PhaseDashCooldownMobEffect extends MobEffect {
	public PhaseDashCooldownMobEffect() {
		super(MobEffectCategory.HARMFUL, -5947956);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.phase_dash_cooldown";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}