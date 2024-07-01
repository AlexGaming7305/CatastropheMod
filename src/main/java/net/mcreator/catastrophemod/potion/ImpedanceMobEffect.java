
package net.mcreator.catastrophemod.potion;

public class ImpedanceMobEffect extends MobEffect {
	public ImpedanceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -5188647);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.impedance";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}