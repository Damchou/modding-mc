package damcho.mineborne.handlers;

import java.io.File;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	public static boolean keepInventory;
	
	public static void init() {
		Configuration config = new Configuration(new File("Config/KeepingInentory.cfg"));
		config.load();
		
		keepInventory = config.getBoolean("keepInventory", Configuration.CATEGORY_GENERAL, true, "Whether players keep their inventory on death.");
		
		if(config.hasChanged()) config.save();
	}
	
}
