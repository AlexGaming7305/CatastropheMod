package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

public class AmatoxinOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("catastrophe_mod:liver_failure")))), 1);
		if (entity instanceof Player _player)
			_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 1));
	}
}
