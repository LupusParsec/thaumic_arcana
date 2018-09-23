package hu.frontrider.arcana.registrationhandlers.recipes

import net.minecraft.item.EnumDyeColor
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.ResourceLocation
import net.minecraftforge.fml.common.registry.GameRegistry
import thaumcraft.api.ThaumcraftApi
import thaumcraft.api.ThaumcraftApiHelper
import thaumcraft.api.aspects.Aspect
import thaumcraft.api.aspects.AspectList
import thaumcraft.api.blocks.BlocksTC
import thaumcraft.api.crafting.InfusionRecipe

import hu.frontrider.arcana.ThaumicArcana.MODID
import hu.frontrider.arcana.registrationhandlers.ItemRegistry.Companion
import net.minecraft.init.Items.DYE
import thaumcraft.api.items.ItemsTC.salisMundus

object InfusionRecipes {

    @GameRegistry.ObjectHolder("$MODID:enchant_modifier")
    internal var modifier: Item? = null

    fun register() {
        registerCreatureEnchants()
    }

    internal fun registerCreatureEnchants() {

        run {
            val source = ItemStack(Companion.enchanting_powder_basic)
            source.tagCompound = null

            val itemStack = ItemStack(Companion.enchanting_powder_advanced)
            ThaumcraftApi.addInfusionCraftingRecipe(
                    ResourceLocation(MODID, "enchant_powder_advanced"),
                    InfusionRecipe("CREATURE_ENCHANT_ADVANCED",
                            itemStack,
                            5, AspectList()
                            .add(Aspect.MAGIC, 20)
                            .add(Aspect.LIFE, 50)
                            .add(Aspect.AURA, 20),
                            source,
                            ItemStack(salisMundus),
                            ItemStack(DYE, 1, 4),
                            ItemStack(salisMundus),
                            ItemStack(DYE, 1, 4),
                            ItemStack(salisMundus),
                            ItemStack(DYE, 1, 4)
                    )
            )
        }
        run {
            val itemStack = ItemStack(modifier!!)

            val source = ItemStack(Companion.enchanting_powder_advanced)
            ThaumcraftApi.addInfusionCraftingRecipe(
                    ResourceLocation(MODID, "enchant_modifier_base"),
                    InfusionRecipe("CREATURE_ENCHANT_MODIFICATION",
                            itemStack,
                            5,
                            AspectList()
                                    .add(Aspect.MAGIC, 20)
                                    .add(Aspect.LIFE, 50)
                                    .add(Aspect.AURA, 20)
                                    .add(Aspect.BEAST, 100),
                            source,
                            ItemStack(BlocksTC.nitor[EnumDyeColor.WHITE]),
                            ItemStack(BlocksTC.nitor[EnumDyeColor.WHITE]),
                            ItemStack(BlocksTC.nitor[EnumDyeColor.WHITE]),
                            ItemStack(BlocksTC.nitor[EnumDyeColor.WHITE]),
                            ThaumcraftApiHelper.makeCrystal(Aspect.ORDER),
                            ThaumcraftApiHelper.makeCrystal(Aspect.ORDER),
                            ThaumcraftApiHelper.makeCrystal(Aspect.MAGIC),
                            ThaumcraftApiHelper.makeCrystal(Aspect.MAGIC)
                    )
            )
        }
    }

}
