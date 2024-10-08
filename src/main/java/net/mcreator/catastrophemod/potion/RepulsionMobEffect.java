
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class RepulsionMobEffect extends MobEffect {
	public RepulsionMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -11233345);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.repulsion";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
