package damcho.mineborne;

import damcho.mineborne.events.HungerEventHandler;
import damcho.mineborne.init.ModBlocks;
import damcho.mineborne.init.ModItems;
import damcho.mineborne.proxy.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Mineborne {
	
	@Instance
	public static Mineborne instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Pre Init");
		
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("Init");
		proxy.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("Post Init");
		
		MinecraftForge.EVENT_BUS.register(new HungerEventHandler());
	}
	
}
