
package net.mcreator.catastrophemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.procedures.ElectrifiedSwordRightclickedProcedure;
import net.mcreator.catastrophemod.procedures.ElectrifiedSwordLivingEntityIsHitWithItemProcedure;
import net.mcreator.catastrophemod.init.CatastropheModModItems;

import java.util.List;

public class ElectrifiedSwordItem extends SwordItem {
	public ElectrifiedSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 230;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 1f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 12;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(CatastropheModModItems.COPPER_SHARD.get()));
			}
		}, 3, -2.4f, new Item.Properties());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77Hitting enemies charges up the blade up to three times"));
		list.add(Component.literal("\u00A77Inflicts \u00A7cElectrified \u00A77when fully charged"));
		list.add(Component.literal("\u00A7aRIght-click + When fully charged: \u00A77Throws the blade in the air which splits into electric sparks"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ElectrifiedSwordRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		ElectrifiedSwordLivingEntityIsHitWithItemProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}
}
