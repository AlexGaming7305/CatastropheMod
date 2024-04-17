package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.entity.EarthShockwaveEntity;
import net.mcreator.catastrophemod.CatastropheModMod;

public class EarthShockwaveOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "");
			}
		}
		entity.invulnerableTime = 20;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 255, false, false));
		if (entity.getPersistentData().getDouble("shockwave") == 0) {
			CatastropheModMod.queueServerWork(1, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_1");
			});
			CatastropheModMod.queueServerWork(2, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_2");
			});
			CatastropheModMod.queueServerWork(3, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_3");
			});
			CatastropheModMod.queueServerWork(4, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_4");
			});
			CatastropheModMod.queueServerWork(5, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_5");
			});
			CatastropheModMod.queueServerWork(6, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_6");
			});
			CatastropheModMod.queueServerWork(7, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_7");
			});
			CatastropheModMod.queueServerWork(8, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_8");
			});
			CatastropheModMod.queueServerWork(9, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_9");
			});
			CatastropheModMod.queueServerWork(10, () -> {
				if (entity instanceof EarthShockwaveEntity animatable)
					animatable.setTexture("earth_shockwave_10");
			});
			CatastropheModMod.queueServerWork(15, () -> {
				if (!entity.level().isClientSide())
					entity.discard();
			});
		}
		if (entity.getPersistentData().getDouble("shockwave") == 0) {
			entity.getPersistentData().putDouble("shockwave", 15);
		} else {
			entity.getPersistentData().putDouble("shockwave", (entity.getPersistentData().getDouble("shockwave") - 1));
		}
		entity.setNoGravity(true);
	}
}
