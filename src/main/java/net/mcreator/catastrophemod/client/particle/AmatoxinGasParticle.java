
package net.mcreator.catastrophemod.client.particle;

@OnlyIn(Dist.CLIENT)
public class AmatoxinGasParticle extends TextureSheetParticle {
	public static AmatoxinGasParticleProvider provider(SpriteSet spriteSet) {
		return new AmatoxinGasParticleProvider(spriteSet);
	}

	public static class AmatoxinGasParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public AmatoxinGasParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new AmatoxinGasParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected AmatoxinGasParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.quadSize *= 1.9f;
		this.lifetime = 14;
		this.gravity = 0f;
		this.hasPhysics = true;
		this.xd = vx * 0.2;
		this.yd = vy * 0.2;
		this.zd = vz * 0.2;
		this.setSpriteFromAge(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.removed) {
			this.setSprite(this.spriteSet.get((this.age / 2) % 8 + 1, 8));
		}
	}
}