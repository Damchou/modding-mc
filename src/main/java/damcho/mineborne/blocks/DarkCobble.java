package damcho.mineborne.blocks;

import damcho.mineborne.Mineborne;
import damcho.mineborne.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DarkCobble extends Block {

	public DarkCobble() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.MineborneBlocks.DARKCOBBLE.getRegistryName());
		setRegistryName(Reference.MineborneBlocks.DARKCOBBLE.getRegistryName());
		setBlockUnbreakable();
		setResistance(15.0f);
		setCreativeTab(Mineborne.CREATIVE_TAB);
	}

}
