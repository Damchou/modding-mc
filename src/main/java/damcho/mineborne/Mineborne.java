package damcho.mineborne;

import damcho.mineborne.entity.EntityFirebomb;
import damcho.mineborne.handlers.CustomSoundHandler;
import damcho.mineborne.handlers.DeathHandler;
import damcho.mineborne.handlers.HungerEventHandler;
import damcho.mineborne.init.ModBlocks;
import damcho.mineborne.init.ModItems;
import damcho.mineborne.proxy.CommonProxy;
import damcho.mineborne.render.RenderFirebomb;
import damcho.mineborne.tileentity.TileEntityBonfire;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class Mineborne {
	
	@Instance
	public static Mineborne instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs CREATIVE_TAB = new MineborneTab();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Pre Init");
		
		proxy.preInit();
		
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println("Init");
		proxy.init();

		GameRegistry.registerTileEntity(TileEntityBonfire.class, Reference.MOD_ID + "TileEntityBonfire");
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + "Firebomb"), EntityFirebomb.class, "Firebomb", 0, this, 64, 10, true);
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println("Post Init");
		
		MinecraftForge.EVENT_BUS.register(new HungerEventHandler());
		MinecraftForge.EVENT_BUS.register(new DeathHandler());
	}
	
}
