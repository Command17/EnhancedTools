package com.github.command17.enhancedtools.client;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.util.ModItemProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EnhancedTools.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnhancedToolsClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EnhancedTools.LOGGER.info("Initializing Client...");

        event.enqueueWork(ModItemProperties::addCustomItemProperties);

        EnhancedTools.LOGGER.info("Initialized Client.");
    }
}
