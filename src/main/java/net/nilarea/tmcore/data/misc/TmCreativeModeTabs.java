package net.nilarea.tmcore.data.misc;

import net.nilarea.tmcore.TechnoMatrixCore;
import net.nilarea.tmcore.api.registry.registry.TmRegistrate;
import net.nilarea.tmcore.utils.TmUtil;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import com.tterrag.registrate.util.entry.RegistryEntry;
import org.jetbrains.annotations.NotNull;

import static net.nilarea.tmcore.common.registry.TmRegistration.REGISTRATE;

public class TmCreativeModeTabs {

    public static RegistryEntry<CreativeModeTab, CreativeModeTab> MATERIAL_FLUID = REGISTRATE.defaultCreativeTab("material_fluid",
            builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("material_fluid", REGISTRATE))
                    .icon(Items.COMMAND_BLOCK::getDefaultInstance)
                    .title(REGISTRATE.addLang("itemGroup", TmUtil.id("material_fluid"),
                            TechnoMatrixCore.MOD_NAME + " Material Fluid Containers"))
                    .build())
            .register();
    public static RegistryEntry<CreativeModeTab, CreativeModeTab> MATERIAL_ITEM = REGISTRATE.defaultCreativeTab("material_item",
            builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("material_item", REGISTRATE))
                    .icon(Items.COMMAND_BLOCK::getDefaultInstance)
                    .title(REGISTRATE.addLang("itemGroup", TmUtil.id("material_item"), TechnoMatrixCore.MOD_NAME + " Material Items"))
                    .build())
            .register();
    public static RegistryEntry<CreativeModeTab, CreativeModeTab> MATERIAL_BLOCK = REGISTRATE.defaultCreativeTab("material_block",
            builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("material_block", REGISTRATE))
                    .icon(Items.COMMAND_BLOCK::getDefaultInstance)
                    .title(REGISTRATE.addLang("itemGroup", TmUtil.id("material_block"), TechnoMatrixCore.MOD_NAME + " Material Blocks"))
                    .build())
            .register();
    public static RegistryEntry<CreativeModeTab, CreativeModeTab> DECORATION = REGISTRATE.defaultCreativeTab("decoration",
            builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("decoration", REGISTRATE))
                    .icon(Items.COMMAND_BLOCK::getDefaultInstance)
                    .title(REGISTRATE.addLang("itemGroup", TmUtil.id("decoration"), TechnoMatrixCore.MOD_NAME + " Decoration Blocks"))
                    .build())
            .register();
    public static RegistryEntry<CreativeModeTab, CreativeModeTab> TOOL = REGISTRATE.defaultCreativeTab("tool",
            builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("tool", REGISTRATE))
                    .icon(Items.COMMAND_BLOCK::getDefaultInstance)
                    .title(REGISTRATE.addLang("itemGroup", TmUtil.id("tool"), TechnoMatrixCore.MOD_NAME + " Tools"))
                    .build())
            .register();
    public static RegistryEntry<CreativeModeTab, CreativeModeTab> MACHINE = REGISTRATE.defaultCreativeTab("machine",
            builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("machine", REGISTRATE))
                    .icon(Items.COMMAND_BLOCK::getDefaultInstance)
                    .title(REGISTRATE.addLang("itemGroup", TmUtil.id("machine"), TechnoMatrixCore.MOD_NAME + " Machines"))
                    .build())
            .register();
    public static RegistryEntry<CreativeModeTab, CreativeModeTab> ITEM = REGISTRATE.defaultCreativeTab("item",
            builder -> builder.displayItems(new RegistrateDisplayItemsGenerator("item", REGISTRATE))
                    .icon(Items.COMMAND_BLOCK::getDefaultInstance)
                    .title(REGISTRATE.addLang("itemGroup", TmUtil.id("item"), TechnoMatrixCore.MOD_NAME + " Items"))
                    .build())
            .register();

    public static void init() {}

    public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        public final String name;
        public final TmRegistrate registrate;

        public RegistrateDisplayItemsGenerator(String name, TmRegistrate registrate) {
            this.name = name;
            this.registrate = registrate;
        }

        @Override
        public void accept(@NotNull CreativeModeTab.ItemDisplayParameters itemDisplayParameters,
                           @NotNull CreativeModeTab.Output output) {
            var tab = registrate.get(name, Registries.CREATIVE_MODE_TAB);
            for (var entry : registrate.getAll(Registries.BLOCK)) {
                if (!registrate.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get().asItem();
                if (item == Items.AIR)
                    continue;
            }
            for (var entry : registrate.getAll(Registries.ITEM)) {
                if (!registrate.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get();
                switch (item) {
                    default -> output.accept(item);
                }
            }
        }
    }
}
