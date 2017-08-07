package damcho.mineborne.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiDeathTest extends GuiScreen {
	

	private static Minecraft mc = Minecraft.getMinecraft();
	protected static EntityPlayer player = mc.player;
	
	protected static boolean isValid = true;
	
	protected static int alpha = 0;
	protected static int titleAlpha = 0;
	protected static int clock = 0;
	
	protected float last_time = System.nanoTime();
	protected static int delta_time;
	
	protected static boolean isDone = false;
	
	@Override
    public void initGui() {}

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
    	

        super.drawScreen(mouseX, mouseY, partialTicks);
        drawWorldBackground(1);
        
        ScaledResolution res = new ScaledResolution(mc);
		int width = res.getScaledWidth();
		int height = res.getScaledHeight();
		
		
		if(isValid) {
			System.out.println("Validating");
			alpha = 0;
			titleAlpha = 0;
			clock = 0;
			last_time = System.nanoTime();
			isValid = false;
		}
		
		int offset = 128;
		int x = (int) (width);
		int y = (int) (height);
		
		
		long time = System.nanoTime();
		delta_time = (int) ((time - last_time) / 1000000);
		last_time = time;
		clock += delta_time;
		
		
		GlStateManager.pushMatrix();
		GlStateManager.enableBlend();
		GlStateManager.enableAlpha();
		
		if(clock >= 20) {
			
			if(alpha < 220)
				alpha++;
		}
		
		if(clock >= 600) {
			if(titleAlpha < 200)
				titleAlpha++;
		}

		mc.getTextureManager().bindTexture(new ResourceLocation("dmb:textures/gui/deathscreen_title3.png"));
		mc.draw(0, 0, 0, 0, x, y, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, alpha);
		
		mc.getTextureManager().bindTexture(new ResourceLocation("dmb:textures/gui/title.png"));
		mc.draw((x/2)-offset, 0, 0, 0, 256, 256, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF, titleAlpha);
		
		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.popMatrix();
		
		
		if(clock >= 7000){
			//if((boss.isActive 		(when all players are dead, boss.isActive = false
				//text with "waiting for other players to die
			//else
			mc.player.closeScreen();
			isValid = true;
			isDone = true;
			mc.player.respawnPlayer();
		}
		
		
    	
	}

    // Because GuiOpenEvent triggers twice, we use boolean (isDone) to prevent another
    // Game Over screen to pop up
    @Override
    public void updateScreen() {
        super.updateScreen();
        if(!mc.player.isDead && isDone) {
        	System.out.println("Done rendering Game Over");
        	isDone = false;
			mc.player.closeScreen();
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
    	return false;
    }

    // Because GuiOpenEvent triggers twice, we use boolean to lock our
    // custom game over screen for short amount of time
    
	public static void setLock() {
		isDone = true;
	}
	
	public static boolean getLock() {
		return isDone;
	}
}
