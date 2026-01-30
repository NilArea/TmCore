package net.nilarea.tmcore.common.registry;

import net.nilarea.tmcore.TechnoMatrixCore;
import net.nilarea.tmcore.api.registry.registry.TmRegistrate;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class TmRegistration {

    public static TmRegistrate REGISTRATE = TmRegistrate.create(TechnoMatrixCore.MOD_ID);

    static {
        REGISTRATE.defaultCreativeTab((ResourceKey<CreativeModeTab>) null);
    }

    public static void init() {}
}
