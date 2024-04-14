
package net.mcreator.catastrophemod.client.particle;

@OnlyIn(Dist.CLIENT)
public class BlizzardWindParticle extends TextureSheetParticle {
	public static BlizzardWindParticleProvider provider(SpriteSet spriteSet) {
		return new BlizzardWindParticleProvider(spriteSet);
	}

	public static class BlizzardWindParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public BlizzardWindParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new BlizzardWindParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;
	private float angularVelocity;
	private float angularAcceleration;

	protected BlizzardWindParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.4f, 0.4f);
		this.quadSize *= 6f;
		this.lifetime = (int) Math.max(1, 25 + (this.random.nextInt(30) - 15));
		this.gravity = 0.3f;
		this.hasPhysics = true;
		this.xd = vx * 1;
		this.yd = vy * 1;
		this.zd = vz * 1;
		this.angularVelocity = 0.01f;
		this.angularAcceleration = 0.02f;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
		super.tick();
		this.oRoll = this.roll;
		this.roll += this.angularVelocity;
		this.angularVelocity += this.angularAcceleration;
	}
}