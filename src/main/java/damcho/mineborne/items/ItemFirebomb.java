package damcho.mineborne.items;

import damcho.mineborne.CooldownController;
import damcho.mineborne.Mineborne;
import damcho.mineborne.Reference;
import damcho.mineborne.entity.EntityFirebomb;
import damcho.mineborne.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFirebomb extends Item{
	
	protected final static String DAMAGETYPE = "fire";
	protected final static float DAMAGE = 1;
	protected final static int COOLDOWN = 2;
	
	private CooldownController cc;

	public ItemFirebomb() {
		setUnlocalizedName(Reference.MineborneItems.FIREBOMB.getUnlocalizedName());
		setRegistryName(Reference.MineborneItems.FIREBOMB.getRegistryName());
		setCreativeTab(Mineborne.CREATIVE_TAB);
		this.cc = new CooldownController(COOLDOWN);
	}
	
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemstack) {
		return EnumRarity.EPIC;
	}
	
	public static String getDamageType() {
		return DAMAGETYPE;
	}
	
	public static float getDamage() {
		return DAMAGE;
	}
	
	public boolean isStackable() {
		return true;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		
		// Create an ItemStack from the item being held in the hand of player
		ItemStack itemstack = player.getHeldItem(hand);
		this.cc.setItemStack(itemstack);
		
		if(this.cc.getCooldown() > 0) {
			return new ActionResult(EnumActionResult.PASS, itemstack);
		} else {
		
		// (1) Decrement the stack size if NOT in creative mode
		if(!player.capabilities.isCreativeMode)
			itemstack.shrink(1);
		
		// (2) Play the sound
		world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.NEUTRAL, 0.5f, 0.4f / (itemRand.nextFloat() * 0.4f + 0.8f));
		
		if(!world.isRemote) {
			EntityFirebomb firebomb = new EntityFirebomb(world, player);
			firebomb.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 1.0f, 0.7f, 0.5f);
			world.spawnEntity(firebomb);
		}

		this.cc.setCooldownOn(player);
		
		player.addStat(StatList.getObjectUseStats(this));
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int metadata, boolean bool) {

		cc.update(itemstack, world, entity, metadata, bool);
	}
	
}
