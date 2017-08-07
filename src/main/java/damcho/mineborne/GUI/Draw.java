package damcho.mineborne.gui;

import org.lwjgl.opengl.GL11;

import damcho.mineborne.CooldownController;
import damcho.mineborne.blocks.AreaPlate;
import damcho.mineborne.blocks.AreaPlateFurnace;
import damcho.mineborne.handlers.CustomSoundHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Draw {
	
	private static Minecraft mc = Minecraft.getMinecraft();
	protected static World world = mc.world;
	protected static EntityPlayer player = mc.player;
	
	protected static int delta_time;
	static long last_time = System.nanoTime();
	
	
	protected static float scale = 0;
	protected static int counter = 0;
	
	protected static int textAlpha = 0;
	protected static int textClock = 0;
	
	protected static int deathAlpha = 0;
	protected static int deathTitleAlpha = 0;
	protected static int deathClock = 0;
	
	protected static boolean isValid = true;
	
	
	public static void setValid() {
		isValid = true;
	}
	
	
	public static void renderText(String name) {
		if(mc.inGameHasFocus || (mc.currentScreen != null)) {
			
			ScaledResolution res = new ScaledResolution(mc);
			FontRenderer fontRender = mc.fontRenderer;
			int width = res.getScaledWidth();
			int height = res.getScaledHeight();
			
			if(isValid) {
				System.out.println("Validating, " + player + ", " + world);
				textAlpha = 0;
				scale = 0;
				counter = 0;
				textClock = 0;
				isValid = false;
				
			}
			
			if(counter != 2) {
				
				GlStateManager.pushMatrix();
				GlStateManager.enableBlend();
				GlStateManager.enableAlpha(); // tarpeellisia?
				GlStateManager.scale(scale, scale, scale);
				
				long time = System.nanoTime();
				delta_time = (int) ((time - last_time) / 1000000);
				last_time = time;
				textClock += delta_time;
				
				int var6 = res.getScaledWidth();
				int var7 = res.getScaledHeight();
				
				int x = (int) (width / (scale * 2));
				int y = (int) (height / 8);
				
				int color = 0xffffff;
				int offset = mc.fontRenderer.getStringWidth(name) / 2;
				
				
				
				if(textClock >= 150) {
					
					System.out.println("TICK TOCK!" + textClock);
					if(textAlpha < 254 && counter == 0) {
						textAlpha += 2;
					}
					if(textAlpha == 4 && counter == 0)
						scale = 3.0f;
					if(textAlpha >= 254 && counter == 0) {
						counter = 1;
					}
					if(textAlpha > 0 && counter == 1) {
						textAlpha -= 1;
					}	
					if(textAlpha == 4 && counter == 1)
						scale = 0;
					if(textAlpha <= 0 && counter == 1) {
						counter = 2;
						textAlpha = 0;
					}
				}
				
				mc.fontRenderer.drawStringWithShadow(name, (x - offset), y, color | textAlpha << 24);
				
				GlStateManager.disableBlend();
				GlStateManager.disableAlpha();
				GlStateManager.popMatrix();
				
				
				
				if(counter == 2) {
					RenderHandler.resetString();
					System.out.println("stoppin hud rendering");
					isValid = true;
					RenderHandler.deactivate();
				}
			}
			
		}
	}
}
