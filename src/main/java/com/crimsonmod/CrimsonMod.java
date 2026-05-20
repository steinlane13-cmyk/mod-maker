package com.crimsonmod;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafxmod.FXModLoadingContext;
import net.minecraftforge.api.distmarker.OnlyIn;

@Mod("crimsonmod")
public class CrimsonMod {
    public CrimsonMod() {
        IEventBus modEventBus = FXModLoadingContext.getInstance().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        
        ModItems.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }
}
