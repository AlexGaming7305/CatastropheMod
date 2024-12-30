package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.catastrophemod.init.CatastropheModModItems;

public class StarlitLacewingRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.TWIG.get()) {
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).setCount((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1));
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(CatastropheModModItems.STARLIT_LACEWING_STAFF.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (!entity.level().isClientSide())
				entity.discard();
		} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == CatastropheModModItems.TWIG.get()) {
			(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setCount((int) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() - 1));
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), new ItemStack(CatastropheModModItems.STARLIT_LACEWING_STAFF.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
