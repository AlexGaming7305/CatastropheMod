package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;

import java.util.List;
import java.util.Comparator;

public class DiamondDetonationRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack axe = ItemStack.EMPTY;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).diamond_detonation_used == false) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CatastropheModModEntities.DIAMOND_DETONATION_BOMB.get().spawn(_level, BlockPos.containing(x, y + 1.5, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")), SoundSource.PLAYERS, 1, (float) 1.2);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.extinguish_fire")), SoundSource.PLAYERS, 1, (float) 1.2, false);
				}
			}
			{
				boolean _setval = true;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.diamond_detonation_used = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).diamond_detonation_used == true) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 50);
			{
				boolean _setval = false;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.diamond_detonation_used = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(100 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator.getPersistentData().getString("DetonationOwner")).equals(entity.getStringUUID())) {
						entityiterator.getPersistentData().putDouble("lifetime", 99);
					}
				}
			}
		}
	}
}
