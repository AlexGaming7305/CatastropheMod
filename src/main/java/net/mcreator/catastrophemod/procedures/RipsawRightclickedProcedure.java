package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class RipsawRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack axe = ItemStack.EMPTY;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("catastrophe_mod", "player_animation"));
					if (animation != null && !animation.isActive()) {
						animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("catastrophe_mod", "basic_shoot_right"))));
					}
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if (world.isClientSide()) {
				if (entity instanceof AbstractClientPlayer player) {
					var animation = (ModifierLayer<IAnimation>) PlayerAnimationAccess.getPlayerAssociatedData(player).get(new ResourceLocation("catastrophe_mod", "player_animation"));
					if (animation != null && !animation.isActive()) {
						animation.setAnimation(new KeyframeAnimationPlayer(PlayerAnimationRegistry.getAnimation(new ResourceLocation("catastrophe_mod", "basic_shoot_left"))));
					}
				}
			}
		}
		{
			boolean _setval = true;
			entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ripsaw_effects = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = CatastropheModModEntities.RIPSAW_SAWBLADE.get().spawn(_level, BlockPos.containing(x, y + 1.6, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:ripsaw_shoot")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:ripsaw_shoot")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (itemstack.getItem() instanceof RipsawItem)
			itemstack.getOrCreateTag().putString("geckoAnim", "animation.ripsaw.shoot");
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(1, RandomSource.create(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		CatastropheModMod.queueServerWork(50, () -> {
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
		for (int index0 = 0; index0 < 2; index0++) {
			world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.SPARK.get()), x, (y + 1.6), z,
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getX()) * 0.1),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getY()) * 0.1),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getZ()) * 0.1));
			world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.SPARK.get()), x, (y + 1.6), z,
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getX()) * 0.2),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getY()) * 0.2),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getZ()) * 0.2));
			world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.SPARK.get()), x, (y + 1.6), z,
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getX()) * 0.3),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getY()) * 0.3),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getZ()) * 0.3));
			world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.SPARK.get()), x, (y + 1.6), z,
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getX()) * 0.4),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getY()) * 0.4),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getZ()) * 0.4));
			world.addParticle((SimpleParticleType) (CatastropheModModParticleTypes.SPARK.get()), x, (y + 1.6), z,
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getX()) * 0.5),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getY()) * 0.5),
					(((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(3)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
							+ Mth.nextInt(RandomSource.create(), -1, 2)) - entity.getZ()) * 0.5));
		}
	}
}
