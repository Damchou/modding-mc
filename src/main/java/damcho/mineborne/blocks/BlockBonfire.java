package damcho.mineborne.blocks;

import java.util.List;

import damcho.mineborne.Mineborne;
import damcho.mineborne.Reference;
import damcho.mineborne.tileentity.TileEntityBonfire;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBonfire extends Block implements ITileEntityProvider {
	
	//0.0625
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 4.5, 0.0625 * 13, 0.0625 * 14, 0.0625 * 12);

	public BlockBonfire() {
		super(Material.IRON);
		setUnlocalizedName(Reference.MineborneBlocks.BLOCKBONFIRE.getRegistryName());
		setRegistryName(Reference.MineborneBlocks.BLOCKBONFIRE.getRegistryName());
		setBlockUnbreakable();
		setResistance(15.0f);
		setCreativeTab(Mineborne.CREATIVE_TAB);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBonfire();
	}

	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote && TileEntityBonfire.getCD() <= 0) {
			
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			
			if(tileEntity instanceof TileEntityBonfire && playerIn instanceof EntityPlayer) {
				
				TileEntityBonfire bonfire = (TileEntityBonfire) tileEntity;
				bonfire.setSpawn(worldIn, playerIn, pos);
				bonfire.giveEstus(playerIn);
			}
		}
		
		return true;
	}

}
