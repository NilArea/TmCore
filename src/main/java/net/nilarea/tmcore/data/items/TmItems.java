package net.nilarea.tmcore.data.items;

import net.nilarea.tmcore.data.misc.TmCreativeModeTabs;

import net.minecraft.world.item.Item;

import com.tterrag.registrate.util.entry.ItemEntry;

import static net.nilarea.tmcore.common.registry.TmRegistration.REGISTRATE;

public class TmItems {

    static {
        REGISTRATE.creativeModeTab(() -> TmCreativeModeTabs.ITEM);
    }

    public static ItemEntry<Item> TEST_ITEM = REGISTRATE.item("test_item", Item::new)
            .lang("Test Item")
            .register();

    public static void init() {}
}
