package damcho.mineborne.blocks;

import damcho.mineborne.Mineborne;
import damcho.mineborne.Reference;
import damcho.mineborne.gui.Draw;
import damcho.mineborne.gui.RenderHandler;
import damcho.mineborne.handlers.CustomSoundHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;

public class AreaPlate extends Block{
	
	private static final String AREA_NAME = "test1";
	
	protected static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.03125D, 0.9375D);
	protected static boolean isActivated = false;
	
	private static Minecraft mc = Minecraft.getMinecraft();
	
	public AreaPlate() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.MineborneBlocks.AREAPLATE.getRegistryName());
		setRegistryName(Reference.MineborneBlocks.AREAPLATE.getRegistryName());
		setCreativeTab(Mineborne.CREATIVE_TAB);
		setBlockUnbreakable();
		setResistance(15.0f);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	
	// for testing, use better data saving for MP
	public static void setDeactivation() {
		isActivated = false;
	}
	
	public static void resetOther() {
		AreaPlateFurnace.setDeactivation();
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
	super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		if(entityIn instanceof EntityPlayerMP && !isActivated) {
			Draw.setValid();
			isActivated = true;
			resetOther();
			worldIn.playSound(null, entityIn.getPosition(), CustomSoundHandler.NEW_AREA_SOUND, SoundCategory.MASTER, 2.0f, 1.0f);
			System.out.println("AreaPlate activated " + entityIn + ", " + worldIn);
			RenderHandler.setDiscoveryText(AREA_NAME);
		}
	}	
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    public boolean canCreatureSpawn(IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
    	return false;
    }

    
}
