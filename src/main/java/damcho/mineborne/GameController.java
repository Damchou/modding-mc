package damcho.mineborne;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.util.FoodStats;
import net.minecraft.util.ITickable;

// tänne tulee kaikki laajasti yleinen käytös pelissä, esim. tappojen määrä tai bossien lukumäärä.
// toimii Tick Event Handling, testaa ServerTickEventtiä tarkkuuden varalta.

public class GameController implements ITickable{

	@Override
	public void update() {
		/*if(entity instanceof EntityPlayer && world.isRemote) {
			EntityPlayer player = (EntityPlayer) entity;
			player.getFoodStats().setFoodLevel(10);
		}*/
	}

}
