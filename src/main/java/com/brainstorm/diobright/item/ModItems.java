package com.brainstorm.diobright.item;

import com.brainstorm.diobright.DiobrightMod;
import com.brainstorm.diobright.util.Registration;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> DIO_ROD =
            Registration.ITEMS.register("dio_rod",
                    () -> new Item(new Item.Properties().group(DiobrightMod.DIOBRIGHT_TAB)));


    /* Tools */

    public static final RegistryObject<Item> DIORITE_SHOVEL =
            Registration.ITEMS.register("diorite_shovel",
                    () -> new ShovelItem(ModItemTier.DIORITE, 0f, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.SHOVEL, 2)
                                    .group(DiobrightMod.DIOBRIGHT_TAB)));

    public static final RegistryObject<Item> DIORITE_PICKAXE =
            Registration.ITEMS.register("diorite_pickaxe",
                    () -> new PickaxeItem(ModItemTier.DIORITE, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 2)
                                    .group(DiobrightMod.DIOBRIGHT_TAB)));

    public static final RegistryObject<Item> DIORITE_AXE =
            Registration.ITEMS.register("diorite_axe",
                    () -> new AxeItem(ModItemTier.DIORITE, 0, 3f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.AXE, 2)
                                    .group(DiobrightMod.DIOBRIGHT_TAB)));

    public static final RegistryObject<Item> DIORITE_SWORD =
            Registration.ITEMS.register("diorite_sword",
                    () -> new SwordItem(ModItemTier.DIORITE, 1000, 3f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .group(DiobrightMod.DIOBRIGHT_TAB)));

    public static void register() {}


    ;public enum ModItemTier implements IItemTier {
        DIORITE(2, 150, 2.5f, 0f, 10,
                Ingredient.fromStacks(new ItemStack(Items.DIORITE)));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
        public int getMaxUses() {
            return maxUses;
        }

        @Override
        public float getEfficiency() {
            return efficiency;
        }

        @Override
        public float getAttackDamage() {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return repairMaterial;
        }
    }

}
