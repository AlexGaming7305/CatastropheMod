
package net.mcreator.catastrophemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.catastrophemod.procedures.StarlitLacewingStaffRightclickedProcedure;

import java.util.List;

public class StarlitLacewingStaffItem extends Item {
	public StarlitLacewingStaffItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aRight-click: \u00A77Summons a \u00A7bStarlit Lacewing \u00A77to fight for you"));
		list.add(Component.literal("\u00A7aSneak + Right-click: \u00A77Despawns the nearest \u00A7bStarlit Lacewing"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		StarlitLacewingStaffRightclickedProcedure.execute(world, entity, ar.getObject());
		return ar;
	}
}
