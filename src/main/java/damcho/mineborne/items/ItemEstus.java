package damcho.mineborne.items;

import damcho.mineborne.Mineborne;
import damcho.mineborne.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.FoodStats;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEstus extends ItemFood {
	
	private PotionEffect[] effects;
	private FoodStats food = new FoodStats();

	public ItemEstus(PotionEffect... effects) {
		super(0, 0.1f, false);
		setAlwaysEdible();
		this.effects = effects;
		setUnlocalizedName(Reference.MineborneItems.ESTUS.getUnlocalizedName());
		setRegistryName(Reference.MineborneItems.ESTUS.getRegistryName());
		setCreativeTab(Mineborne.CREATIVE_TAB);
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemstack) {
		return EnumRarity.UNCOMMON;
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
	
	// Makes Estus Flask undroppable
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		return false;
	}
	
	// Makes Estus Flask's life span in world to 0 ticks
	@Override
	public int getEntityLifespan(ItemStack itemStack, World world) {
		return 0;
	}
	
	
}
