package damcho.mineborne.blocks;

import damcho.mineborne.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DarkOrnament extends Block {

	public DarkOrnament() {
		super(Material.ROCK);
		setUnlocalizedName(Reference.MineborneBlocks.DARKORNAMENT.getRegistryName());
		setRegistryName(Reference.MineborneBlocks.DARKORNAMENT.getRegistryName());
		setBlockUnbreakable();
		setResistance(15.0f);
	}

}
