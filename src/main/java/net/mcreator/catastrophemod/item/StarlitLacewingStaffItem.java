
package net.mcreator.catastrophemod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class StarlitLacewingStaffItem extends Item {
	public StarlitLacewingStaffItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aRight-click: \u00A77Summons a \u00A76Starlit Lacewing \u00A77to fight for you"));
		list.add(Component.literal("\u00A7aSneak + Right-click: \u00A77Despawns the nearest \u00A76Starlit Lacewing"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		StarlitLacewingStaffRightclickedProcedure.execute();
		return ar;
	}
}