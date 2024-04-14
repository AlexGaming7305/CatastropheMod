
package net.mcreator.catastrophemod.potion;

public class BullseyeMobEffect extends MobEffect {
	public BullseyeMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6750208);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.bullseye";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}