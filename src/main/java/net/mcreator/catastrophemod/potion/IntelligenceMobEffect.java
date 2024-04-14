
package net.mcreator.catastrophemod.potion;

public class IntelligenceMobEffect extends MobEffect {
	public IntelligenceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13312);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.intelligence";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}