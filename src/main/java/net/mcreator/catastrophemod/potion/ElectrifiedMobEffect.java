
package net.mcreator.catastrophemod.potion;

public class ElectrifiedMobEffect extends MobEffect {
	public ElectrifiedMobEffect() {
		super(MobEffectCategory.HARMFUL, -10027009);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.electrified";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ElectrifiedOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}