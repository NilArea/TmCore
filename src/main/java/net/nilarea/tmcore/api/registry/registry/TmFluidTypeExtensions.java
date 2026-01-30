package net.nilarea.tmcore.api.registry.registry;

import net.nilarea.tmcore.utils.TmUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TmFluidTypeExtensions implements IClientFluidTypeExtensions {

    public static final Identifier FLUID_SCREEN_OVERLAY = TmUtil.id("textures/misc/fluid_screen_overlay.png");

    public TmFluidTypeExtensions(@Nullable Identifier stillTexture,
                                 @Nullable Identifier flowingTexture,
                                 int tintColor) {
        this.stillTexture = stillTexture;
        this.flowingTexture = flowingTexture;
        this.tintColor = tintColor;
    }

    @Getter
    @Setter
    @Nullable
    private Identifier flowingTexture, stillTexture;
    @Getter
    @Setter
    private int tintColor;

    @Override
    public Identifier getRenderOverlayTexture(@NotNull Minecraft mc) {
        return FLUID_SCREEN_OVERLAY;
    }
}
