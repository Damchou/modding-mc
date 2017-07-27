package damcho.mineborne;

import damcho.mineborne.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MineborneTab extends CreativeTabs{

	public MineborneTab() {
		super("tabMineborne");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.estus);
	}

}
