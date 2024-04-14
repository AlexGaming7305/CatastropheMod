package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class CrystalSpearStabOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		CatastropheModMod.queueServerWork(10, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
		entity.setNoGravity(true);
		CatastropheModMod.queueServerWork(2, () -> {
			if (entity instanceof CrystalSpearStabEntity animatable)
				animatable.setTexture("amethyst_spear_stab_texture_1");
		});
		CatastropheModMod.queueServerWork(4, () -> {
			if (entity instanceof CrystalSpearStabEntity animatable)
				animatable.setTexture("amethyst_spear_stab_texture_2");
		});
		CatastropheModMod.queueServerWork(6, () -> {
			if (entity instanceof CrystalSpearStabEntity animatable)
				animatable.setTexture("amethyst_spear_stab_texture_3");
		});
		CatastropheModMod.queueServerWork(8, () -> {
			if (entity instanceof CrystalSpearStabEntity animatable)
				animatable.setTexture("amethyst_spear_stab_texture_4");
		});
	}
}
