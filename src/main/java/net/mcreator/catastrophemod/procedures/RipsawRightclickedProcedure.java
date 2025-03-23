package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;
import net.mcreator.catastrophemod.item.RipsawItem;
import net.mcreator.catastrophemod.init.CatastropheModModParticleTypes;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;
import net.mcreator.catastrophemod.CatastropheModMod;

public class RipsawRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack axe = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:ripsaw_shoots")), SoundSource.PLAYERS, 1, Mth.nextInt(RandomSource.create(), 1, (int) 1.1));
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:ripsaw_shoots")), SoundSource.PLAYERS, 1, Mth.nextInt(RandomSource.create(), 1, (int) 1.1), false);
				}
			}
		}
		if (itemstack.getItem() instanceof RipsawItem)
			itemstack.getOrCreateTag().putString("geckoAnim", "animation.ripsaw.shoot");
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 65);
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(1, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		CatastropheModMod.queueServerWork(10, () -> {
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 1;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.intensity_timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 20;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.screenshake_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		});
		CatastropheModMod.queueServerWork(25, () -> {
			{
				boolean _setval = true;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ripsaw_effects = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.setDeltaMovement(new Vec3(((-1) * entity.getLookAngle().x), ((-0.5) * entity.getLookAngle().y), ((-1) * entity.getLookAngle().z)));
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = CatastropheModModEntities.RIPSAW_SAWBLADE.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY() + 1.6, entity.getZ()), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
				}
			}
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).intensity_timer + 2;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.intensity_timer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).screenshake_time + 40;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.screenshake_time = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			for (int index0 = 0; index0 < 6; index0++) {
				world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.SPARK.get()), x, (y + 1.6), z,
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
								+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getX()) * Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.4)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
								+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getY()) * Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.4)),
						(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
								+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getZ()) * Mth.nextInt(RandomSource.create(), (int) 0.1, (int) 0.4)));
			}
		});
		CatastropheModMod.queueServerWork(55, () -> {
			{
				boolean _setval = false;
				entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ripsaw_effects = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (itemstack.getItem() instanceof RipsawItem)
				itemstack.getOrCreateTag().putString("geckoAnim", "animation.ripsaw.reload");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.place")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lantern.place")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		});
	}
}
