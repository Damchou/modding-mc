package damcho.mineborne.handlers;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;

public class DeathHandler {
	
	@EventHandler
	public void onPlayerDeath(PlayerDropsEvent event) {
		event.setCanceled(true);
	}
}
