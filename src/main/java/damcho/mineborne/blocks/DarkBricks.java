package damcho.mineborne.blocks;

import damcho.mineborne.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DarkBricks extends Block {

	public DarkBricks() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.MineborneBlocks.DARKBRICKS.getRegistryName());
		setRegistryName(Reference.MineborneBlocks.DARKBRICKS.getRegistryName());
		setBlockUnbreakable();
		setResistance(15.0f);
	}

}
