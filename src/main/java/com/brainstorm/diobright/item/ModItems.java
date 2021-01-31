package com.brainstorm.diobright.item;

import com.brainstorm.diobright.DiobrightMod;
import com.brainstorm.diobright.util.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> DIO_ROD =
            Registration.ITEMS.register("dio_rod",
                    () -> new Item(new Item.Properties().group(DiobrightMod.DIOBRIGHT_TAB)));

    public static void register() {}
}
