package damcho.mineborne.blocks;

import damcho.mineborne.Mineborne;
import damcho.mineborne.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DarkSquare extends Block {

	public DarkSquare() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.MineborneBlocks.DARKSQUARE.getRegistryName());
		setRegistryName(Reference.MineborneBlocks.DARKSQUARE.getRegistryName());
		setBlockUnbreakable();
		setResistance(15.0f);
		setCreativeTab(Mineborne.CREATIVE_TAB);
	}

}
