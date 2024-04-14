package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class SilkMothRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.HEART, x, y, z, 3, 0.2, 0.1, 0.2, 0);
		if (entity.getPersistentData().getBoolean("mulberry_silk_moth")) {
			if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).mulberry_silk_moth_pet == false) {
				{
					boolean _setval = true;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.mulberry_silk_moth_pet = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		} else if (entity.getPersistentData().getBoolean("luna_moth")) {
			if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).luna_moth_pet == false) {
				{
					boolean _setval = true;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.luna_moth_pet = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		} else if (entity.getPersistentData().getBoolean("cecropia_moth")) {
			if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).cecropia_moth_pet == false) {
				{
					boolean _setval = true;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.cecropia_moth_pet = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		} else if (entity.getPersistentData().getBoolean("polyphemus_moth")) {
			if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).polyphemus_moth_pet == false) {
				{
					boolean _setval = true;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.polyphemus_moth_pet = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		} else if (entity.getPersistentData().getBoolean("comet_moth")) {
			if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).comet_moth_pet == false) {
				{
					boolean _setval = true;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.comet_moth_pet = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		} else if (entity.getPersistentData().getBoolean("rosy_maple_moth")) {
			if ((sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).rosy_maple_moth_pet == false) {
				{
					boolean _setval = true;
					sourceentity.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.rosy_maple_moth_pet = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			}
		}
	}
}
