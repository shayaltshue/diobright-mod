package com.brainstorm.diobright;

import com.brainstorm.diobright.block.ModBlocks;
import com.brainstorm.diobright.item.ModItems;
import com.brainstorm.diobright.util.Registration;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(DiobrightMod.MOD_ID)
public class DiobrightMod
{
    public static final String MOD_ID = "diobright";

    public static final ItemGroup DIOBRIGHT_TAB = new ItemGroup("diobrightTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModBlocks.DIOBRIGHT_BLOCK.get());
        }
    };

    private static final Logger LOGGER = LogManager.getLogger();

    public DiobrightMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo(MOD_ID, "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    private void registerModAdditions()
    {
        // Inits the registration of our additions
        Registration.init();

        // Registers items, blocks etc by our mod
        ModBlocks.register();
        ModItems.register();
    }
}
