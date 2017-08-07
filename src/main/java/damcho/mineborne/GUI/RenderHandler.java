package damcho.mineborne.gui;

import damcho.mineborne.handlers.CustomSoundHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class RenderHandler {

	public static RenderHandler instance = new RenderHandler();
	private static Minecraft mc = Minecraft.getMinecraft();
	private static String name;
	private static boolean activated = false;
	
	@SubscribeEvent
	public void RenderGameOverlayEvent(RenderGameOverlayEvent.Post event) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT && activated) {
			EntityPlayer player = (EntityPlayer) mc.player;
			Draw.renderText(name);
		}
	}
	
	public static void setDiscoveryText(String givenName) {
		System.out.println("requested discovery text");
		name = givenName;
		activated = true;
	}
	
	public static void deactivate() {
		System.out.println("deactivated");
		activated = false;
	}
	
	public static void resetString() {
		name = null;
	}
}
