package damcho.mineborne;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.FoodStats;

// t�nne tulee kaikki laajasti yleinen k�yt�s peliss�, esim. tappojen m��r� tai bossien lukum��r�.
// toimii Tick Event Handling, testaa ServerTickEventti� tarkkuuden varalta.

public class GameController {
	
	public void onUpdate(ItemStack stack, World world, Entity entity) {
		
		if(entity instanceof EntityPlayer && world.isRemote) {
			EntityPlayer player = (EntityPlayer) entity;
			player.getFoodStats().setFoodLevel(10);
		}
	}

}
