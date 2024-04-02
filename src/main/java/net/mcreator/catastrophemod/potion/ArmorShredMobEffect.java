
package net.mcreator.catastrophemod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.catastrophemod.procedures.ArmorShredEffectStartedappliedProcedure;
import net.mcreator.catastrophemod.procedures.ArmorShredEffectExpiresProcedure;

public class ArmorShredMobEffect extends MobEffect {
	public ArmorShredMobEffect() {
		super(MobEffectCategory.HARMFUL, -3943208);
	}

	@Override
	public String getDescriptionId() {
		return "effect.catastrophe_mod.armor_shred";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ArmorShredEffectStartedappliedProcedure.execute(entity.level(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ArmorShredEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
