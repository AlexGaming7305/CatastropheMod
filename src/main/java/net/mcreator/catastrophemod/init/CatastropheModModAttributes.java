/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

import net.mcreator.catastrophemod.CatastropheModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatastropheModModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, CatastropheModMod.MODID);
	public static final RegistryObject<Attribute> MELEEDAMAGE = ATTRIBUTES.register("melee_damage", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".melee_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> SWORDDAMAGE = ATTRIBUTES.register("sword_damage", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".sword_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> AXEDAMAGE = ATTRIBUTES.register("axe_damage", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".axe_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> SPEARDAMAGE = ATTRIBUTES.register("spear_damage", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".spear_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> RANGEDDAMAGE = ATTRIBUTES.register("ranged_damage", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".ranged_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> THROWINGKNIFEDAMAGE = ATTRIBUTES.register("throwing_knife_damage", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".throwing_knife_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> MAGICDAMAGE = ATTRIBUTES.register("magic_damage", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".magic_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> SUMMONERDAMAGE = ATTRIBUTES.register("summoner_damage", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".summoner_damage", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> ARMORPENETRATION = ATTRIBUTES.register("armor_penetration", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".armor_penetration", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> DAMAGEREDUCTION = ATTRIBUTES.register("damage_reduction", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".damage_reduction", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> MAXMANA = ATTRIBUTES.register("max_mana", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".max_mana", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> MANAREGENERATION = ATTRIBUTES.register("mana_regeneration", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".mana_regeneration", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> MANAUSAGEREDUCTION = ATTRIBUTES.register("mana_usage_reduction", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".mana_usage_reduction", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> MINIONSLOTS = ATTRIBUTES.register("minion_slots", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".minion_slots", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> THROWINGSPEED = ATTRIBUTES.register("throwing_speed", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".throwing_speed", 0, 0, 0)).setSyncable(true));
	public static final RegistryObject<Attribute> CASTINGSPEED = ATTRIBUTES.register("casting_speed", () -> (new RangedAttribute("attribute." + CatastropheModMod.MODID + ".casting_speed", 0, 0, 0)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, MELEEDAMAGE.get());
		event.add(EntityType.PLAYER, SWORDDAMAGE.get());
		event.add(EntityType.PLAYER, AXEDAMAGE.get());
		event.add(EntityType.PLAYER, SPEARDAMAGE.get());
		event.add(EntityType.PLAYER, RANGEDDAMAGE.get());
		event.add(EntityType.PLAYER, THROWINGKNIFEDAMAGE.get());
		event.add(EntityType.PLAYER, MAGICDAMAGE.get());
		event.add(EntityType.PLAYER, SUMMONERDAMAGE.get());
		event.add(EntityType.PLAYER, ARMORPENETRATION.get());
		event.add(EntityType.PLAYER, DAMAGEREDUCTION.get());
		event.add(EntityType.PLAYER, MAXMANA.get());
		event.add(EntityType.PLAYER, MANAREGENERATION.get());
		event.add(EntityType.PLAYER, MANAUSAGEREDUCTION.get());
		event.add(EntityType.PLAYER, MINIONSLOTS.get());
		event.add(EntityType.PLAYER, THROWINGSPEED.get());
		event.add(EntityType.PLAYER, CASTINGSPEED.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(MAXMANA.get()).setBaseValue(oldP.getAttribute(MAXMANA.get()).getBaseValue());
			newP.getAttribute(MANAREGENERATION.get()).setBaseValue(oldP.getAttribute(MANAREGENERATION.get()).getBaseValue());
			newP.getAttribute(MINIONSLOTS.get()).setBaseValue(oldP.getAttribute(MINIONSLOTS.get()).getBaseValue());
		}
	}
}
