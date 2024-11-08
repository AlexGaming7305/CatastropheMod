
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class LightningSlamCooldownMobEffect extends MobEffect {
	public LightningSlamCooldownMobEffect() {
		super(MobEffectCategory.HARMFUL, -1737385);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.lightning_slam_cooldown";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
