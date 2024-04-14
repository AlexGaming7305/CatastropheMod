
package net.mcreator.catastrophemod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;

import javax.annotation.Nullable;

import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationState;

public class SilkMothEntity extends PathfinderMob implements GeoEntity {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SilkMothEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SilkMothEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SilkMothEntity.class, EntityDataSerializers.STRING);

	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";

	public SilkMothEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(CatastropheModModEntities.SILK_MOTH.get(), world);
	}

	public SilkMothEntity(EntityType<SilkMothEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);

		this.moveControl = new FlyingMoveControl(this, 10, true);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "mulberry_silk_moth");
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new RestrictSunGoal(this) {
			@Override
			public boolean canUse() {
				double x = SilkMothEntity.this.getX();
				double y = SilkMothEntity.this.getY();
				double z = SilkMothEntity.this.getZ();
				Entity entity = SilkMothEntity.this;
				Level world = SilkMothEntity.this.level();
				return super.canUse() &&

						SilkMothSleepConditionProcedure.execute(entity)

				;
			}
		});
		this.goalSelector.addGoal(2, new MoveBackToVillageGoal(this, 0.6, false) {
			@Override
			public boolean canUse() {
				double x = SilkMothEntity.this.getX();
				double y = SilkMothEntity.this.getY();
				double z = SilkMothEntity.this.getZ();
				Entity entity = SilkMothEntity.this;
				Level world = SilkMothEntity.this.level();
				return super.canUse() &&

						SilkMothSleepConditionProcedure.execute(entity)

				;
			}
		});
		this.goalSelector.addGoal(3, new TemptGoal(this, 3, Ingredient.of(Blocks.LANTERN.asItem()), false) {
			@Override
			public boolean canUse() {
				double x = SilkMothEntity.this.getX();
				double y = SilkMothEntity.this.getY();
				double z = SilkMothEntity.this.getZ();
				Entity entity = SilkMothEntity.this;
				Level world = SilkMothEntity.this.level();
				return super.canUse() &&

						SilkMothSleepConditionProcedure.execute(entity)

				;
			}
		});
		this.goalSelector.addGoal(4, new RandomStrollGoal(this, 2, 20) {

			@Override
			protected Vec3 getPosition() {
				RandomSource random = SilkMothEntity.this.getRandom();
				double dir_x = SilkMothEntity.this.getX() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_y = SilkMothEntity.this.getY() + ((random.nextFloat() * 2 - 1) * 16);
				double dir_z = SilkMothEntity.this.getZ() + ((random.nextFloat() * 2 - 1) * 16);
				return new Vec3(dir_x, dir_y, dir_z);
			}

			@Override
			public boolean canUse() {
				double x = SilkMothEntity.this.getX();
				double y = SilkMothEntity.this.getY();
				double z = SilkMothEntity.this.getZ();
				Entity entity = SilkMothEntity.this;
				Level world = SilkMothEntity.this.level();
				return super.canUse() &&

						SilkMothSleepConditionProcedure.execute(entity)

				;
			}

		});
		this.goalSelector.addGoal(5, new PanicGoal(this, 4));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = SilkMothEntity.this.getX();
				double y = SilkMothEntity.this.getY();
				double z = SilkMothEntity.this.getZ();
				Entity entity = SilkMothEntity.this;
				Level world = SilkMothEntity.this.level();
				return super.canUse() &&

						SilkMothSleepConditionProcedure.execute(entity)

				;
			}
		});
		this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, (float) 0.5) {
			@Override
			public boolean canUse() {
				double x = SilkMothEntity.this.getX();
				double y = SilkMothEntity.this.getY();
				double z = SilkMothEntity.this.getZ();
				Entity entity = SilkMothEntity.this;
				Level world = SilkMothEntity.this.level();
				return super.canUse() &&

						SilkMothSleepConditionProcedure.execute(entity)

				;
			}
		});

	}

	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {

		return false;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		SilkMothOnInitialEntitySpawnProcedure.execute(this);
		return retval;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Texture", this.getTexture());
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Texture"))
			this.setTexture(compound.getString("Texture"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level().isClientSide());

		super.mobInteract(sourceentity, hand);

		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		SilkMothRightClickedOnEntityProcedure.execute(world, x, y, z);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		SilkMothOnEntityTickUpdateProcedure.execute(this.level(), this);
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
		this.setNoGravity(true);
	}

	public static void init() {
		SpawnPlacements.register(CatastropheModModEntities.SILK_MOTH.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && world.getRawBrightness(pos, 0) > 8));

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.15);
		builder = builder.add(Attributes.MAX_HEALTH, 8);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.FLYING_SPEED, 0.15);

		return builder;
	}

	private PlayState movementPredicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop("animation.silk_moth.idle"));
		}
		return PlayState.STOP;
	}

	private PlayState procedurePredicate(AnimationState event) {
		if (!animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED) {
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("empty")) {
			return PlayState.STOP;
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(SilkMothEntity.RemovalReason.KILLED);
			this.dropExperience();

		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.add(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

}
