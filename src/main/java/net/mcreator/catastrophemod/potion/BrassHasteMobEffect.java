
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BrassHasteMobEffect extends MobEffect {
	public BrassHasteMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13262);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.brass_haste";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
