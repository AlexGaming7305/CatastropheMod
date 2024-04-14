
package net.mcreator.catastrophemod.item;

import net.minecraft.network.chat.Component;

public class MusicDiscOutsideOfTheAtmosphereItem extends RecordItem {

	public MusicDiscOutsideOfTheAtmosphereItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("catastrophe_mod:outside_of_the_atmosphere")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 100);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

}
