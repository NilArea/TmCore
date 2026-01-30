package net.nilarea.tmcore.common;

import net.nilarea.tmcore.data.blocks.TmBlocks;
import net.nilarea.tmcore.data.fluids.TmFluids;
import net.nilarea.tmcore.data.items.TmItems;
import net.nilarea.tmcore.data.misc.TmCreativeTabs;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class TmCommonProxy {

    public TmCommonProxy() {
        Init();
    }

    public static void Init() {
        TmCreativeTabs.init();
        TmBlocks.init();
        TmItems.init();
        TmFluids.init();
    }

    @SubscribeEvent
    private static void OnCommonSetup(FMLCommonSetupEvent event) {}
}
