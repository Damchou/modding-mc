package damcho.mineborne.render;

import org.lwjgl.opengl.GL11;

import damcho.mineborne.Reference;
import damcho.mineborne.entity.EntityFirebomb;
import damcho.mineborne.tileentity.TileEntityBonfire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityBonfireRenderer extends TileEntitySpecialRenderer {

	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":" + "blocks/bonfire.png");
	private TileEntityBonfire bonfireModel = new TileEntityBonfire();
	
	public TileEntityBonfireRenderer() {
		
	}
	
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTick, int destroyStage) {
		
	}
	
	public void doRender(TileEntityBonfire entity, double x, double y, double z, float entityYaw, float partialTicks) {
		
		float scaleFactor = 4.5F;
		GlStateManager.pushMatrix();
		GlStateManager.translate(0F, 1.5F-1.5F*scaleFactor, 0F);
		GlStateManager.scale(scaleFactor, scaleFactor, scaleFactor);
		GlStateManager.popMatrix();
	}

}
