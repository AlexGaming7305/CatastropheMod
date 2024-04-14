package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DashOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Cursed_Armor_Phasing == true) {
			if ((entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).Cursed_Dash_Cooldown == false) {
				if (!world.getEntitiesOfClass(Monster.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY() + 0.5), (entity.getZ())), 15, 15, 15), e -> true).isEmpty()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:cursed_dash")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:cursed_dash")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 1), (entity.getLookAngle().y), (entity.getLookAngle().z * 1)));
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "");
						}
					}
					entity.invulnerableTime = 20;
					{
						boolean _setval = true;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Cursed_Dash_Cooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = true;
						entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Cursed_Dash_Contact = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					CatastropheModMod.queueServerWork(10, () -> {
						{
							boolean _setval = false;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Cursed_Dash_Contact = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
					CatastropheModMod.queueServerWork(60, () -> {
						{
							boolean _setval = false;
							entity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Cursed_Dash_Cooldown = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					});
				}
			}
		}
	}
}
