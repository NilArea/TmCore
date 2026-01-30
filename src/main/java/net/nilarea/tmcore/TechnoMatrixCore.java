package net.nilarea.tmcore;

import net.nilarea.tmcore.client.ClientProxy;
import net.nilarea.tmcore.common.CommonProxy;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

import com.tterrag.registrate.util.RegistrateDistExecutor;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TechnoMatrixCore.MOD_ID)
public class TechnoMatrixCore {

    public static final String MOD_ID = "tmcore";
    public static final String MOD_NAME = "科技矩阵";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Getter
    public static IEventBus modEventBus;
    @Getter
    public static ModContainer modContainer;

    public TechnoMatrixCore(IEventBus modEventBus, ModContainer modContainer) {
        TechnoMatrixCore.modEventBus = modEventBus;
        TechnoMatrixCore.modContainer = modContainer;
        RegistrateDistExecutor.unsafeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    }
}
