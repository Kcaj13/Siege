package net.siegerpg.siege.core.items.implemented.armor.boots.hardenedLeatherBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Leather
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughHardenedLeatherBoots() : CustomBoots(
    name = "Tough Hardened Leather Boots",
    customModelData = 1,
    description = listOf("Bootleg spurs!"),
    levelRequirement = 17,
    material = Material.LEATHER_BOOTS,
    baseStats = CustomItemUtils.statMap(health = 5.0, toughness = 40.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Leather.tier(2))
            s3(Leather.tier(2))
            s4(Pebble.tier(2))
            s6(Pebble.tier(2))
            s6(Pebble.tier(2))
            item { player, b ->
                val newItem = ToughHardenedLeatherBoots(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    }
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