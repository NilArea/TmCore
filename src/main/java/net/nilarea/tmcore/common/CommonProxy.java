package net.nilarea.tmcore.common;

import net.nilarea.tmcore.TechnoMatrixCore;
import net.nilarea.tmcore.api.registry.TmRegistries;
import net.nilarea.tmcore.config.ConfigHolder;
import net.nilarea.tmcore.data.blockentities.TmBlockEntities;
import net.nilarea.tmcore.data.blocks.TmBlocks;
import net.nilarea.tmcore.data.entities.TmEntityTypes;
import net.nilarea.tmcore.data.fluids.TmFluids;
import net.nilarea.tmcore.data.items.TmItems;
import net.nilarea.tmcore.data.misc.TmCreativeModeTabs;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonProxy {

    public CommonProxy() {
        var modBus = TechnoMatrixCore.getModEventBus();
        ConfigHolder.init();
        modBus.register(CommonProxy.class);
        Init();

        TmRegistries.init(modBus);
    }

    public static void Init() {
        ConfigHolder.init();

        TmFluids.init();
        TmCreativeModeTabs.init();
        TmBlocks.init();
        TmEntityTypes.init();
        TmBlockEntities.init();

        TmItems.init();
    }

    @SubscribeEvent
    private static void OnCommonSetup(FMLCommonSetupEvent event) {}
}
