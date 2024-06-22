package com.github.command17.enhancedtools.item.tab;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    private static final DeferredRegister<CreativeModeTab> TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnhancedTools.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENHANCED_TOOLS_TAB = TAB_REGISTRY.register("enhanced_tools",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativemodetab.enhancedtools.enhanced_tools"))
                    .icon(() -> new ItemStack(ModItems.COPPER_BOW.get()))
                    .build());

    public static void register(IEventBus eventBus) {
        TAB_REGISTRY.register(eventBus);

        EnhancedTools.LOGGER.info("Registered Creative Mode Tabs.");
    }
}
