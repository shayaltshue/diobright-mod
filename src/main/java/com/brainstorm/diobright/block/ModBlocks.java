package com.brainstorm.diobright.block;

import com.brainstorm.diobright.DiobrightMod;
import com.brainstorm.diobright.util.Registration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final RegistryObject<Block> DIOBRIGHT_BLOCK = register("diobright_block",
            () -> new Block(Block.Properties.create(Material.ROCK)
                    .lightValue(15)
                    .hardnessAndResistance(1f, 5f)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> DIOBRICK_BLOCK = register("diobrick_block",
            () -> new Block(Block.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3f, 10f)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));

    public static void register() {}

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(DiobrightMod.DIOBRIGHT_TAB)));
        return toReturn;
    }
}
