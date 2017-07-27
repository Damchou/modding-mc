package damcho.mineborne.entity;

import damcho.mineborne.items.ItemFirebomb;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFirebomb extends EntityThrowable{
	
	private EntityLivingBase thrower;
	
	public EntityFirebomb(World world) {
		super(world);
	}
	
	public EntityFirebomb(World world, EntityLivingBase thrower) {
		super(world, thrower);
		this.thrower = thrower;
	}

	@SideOnly(Side.CLIENT)
	public EntityFirebomb(World world, double par2, double par4, double par6) {
		super(world, par2, par4, par6);
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {
		
		if(!world.isRemote){
		
			if(result.typeOfHit == RayTraceResult.Type.BLOCK) {
			
				Block block = this.world.getBlockState(result.getBlockPos()).getBlock();
				this.destroySelf();
			
			} else {
			
				if(result.typeOfHit == RayTraceResult.Type.ENTITY && (!result.entityHit.equals(this.thrower))) {
					this.inflictDamage(result);
					this.destroySelf();
				}
			}
		}
	}
	
	public void onUpdate()
    {
        EntityLivingBase entitylivingbase = this.getThrower();

        if (entitylivingbase != null && entitylivingbase instanceof EntityPlayer && !entitylivingbase.isEntityAlive())
        {
            this.setDead();
        }
        else
        {
            super.onUpdate();
        }
    }
	
	private void inflictDamage(RayTraceResult result) {
		result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), ItemFirebomb.getDamage());
	}
	
	private void destroySelf() {
		this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, 1.0d, 1.0d, 1.0d, new int[0]);
		this.world.createExplosion(this, posX, posY, posZ, 2.0f, true);
		
		this.setDead();
	}
	
}
