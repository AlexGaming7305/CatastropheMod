package net.mcreator.catastrophemod.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.catastrophemod.enchantment.WizardryEnchantment;
import net.mcreator.catastrophemod.CatastropheModMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatastropheModModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		CatastropheModMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		CatastropheModMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Mana = original.Mana;
			clone.ManaStart = original.ManaStart;
			clone.Maxmana = original.Maxmana;
			clone.SoulPower = original.SoulPower;
			clone.MaxSoulPower = original.MaxSoulPower;
			clone.double_jump_condition = original.double_jump_condition;
			clone.thunder_star = original.thunder_star;
			clone.mana_star_uses = original.mana_star_uses;
			clone.mulberry_silk_moth_pet = original.mulberry_silk_moth_pet;
			clone.luna_moth_pet = original.luna_moth_pet;
			clone.cecropia_moth_pet = original.cecropia_moth_pet;
			clone.polyphemus_moth_pet = original.polyphemus_moth_pet;
			clone.comet_moth_pet = original.comet_moth_pet;
			clone.rosy_maple_moth_pet = original.rosy_maple_moth_pet;
			clone.mana_cost_accursed_tome = original.mana_cost_accursed_tome;
			if (!event.isWasDeath()) {
				clone.crimsondagger = original.crimsondagger;
				clone.pocketshield = original.pocketshield;
				clone.acidtarantula = original.acidtarantula;
				clone.stormshield = original.stormshield;
				clone.woodenSpear = original.woodenSpear;
				clone.stoneSpear = original.stoneSpear;
				clone.ironSpear = original.ironSpear;
				clone.goldenSpear = original.goldenSpear;
				clone.diamondSpear = original.diamondSpear;
				clone.netheriteSpear = original.netheriteSpear;
				clone.naturiteSpear = original.naturiteSpear;
				clone.spearOfNature = original.spearOfNature;
				clone.electrifiedSpear = original.electrifiedSpear;
				clone.amethystSpear = original.amethystSpear;
				clone.moss_armor = original.moss_armor;
				clone.tungstenSpear = original.tungstenSpear;
				clone.seaSpear = original.seaSpear;
				clone.seaspeardashdamage = original.seaspeardashdamage;
				clone.nautilus_armor = original.nautilus_armor;
				clone.nautilus_armor_submerged = original.nautilus_armor_submerged;
				clone.oceanic_artifact_submerged = original.oceanic_artifact_submerged;
				clone.naturite_armor = original.naturite_armor;
				clone.natures_blessing_armor = original.natures_blessing_armor;
				clone.amulet_of_vitality = original.amulet_of_vitality;
				clone.sandstorm_surge_cooldown = original.sandstorm_surge_cooldown;
				clone.firebrand = original.firebrand;
				clone.BaseManaRegenCooldown = original.BaseManaRegenCooldown;
				clone.thorn_armor = original.thorn_armor;
				clone.iceSpear = original.iceSpear;
				clone.sporesplosion = original.sporesplosion;
				clone.bookofblades = original.bookofblades;
				clone.bookofbladesmanadrain = original.bookofbladesmanadrain;
				clone.crystalarklaser = original.crystalarklaser;
				clone.hellbane = original.hellbane;
				clone.OceanicArtifactRegen = original.OceanicArtifactRegen;
				clone.crystalarkcharge = original.crystalarkcharge;
				clone.storm_catalyst_regen = original.storm_catalyst_regen;
				clone.lifedrainarrow = original.lifedrainarrow;
				clone.veinstriker = original.veinstriker;
				clone.shroomium_armor_setbonus = original.shroomium_armor_setbonus;
				clone.shroomium_armor_cooldown = original.shroomium_armor_cooldown;
				clone.hellbane_cooldown = original.hellbane_cooldown;
				clone.shadowflame_burster_cooldown = original.shadowflame_burster_cooldown;
				clone.mineral_wraith_theme_cooldown = original.mineral_wraith_theme_cooldown;
				clone.earth_breaker = original.earth_breaker;
				clone.ice_sword = original.ice_sword;
				clone.hunter_crit_cooldown = original.hunter_crit_cooldown;
				clone.hunter_crit_damage = original.hunter_crit_damage;
				clone.hunter_armor_stealth = original.hunter_armor_stealth;
				clone.hunter_armor_stealth_timer = original.hunter_armor_stealth_timer;
				clone.running_boots_speed = original.running_boots_speed;
				clone.nether_treads_speed = original.nether_treads_speed;
				clone.hunter_armor_speed = original.hunter_armor_speed;
				clone.thorn_infested_armor_theme_cooldown = original.thorn_infested_armor_theme_cooldown;
				clone.earthbound_wraith_theme_cooldown = original.earthbound_wraith_theme_cooldown;
				clone.sepulcher_theme_cooldown = original.sepulcher_theme_cooldown;
				clone.screenshake = original.screenshake;
				clone.shakeyaw = original.shakeyaw;
				clone.shakeheadpitch = original.shakeheadpitch;
				clone.intesity_lowering = original.intesity_lowering;
				clone.intensity_timer = original.intensity_timer;
				clone.nightfalls_demise_effects = original.nightfalls_demise_effects;
				clone.knife_of_proficiency = original.knife_of_proficiency;
				clone.frozen_shield = original.frozen_shield;
				clone.crystal_bow_charge = original.crystal_bow_charge;
				clone.crystal_bow_load = original.crystal_bow_load;
				clone.crystal_bow_ready = original.crystal_bow_ready;
				clone.Cursed_Armor_Phasing = original.Cursed_Armor_Phasing;
				clone.Cursed_Dash_Cooldown = original.Cursed_Dash_Cooldown;
				clone.Cursed_Dash_Contact = original.Cursed_Dash_Contact;
				clone.cursed_armor_hood = original.cursed_armor_hood;
				clone.cursed_armor_robes = original.cursed_armor_robes;
				clone.cursed_armor_greaves = original.cursed_armor_greaves;
				clone.cursed_armor_boots = original.cursed_armor_boots;
				clone.cursed_armor_cooldown = original.cursed_armor_cooldown;
				clone.blizzard_load = original.blizzard_load;
				clone.blizzard_loop_cooldown = original.blizzard_loop_cooldown;
				clone.blizzard_mana_drain = original.blizzard_mana_drain;
				clone.ice_sword_cooldown = original.ice_sword_cooldown;
				clone.ripsaw_effects = original.ripsaw_effects;
				clone.ice_bow_charge = original.ice_bow_charge;
				clone.ice_bow_load = original.ice_bow_load;
				clone.ice_bow_ready = original.ice_bow_ready;
				clone.spear_pin_point_strike_cooldown = original.spear_pin_point_strike_cooldown;
				clone.armor_shred_level = original.armor_shred_level;
				clone.mana_regen_cooldown = original.mana_regen_cooldown;
				clone.Resilience_Enchantment = original.Resilience_Enchantment;
				clone.Resilience_Level = original.Resilience_Level;
				clone.is_hit_during_bossfight = original.is_hit_during_bossfight;
				clone.WizardryEnchantment = original.WizardryEnchantment;
				clone.WizardryLevel = original.WizardryLevel;
				clone.parry_screen_flash = original.parry_screen_flash;
				clone.parry_cooldown = original.parry_cooldown;
				clone.parry_melee_attack_mode = original.parry_melee_attack_mode;
				clone.wooden_katana_sheathed = original.wooden_katana_sheathed;
				clone.parry_projectile_mode = original.parry_projectile_mode;
				clone.totem_cooldown = original.totem_cooldown;
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					CatastropheModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					CatastropheModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					CatastropheModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "catastrophe_mod_worldvars";
		public boolean Tia_Killed = false;
		public boolean violent_difficulty = false;

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			Tia_Killed = nbt.getBoolean("Tia_Killed");
			violent_difficulty = nbt.getBoolean("violent_difficulty");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putBoolean("Tia_Killed", Tia_Killed);
			nbt.putBoolean("violent_difficulty", violent_difficulty);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				CatastropheModMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "catastrophe_mod_mapvars";

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				CatastropheModMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("catastrophe_mod", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Mana = 20.0;
		public boolean ManaStart = false;
		public double Maxmana = 20.0;
		public double SoulPower = 0.0;
		public double MaxSoulPower = 1.0;
		public boolean crimsondagger = false;
		public boolean pocketshield = false;
		public boolean acidtarantula = false;
		public boolean stormshield = false;
		public boolean double_jump_condition = false;
		public boolean woodenSpear = false;
		public boolean stoneSpear = false;
		public boolean ironSpear = false;
		public boolean goldenSpear = false;
		public boolean diamondSpear = false;
		public boolean netheriteSpear = false;
		public boolean naturiteSpear = false;
		public boolean spearOfNature = false;
		public boolean electrifiedSpear = false;
		public boolean amethystSpear = false;
		public boolean moss_armor = false;
		public boolean tungstenSpear = false;
		public boolean seaSpear = false;
		public boolean seaspeardashdamage = false;
		public boolean nautilus_armor = false;
		public boolean nautilus_armor_submerged = false;
		public boolean oceanic_artifact_submerged = false;
		public boolean naturite_armor = false;
		public boolean natures_blessing_armor = false;
		public boolean amulet_of_vitality = false;
		public boolean sandstorm_surge_cooldown = false;
		public double firebrand = 0;
		public boolean BaseManaRegenCooldown = false;
		public boolean thorn_armor = false;
		public boolean iceSpear = false;
		public double sporesplosion = 0;
		public boolean bookofblades = false;
		public boolean bookofbladesmanadrain = false;
		public boolean crystalarklaser = false;
		public boolean hellbane = false;
		public boolean OceanicArtifactRegen = false;
		public double crystalarkcharge = 0;
		public boolean thunder_star = false;
		public boolean storm_catalyst_regen = false;
		public boolean lifedrainarrow = false;
		public boolean veinstriker = false;
		public boolean shroomium_armor_setbonus = false;
		public boolean shroomium_armor_cooldown = false;
		public boolean hellbane_cooldown = false;
		public boolean shadowflame_burster_cooldown = false;
		public boolean mineral_wraith_theme_cooldown = false;
		public double earth_breaker = 0;
		public double ice_sword = 0;
		public boolean hunter_crit_cooldown = false;
		public boolean hunter_crit_damage = false;
		public boolean hunter_armor_stealth = false;
		public double hunter_armor_stealth_timer = 0;
		public double running_boots_speed = 0;
		public double nether_treads_speed = 0;
		public double hunter_armor_speed = 0;
		public boolean thorn_infested_armor_theme_cooldown = false;
		public boolean earthbound_wraith_theme_cooldown = false;
		public boolean sepulcher_theme_cooldown = false;
		public boolean screenshake = false;
		public double shakeyaw = 0;
		public double shakeheadpitch = 0;
		public double intesity_lowering = 0;
		public double intensity_timer = 0;
		public boolean nightfalls_demise_effects = false;
		public double knife_of_proficiency = 0;
		public double frozen_shield = 0;
		public double mana_star_uses = 0;
		public double crystal_bow_charge = 0;
		public boolean crystal_bow_load = false;
		public boolean crystal_bow_ready = false;
		public boolean Cursed_Armor_Phasing = false;
		public boolean Cursed_Dash_Cooldown = false;
		public boolean Cursed_Dash_Contact = false;
		public boolean cursed_armor_hood = false;
		public boolean cursed_armor_robes = false;
		public boolean cursed_armor_greaves = false;
		public boolean cursed_armor_boots = false;
		public boolean cursed_armor_cooldown = false;
		public boolean blizzard_load = false;
		public boolean blizzard_loop_cooldown = false;
		public boolean blizzard_mana_drain = false;
		public boolean ice_sword_cooldown = false;
		public boolean ripsaw_effects = false;
		public double ice_bow_charge = 0;
		public boolean ice_bow_load = false;
		public boolean ice_bow_ready = false;
		public boolean spear_pin_point_strike_cooldown = false;
		public double armor_shred_level = 0;
		public double mana_regen_cooldown = 0;
		public boolean Resilience_Enchantment = false;
		public double Resilience_Level = 0;
		public boolean mulberry_silk_moth_pet = false;
		public boolean luna_moth_pet = false;
		public boolean cecropia_moth_pet = false;
		public boolean polyphemus_moth_pet = false;
		public boolean comet_moth_pet = false;
		public boolean rosy_maple_moth_pet = false;
		public boolean is_hit_during_bossfight = false;
		public double mana_cost_accursed_tome = 6.0;
		public boolean WizardryEnchantment = false;
		public double WizardryLevel = 0;
		public boolean parry_screen_flash = false;
		public double parry_cooldown = 0.0;
		public double parry_melee_attack_mode = 0;
		public boolean wooden_katana_sheathed = false;
		public double parry_projectile_mode = 0;
		public double totem_cooldown = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				CatastropheModMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Mana", Mana);
			nbt.putBoolean("ManaStart", ManaStart);
			nbt.putDouble("Maxmana", Maxmana);
			nbt.putDouble("SoulPower", SoulPower);
			nbt.putDouble("MaxSoulPower", MaxSoulPower);
			nbt.putBoolean("crimsondagger", crimsondagger);
			nbt.putBoolean("pocketshield", pocketshield);
			nbt.putBoolean("acidtarantula", acidtarantula);
			nbt.putBoolean("stormshield", stormshield);
			nbt.putBoolean("double_jump_condition", double_jump_condition);
			nbt.putBoolean("woodenSpear", woodenSpear);
			nbt.putBoolean("stoneSpear", stoneSpear);
			nbt.putBoolean("ironSpear", ironSpear);
			nbt.putBoolean("goldenSpear", goldenSpear);
			nbt.putBoolean("diamondSpear", diamondSpear);
			nbt.putBoolean("netheriteSpear", netheriteSpear);
			nbt.putBoolean("naturiteSpear", naturiteSpear);
			nbt.putBoolean("spearOfNature", spearOfNature);
			nbt.putBoolean("electrifiedSpear", electrifiedSpear);
			nbt.putBoolean("amethystSpear", amethystSpear);
			nbt.putBoolean("moss_armor", moss_armor);
			nbt.putBoolean("tungstenSpear", tungstenSpear);
			nbt.putBoolean("seaSpear", seaSpear);
			nbt.putBoolean("seaspeardashdamage", seaspeardashdamage);
			nbt.putBoolean("nautilus_armor", nautilus_armor);
			nbt.putBoolean("nautilus_armor_submerged", nautilus_armor_submerged);
			nbt.putBoolean("oceanic_artifact_submerged", oceanic_artifact_submerged);
			nbt.putBoolean("naturite_armor", naturite_armor);
			nbt.putBoolean("natures_blessing_armor", natures_blessing_armor);
			nbt.putBoolean("amulet_of_vitality", amulet_of_vitality);
			nbt.putBoolean("sandstorm_surge_cooldown", sandstorm_surge_cooldown);
			nbt.putDouble("firebrand", firebrand);
			nbt.putBoolean("BaseManaRegenCooldown", BaseManaRegenCooldown);
			nbt.putBoolean("thorn_armor", thorn_armor);
			nbt.putBoolean("iceSpear", iceSpear);
			nbt.putDouble("sporesplosion", sporesplosion);
			nbt.putBoolean("bookofblades", bookofblades);
			nbt.putBoolean("bookofbladesmanadrain", bookofbladesmanadrain);
			nbt.putBoolean("crystalarklaser", crystalarklaser);
			nbt.putBoolean("hellbane", hellbane);
			nbt.putBoolean("OceanicArtifactRegen", OceanicArtifactRegen);
			nbt.putDouble("crystalarkcharge", crystalarkcharge);
			nbt.putBoolean("thunder_star", thunder_star);
			nbt.putBoolean("storm_catalyst_regen", storm_catalyst_regen);
			nbt.putBoolean("lifedrainarrow", lifedrainarrow);
			nbt.putBoolean("veinstriker", veinstriker);
			nbt.putBoolean("shroomium_armor_setbonus", shroomium_armor_setbonus);
			nbt.putBoolean("shroomium_armor_cooldown", shroomium_armor_cooldown);
			nbt.putBoolean("hellbane_cooldown", hellbane_cooldown);
			nbt.putBoolean("shadowflame_burster_cooldown", shadowflame_burster_cooldown);
			nbt.putBoolean("mineral_wraith_theme_cooldown", mineral_wraith_theme_cooldown);
			nbt.putDouble("earth_breaker", earth_breaker);
			nbt.putDouble("ice_sword", ice_sword);
			nbt.putBoolean("hunter_crit_cooldown", hunter_crit_cooldown);
			nbt.putBoolean("hunter_crit_damage", hunter_crit_damage);
			nbt.putBoolean("hunter_armor_stealth", hunter_armor_stealth);
			nbt.putDouble("hunter_armor_stealth_timer", hunter_armor_stealth_timer);
			nbt.putDouble("running_boots_speed", running_boots_speed);
			nbt.putDouble("nether_treads_speed", nether_treads_speed);
			nbt.putDouble("hunter_armor_speed", hunter_armor_speed);
			nbt.putBoolean("thorn_infested_armor_theme_cooldown", thorn_infested_armor_theme_cooldown);
			nbt.putBoolean("earthbound_wraith_theme_cooldown", earthbound_wraith_theme_cooldown);
			nbt.putBoolean("sepulcher_theme_cooldown", sepulcher_theme_cooldown);
			nbt.putBoolean("screenshake", screenshake);
			nbt.putDouble("shakeyaw", shakeyaw);
			nbt.putDouble("shakeheadpitch", shakeheadpitch);
			nbt.putDouble("intesity_lowering", intesity_lowering);
			nbt.putDouble("intensity_timer", intensity_timer);
			nbt.putBoolean("nightfalls_demise_effects", nightfalls_demise_effects);
			nbt.putDouble("knife_of_proficiency", knife_of_proficiency);
			nbt.putDouble("frozen_shield", frozen_shield);
			nbt.putDouble("mana_star_uses", mana_star_uses);
			nbt.putDouble("crystal_bow_charge", crystal_bow_charge);
			nbt.putBoolean("crystal_bow_load", crystal_bow_load);
			nbt.putBoolean("crystal_bow_ready", crystal_bow_ready);
			nbt.putBoolean("Cursed_Armor_Phasing", Cursed_Armor_Phasing);
			nbt.putBoolean("Cursed_Dash_Cooldown", Cursed_Dash_Cooldown);
			nbt.putBoolean("Cursed_Dash_Contact", Cursed_Dash_Contact);
			nbt.putBoolean("cursed_armor_hood", cursed_armor_hood);
			nbt.putBoolean("cursed_armor_robes", cursed_armor_robes);
			nbt.putBoolean("cursed_armor_greaves", cursed_armor_greaves);
			nbt.putBoolean("cursed_armor_boots", cursed_armor_boots);
			nbt.putBoolean("cursed_armor_cooldown", cursed_armor_cooldown);
			nbt.putBoolean("blizzard_load", blizzard_load);
			nbt.putBoolean("blizzard_loop_cooldown", blizzard_loop_cooldown);
			nbt.putBoolean("blizzard_mana_drain", blizzard_mana_drain);
			nbt.putBoolean("ice_sword_cooldown", ice_sword_cooldown);
			nbt.putBoolean("ripsaw_effects", ripsaw_effects);
			nbt.putDouble("ice_bow_charge", ice_bow_charge);
			nbt.putBoolean("ice_bow_load", ice_bow_load);
			nbt.putBoolean("ice_bow_ready", ice_bow_ready);
			nbt.putBoolean("spear_pin_point_strike_cooldown", spear_pin_point_strike_cooldown);
			nbt.putDouble("armor_shred_level", armor_shred_level);
			nbt.putDouble("mana_regen_cooldown", mana_regen_cooldown);
			nbt.putBoolean("Resilience_Enchantment", Resilience_Enchantment);
			nbt.putDouble("Resilience_Level", Resilience_Level);
			nbt.putBoolean("mulberry_silk_moth_pet", mulberry_silk_moth_pet);
			nbt.putBoolean("luna_moth_pet", luna_moth_pet);
			nbt.putBoolean("cecropia_moth_pet", cecropia_moth_pet);
			nbt.putBoolean("polyphemus_moth_pet", polyphemus_moth_pet);
			nbt.putBoolean("comet_moth_pet", comet_moth_pet);
			nbt.putBoolean("rosy_maple_moth_pet", rosy_maple_moth_pet);
			nbt.putBoolean("is_hit_during_bossfight", is_hit_during_bossfight);
			nbt.putDouble("mana_cost_accursed_tome", mana_cost_accursed_tome);
			nbt.putBoolean("WizardryEnchantment", WizardryEnchantment);
			nbt.putDouble("WizardryLevel", WizardryLevel);
			nbt.putBoolean("parry_screen_flash", parry_screen_flash);
			nbt.putDouble("parry_cooldown", parry_cooldown);
			nbt.putDouble("parry_melee_attack_mode", parry_melee_attack_mode);
			nbt.putBoolean("wooden_katana_sheathed", wooden_katana_sheathed);
			nbt.putDouble("parry_projectile_mode", parry_projectile_mode);
			nbt.putDouble("totem_cooldown", totem_cooldown);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Mana = nbt.getDouble("Mana");
			ManaStart = nbt.getBoolean("ManaStart");
			Maxmana = nbt.getDouble("Maxmana");
			SoulPower = nbt.getDouble("SoulPower");
			MaxSoulPower = nbt.getDouble("MaxSoulPower");
			crimsondagger = nbt.getBoolean("crimsondagger");
			pocketshield = nbt.getBoolean("pocketshield");
			acidtarantula = nbt.getBoolean("acidtarantula");
			stormshield = nbt.getBoolean("stormshield");
			double_jump_condition = nbt.getBoolean("double_jump_condition");
			woodenSpear = nbt.getBoolean("woodenSpear");
			stoneSpear = nbt.getBoolean("stoneSpear");
			ironSpear = nbt.getBoolean("ironSpear");
			goldenSpear = nbt.getBoolean("goldenSpear");
			diamondSpear = nbt.getBoolean("diamondSpear");
			netheriteSpear = nbt.getBoolean("netheriteSpear");
			naturiteSpear = nbt.getBoolean("naturiteSpear");
			spearOfNature = nbt.getBoolean("spearOfNature");
			electrifiedSpear = nbt.getBoolean("electrifiedSpear");
			amethystSpear = nbt.getBoolean("amethystSpear");
			moss_armor = nbt.getBoolean("moss_armor");
			tungstenSpear = nbt.getBoolean("tungstenSpear");
			seaSpear = nbt.getBoolean("seaSpear");
			seaspeardashdamage = nbt.getBoolean("seaspeardashdamage");
			nautilus_armor = nbt.getBoolean("nautilus_armor");
			nautilus_armor_submerged = nbt.getBoolean("nautilus_armor_submerged");
			oceanic_artifact_submerged = nbt.getBoolean("oceanic_artifact_submerged");
			naturite_armor = nbt.getBoolean("naturite_armor");
			natures_blessing_armor = nbt.getBoolean("natures_blessing_armor");
			amulet_of_vitality = nbt.getBoolean("amulet_of_vitality");
			sandstorm_surge_cooldown = nbt.getBoolean("sandstorm_surge_cooldown");
			firebrand = nbt.getDouble("firebrand");
			BaseManaRegenCooldown = nbt.getBoolean("BaseManaRegenCooldown");
			thorn_armor = nbt.getBoolean("thorn_armor");
			iceSpear = nbt.getBoolean("iceSpear");
			sporesplosion = nbt.getDouble("sporesplosion");
			bookofblades = nbt.getBoolean("bookofblades");
			bookofbladesmanadrain = nbt.getBoolean("bookofbladesmanadrain");
			crystalarklaser = nbt.getBoolean("crystalarklaser");
			hellbane = nbt.getBoolean("hellbane");
			OceanicArtifactRegen = nbt.getBoolean("OceanicArtifactRegen");
			crystalarkcharge = nbt.getDouble("crystalarkcharge");
			thunder_star = nbt.getBoolean("thunder_star");
			storm_catalyst_regen = nbt.getBoolean("storm_catalyst_regen");
			lifedrainarrow = nbt.getBoolean("lifedrainarrow");
			veinstriker = nbt.getBoolean("veinstriker");
			shroomium_armor_setbonus = nbt.getBoolean("shroomium_armor_setbonus");
			shroomium_armor_cooldown = nbt.getBoolean("shroomium_armor_cooldown");
			hellbane_cooldown = nbt.getBoolean("hellbane_cooldown");
			shadowflame_burster_cooldown = nbt.getBoolean("shadowflame_burster_cooldown");
			mineral_wraith_theme_cooldown = nbt.getBoolean("mineral_wraith_theme_cooldown");
			earth_breaker = nbt.getDouble("earth_breaker");
			ice_sword = nbt.getDouble("ice_sword");
			hunter_crit_cooldown = nbt.getBoolean("hunter_crit_cooldown");
			hunter_crit_damage = nbt.getBoolean("hunter_crit_damage");
			hunter_armor_stealth = nbt.getBoolean("hunter_armor_stealth");
			hunter_armor_stealth_timer = nbt.getDouble("hunter_armor_stealth_timer");
			running_boots_speed = nbt.getDouble("running_boots_speed");
			nether_treads_speed = nbt.getDouble("nether_treads_speed");
			hunter_armor_speed = nbt.getDouble("hunter_armor_speed");
			thorn_infested_armor_theme_cooldown = nbt.getBoolean("thorn_infested_armor_theme_cooldown");
			earthbound_wraith_theme_cooldown = nbt.getBoolean("earthbound_wraith_theme_cooldown");
			sepulcher_theme_cooldown = nbt.getBoolean("sepulcher_theme_cooldown");
			screenshake = nbt.getBoolean("screenshake");
			shakeyaw = nbt.getDouble("shakeyaw");
			shakeheadpitch = nbt.getDouble("shakeheadpitch");
			intesity_lowering = nbt.getDouble("intesity_lowering");
			intensity_timer = nbt.getDouble("intensity_timer");
			nightfalls_demise_effects = nbt.getBoolean("nightfalls_demise_effects");
			knife_of_proficiency = nbt.getDouble("knife_of_proficiency");
			frozen_shield = nbt.getDouble("frozen_shield");
			mana_star_uses = nbt.getDouble("mana_star_uses");
			crystal_bow_charge = nbt.getDouble("crystal_bow_charge");
			crystal_bow_load = nbt.getBoolean("crystal_bow_load");
			crystal_bow_ready = nbt.getBoolean("crystal_bow_ready");
			Cursed_Armor_Phasing = nbt.getBoolean("Cursed_Armor_Phasing");
			Cursed_Dash_Cooldown = nbt.getBoolean("Cursed_Dash_Cooldown");
			Cursed_Dash_Contact = nbt.getBoolean("Cursed_Dash_Contact");
			cursed_armor_hood = nbt.getBoolean("cursed_armor_hood");
			cursed_armor_robes = nbt.getBoolean("cursed_armor_robes");
			cursed_armor_greaves = nbt.getBoolean("cursed_armor_greaves");
			cursed_armor_boots = nbt.getBoolean("cursed_armor_boots");
			cursed_armor_cooldown = nbt.getBoolean("cursed_armor_cooldown");
			blizzard_load = nbt.getBoolean("blizzard_load");
			blizzard_loop_cooldown = nbt.getBoolean("blizzard_loop_cooldown");
			blizzard_mana_drain = nbt.getBoolean("blizzard_mana_drain");
			ice_sword_cooldown = nbt.getBoolean("ice_sword_cooldown");
			ripsaw_effects = nbt.getBoolean("ripsaw_effects");
			ice_bow_charge = nbt.getDouble("ice_bow_charge");
			ice_bow_load = nbt.getBoolean("ice_bow_load");
			ice_bow_ready = nbt.getBoolean("ice_bow_ready");
			spear_pin_point_strike_cooldown = nbt.getBoolean("spear_pin_point_strike_cooldown");
			armor_shred_level = nbt.getDouble("armor_shred_level");
			mana_regen_cooldown = nbt.getDouble("mana_regen_cooldown");
			Resilience_Enchantment = nbt.getBoolean("Resilience_Enchantment");
			Resilience_Level = nbt.getDouble("Resilience_Level");
			mulberry_silk_moth_pet = nbt.getBoolean("mulberry_silk_moth_pet");
			luna_moth_pet = nbt.getBoolean("luna_moth_pet");
			cecropia_moth_pet = nbt.getBoolean("cecropia_moth_pet");
			polyphemus_moth_pet = nbt.getBoolean("polyphemus_moth_pet");
			comet_moth_pet = nbt.getBoolean("comet_moth_pet");
			rosy_maple_moth_pet = nbt.getBoolean("rosy_maple_moth_pet");
			is_hit_during_bossfight = nbt.getBoolean("is_hit_during_bossfight");
			mana_cost_accursed_tome = nbt.getDouble("mana_cost_accursed_tome");
			WizardryEnchantment = nbt.getBoolean("WizardryEnchantment");
			WizardryLevel = nbt.getDouble("WizardryLevel");
			parry_screen_flash = nbt.getBoolean("parry_screen_flash");
			parry_cooldown = nbt.getDouble("parry_cooldown");
			parry_melee_attack_mode = nbt.getDouble("parry_melee_attack_mode");
			wooden_katana_sheathed = nbt.getBoolean("wooden_katana_sheathed");
			parry_projectile_mode = nbt.getDouble("parry_projectile_mode");
			totem_cooldown = nbt.getDouble("totem_cooldown");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Mana = message.data.Mana;
					variables.ManaStart = message.data.ManaStart;
					variables.Maxmana = message.data.Maxmana;
					variables.SoulPower = message.data.SoulPower;
					variables.MaxSoulPower = message.data.MaxSoulPower;
					variables.crimsondagger = message.data.crimsondagger;
					variables.pocketshield = message.data.pocketshield;
					variables.acidtarantula = message.data.acidtarantula;
					variables.stormshield = message.data.stormshield;
					variables.double_jump_condition = message.data.double_jump_condition;
					variables.woodenSpear = message.data.woodenSpear;
					variables.stoneSpear = message.data.stoneSpear;
					variables.ironSpear = message.data.ironSpear;
					variables.goldenSpear = message.data.goldenSpear;
					variables.diamondSpear = message.data.diamondSpear;
					variables.netheriteSpear = message.data.netheriteSpear;
					variables.naturiteSpear = message.data.naturiteSpear;
					variables.spearOfNature = message.data.spearOfNature;
					variables.electrifiedSpear = message.data.electrifiedSpear;
					variables.amethystSpear = message.data.amethystSpear;
					variables.moss_armor = message.data.moss_armor;
					variables.tungstenSpear = message.data.tungstenSpear;
					variables.seaSpear = message.data.seaSpear;
					variables.seaspeardashdamage = message.data.seaspeardashdamage;
					variables.nautilus_armor = message.data.nautilus_armor;
					variables.nautilus_armor_submerged = message.data.nautilus_armor_submerged;
					variables.oceanic_artifact_submerged = message.data.oceanic_artifact_submerged;
					variables.naturite_armor = message.data.naturite_armor;
					variables.natures_blessing_armor = message.data.natures_blessing_armor;
					variables.amulet_of_vitality = message.data.amulet_of_vitality;
					variables.sandstorm_surge_cooldown = message.data.sandstorm_surge_cooldown;
					variables.firebrand = message.data.firebrand;
					variables.BaseManaRegenCooldown = message.data.BaseManaRegenCooldown;
					variables.thorn_armor = message.data.thorn_armor;
					variables.iceSpear = message.data.iceSpear;
					variables.sporesplosion = message.data.sporesplosion;
					variables.bookofblades = message.data.bookofblades;
					variables.bookofbladesmanadrain = message.data.bookofbladesmanadrain;
					variables.crystalarklaser = message.data.crystalarklaser;
					variables.hellbane = message.data.hellbane;
					variables.OceanicArtifactRegen = message.data.OceanicArtifactRegen;
					variables.crystalarkcharge = message.data.crystalarkcharge;
					variables.thunder_star = message.data.thunder_star;
					variables.storm_catalyst_regen = message.data.storm_catalyst_regen;
					variables.lifedrainarrow = message.data.lifedrainarrow;
					variables.veinstriker = message.data.veinstriker;
					variables.shroomium_armor_setbonus = message.data.shroomium_armor_setbonus;
					variables.shroomium_armor_cooldown = message.data.shroomium_armor_cooldown;
					variables.hellbane_cooldown = message.data.hellbane_cooldown;
					variables.shadowflame_burster_cooldown = message.data.shadowflame_burster_cooldown;
					variables.mineral_wraith_theme_cooldown = message.data.mineral_wraith_theme_cooldown;
					variables.earth_breaker = message.data.earth_breaker;
					variables.ice_sword = message.data.ice_sword;
					variables.hunter_crit_cooldown = message.data.hunter_crit_cooldown;
					variables.hunter_crit_damage = message.data.hunter_crit_damage;
					variables.hunter_armor_stealth = message.data.hunter_armor_stealth;
					variables.hunter_armor_stealth_timer = message.data.hunter_armor_stealth_timer;
					variables.running_boots_speed = message.data.running_boots_speed;
					variables.nether_treads_speed = message.data.nether_treads_speed;
					variables.hunter_armor_speed = message.data.hunter_armor_speed;
					variables.thorn_infested_armor_theme_cooldown = message.data.thorn_infested_armor_theme_cooldown;
					variables.earthbound_wraith_theme_cooldown = message.data.earthbound_wraith_theme_cooldown;
					variables.sepulcher_theme_cooldown = message.data.sepulcher_theme_cooldown;
					variables.screenshake = message.data.screenshake;
					variables.shakeyaw = message.data.shakeyaw;
					variables.shakeheadpitch = message.data.shakeheadpitch;
					variables.intesity_lowering = message.data.intesity_lowering;
					variables.intensity_timer = message.data.intensity_timer;
					variables.nightfalls_demise_effects = message.data.nightfalls_demise_effects;
					variables.knife_of_proficiency = message.data.knife_of_proficiency;
					variables.frozen_shield = message.data.frozen_shield;
					variables.mana_star_uses = message.data.mana_star_uses;
					variables.crystal_bow_charge = message.data.crystal_bow_charge;
					variables.crystal_bow_load = message.data.crystal_bow_load;
					variables.crystal_bow_ready = message.data.crystal_bow_ready;
					variables.Cursed_Armor_Phasing = message.data.Cursed_Armor_Phasing;
					variables.Cursed_Dash_Cooldown = message.data.Cursed_Dash_Cooldown;
					variables.Cursed_Dash_Contact = message.data.Cursed_Dash_Contact;
					variables.cursed_armor_hood = message.data.cursed_armor_hood;
					variables.cursed_armor_robes = message.data.cursed_armor_robes;
					variables.cursed_armor_greaves = message.data.cursed_armor_greaves;
					variables.cursed_armor_boots = message.data.cursed_armor_boots;
					variables.cursed_armor_cooldown = message.data.cursed_armor_cooldown;
					variables.blizzard_load = message.data.blizzard_load;
					variables.blizzard_loop_cooldown = message.data.blizzard_loop_cooldown;
					variables.blizzard_mana_drain = message.data.blizzard_mana_drain;
					variables.ice_sword_cooldown = message.data.ice_sword_cooldown;
					variables.ripsaw_effects = message.data.ripsaw_effects;
					variables.ice_bow_charge = message.data.ice_bow_charge;
					variables.ice_bow_load = message.data.ice_bow_load;
					variables.ice_bow_ready = message.data.ice_bow_ready;
					variables.spear_pin_point_strike_cooldown = message.data.spear_pin_point_strike_cooldown;
					variables.armor_shred_level = message.data.armor_shred_level;
					variables.mana_regen_cooldown = message.data.mana_regen_cooldown;
					variables.Resilience_Enchantment = message.data.Resilience_Enchantment;
					variables.Resilience_Level = message.data.Resilience_Level;
					variables.mulberry_silk_moth_pet = message.data.mulberry_silk_moth_pet;
					variables.luna_moth_pet = message.data.luna_moth_pet;
					variables.cecropia_moth_pet = message.data.cecropia_moth_pet;
					variables.polyphemus_moth_pet = message.data.polyphemus_moth_pet;
					variables.comet_moth_pet = message.data.comet_moth_pet;
					variables.rosy_maple_moth_pet = message.data.rosy_maple_moth_pet;
					variables.is_hit_during_bossfight = message.data.is_hit_during_bossfight;
					variables.mana_cost_accursed_tome = message.data.mana_cost_accursed_tome;
					variables.WizardryEnchantment = message.data.WizardryEnchantment;
					variables.WizardryLevel = message.data.WizardryLevel;
					variables.parry_screen_flash = message.data.parry_screen_flash;
					variables.parry_cooldown = message.data.parry_cooldown;
					variables.parry_melee_attack_mode = message.data.parry_melee_attack_mode;
					variables.wooden_katana_sheathed = message.data.wooden_katana_sheathed;
					variables.parry_projectile_mode = message.data.parry_projectile_mode;
					variables.totem_cooldown = message.data.totem_cooldown;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
