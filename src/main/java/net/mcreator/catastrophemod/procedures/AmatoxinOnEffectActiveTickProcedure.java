package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class AmatoxinOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, double amplifier) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("Delay") == 0) {
			entity.getPersistentData().putDouble("Delay", (40 - amplifier * 5));
		} else {
			entity.getPersistentData().putDouble("Delay", (entity.getPersistentData().getDouble("Delay") - 1));
		}
		if (entity.getPersistentData().getDouble("Delay") == 0) {
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:liver_failure")))), 1);
			if (entity instanceof Player _player)
				_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 1));
		}
	}
}
