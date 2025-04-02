
package net.mcreator.catastrophemod.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;

import net.mcreator.catastrophemod.procedures.FederalMagnumProjectileWhileProjectileFlyingTickProcedure;
import net.mcreator.catastrophemod.init.CatastropheModModItems;
import net.mcreator.catastrophemod.init.CatastropheModModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class FederalMagnumProjectileEntity extends AbstractArrow implements ItemSupplier {
	public static final ItemStack PROJECTILE_ITEM = new ItemStack(CatastropheModModItems.FEDERAL_MAGNUM.get());

	public FederalMagnumProjectileEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(CatastropheModModEntities.FEDERAL_MAGNUM_PROJECTILE.get(), world);
	}

	public FederalMagnumProjectileEntity(EntityType<? extends FederalMagnumProjectileEntity> type, Level world) {
		super(type, world);
	}

	public FederalMagnumProjectileEntity(EntityType<? extends FederalMagnumProjectileEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public FederalMagnumProjectileEntity(EntityType<? extends FederalMagnumProjectileEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected ItemStack getPickupItem() {
		return PROJECTILE_ITEM;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		FederalMagnumProjectileWhileProjectileFlyingTickProcedure.execute(this.level(), this);
		if (this.inGround)
			this.discard();
	}

	public static FederalMagnumProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
		return shoot(world, entity, source, 1f, 0, 0);
	}

	public static FederalMagnumProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		FederalMagnumProjectileEntity entityarrow = new FederalMagnumProjectileEntity(CatastropheModModEntities.FEDERAL_MAGNUM_PROJECTILE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		return entityarrow;
	}

	public static FederalMagnumProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
		FederalMagnumProjectileEntity entityarrow = new FederalMagnumProjectileEntity(CatastropheModModEntities.FEDERAL_MAGNUM_PROJECTILE.get(), entity, entity.level());
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(0);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(false);
		entity.level().addFreshEntity(entityarrow);
		return entityarrow;
	}
}
