
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.catastrophemod.CatastropheModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatastropheModModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CatastropheModMod.MODID);
	public static final RegistryObject<CreativeModeTab> MAGE = REGISTRY.register("mage",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.catastrophe_mod.mage")).icon(() -> new ItemStack(CatastropheModModItems.BLIZZARD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CatastropheModModItems.SPELL_OF_FLAMES.get());
				tabData.accept(CatastropheModModItems.SPELLOF_POISON.get());
				tabData.accept(CatastropheModModItems.SPELL_OF_PHANTOMS.get());
				tabData.accept(CatastropheModModItems.SHROOMIUM_HELMET.get());
				tabData.accept(CatastropheModModItems.SHROOMIUM_CHESTPLATE.get());
				tabData.accept(CatastropheModModItems.SHROOMIUM_LEGGINGS.get());
				tabData.accept(CatastropheModModItems.SHROOMIUM_BOOTS.get());
				tabData.accept(CatastropheModModItems.NAUTILUS_HELMET.get());
				tabData.accept(CatastropheModModItems.NAUTILUS_CHESTPLATE.get());
				tabData.accept(CatastropheModModItems.NAUTILUS_LEGGINGS.get());
				tabData.accept(CatastropheModModItems.NAUTILUS_BOOTS.get());
				tabData.accept(CatastropheModModItems.RIPTIDE.get());
				tabData.accept(CatastropheModModItems.CRIMSON_RAY.get());
				tabData.accept(CatastropheModModItems.SPORE_STAFF.get());
				tabData.accept(CatastropheModModItems.SHADOWFLAME_SCEPTER.get());
				tabData.accept(CatastropheModModItems.BLOSSOM_FLORA.get());
				tabData.accept(CatastropheModModItems.EARTHBOUND_STAFF.get());
				tabData.accept(CatastropheModModItems.CURSED_ARMOR_HELMET.get());
				tabData.accept(CatastropheModModItems.CURSED_ARMOR_CHESTPLATE.get());
				tabData.accept(CatastropheModModItems.CURSED_ARMOR_LEGGINGS.get());
				tabData.accept(CatastropheModModItems.CURSED_ARMOR_BOOTS.get());
				tabData.accept(CatastropheModModItems.BLIZZARD.get());
				tabData.accept(CatastropheModModItems.ACCURSED_TOME.get());
				tabData.accept(CatastropheModModItems.HAUNTED_MIRROR.get());
				tabData.accept(CatastropheModModItems.FORCE_MISSILES.get());
				tabData.accept(CatastropheModModItems.THUNDERSTRIKE.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> MELEE = REGISTRY.register("melee",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.catastrophe_mod.melee")).icon(() -> new ItemStack(CatastropheModModItems.ELECTRIFIED_SWORD.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CatastropheModModItems.REINFORCED_IRON_ARMOR_HELMET.get());
				tabData.accept(CatastropheModModItems.REINFORCED_IRON_ARMOR_CHESTPLATE.get());
				tabData.accept(CatastropheModModItems.REINFORCED_IRON_ARMOR_LEGGINGS.get());
				tabData.accept(CatastropheModModItems.REINFORCED_IRON_ARMOR_BOOTS.get());
				tabData.accept(CatastropheModModItems.ICE_SWORD.get());
				tabData.accept(CatastropheModModItems.NATUREITE_SWORD.get());
				tabData.accept(CatastropheModModItems.CACTUS_CUTTER.get());
				tabData.accept(CatastropheModModItems.WOODEN_SPEAR.get());
				tabData.accept(CatastropheModModItems.STONE_SPEAR.get());
				tabData.accept(CatastropheModModItems.IRON_SPEAR.get());
				tabData.accept(CatastropheModModItems.GOLDEN_SPEAR.get());
				tabData.accept(CatastropheModModItems.DIAMOND_SPEAR.get());
				tabData.accept(CatastropheModModItems.NETHERITE_SPEAR.get());
				tabData.accept(CatastropheModModItems.NATURITE_SPEAR.get());
				tabData.accept(CatastropheModModItems.SPEAR_OF_NATURE.get());
				tabData.accept(CatastropheModModItems.ELECTRIFIED_SPEAR.get());
				tabData.accept(CatastropheModModItems.SEA_SPEAR.get());
				tabData.accept(CatastropheModModItems.THORN_SWORD.get());
				tabData.accept(CatastropheModModItems.NATURE_DEFENDER.get());
				tabData.accept(CatastropheModModItems.FIREBRAND.get());
				tabData.accept(CatastropheModModItems.GRAVE_DIGGER.get());
				tabData.accept(CatastropheModModItems.REINFORCED_AXE.get());
				tabData.accept(CatastropheModModItems.SPORESPLOSION.get());
				tabData.accept(CatastropheModModItems.SHADOWFLAME_BURSTER.get());
				tabData.accept(CatastropheModModItems.ICE_SPEAR.get());
				tabData.accept(CatastropheModModItems.HELLBANE.get());
				tabData.accept(CatastropheModModItems.EARTH_BREAKER.get());
				tabData.accept(CatastropheModModItems.NIGHTFALLS_DEMISE.get());
				tabData.accept(CatastropheModModItems.DIAMOND_DETONATION.get());
				tabData.accept(CatastropheModModItems.BRASS_COLORED_SHOVEL.get());
				tabData.accept(CatastropheModModItems.BRASS_COLORED_PICKAXE.get());
				tabData.accept(CatastropheModModItems.WOODEN_KATANA.get());
				tabData.accept(CatastropheModModItems.ELECTRIFIED_SWORD.get());
				tabData.accept(CatastropheModModItems.CRYSTALLINE_EDGE.get());
				tabData.accept(CatastropheModModItems.ELECTRIFIED_ARMOR_HELMET.get());
				tabData.accept(CatastropheModModItems.ELECTRIFIED_ARMOR_CHESTPLATE.get());
				tabData.accept(CatastropheModModItems.ELECTRIFIED_ARMOR_LEGGINGS.get());
				tabData.accept(CatastropheModModItems.ELECTRIFIED_ARMOR_BOOTS.get());
				tabData.accept(CatastropheModModItems.WIRESAW.get());
				tabData.accept(CatastropheModModItems.RUSTY_SCISSORS.get());
				tabData.accept(CatastropheModModItems.TIDE_SLASHER.get());
				tabData.accept(CatastropheModModItems.ANCIENT_CLAYMORE.get());
				tabData.accept(CatastropheModModItems.CRYSTAL_PIERCER.get());
				tabData.accept(CatastropheModModItems.CRIMSON_SABER.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> DARK_MAGIC = REGISTRY.register("dark_magic",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.catastrophe_mod.dark_magic")).icon(() -> new ItemStack(CatastropheModModItems.STARLIT_LACEWING_STAFF.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CatastropheModModItems.LIGHTNING_BLADE_STAFF.get());
				tabData.accept(CatastropheModModItems.STARLIT_LACEWING_STAFF.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> BOSS_SUMMONS = REGISTRY.register("boss_summons",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.catastrophe_mod.boss_summons")).icon(() -> new ItemStack(CatastropheModModItems.COPPER_TOKEN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CatastropheModModItems.POISONED_IRON_HEART.get());
				tabData.accept(CatastropheModModItems.COPPER_TOKEN.get());
				tabData.accept(CatastropheModModItems.SHADOWFLAME_SKULL.get());
				tabData.accept(CatastropheModModItems.EARTHBOUND_CORE.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> CLASSLESS_ITEMS = REGISTRY.register("classless_items",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.catastrophe_mod.classless_items")).icon(() -> new ItemStack(CatastropheModModItems.NATURES_BLESSING_CHESTPLATE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CatastropheModModItems.NATUREITE_ARMOR_HELMET.get());
				tabData.accept(CatastropheModModItems.NATUREITE_ARMOR_CHESTPLATE.get());
				tabData.accept(CatastropheModModItems.NATUREITE_ARMOR_LEGGINGS.get());
				tabData.accept(CatastropheModModItems.NATUREITE_ARMOR_BOOTS.get());
				tabData.accept(CatastropheModModItems.NATURES_BLESSING_HELMET.get());
				tabData.accept(CatastropheModModItems.NATURES_BLESSING_CHESTPLATE.get());
				tabData.accept(CatastropheModModItems.NATURES_BLESSING_LEGGINGS.get());
				tabData.accept(CatastropheModModItems.NATURES_BLESSING_BOOTS.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> BULLETS = REGISTRY.register("bullets",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.catastrophe_mod.bullets")).icon(() -> new ItemStack(CatastropheModModItems.SEA_BOW.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CatastropheModModItems.STORM_BOW.get());
				tabData.accept(CatastropheModModItems.NATURES_STRIKE.get());
				tabData.accept(CatastropheModModItems.THORN_BOW.get());
				tabData.accept(CatastropheModModItems.NATURITE_BOW.get());
				tabData.accept(CatastropheModModItems.SEA_BOW.get());
				tabData.accept(CatastropheModModItems.HUNTER_HELMET.get());
				tabData.accept(CatastropheModModItems.HUNTER_CHESTPLATE.get());
				tabData.accept(CatastropheModModItems.HUNTER_LEGGINGS.get());
				tabData.accept(CatastropheModModItems.HUNTER_BOOTS.get());
				tabData.accept(CatastropheModModItems.KNIFE_OF_PROFICIENCY.get());
				tabData.accept(CatastropheModModItems.CRYSTAL_ROUND.get());
				tabData.accept(CatastropheModModItems.ELECTRIFIED_ROUND.get());
				tabData.accept(CatastropheModModItems.VENOMOUS_ROUND.get());
				tabData.accept(CatastropheModModItems.SHADOWFLAME_WHISPER.get());
				tabData.accept(CatastropheModModItems.ICE_BOW.get());
				tabData.accept(CatastropheModModItems.SHROOM_BOW.get());
				tabData.accept(CatastropheModModItems.CRYSTAL_BOW.get());
				tabData.accept(CatastropheModModItems.EARTH_SHATTERER.get());
				tabData.accept(CatastropheModModItems.VEIN_STRIKER.get());
				tabData.accept(CatastropheModModItems.FLAMESTRIKE.get());
				tabData.accept(CatastropheModModItems.RIPSAW.get());
				tabData.accept(CatastropheModModItems.STORM_ARROW.get());
				tabData.accept(CatastropheModModItems.RUSTGUN.get());
				tabData.accept(CatastropheModModItems.HUNTSMAN_KNIFE.get());
				tabData.accept(CatastropheModModItems.WOODEN_BOW.get());
				tabData.accept(CatastropheModModItems.ACCURSED_ARROW.get());
				tabData.accept(CatastropheModModItems.NAILGUN.get());
				tabData.accept(CatastropheModModItems.SCRAP_ROUND.get());
				tabData.accept(CatastropheModModItems.COPPER_ROUND.get());
				tabData.accept(CatastropheModModItems.DOUBLE_BARRELED_SHOTGUN.get());
				tabData.accept(CatastropheModModItems.SAWED_OFF_SHOTGUN.get());
				tabData.accept(CatastropheModModItems.BUCKSHOT.get());
				tabData.accept(CatastropheModModItems.IRON_PELLETS.get());
				tabData.accept(CatastropheModModItems.RAGING_HUNTER.get());
				tabData.accept(CatastropheModModItems.FEDERAL_MAGNUM.get());
			}).withSearchBar().build());
	public static final RegistryObject<CreativeModeTab> RELICS = REGISTRY.register("relics",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.catastrophe_mod.relics")).icon(() -> new ItemStack(CatastropheModModItems.RUNNING_BOOTS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CatastropheModModItems.RUNNING_BOOTS.get());
				tabData.accept(CatastropheModModItems.BURNACE.get());
				tabData.accept(CatastropheModModItems.ROTTEN_HEART.get());
				tabData.accept(CatastropheModModItems.STORM_CATALYST.get());
				tabData.accept(CatastropheModModItems.SPIRIT_IN_A_BOTTLE.get());
				tabData.accept(CatastropheModModItems.SCAFFOLDING_KIT.get());
				tabData.accept(CatastropheModModItems.MANA_ROSE.get());
				tabData.accept(CatastropheModModItems.FOREST_TOTEM.get());
				tabData.accept(CatastropheModModItems.ENERGY_COIL.get());
				tabData.accept(CatastropheModModItems.AGILITY_SCARF.get());
				tabData.accept(CatastropheModModItems.HEART_LOCKET.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(CatastropheModModBlocks.CALICO_MUSHROOM.get().asItem());
			tabData.accept(CatastropheModModBlocks.NATUREITE_ORE.get().asItem());
			tabData.accept(CatastropheModModBlocks.NATUREITE_BLOCK.get().asItem());
			tabData.accept(CatastropheModModBlocks.DRIED_ROSXITE_ORE.get().asItem());
			tabData.accept(CatastropheModModBlocks.ROSXITE_ORE.get().asItem());
			tabData.accept(CatastropheModModBlocks.SHROOMIUM_ORE.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHISELED_CHARRED_BRICKS.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_BRICKS.get().asItem());
			tabData.accept(CatastropheModModBlocks.CRACKED_CHARRED_BRICKS.get().asItem());
			tabData.accept(CatastropheModModBlocks.POLISHED_CHARRED_STONE.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_TILES.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_STONE.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_STONE_SLAB.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_STONE_STAIRS.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_BRICKS_SLAB.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_BRICKS_STAIRS.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_TILES_SLAB.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHARRED_TILES_STAIRS.get().asItem());
			tabData.accept(CatastropheModModBlocks.DECAYING_GRASS.get().asItem());
			tabData.accept(CatastropheModModBlocks.DECAYING_SHALE.get().asItem());
			tabData.accept(CatastropheModModBlocks.DECAYING_SPINE.get().asItem());
			tabData.accept(CatastropheModModBlocks.MOLTEN_CHARRED_BRICKS.get().asItem());
			tabData.accept(CatastropheModModBlocks.POLISHED_CHARRED_STONE_STAIRS.get().asItem());
			tabData.accept(CatastropheModModBlocks.POLISHED_CHARRED_STONE_SLAB.get().asItem());
			tabData.accept(CatastropheModModBlocks.MOLTEN_CHARRED_BRICKS_STAIRS.get().asItem());
			tabData.accept(CatastropheModModBlocks.MOLTEN_CHARRED_BRICKS_SLAB.get().asItem());
			tabData.accept(CatastropheModModBlocks.SEA_CRYSTAL_CLUSTER.get().asItem());
			tabData.accept(CatastropheModModBlocks.DEPTHSTONE.get().asItem());
			tabData.accept(CatastropheModModBlocks.DEPTHSTONE_BRICKS.get().asItem());
			tabData.accept(CatastropheModModBlocks.CRACKED_DEPTHSTONE_BRICKS.get().asItem());
			tabData.accept(CatastropheModModBlocks.CHISELED_DEPTHSTONE_BRICKS.get().asItem());
			tabData.accept(CatastropheModModBlocks.DEPTHSTONE_SLAB.get().asItem());
			tabData.accept(CatastropheModModBlocks.DEPTHSTONE_STAIRS.get().asItem());
			tabData.accept(CatastropheModModBlocks.DEPTHSTONE_BRICKS_SLAB.get().asItem());
			tabData.accept(CatastropheModModBlocks.DEPTHSTONE_BRICKS_STAIRS.get().asItem());
			tabData.accept(CatastropheModModBlocks.ELECTRIFIED_DIODE.get().asItem());
			tabData.accept(CatastropheModModBlocks.ELECTRIFIED_CHAIN.get().asItem());
			tabData.accept(CatastropheModModBlocks.CORRODED_GRATE.get().asItem());
			tabData.accept(CatastropheModModBlocks.STEEL_PLATING.get().asItem());
			tabData.accept(CatastropheModModBlocks.CORRODED_STEEL_PLATING.get().asItem());
			tabData.accept(CatastropheModModBlocks.STEEL_PANEL.get().asItem());
			tabData.accept(CatastropheModModBlocks.CORRODED_STEEL_PANEL.get().asItem());
			tabData.accept(CatastropheModModBlocks.REINFORCED_CONCRETE.get().asItem());
			tabData.accept(CatastropheModModBlocks.CORRODED_REINFORCED_CONCRETE.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(CatastropheModModBlocks.OIL.get().asItem());
		}

		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(CatastropheModModItems.NATURITE_SHIELD.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(CatastropheModModItems.COPPER_SHARD.get());
			tabData.accept(CatastropheModModItems.POISONED_VINES.get());
			tabData.accept(CatastropheModModItems.SPELL_TOME.get());
			tabData.accept(CatastropheModModItems.BACK_PACK.get());
			tabData.accept(CatastropheModModItems.NATUREITE_INGOT.get());
			tabData.accept(CatastropheModModItems.MINERAL_WRAITH_LOOT_BUNDLE.get());
			tabData.accept(CatastropheModModItems.THORN_INFESTED_ARMOR_LOOT_BUNDLE.get());
			tabData.accept(CatastropheModModItems.ROSXITE_INGOT.get());
			tabData.accept(CatastropheModModItems.RAW_NATUREITE.get());
			tabData.accept(CatastropheModModItems.MUSIC_DISC_STRIKE_YOU_DOWN.get());
			tabData.accept(CatastropheModModItems.REINFORCED_PLATES.get());
			tabData.accept(CatastropheModModItems.RAW_ROSXITE.get());
			tabData.accept(CatastropheModModItems.MUSIC_DISC_PROLIFERATING_MUSHROOMS.get());
			tabData.accept(CatastropheModModItems.MUSIC_DISC_NETHERS_FURY.get());
			tabData.accept(CatastropheModModItems.RAW_SHROOMIUM.get());
			tabData.accept(CatastropheModModItems.SHROOMIUM_INGOT.get());
			tabData.accept(CatastropheModModItems.HERMIT_CRAB_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.TEAR_OF_THE_SEA.get());
			tabData.accept(CatastropheModModItems.SPORE_ZOMBIE_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.CALICO_STAG_BEETLE_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.SHADE_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.MUSIC_DISC_VINES_OF_VENOM.get());
			tabData.accept(CatastropheModModItems.CHARRED_SKELETON_GUARD_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.SEPULCHER_LOOT_BUNDLE.get());
			tabData.accept(CatastropheModModItems.INFERNAL_FRAGMENT.get());
			tabData.accept(CatastropheModModItems.SHADOWFLAME_FRAGMENT.get());
			tabData.accept(CatastropheModModItems.BLAZING_PHOENIX_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.EARTHBOUND_WRAITH_LOOT_BUNDLE.get());
			tabData.accept(CatastropheModModItems.THUNDER_STAR.get());
			tabData.accept(CatastropheModModItems.WITHER_SKULL_FRAGMENT.get());
			tabData.accept(CatastropheModModItems.MUSIC_DISC_BATTLE_OF_STONE.get());
			tabData.accept(CatastropheModModItems.MUSIC_DISC_SPARK_OF_A_SHADOW.get());
			tabData.accept(CatastropheModModItems.MANA_STAR.get());
			tabData.accept(CatastropheModModItems.CURSED_CLOTH.get());
			tabData.accept(CatastropheModModItems.SILK_MOTH_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.ATLANTIC_SEA_NETTLE_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.ANGLERFISH_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.STARLIT_LACEWING_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.GIANT_ISOPOD_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.VOLTBLADE_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.ARC_STRIKER_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.SURGE_BREAKER_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.ACCURSED_WITCH_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.NIGHT_REAPER_SPAWN_EGG.get());
			tabData.accept(CatastropheModModItems.MUSIC_DISC_FAILED_INCARNATIONS.get());
			tabData.accept(CatastropheModModItems.MUSIC_DISC_ALTAR_OF_THE_INCARNATE.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(CatastropheModModItems.RUSTY_COGWHEEL.get());
			tabData.accept(CatastropheModModItems.TWIG.get());
			tabData.accept(CatastropheModModItems.SEA_CRYSTAL_GEODE.get());
			tabData.accept(CatastropheModModItems.ATLANTIC_SEA_NETTLE_ITEM.get());
			tabData.accept(CatastropheModModItems.GIANT_ISOPOD_SCALE.get());
			tabData.accept(CatastropheModModItems.FORGE_KEY.get());
			tabData.accept(CatastropheModModItems.GASOLINE_CANISTER.get());
			tabData.accept(CatastropheModModItems.FERTILIZER.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(CatastropheModModItems.NATUREITE_PICKAXE.get());
			tabData.accept(CatastropheModModItems.NATUREITE_AXE.get());
			tabData.accept(CatastropheModModItems.NATUREITE_SHOVEL.get());
			tabData.accept(CatastropheModModItems.NATUREITE_HOE.get());
			tabData.accept(CatastropheModModItems.SEA_PICKAXE.get());
			tabData.accept(CatastropheModModItems.SEA_AXE.get());
			tabData.accept(CatastropheModModItems.SEA_SHOVEL.get());
			tabData.accept(CatastropheModModItems.SEA_HOE.get());
			tabData.accept(CatastropheModModItems.ROD_OF_TELEPORTATION.get());
			tabData.accept(CatastropheModModItems.DYNAMITE.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(CatastropheModModItems.NATUREITE_APPLE.get());
			tabData.accept(CatastropheModModItems.CALICO_MUSHROOM_STEW.get());
			tabData.accept(CatastropheModModItems.PURIFIED_CALICO_MUSHROOM_STEW.get());
			tabData.accept(CatastropheModModItems.LESSER_MANA_POTION.get());
			tabData.accept(CatastropheModModItems.MANA_POTION.get());
		}

		if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(CatastropheModModBlocks.CALICO_SHROOM.get().asItem());
			tabData.accept(CatastropheModModBlocks.TALL_CALICO_SHROOM.get().asItem());
			tabData.accept(CatastropheModModBlocks.FLOWER_OF_AFFLICTION.get().asItem());
			tabData.accept(CatastropheModModBlocks.WITHERING_GRASS.get().asItem());
			tabData.accept(CatastropheModModBlocks.TALL_WITHERING_GRASS.get().asItem());
		}
	}
}
