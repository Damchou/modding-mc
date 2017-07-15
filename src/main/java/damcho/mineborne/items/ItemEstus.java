package damcho.mineborne.items;

import damcho.mineborne.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;

public class ItemEstus extends ItemFood {
	
	private PotionEffect[] effects;
	private FoodStats food = new FoodStats();

	public ItemEstus(PotionEffect... effects) {
		super(0, 0.1f, false);
		setAlwaysEdible();
		this.effects = effects;
		setUnlocalizedName(Reference.MineborneItems.ESTUS.getUnlocalizedName());
		setRegistryName(Reference.MineborneItems.ESTUS.getRegistryName());
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
		
		for (int i = 0; i < effects.length; i++) {
			if(!world.isRemote && effects[i] != null)
				player.addPotionEffect(new PotionEffect(this.effects[i]));
			food.setFoodLevel(20);
		}
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack){
		return EnumAction.DRINK;
	}
}
