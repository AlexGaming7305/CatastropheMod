
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.catastrophemod.block.WitheringGrassBlock;
import net.mcreator.catastrophemod.block.TallWitheringGrassBlock;
import net.mcreator.catastrophemod.block.TallCalicoShroomBlock;
import net.mcreator.catastrophemod.block.ShroomiumOreBlock;
import net.mcreator.catastrophemod.block.SeaCrystalClusterBlock;
import net.mcreator.catastrophemod.block.SeaCrystalBlockBlock;
import net.mcreator.catastrophemod.block.RosxiteOreBlock;
import net.mcreator.catastrophemod.block.PolishedCharredStoneStairsBlock;
import net.mcreator.catastrophemod.block.PolishedCharredStoneSlabBlock;
import net.mcreator.catastrophemod.block.PolishedCharredStoneBlock;
import net.mcreator.catastrophemod.block.NatureiteOreBlock;
import net.mcreator.catastrophemod.block.NatureiteBlockBlock;
import net.mcreator.catastrophemod.block.MoltenCharredBricksStairsBlock;
import net.mcreator.catastrophemod.block.MoltenCharredBricksSlabBlock;
import net.mcreator.catastrophemod.block.MoltenCharredBricksBlock;
import net.mcreator.catastrophemod.block.ManaRosePlantBlock;
import net.mcreator.catastrophemod.block.FlowerOfAfflictionBlock;
import net.mcreator.catastrophemod.block.DriedRosxiteOreBlock;
import net.mcreator.catastrophemod.block.DecayingSpineBlock;
import net.mcreator.catastrophemod.block.DecayingShaleBlock;
import net.mcreator.catastrophemod.block.DecayingGrassBlock;
import net.mcreator.catastrophemod.block.CrimstoneOreBlock;
import net.mcreator.catastrophemod.block.CrackedCharredBricksBlock;
import net.mcreator.catastrophemod.block.ChiseledCharredBricksBlock;
import net.mcreator.catastrophemod.block.CharredTilesStairsBlock;
import net.mcreator.catastrophemod.block.CharredTilesSlabBlock;
import net.mcreator.catastrophemod.block.CharredTilesBlock;
import net.mcreator.catastrophemod.block.CharredStoneStairsBlock;
import net.mcreator.catastrophemod.block.CharredStoneSlabBlock;
import net.mcreator.catastrophemod.block.CharredStoneBlock;
import net.mcreator.catastrophemod.block.CharredBricksStairsBlock;
import net.mcreator.catastrophemod.block.CharredBricksSlabBlock;
import net.mcreator.catastrophemod.block.CharredBricksBlock;
import net.mcreator.catastrophemod.block.CalicoShroomBlock;
import net.mcreator.catastrophemod.block.CalicoMushroomBlock;
import net.mcreator.catastrophemod.CatastropheModMod;

