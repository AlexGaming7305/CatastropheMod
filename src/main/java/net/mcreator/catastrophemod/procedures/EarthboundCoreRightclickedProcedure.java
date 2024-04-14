package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class EarthboundCoreRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getY() <= 20 && (entity.level().dimension()) == Level.OVERWORLD) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(CatastropheModModItems.EARTHBOUND_CORE.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CatastropheModModEntities.EARTHBOUND_WRAITH.get().spawn(_level, BlockPos.containing(x, y + 3, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
	}
}
