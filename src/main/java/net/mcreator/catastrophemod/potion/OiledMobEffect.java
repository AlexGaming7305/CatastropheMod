
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.OiledOnEffectActiveTickProcedure;

public class OiledMobEffect extends MobEffect {
	public OiledMobEffect() {
		super(MobEffectCategory.HARMFUL, -14874829);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.oiled";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		OiledOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
