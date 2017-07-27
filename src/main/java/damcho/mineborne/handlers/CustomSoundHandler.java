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
					NEW_AREA_SOUND
			);
		}
}

}
