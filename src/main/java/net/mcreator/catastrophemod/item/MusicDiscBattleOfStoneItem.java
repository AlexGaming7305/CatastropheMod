
package net.mcreator.catastrophemod.item;

import net.minecraft.network.chat.Component;

public class MusicDiscBattleOfStoneItem extends RecordItem {

	public MusicDiscBattleOfStoneItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:battle_of_stone")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 100);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

}
