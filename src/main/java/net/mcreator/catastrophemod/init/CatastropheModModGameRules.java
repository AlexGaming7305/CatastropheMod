
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.catastrophemod.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatastropheModModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> TOTEM_COOLDOWN = GameRules.register("totemCooldown", GameRules.Category.PLAYER, GameRules.IntegerValue.create(6000));
}
