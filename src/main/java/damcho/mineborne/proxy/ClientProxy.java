package damcho.mineborne.proxy;

import damcho.mineborne.entity.EntityFirebomb;
import damcho.mineborne.handlers.CustomSoundHandler;
import damcho.mineborne.init.ModBlocks;
import damcho.mineborne.init.ModItems;
import damcho.mineborne.render.RenderFirebomb;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy implements CommonProxy{
	
	
	@Override
	public void preInit() {
		RenderFirebomb.registerRender();
	}

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
	
}
