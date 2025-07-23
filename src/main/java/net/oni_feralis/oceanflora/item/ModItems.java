package net.oni_feralis.oceanflora.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.oni_feralis.oceanflora.OceanFlora;
import net.oni_feralis.oceanflora.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OceanFlora.MOD_ID);

    public static final DeferredItem<Item> SEATATO = ITEMS.registerItem("seatato",
                    (properties) -> new BlockItem(ModBlocks.SEATATO_CROP.get(), properties.food(ModFoodProperties.SEATATO)));


//ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}