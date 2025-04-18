package net.mcreator.catastrophemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.catastrophemod.network.CatastropheModModVariables;

import java.util.List;
import java.util.Comparator;

public class SwordOrbitOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean flag = false;
		double yort = 0;
		double xort = 0;
		double lifetime = 0;
		double sum = 0;
		double turn = 0;
		double zdir = 0;
		double ydir = 0;
		double xdir = 0;
		double speed = 0;
		double zort = 0;
		double zvel = 0;
		double yvel = 0;
		double radius = 0;
		double xvel = 0;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "");
			}
		}
		entity.invulnerableTime = 20;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 255, true, false));
		if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).isEmpty() == false) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if (!((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null) == null)) {
			if (((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CatastropheModModVariables.PlayerVariables())).stormshield == false) {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
		if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator == (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null)
						&& (entityiterator.getCapability(CatastropheModModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CatastropheModModVariables.PlayerVariables())).stormshield == true) {
					{
						Entity _ent = entity;
						_ent.teleportTo(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX()), ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getY() + 0.2),
								((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ()));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getX()), ((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getY() + 0.2),
									((entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getZ()), _ent.getYRot(), _ent.getXRot());
					}
				}
			}
		}
	}
}
