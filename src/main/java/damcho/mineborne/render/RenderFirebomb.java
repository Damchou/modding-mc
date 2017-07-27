package damcho.mineborne.render;

import damcho.mineborne.Mineborne;
import damcho.mineborne.Reference;
import damcho.mineborne.entity.EntityFirebomb;
import damcho.mineborne.init.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderFirebomb extends Render<EntityFirebomb> {
	
	private static final ResourceLocation firebombTexture = new ResourceLocation(Reference.MOD_ID, "textures/items/firebomb.png");

	protected final Item item;
	private final RenderItem itemRenderer;
	
	
	public RenderFirebomb(RenderManager renderManager) {
		super(renderManager);
		this.item = ModItems.firebomb;
		this.itemRenderer = Minecraft.getMinecraft().getRenderItem();
	}
	
	
	public static void registerRender() {
		RenderingRegistry.registerEntityRenderingHandler(EntityFirebomb.class, new IRenderFactory<EntityFirebomb>() {
			@Override
			public Render<EntityFirebomb> createRenderFor(RenderManager manager) {
				return new RenderFirebomb(manager);
			}
		});
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityFirebomb firebomb) {
		return this.firebombTexture;
	}
	
	public ItemStack getStackToRender(EntityFirebomb entity) {
		return new ItemStack(this.item);
	}
	
	@Override
	public void doRender(EntityFirebomb entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindTexture(firebombTexture);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
}
