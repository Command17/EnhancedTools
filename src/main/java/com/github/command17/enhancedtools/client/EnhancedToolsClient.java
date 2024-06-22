package com.github.command17.enhancedtools.client;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.util.ModItemProperties;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = EnhancedTools.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EnhancedToolsClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EnhancedTools.LOGGER.info("Initializing Client...");

        event.enqueueWork(ModItemProperties::addCustomItemProperties);

        EnhancedTools.LOGGER.info("Initialized Client.");
    }
}
