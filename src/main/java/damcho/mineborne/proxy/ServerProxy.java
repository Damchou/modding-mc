package damcho.mineborne.proxy;

import damcho.mineborne.Mineborne;
import damcho.mineborne.handlers.ModGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ServerProxy implements CommonProxy{

	@Override
	public void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Mineborne.instance, new ModGuiHandler());
	}

	@Override
	public void preInit() {
		// TODO Auto-generated method stub
		
	}

}
