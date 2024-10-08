
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class ManaSicknessMobEffect extends MobEffect {
	public ManaSicknessMobEffect() {
		super(MobEffectCategory.HARMFUL, -13070878);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.mana_sickness";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
