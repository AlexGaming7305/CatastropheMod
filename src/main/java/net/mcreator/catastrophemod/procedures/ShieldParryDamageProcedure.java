package net.mcreator.catastrophemod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShieldParryDamageProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

private static void execute(
@Nullable Event event,
Entity entity
) {
if(
entity == null
) return ;
ItemStack shield_held = ItemStack.EMPTY;
if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) { shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem():ItemStack.EMPTY);}else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:shields")))) { shield_held = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY);}if (shield_held.getItem() == Items.SHIELD) {if (==false) {if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get(), shield_held) != 0) {}else{}if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal((+" parry damage")), false);}}if (shield_held.getItem() == CatastropheModModItems.NATURITE_SHIELD.get()) {if (==false) {if (EnchantmentHelper.getItemEnchantmentLevel(CatastropheModModEnchantments.COUNTERATTACK.get(), shield_held) != 0) {}else{}if (entity instanceof Player _player && !_player.level().isClientSide())
_player.displayClientMessage(Component.literal((+" parry damage")), false);}}
}
}
