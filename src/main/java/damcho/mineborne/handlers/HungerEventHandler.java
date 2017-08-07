package damcho.mineborne.handlers;

import damcho.mineborne.blocks.AreaPlate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogDensity;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HungerEventHandler {
	
	/*
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	
	public void onEventTest(FogDensity event) {
		event.setDensity(0.7f);
		event.setCanceled(true);
	}*/
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	
	public void onEventFogTest(FogColors event) {
		event.setRed(200.0f);
	}
	
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	
	public void onEventJoin(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof EntityPlayer){
			System.out.println("Joined, hunger activated");
			((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("speed"), 100000, 2));
		}
	}

}
