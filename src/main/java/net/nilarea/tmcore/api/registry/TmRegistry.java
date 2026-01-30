package net.nilarea.tmcore.api.registry;

import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

import com.mojang.serialization.Lifecycle;

public class TmRegistry<T> extends MappedRegistry<T> {

    public TmRegistry(ResourceKey<? extends Registry<T>> key, Lifecycle lifecycle) {
        super(key, lifecycle);
    }

    public TmRegistry(ResourceKey<? extends Registry<T>> key, Lifecycle initialLifecycle, boolean intrusiveHolders) {
        super(key, initialLifecycle, intrusiveHolders);
    }
}
