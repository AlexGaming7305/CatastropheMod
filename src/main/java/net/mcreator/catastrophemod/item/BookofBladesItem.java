
package net.mcreator.catastrophemod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class BookofBladesItem extends Item {
	public BookofBladesItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7aRight-click: \u00A77Casts 2 enchanted swords that home into enemies \u00A7b(Costs 10 mana)"));
		list.add(Component.literal("\u00A7aSneak + Right-Click: \u00A77Summons an orbit of enchanted swords around you that damage nearby enemies \u00A7b(Costs 25 mana)"));
		list.add(Component.literal("\u00A77Your mana drains while the swords are active and they dissapear if you run out of mana"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		BookofBladesRightClickedInAirProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}