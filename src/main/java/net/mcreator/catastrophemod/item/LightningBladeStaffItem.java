
package net.mcreator.catastrophemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.procedures.LightningBladeStaffRightclickedProcedure;
import net.mcreator.catastrophemod.procedures.LightningBladeStaffEntitySwingsItemProcedure;

import java.util.List;

public class LightningBladeStaffItem extends Item {
	public LightningBladeStaffItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aRight-click: \u00A77Summons a \u00A7bLightning Blade \u00A77to fight for you."));
		list.add(Component.literal("\u00A7aSneak + Right-click: \u00A77Despawns the nearest \u00A7bLightning Blade"));
		list.add(Component.literal("\u00A7aSneak + Left-click: \u00A77Commands all \u00A7bLightning Blades \u00A77to slam down onto their target"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		LightningBladeStaffRightclickedProcedure.execute(world, entity, ar.getObject());
		return ar;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		LightningBladeStaffEntitySwingsItemProcedure.execute(entity.level(), entity, itemstack);
		return retval;
	}
}
