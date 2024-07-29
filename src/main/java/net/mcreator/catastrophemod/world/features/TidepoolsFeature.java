
package net.mcreator.catastrophemod.world.features;

import net.minecraft.world.level.levelgen.feature.configurations.SimpleRandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.SimpleRandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

import net.mcreator.catastrophemod.procedures.TidepoolsAdditionalGenerationConditionProcedure;

public class TidepoolsFeature extends SimpleRandomSelectorFeature {
	public TidepoolsFeature() {
		super(SimpleRandomFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<SimpleRandomFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!TidepoolsAdditionalGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}
