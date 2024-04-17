
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

import net.mcreator.catastrophemod.procedures.StaffofVitalityRightclickedProcedure;

import java.util.List;

public class StaffofVitalityItem extends Item {
	public StaffofVitalityItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aRight-click: \u00A77Casts a healing orb \u00A7b(Costs 20 Mana)"));
		list.add(Component.literal("\u00A7aSneak + Right-click: \u00A77Casts an healing aura that heals players and passive mobs \u00A7b(Costs 40 Mana)"));
		list.add(Component.literal("\u00A77While the aura is active your mana is being drained and the aura will disappear if your mana runs out"));
		list.add(Component.literal("\u00A7aSneak + Right-click \u00A77again to despawn the aura"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		StaffofVitalityRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
