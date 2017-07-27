package damcho.mineborne;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CooldownController extends Item{
		
		protected static int maxCooldown;
		protected static int cooldown = 0;
		protected static ItemStack itemstack;
		
		long last_time = System.nanoTime();

		/**
		 * 
		 * Please input max cooldown in seconds.
		 * @param maxCooldown
		 */
		public CooldownController(int maxCooldown) {
			this.maxCooldown = maxCooldown * 1000;
		}
		
		public static int getCooldown() {
			return itemstack.getTagCompound().getInteger("Cooldown");
		}
		
		public static int getMaxCooldown() {
			return maxCooldown;
		}
		
		public void setItemStack(ItemStack itemstack) {
			this.itemstack = itemstack;
		}
		
		public void setCooldownOn(EntityPlayer player) {
			
			for(int inventorySlot = 0; inventorySlot <= 41; inventorySlot++) {
				
				System.out.println("inventoryslot: " + inventorySlot);
				
				if((player.inventory.getStackInSlot(inventorySlot)).isItemEqual(itemstack)) {
					
					player.inventory.getStackInSlot(inventorySlot).getTagCompound().setInteger("Cooldown", maxCooldown);
					System.out.println("Found one!");
					this.cooldown = maxCooldown;
				}
			}
		}
		
		public void update(ItemStack itemstack, World world, Entity entity, int metadata, boolean bool) {

			long time = System.nanoTime();
			int delta_time = (int) ((time - last_time) / 1000000);
			last_time = time;
			
			if(itemstack.getTagCompound() == null) {
				itemstack.setTagCompound(new NBTTagCompound());
				itemstack.getTagCompound().setInteger("Cooldown", 0);
				System.out.println("ALLOCATED NBTTAG FOR COOLDOWN TO " + itemstack);
			}
			
			if(itemstack.getTagCompound().getInteger("Cooldown") > 0) {
				this.cooldown -= delta_time;;
				itemstack.getTagCompound().setInteger("Cooldown", cooldown);
				System.out.println(this.cooldown);
			}
		}
		
}