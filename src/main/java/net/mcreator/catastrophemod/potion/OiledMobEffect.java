
package net.mcreator.catastrophemod.potion;

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