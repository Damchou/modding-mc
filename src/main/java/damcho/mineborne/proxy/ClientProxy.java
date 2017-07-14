package damcho.mineborne.proxy;

import damcho.mineborne.init.ModBlocks;
import damcho.mineborne.init.ModItems;

public class ClientProxy implements CommonProxy{

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}

	
}
