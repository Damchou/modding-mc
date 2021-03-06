package damcho.mineborne.init;

import damcho.mineborne.Reference;
import damcho.mineborne.items.ItemEstus;
import damcho.mineborne.items.ItemFirebomb;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class ModItems {
	
	public static Item estus;
	public static Item firebomb;

	public static void init() {
		estus = new ItemEstus(new PotionEffect(Potion.getPotionFromResourceLocation("regeneration"), 110, 3));
		firebomb = new ItemFirebomb();
	}
	
	public static void register() {
		ForgeRegistries.ITEMS.register(estus);
		ForgeRegistries.ITEMS.register(firebomb);
	}

	public static void registerRenders() {
		registerRender(estus);
		registerRender(firebomb);
	}
	
	private static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
