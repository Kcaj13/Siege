package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.blockDrops.RefinedMetal
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class IronLeggings() : CustomHelmet(
    name = "Iron Leggings",
    customModelData = 1,
    description = listOf("Iron jenkins"),
    levelRequirement = 35,
    material = Material.IRON_LEGGINGS,
    baseStats = CustomItemUtils.statMap(health = 50.0, toughness = 100.0, regeneration = 30.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal(0)) //tier 2
            s2(RefinedMetal(0)) //tier 2
            s3(RefinedMetal(0)) //tier 2
            s4(RefinedMetal(0)) //tier 2
            s6(RefinedMetal(0)) //tier 2
            s7(RefinedMetal(0)) //tier 2
            s9(RefinedMetal(0)) //tier 2
            item { player, b ->
                IronLeggings(Utils.randRarity())
            }
        }
    },
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