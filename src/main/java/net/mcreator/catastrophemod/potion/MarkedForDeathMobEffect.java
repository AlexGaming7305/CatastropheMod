
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class MarkedForDeathMobEffect extends MobEffect {
	public MarkedForDeathMobEffect() {
		super(MobEffectCategory.HARMFUL, -5111808);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.marked_for_death";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
