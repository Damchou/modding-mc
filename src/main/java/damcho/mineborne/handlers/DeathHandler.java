package damcho.mineborne.handlers;

import java.util.ArrayList;
import java.util.List;

import damcho.mineborne.gui.Draw;
import damcho.mineborne.gui.RenderHandler;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DeathHandler {
	
	@SubscribeEvent
	public void onPlayerDeath(LivingDeathEvent event) {
		
		if(event.getEntity() instanceof EntityPlayer) {
			
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			int rand = (int) ((Math.random() * 6) + 1);
			System.out.println(rand);
			
			switch(rand) {
				case 1: player.getEntityWorld().playSound(null, player.getPosition(), CustomSoundHandler.DEATH_SCREAM01_SOUND, SoundCategory.MASTER, 0.9f, 1.0f);
						break;
				case 2: player.getEntityWorld().playSound(null, player.getPosition(), CustomSoundHandler.DEATH_SCREAM02_SOUND, SoundCategory.MASTER, 0.9f, 1.0f);
						break;
				case 3: player.getEntityWorld().playSound(null, player.getPosition(), CustomSoundHandler.DEATH_SCREAM03_SOUND, SoundCategory.MASTER, 0.9f, 1.0f);
						break;
				case 4: player.getEntityWorld().playSound(null, player.getPosition(), CustomSoundHandler.DEATH_SCREAM04_SOUND, SoundCategory.MASTER, 0.9f, 1.0f);
						break;
				case 5: player.getEntityWorld().playSound(null, player.getPosition(), CustomSoundHandler.DEATH_SCREAM05_SOUND, SoundCategory.MASTER, 0.9f, 1.0f);
						break;
				case 6: player.getEntityWorld().playSound(null, player.getPosition(), CustomSoundHandler.DEATH_SCREAM06_SOUND, SoundCategory.MASTER, 0.9f, 1.0f);
						break;
			}
			
			player.getEntityWorld().spawnParticle(EnumParticleTypes.REDSTONE, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), 0.0D, 0.0D, 0.0D);
			player.getEntityWorld().playSound(null, player.getPosition(), CustomSoundHandler.YOU_DIED_SOUND, SoundCategory.MASTER, 0.9f, 1.0f);

		}
	}
}
