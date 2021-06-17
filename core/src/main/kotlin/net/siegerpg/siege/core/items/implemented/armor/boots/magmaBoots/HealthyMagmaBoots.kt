package net.siegerpg.siege.core.items.implemented.armor.boots.magmaBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.PlantMatter
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealthyMagmaBoots() : CustomBoots(
    name = "Healthy Magma Boots",
    customModelData = 1,
    description = listOf("Some lit boots"),
    levelRequirement = 12,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 12.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma.tier(2))
            s3(Magma.tier(2))
            s3(Magma.tier(2))
            s4(PlantMatter.tier(2))
            s6(PlantMatter.tier(2))
            item { player, b ->
                val newItem = HealthyMagmaBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    leatherColor = Color.ORANGE
) {

    constructor(quality: Int): this() {
        this.quality = quality
        this.rarity = Rarity.getFromInt(quality)
        this.serialize()
    }

    constructor(item: ItemStack): this() {
        this.item = item
        deserialize()
    }

}