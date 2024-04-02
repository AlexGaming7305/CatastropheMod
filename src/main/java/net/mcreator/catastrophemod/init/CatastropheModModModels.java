
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.catastrophemod.client.model.Modelwuflar_pellet;
import net.mcreator.catastrophemod.client.model.Modelwuflar_laser;
import net.mcreator.catastrophemod.client.model.Modelvulnerability_skull;
import net.mcreator.catastrophemod.client.model.Modelvenomous_round;
import net.mcreator.catastrophemod.client.model.Modelvein_striker;
import net.mcreator.catastrophemod.client.model.Modeltracking_disc;
import net.mcreator.catastrophemod.client.model.Modeltiny_thorn;
import net.mcreator.catastrophemod.client.model.Modelthorn_spear;
import net.mcreator.catastrophemod.client.model.Modelthorn_leggings;
import net.mcreator.catastrophemod.client.model.Modelthorn_helmet;
import net.mcreator.catastrophemod.client.model.Modelthorn_chestplate;
import net.mcreator.catastrophemod.client.model.Modelthorn_boots;
import net.mcreator.catastrophemod.client.model.Modelthorn_arrow;
import net.mcreator.catastrophemod.client.model.Modelspore;
import net.mcreator.catastrophemod.client.model.Modelshroomium_hat;
import net.mcreator.catastrophemod.client.model.Modelshell;
import net.mcreator.catastrophemod.client.model.Modelshadowfire_soul;
import net.mcreator.catastrophemod.client.model.Modelshadowfire_skull;
import net.mcreator.catastrophemod.client.model.Modelshadowfire_ball;
import net.mcreator.catastrophemod.client.model.Modelsea_pendant;
import net.mcreator.catastrophemod.client.model.Modelsand_pillar;
import net.mcreator.catastrophemod.client.model.Modelrunning_boot;
import net.mcreator.catastrophemod.client.model.Modelrubybolt;
import net.mcreator.catastrophemod.client.model.Modelpoisonous_thorn;
import net.mcreator.catastrophemod.client.model.Modelpacifying_sight;
import net.mcreator.catastrophemod.client.model.Modelnature_blast;
import net.mcreator.catastrophemod.client.model.Modelmurky_slime;
import net.mcreator.catastrophemod.client.model.Modelknife_of_proficiency;
import net.mcreator.catastrophemod.client.model.Modeliron_round;
import net.mcreator.catastrophemod.client.model.Modelicicle;
import net.mcreator.catastrophemod.client.model.Modelice_spike;
import net.mcreator.catastrophemod.client.model.Modelice_shard;
import net.mcreator.catastrophemod.client.model.Modelhunters_hat;
import net.mcreator.catastrophemod.client.model.Modelhunter_leggings;
import net.mcreator.catastrophemod.client.model.Modelhunter_chestplate;
import net.mcreator.catastrophemod.client.model.Modelhunter_boots;
import net.mcreator.catastrophemod.client.model.Modelhoming_star;
import net.mcreator.catastrophemod.client.model.Modelhealing_orb;
import net.mcreator.catastrophemod.client.model.Modelhealing_blossom;
import net.mcreator.catastrophemod.client.model.Modelgolden_necklace;
import net.mcreator.catastrophemod.client.model.Modelghost_phantom;
import net.mcreator.catastrophemod.client.model.Modelfrost_ray;
import net.mcreator.catastrophemod.client.model.Modelfireforkarrow;
import net.mcreator.catastrophemod.client.model.Modelfirefly;
import net.mcreator.catastrophemod.client.model.Modelfireball;
import net.mcreator.catastrophemod.client.model.Modelfiery_slash;
import net.mcreator.catastrophemod.client.model.Modelenergy_ball;
import net.mcreator.catastrophemod.client.model.Modelenchanted_sword;
import net.mcreator.catastrophemod.client.model.Modelelectrified_round;
import net.mcreator.catastrophemod.client.model.Modelelectrified_bolt;
import net.mcreator.catastrophemod.client.model.Modelearthbound_rock_shard;
import net.mcreator.catastrophemod.client.model.Modelearthbound_rock;
import net.mcreator.catastrophemod.client.model.Modelearth_shatterer;
import net.mcreator.catastrophemod.client.model.Modelcursed_armor;
import net.mcreator.catastrophemod.client.model.Modelcrystal_shard;
import net.mcreator.catastrophemod.client.model.Modelcrystal_round;
import net.mcreator.catastrophemod.client.model.Modelconos;
import net.mcreator.catastrophemod.client.model.Modelblood_knife;
import net.mcreator.catastrophemod.client.model.Modelblazing_feather;
import net.mcreator.catastrophemod.client.model.Modelbartosa_plane;
import net.mcreator.catastrophemod.client.model.Modelarrow_model;
import net.mcreator.catastrophemod.client.model.Modelark_needle_projectile_again;
import net.mcreator.catastrophemod.client.model.Modelamulet_of_weakening;
import net.mcreator.catastrophemod.client.model.Modelamulet_of_vitality;
import net.mcreator.catastrophemod.client.model.Modelamethystprojectile;
import net.mcreator.catastrophemod.client.model.Modelalex_missile;
import net.mcreator.catastrophemod.client.model.Modelaccursed_dagger;
import net.mcreator.catastrophemod.client.model.Modelabyssal_slime;
import net.mcreator.catastrophemod.client.model.ModelLava_Brute;
import net.mcreator.catastrophemod.client.model.ModelFly;
import net.mcreator.catastrophemod.client.model.ModelFire_Wyvern;
import net.mcreator.catastrophemod.client.model.ModelDestroyer_Head;
import net.mcreator.catastrophemod.client.model.ModelDestroyer_Body;
import net.mcreator.catastrophemod.client.model.ModelBloater;
import net.mcreator.catastrophemod.client.model.ModelArmageddon_Robot;
import net.mcreator.catastrophemod.client.model.ModelAbyssal_Skater;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class CatastropheModModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelcursed_armor.LAYER_LOCATION, Modelcursed_armor::createBodyLayer);
		event.registerLayerDefinition(Modelhunter_boots.LAYER_LOCATION, Modelhunter_boots::createBodyLayer);
		event.registerLayerDefinition(Modelshadowfire_skull.LAYER_LOCATION, Modelshadowfire_skull::createBodyLayer);
		event.registerLayerDefinition(Modelearth_shatterer.LAYER_LOCATION, Modelearth_shatterer::createBodyLayer);
		event.registerLayerDefinition(Modelabyssal_slime.LAYER_LOCATION, Modelabyssal_slime::createBodyLayer);
		event.registerLayerDefinition(Modelfireforkarrow.LAYER_LOCATION, Modelfireforkarrow::createBodyLayer);
		event.registerLayerDefinition(Modelconos.LAYER_LOCATION, Modelconos::createBodyLayer);
		event.registerLayerDefinition(Modelthorn_spear.LAYER_LOCATION, Modelthorn_spear::createBodyLayer);
		event.registerLayerDefinition(Modelshroomium_hat.LAYER_LOCATION, Modelshroomium_hat::createBodyLayer);
		event.registerLayerDefinition(ModelLava_Brute.LAYER_LOCATION, ModelLava_Brute::createBodyLayer);
		event.registerLayerDefinition(ModelFire_Wyvern.LAYER_LOCATION, ModelFire_Wyvern::createBodyLayer);
		event.registerLayerDefinition(Modelhunter_chestplate.LAYER_LOCATION, Modelhunter_chestplate::createBodyLayer);
		event.registerLayerDefinition(Modelsea_pendant.LAYER_LOCATION, Modelsea_pendant::createBodyLayer);
		event.registerLayerDefinition(Modelsand_pillar.LAYER_LOCATION, Modelsand_pillar::createBodyLayer);
		event.registerLayerDefinition(Modelpoisonous_thorn.LAYER_LOCATION, Modelpoisonous_thorn::createBodyLayer);
		event.registerLayerDefinition(Modelvein_striker.LAYER_LOCATION, Modelvein_striker::createBodyLayer);
		event.registerLayerDefinition(Modelmurky_slime.LAYER_LOCATION, Modelmurky_slime::createBodyLayer);
		event.registerLayerDefinition(Modelearthbound_rock.LAYER_LOCATION, Modelearthbound_rock::createBodyLayer);
		event.registerLayerDefinition(Modelrunning_boot.LAYER_LOCATION, Modelrunning_boot::createBodyLayer);
		event.registerLayerDefinition(Modelgolden_necklace.LAYER_LOCATION, Modelgolden_necklace::createBodyLayer);
		event.registerLayerDefinition(Modelrubybolt.LAYER_LOCATION, Modelrubybolt::createBodyLayer);
		event.registerLayerDefinition(Modelcrystal_round.LAYER_LOCATION, Modelcrystal_round::createBodyLayer);
		event.registerLayerDefinition(Modelnature_blast.LAYER_LOCATION, Modelnature_blast::createBodyLayer);
		event.registerLayerDefinition(ModelDestroyer_Head.LAYER_LOCATION, ModelDestroyer_Head::createBodyLayer);
		event.registerLayerDefinition(Modelspore.LAYER_LOCATION, Modelspore::createBodyLayer);
		event.registerLayerDefinition(Modelicicle.LAYER_LOCATION, Modelicicle::createBodyLayer);
		event.registerLayerDefinition(Modelvulnerability_skull.LAYER_LOCATION, Modelvulnerability_skull::createBodyLayer);
		event.registerLayerDefinition(Modelwuflar_laser.LAYER_LOCATION, Modelwuflar_laser::createBodyLayer);
		event.registerLayerDefinition(Modelthorn_chestplate.LAYER_LOCATION, Modelthorn_chestplate::createBodyLayer);
		event.registerLayerDefinition(Modelaccursed_dagger.LAYER_LOCATION, Modelaccursed_dagger::createBodyLayer);
		event.registerLayerDefinition(Modelshadowfire_soul.LAYER_LOCATION, Modelshadowfire_soul::createBodyLayer);
		event.registerLayerDefinition(ModelAbyssal_Skater.LAYER_LOCATION, ModelAbyssal_Skater::createBodyLayer);
		event.registerLayerDefinition(Modelice_spike.LAYER_LOCATION, Modelice_spike::createBodyLayer);
		event.registerLayerDefinition(Modelblood_knife.LAYER_LOCATION, Modelblood_knife::createBodyLayer);
		event.registerLayerDefinition(Modelfireball.LAYER_LOCATION, Modelfireball::createBodyLayer);
		event.registerLayerDefinition(Modeltiny_thorn.LAYER_LOCATION, Modeltiny_thorn::createBodyLayer);
		event.registerLayerDefinition(Modelshadowfire_ball.LAYER_LOCATION, Modelshadowfire_ball::createBodyLayer);
		event.registerLayerDefinition(ModelBloater.LAYER_LOCATION, ModelBloater::createBodyLayer);
		event.registerLayerDefinition(Modelhealing_blossom.LAYER_LOCATION, Modelhealing_blossom::createBodyLayer);
		event.registerLayerDefinition(Modelbartosa_plane.LAYER_LOCATION, Modelbartosa_plane::createBodyLayer);
		event.registerLayerDefinition(ModelArmageddon_Robot.LAYER_LOCATION, ModelArmageddon_Robot::createBodyLayer);
		event.registerLayerDefinition(Modelblazing_feather.LAYER_LOCATION, Modelblazing_feather::createBodyLayer);
		event.registerLayerDefinition(ModelFly.LAYER_LOCATION, ModelFly::createBodyLayer);
		event.registerLayerDefinition(Modelelectrified_bolt.LAYER_LOCATION, Modelelectrified_bolt::createBodyLayer);
		event.registerLayerDefinition(ModelDestroyer_Body.LAYER_LOCATION, ModelDestroyer_Body::createBodyLayer);
		event.registerLayerDefinition(Modelghost_phantom.LAYER_LOCATION, Modelghost_phantom::createBodyLayer);
		event.registerLayerDefinition(Modelfiery_slash.LAYER_LOCATION, Modelfiery_slash::createBodyLayer);
		event.registerLayerDefinition(Modelhealing_orb.LAYER_LOCATION, Modelhealing_orb::createBodyLayer);
		event.registerLayerDefinition(Modelenchanted_sword.LAYER_LOCATION, Modelenchanted_sword::createBodyLayer);
		event.registerLayerDefinition(Modeltracking_disc.LAYER_LOCATION, Modeltracking_disc::createBodyLayer);
		event.registerLayerDefinition(Modelthorn_leggings.LAYER_LOCATION, Modelthorn_leggings::createBodyLayer);
		event.registerLayerDefinition(Modelthorn_helmet.LAYER_LOCATION, Modelthorn_helmet::createBodyLayer);
		event.registerLayerDefinition(Modelalex_missile.LAYER_LOCATION, Modelalex_missile::createBodyLayer);
		event.registerLayerDefinition(Modelcrystal_shard.LAYER_LOCATION, Modelcrystal_shard::createBodyLayer);
		event.registerLayerDefinition(Modeliron_round.LAYER_LOCATION, Modeliron_round::createBodyLayer);
		event.registerLayerDefinition(Modelhunter_leggings.LAYER_LOCATION, Modelhunter_leggings::createBodyLayer);
		event.registerLayerDefinition(Modelice_shard.LAYER_LOCATION, Modelice_shard::createBodyLayer);
		event.registerLayerDefinition(Modelthorn_boots.LAYER_LOCATION, Modelthorn_boots::createBodyLayer);
		event.registerLayerDefinition(Modelthorn_arrow.LAYER_LOCATION, Modelthorn_arrow::createBodyLayer);
		event.registerLayerDefinition(Modelark_needle_projectile_again.LAYER_LOCATION, Modelark_needle_projectile_again::createBodyLayer);
		event.registerLayerDefinition(Modelfirefly.LAYER_LOCATION, Modelfirefly::createBodyLayer);
		event.registerLayerDefinition(Modelhoming_star.LAYER_LOCATION, Modelhoming_star::createBodyLayer);
		event.registerLayerDefinition(Modelwuflar_pellet.LAYER_LOCATION, Modelwuflar_pellet::createBodyLayer);
		event.registerLayerDefinition(Modelshell.LAYER_LOCATION, Modelshell::createBodyLayer);
		event.registerLayerDefinition(Modelvenomous_round.LAYER_LOCATION, Modelvenomous_round::createBodyLayer);
		event.registerLayerDefinition(Modelearthbound_rock_shard.LAYER_LOCATION, Modelearthbound_rock_shard::createBodyLayer);
		event.registerLayerDefinition(Modelamulet_of_vitality.LAYER_LOCATION, Modelamulet_of_vitality::createBodyLayer);
		event.registerLayerDefinition(Modelknife_of_proficiency.LAYER_LOCATION, Modelknife_of_proficiency::createBodyLayer);
		event.registerLayerDefinition(Modelfrost_ray.LAYER_LOCATION, Modelfrost_ray::createBodyLayer);
		event.registerLayerDefinition(Modelpacifying_sight.LAYER_LOCATION, Modelpacifying_sight::createBodyLayer);
		event.registerLayerDefinition(Modelamulet_of_weakening.LAYER_LOCATION, Modelamulet_of_weakening::createBodyLayer);
		event.registerLayerDefinition(Modelelectrified_round.LAYER_LOCATION, Modelelectrified_round::createBodyLayer);
		event.registerLayerDefinition(Modelhunters_hat.LAYER_LOCATION, Modelhunters_hat::createBodyLayer);
		event.registerLayerDefinition(Modelarrow_model.LAYER_LOCATION, Modelarrow_model::createBodyLayer);
		event.registerLayerDefinition(Modelenergy_ball.LAYER_LOCATION, Modelenergy_ball::createBodyLayer);
		event.registerLayerDefinition(Modelamethystprojectile.LAYER_LOCATION, Modelamethystprojectile::createBodyLayer);
	}
}