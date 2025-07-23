package net.oni_feralis.oceanflora.item;

import net.oni_feralis.oceanflora.OceanFlora;
import net.oni_feralis.oceanflora.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OceanFlora.MOD_ID);

    public static final Supplier<CreativeModeTab> OCEANFLORA_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SEATATO.get()))
                    .title(Component.translatable("creativetab.tutorialmod.bismuth_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SEATATO);

                    }).build());

    public static final Supplier<CreativeModeTab> OCEANFLORA_BLOCK_TAB = CREATIVE_MODE_TAB.register("bismuth_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.SEATATO_CROP))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(OceanFlora.MOD_ID, "bismuth_items_tab"))
                    .title(Component.translatable("creativetab.oceanflora.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}