public class CatastropheModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, CatastropheModMod.MODID);
	public static final RegistryObject<Block> CALICO_MUSHROOM = REGISTRY.register("calico_mushroom", () -> new CalicoMushroomBlock());
	public static final RegistryObject<Block> NATUREITE_ORE = REGISTRY.register("natureite_ore", () -> new NatureiteOreBlock());
	public static final RegistryObject<Block> NATUREITE_BLOCK = REGISTRY.register("natureite_block", () -> new NatureiteBlockBlock());
	public static final RegistryObject<Block> DRIED_ROSXITE_ORE = REGISTRY.register("dried_rosxite_ore", () -> new DriedRosxiteOreBlock());
	public static final RegistryObject<Block> ROSXITE_ORE = REGISTRY.register("rosxite_ore", () -> new RosxiteOreBlock());
	public static final RegistryObject<Block> CALICO_SHROOM = REGISTRY.register("calico_shroom", () -> new CalicoShroomBlock());
	public static final RegistryObject<Block> TALL_CALICO_SHROOM = REGISTRY.register("tall_calico_shroom", () -> new TallCalicoShroomBlock());
	public static final RegistryObject<Block> SHROOMIUM_ORE = REGISTRY.register("shroomium_ore", () -> new ShroomiumOreBlock());
	public static final RegistryObject<Block> MANA_ROSE_PLANT = REGISTRY.register("mana_rose_plant", () -> new ManaRosePlantBlock());
	public static final RegistryObject<Block> CHISELED_CHARRED_BRICKS = REGISTRY.register("chiseled_charred_bricks", () -> new ChiseledCharredBricksBlock());
	public static final RegistryObject<Block> CHARRED_BRICKS = REGISTRY.register("charred_bricks", () -> new CharredBricksBlock());
	public static final RegistryObject<Block> CRACKED_CHARRED_BRICKS = REGISTRY.register("cracked_charred_bricks", () -> new CrackedCharredBricksBlock());
	public static final RegistryObject<Block> POLISHED_CHARRED_STONE = REGISTRY.register("polished_charred_stone", () -> new PolishedCharredStoneBlock());
	public static final RegistryObject<Block> CHARRED_TILES = REGISTRY.register("charred_tiles", () -> new CharredTilesBlock());
	public static final RegistryObject<Block> CHARRED_STONE = REGISTRY.register("charred_stone", () -> new CharredStoneBlock());
	public static final RegistryObject<Block> CHARRED_STONE_SLAB = REGISTRY.register("charred_stone_slab", () -> new CharredStoneSlabBlock());
	public static final RegistryObject<Block> CHARRED_STONE_STAIRS = REGISTRY.register("charred_stone_stairs", () -> new CharredStoneStairsBlock());
	public static final RegistryObject<Block> CHARRED_BRICKS_SLAB = REGISTRY.register("charred_bricks_slab", () -> new CharredBricksSlabBlock());
	public static final RegistryObject<Block> CHARRED_BRICKS_STAIRS = REGISTRY.register("charred_bricks_stairs", () -> new CharredBricksStairsBlock());
	public static final RegistryObject<Block> CHARRED_TILES_SLAB = REGISTRY.register("charred_tiles_slab", () -> new CharredTilesSlabBlock());
	public static final RegistryObject<Block> CHARRED_TILES_STAIRS = REGISTRY.register("charred_tiles_stairs", () -> new CharredTilesStairsBlock());
	public static final RegistryObject<Block> DECAYING_GRASS = REGISTRY.register("decaying_grass", () -> new DecayingGrassBlock());
	public static final RegistryObject<Block> DECAYING_SHALE = REGISTRY.register("decaying_shale", () -> new DecayingShaleBlock());
	public static final RegistryObject<Block> DECAYING_SPINE = REGISTRY.register("decaying_spine", () -> new DecayingSpineBlock());
	public static final RegistryObject<Block> FLOWER_OF_AFFLICTION = REGISTRY.register("flower_of_affliction", () -> new FlowerOfAfflictionBlock());
	public static final RegistryObject<Block> WITHERING_GRASS = REGISTRY.register("withering_grass", () -> new WitheringGrassBlock());
	public static final RegistryObject<Block> TALL_WITHERING_GRASS = REGISTRY.register("tall_withering_grass", () -> new TallWitheringGrassBlock());
	public static final RegistryObject<Block> MOLTEN_CHARRED_BRICKS = REGISTRY.register("molten_charred_bricks", () -> new MoltenCharredBricksBlock());
	public static final RegistryObject<Block> POLISHED_CHARRED_STONE_STAIRS = REGISTRY.register("polished_charred_stone_stairs", () -> new PolishedCharredStoneStairsBlock());
	public static final RegistryObject<Block> POLISHED_CHARRED_STONE_SLAB = REGISTRY.register("polished_charred_stone_slab", () -> new PolishedCharredStoneSlabBlock());
	public static final RegistryObject<Block> MOLTEN_CHARRED_BRICKS_STAIRS = REGISTRY.register("molten_charred_bricks_stairs", () -> new MoltenCharredBricksStairsBlock());
	public static final RegistryObject<Block> MOLTEN_CHARRED_BRICKS_SLAB = REGISTRY.register("molten_charred_bricks_slab", () -> new MoltenCharredBricksSlabBlock());
	public static final RegistryObject<Block> CRIMSTONE_ORE = REGISTRY.register("crimstone_ore", () -> new CrimstoneOreBlock());
	public static final RegistryObject<Block> SEA_CRYSTAL_BLOCK = REGISTRY.register("sea_crystal_block", () -> new SeaCrystalBlockBlock());
	public static final RegistryObject<Block> SEA_CRYSTAL_CLUSTER = REGISTRY.register("sea_crystal_cluster", () -> new SeaCrystalClusterBlock());
}
