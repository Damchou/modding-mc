package damcho.mineborne.init;

import damcho.mineborne.blocks.AreaPlate;
import damcho.mineborne.blocks.AreaPlateFurnace;
import damcho.mineborne.blocks.BlockBonfire;
import damcho.mineborne.blocks.DarkBricks;
import damcho.mineborne.blocks.DarkCobble;
import damcho.mineborne.blocks.DarkOrnament;
import damcho.mineborne.blocks.DarkSquare;
import damcho.mineborne.items.ItemEstus;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBlocks {
	
	public static Block darkcobble;
	public static Block darkbricks;
	public static Block darksquare;
	public static Block darkornament;
	public static Block blockbonfire;
	public static Block areaplate;
	public static Block areaplate_furnace;
	
	public static void init() {
		darkcobble = new DarkCobble();
		darkbricks = new DarkBricks();
		darksquare = new DarkSquare();
		darkornament = new DarkOrnament();
		blockbonfire = new BlockBonfire();
		areaplate = new AreaPlate();
		areaplate_furnace = new AreaPlateFurnace();
	}
	
	public static void register() {
		registerBlock(darkcobble);
		registerBlock(darkbricks);
		registerBlock(darksquare);
		registerBlock(darkornament);
		registerBlock(blockbonfire);
		registerBlock(areaplate);
		registerBlock(areaplate_furnace);
	}
	
	private static void registerBlock(Block block) {
		ForgeRegistries.BLOCKS.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
	}

	public static void registerRenders() {
		registerRender(darkcobble);
		registerRender(darkbricks);
		registerRender(darksquare);
		registerRender(darkornament);
		registerRender(blockbonfire);
		registerRender(areaplate);
		registerRender(areaplate_furnace);
	}
	
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}