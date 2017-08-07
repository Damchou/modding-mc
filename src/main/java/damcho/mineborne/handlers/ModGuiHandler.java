package damcho.mineborne.handlers;

import damcho.mineborne.gui.GuiDeathTest;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGameOver;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler{
	
	private static Minecraft mc = Minecraft.getMinecraft();

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}
	
	@SubscribeEvent
	public void openEvent(GuiOpenEvent event) {
		if(event.getGui() instanceof GuiGameOver){
			System.out.println("triggered!");
			event.isCanceled();
			event.setGui(new GuiDeathTest());
		}
	}

	
}
