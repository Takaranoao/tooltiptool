package com.takaranoao.mods.tooltiptool.listener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dimdev.riftloader.listener.InitializationListener;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

public class InitListener implements InitializationListener {
    private static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void onInitialization() {
        LOGGER.info("Adding TooltipTool Mixins");
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.tooltiptool.json");

    }
}
