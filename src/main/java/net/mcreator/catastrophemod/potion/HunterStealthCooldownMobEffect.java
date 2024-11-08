
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class HunterStealthCooldownMobEffect extends MobEffect {
	public HunterStealthCooldownMobEffect() {
		super(MobEffectCategory.HARMFUL, -11986677);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.hunter_stealth_cooldown";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
