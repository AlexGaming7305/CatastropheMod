package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class WiresawEffectsProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z
) {
if (==true) {if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, BlockPos.containing(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_is_sliced")),
SoundSource.PLAYERS, 1, (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1));
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:something_is_sliced")),
SoundSource.PLAYERS, 1, (float)Mth.nextDouble(RandomSource.create(), 0.9, 1.1), false);
}
}
}
}
}
