package net.nilarea.tmcore.api.registry;

import net.nilarea.tmcore.utils.TmUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.RegisterEvent;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.jetbrains.annotations.ApiStatus;

import java.util.function.Consumer;

public class TmRegistries {

    public static final Identifier ROOT_REGISTRY_NAME = TmUtil.id("root");
    public static final TmRegistry<TmRegistry<?>> ROOT = new TmRegistry<>(ROOT_REGISTRY_NAME);
    // TODO ResourceKey

    public static <T> ResourceKey<Registry<T>> makeRegistryKey(Identifier registryId) {
        return ResourceKey.createRegistryKey(registryId);
    }

    private static final Table<Registry<?>, Identifier, Object> TO_REGISTER = HashBasedTable.create();

    public static <V, T extends V> T register(Registry<V> registry, Identifier name, T value) {
        TO_REGISTER.put(registry, name, value);
        return value;
    }

    // ignore the generics and hope the registered objects are still correctly typed :3
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static void actuallyRegister(RegisterEvent event) {
        for (Registry reg : TO_REGISTER.rowKeySet()) {
            event.register(reg.key(), helper -> {
                TO_REGISTER.row(reg).forEach(helper::register);
            });
        }
    }

    public static void init(IEventBus eventBus) {
        Consumer<RegisterEvent> actuallyRegister = TmRegistries::actuallyRegister;
        eventBus.addListener(actuallyRegister);
    }

    private static final RegistryAccess BLANK = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
    private static RegistryAccess FROZEN = BLANK;

    /**
     * You shouldn't call it, you should probably not even look at it just to be extra safe
     *
     * @param registryAccess the new value to set to the frozen registry access
     */
    @ApiStatus.Internal
    public static void updateFrozenRegistry(RegistryAccess registryAccess) {
        FROZEN = registryAccess;
    }

    public static RegistryAccess builtinRegistry() {
        if (FROZEN == BLANK && TmUtil.isClientThread()) {
            if (Minecraft.getInstance().getConnection() != null) {
                return Minecraft.getInstance().getConnection().registryAccess();
            }
        }
        return FROZEN;
    }
}
