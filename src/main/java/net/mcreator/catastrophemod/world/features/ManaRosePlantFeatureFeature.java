
package net.mcreator.catastrophemod.world.features;

public class ManaRosePlantFeatureFeature extends RandomPatchFeature {
	public ManaRosePlantFeatureFeature() {
		super(RandomPatchConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<RandomPatchConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!ManaRosePlantAdditionalGenerationConditionProcedure.execute())
			return false;
		return super.place(context);
	}
}