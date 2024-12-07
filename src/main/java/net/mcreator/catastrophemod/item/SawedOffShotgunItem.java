
package net.mcreator.catastrophemod.item;

import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.ai.attributes.Attributes;

import javax.annotation.Nullable;

import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;

public class SawedOffShotgunItem extends Item implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public String animationprocedure = "empty";
	public static ItemDisplayContext transformType;

	public SawedOffShotgunItem() {
		super(new Item.Properties().durability(187).rarity(Rarity.COMMON));
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		super.initializeClient(consumer);
		consumer.accept(new IClientItemExtensions() {
			private final BlockEntityWithoutLevelRenderer renderer = new SawedOffShotgunItemRenderer();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return renderer;
			}

			private static final HumanoidModel.ArmPose SawedOffShotgunPose = HumanoidModel.ArmPose.create("SawedOffShotgun", false, (model, entity, arm) -> {
				if (arm == HumanoidArm.LEFT) {
					model.leftArm.xRot = 80F + model.head.xRot;
					model.leftArm.yRot = 0.01F + model.head.yRot;
				} else {
					model.rightArm.xRot = 80F + model.head.xRot;
					model.rightArm.yRot = 0.01F + model.head.yRot;
				}
			});

			@Override
			public HumanoidModel.ArmPose getArmPose(LivingEntity entityLiving, InteractionHand hand, ItemStack itemStack) {
				if (!itemStack.isEmpty()) {
					if (entityLiving.getUsedItemHand() == hand) {
						return SawedOffShotgunPose;
					}
				}
				return HumanoidModel.ArmPose.EMPTY;
			}

		});
	}

	public void getTransformType(ItemDisplayContext type) {
		this.transformType = type;
	}

	private PlayState idlePredicate(AnimationState event) {
		if (this.transformType != null ? true : false) {
			if (this.animationprocedure.equals("empty")) {
				event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.sawed_off_shotgun.idle"));
				return PlayState.CONTINUE;
			}
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationState event) {
		if (this.transformType != null ? true : false) {
			if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
				if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
					this.animationprocedure = "empty";
					event.getController().forceAnimationReset();
				}
			} else if (this.animationprocedure.equals("empty")) {
				return PlayState.STOP;
			}
		}
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		AnimationController procedureController = new AnimationController(this, "procedureController", 0, this::procedurePredicate);
		data.add(procedureController);
		AnimationController idleController = new AnimationController(this, "idleController", 0, this::idlePredicate);
		data.add(idleController);
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	@Override
	public int getEnchantmentValue() {
		return 14;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		SawedOffShotgunRightclickedProcedure.execute();
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			SawedOffShotgunItemInHandTickProcedure.execute(entity, itemstack);
		GunAmmoTypeResetProcedure.execute(itemstack);
	}

}
