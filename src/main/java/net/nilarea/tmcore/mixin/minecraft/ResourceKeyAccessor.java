package net.nilarea.tmcore.mixin.minecraft;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = ResourceKey.class, remap = false)
public interface ResourceKeyAccessor {

    @Invoker("<init>")
    static <T> ResourceKey<T> callCreate(Identifier registryName, Identifier location) {
        throw new AssertionError();
    }
}
