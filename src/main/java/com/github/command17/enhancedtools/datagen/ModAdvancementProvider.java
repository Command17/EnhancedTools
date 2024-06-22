package com.github.command17.enhancedtools.datagen;

import com.github.command17.enhancedtools.EnhancedTools;
import com.github.command17.enhancedtools.item.ModItems;
import com.github.command17.enhancedtools.util.ModTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

public class ModAdvancementProvider implements AdvancementProvider.AdvancementGenerator {
    @ParametersAreNonnullByDefault
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
        Advancement.Builder.advancement()
                .display(
                        new DisplayInfo(
                                new ItemStack(ModItems.COPPER_IRON_PICKAXE.get()),
                                Component.translatable(translate("title.enhancing")),
                                Component.translatable(translate("description.enhancing")),
                                null,
                                AdvancementType.TASK,
                                true,
                                true,
                                false
                        )
                )
                .addCriterion("has_enhancement_item",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                ItemPredicate.Builder.item().of(ModTags.ItemTag.ENHANCED_TOOLS_TAG).build()
                        )
                )
                .parent(EnhancedTools.mcResource("story/iron_tools"))
                .save(saver, EnhancedTools.resource("enhancing"), existingFileHelper);

        Advancement.Builder.advancement()
                .addCriterion("has_hammer",
                        InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.NETHERITE_HAMMER.get(), ModItems.COPPER_NETHERITE_HAMMER.get()))
                .parent(EnhancedTools.mcResource("nether/obtain_ancient_debris"))
                .display(
                        new DisplayInfo(
                                new ItemStack(ModItems.NETHERITE_HAMMER.get()),
                                Component.translatable(translate("title.obtain_netherite_hammer")),
                                Component.translatable(translate("description.obtain_netherite_hammer")),
                                null,
                                AdvancementType.CHALLENGE,
                                true,
                                true,
                                false
                        )
                ).save(saver, EnhancedTools.resource("obtain_netherite_hammer"), existingFileHelper);
    }

    private static String translate(String str) {
        return "advancement." + EnhancedTools.MOD_ID + "." + str;
    }
}
