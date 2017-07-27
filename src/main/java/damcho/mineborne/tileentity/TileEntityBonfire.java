package damcho.mineborne.tileentity;

import damcho.mineborne.Reference;
import damcho.mineborne.handlers.CustomSoundHandler;
import damcho.mineborne.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityBonfire extends TileEntity implements ITickable{
	
	private static int cooldown = 0;
	private static int estusMax = 5;
	private static int estusCount;
	
	public void setSpawn(World world, EntityPlayer player, BlockPos pos) {
		this.cooldown = 20 * 8;
		player.setSpawnPoint(player.getPosition(), true);
		System.out.println("Spawn set for " + player + ".");
		world.playSound(null, pos, CustomSoundHandler.BONFIRE_SOUND, SoundCategory.BLOCKS, 0.9f, 0.8f);
	}
	
	public void giveEstus(EntityPlayer player) {
		estusCount = 0;
		for(int islot = 0; islot < player.inventory.getSizeInventory(); islot++) {
			ItemStack stack = player.inventory.getStackInSlot(islot);
			
			if(stack != null && stack.getItem().equals(ModItems.estus)) {
				estusCount += stack.getCount();
			}
		}
		player.inventory.addItemStackToInventory(new ItemStack(ModItems.estus, (estusMax - estusCount)));
	}
	
	/*
	public void reset() {
		for(each missing player's estus) {
			give player estus;
		}
	}*/

	public void update() {
		if(this.cooldown > 0) {
			System.out.println(this.cooldown);
			this.cooldown--;
		}
	}
	
	/*
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("Cooldown", this.cooldown);
		compound.setBoolean("Charged", this.isCharged);

	}
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.cooldown = compound.getInteger("Cooldown");
		this.isCharged = compound.getBoolean("Charged");
	}
	*/
	
	public static int getCD() {
		return cooldown;
	}
	
	
	
}
