package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DriedRosxiteOreUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (CatastropheModModVariables.WorldVariables.get(world).Tia_Killed == true) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = CatastropheModModBlocks.ROSXITE_ORE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
	}
}
