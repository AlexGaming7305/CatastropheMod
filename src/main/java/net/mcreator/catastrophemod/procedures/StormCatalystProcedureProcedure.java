package net.mcreator.catastrophemod.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.catastrophemod.init.CatastropheModModMobEffects;
import net.mcreator.catastrophemod.init.CatastropheModModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StormCatalystProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double damage = 0;
		Entity projectile = null;
		if (sourceentity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(CatastropheModModItems.STORM_CATALYST.get(), lv).isPresent() : false) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:magic_weapons")))
					|| (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("catastrophe_mod:magic_weapons")))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(CatastropheModModMobEffects.ELECTRIFIED.get(), 40, 0));
			}
		}
	}
}
