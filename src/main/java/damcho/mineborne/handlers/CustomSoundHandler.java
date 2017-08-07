package damcho.mineborne.handlers;

import damcho.mineborne.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@SuppressWarnings("WeakerAccess")
@ObjectHolder(Reference.MOD_ID)
public class CustomSoundHandler {
	
	@ObjectHolder("bonfire_sound")
	public static final SoundEvent BONFIRE_SOUND = createSoundEvent("bonfire_sound");

	@ObjectHolder("you_died_sound")
	public static final SoundEvent YOU_DIED_SOUND = createSoundEvent("you_died_sound");

	@ObjectHolder("new_area_sound")
	public static final SoundEvent NEW_AREA_SOUND = createSoundEvent("new_area_sound");
	
	@ObjectHolder("death_scream01_sound")
	public static final SoundEvent DEATH_SCREAM01_SOUND = createSoundEvent("death_scream01_sound");
	
	@ObjectHolder("death_scream02_sound")
	public static final SoundEvent DEATH_SCREAM02_SOUND = createSoundEvent("death_scream02_sound");
	
	@ObjectHolder("death_scream03_sound")
	public static final SoundEvent DEATH_SCREAM03_SOUND = createSoundEvent("death_scream03_sound");
	
	@ObjectHolder("death_scream04_sound")
	public static final SoundEvent DEATH_SCREAM04_SOUND = createSoundEvent("death_scream04_sound");
	
	@ObjectHolder("death_scream05_sound")
	public static final SoundEvent DEATH_SCREAM05_SOUND = createSoundEvent("death_scream05_sound");
	
	@ObjectHolder("death_scream06_sound")
	public static final SoundEvent DEATH_SCREAM06_SOUND = createSoundEvent("death_scream06_sound");

	/**
	 * Create a {@link SoundEvent}.
	 *
	 * @param soundName The SoundEvent's name without the testmod3 prefix
	 * @return The SoundEvent
	 */
	private static SoundEvent createSoundEvent(final String soundName) {
		final ResourceLocation soundID = new ResourceLocation(Reference.MOD_ID, soundName);
		return new SoundEvent(soundID).setRegistryName(soundID);
	}

	@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event) {
			event.getRegistry().registerAll(
					BONFIRE_SOUND,
					YOU_DIED_SOUND,
					NEW_AREA_SOUND,
					DEATH_SCREAM01_SOUND,
					DEATH_SCREAM02_SOUND,
					DEATH_SCREAM03_SOUND,
					DEATH_SCREAM04_SOUND,
					DEATH_SCREAM05_SOUND,
					DEATH_SCREAM06_SOUND
			);
		}
}

}
