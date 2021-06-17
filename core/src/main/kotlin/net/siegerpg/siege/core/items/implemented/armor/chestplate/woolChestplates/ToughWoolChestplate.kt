package net.siegerpg.siege.core.items.implemented.armor.chestplate.woolChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Pebble
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Wool
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughWoolChestplate() : CustomChestplate(
    name = "Tough Wool Chestplate",
    customModelData = 1,
    description = listOf("A cotton jacket"),
    levelRequirement = 9,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 5.0, toughness = 60.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Wool.tier(2))
            s3(Wool.tier(2))
            s4(Wool.tier(2))
            s5(Wool.tier(2))
            s6(Pebble.tier(2))
            s7(Pebble.tier(2))
            s8(Pebble.tier(2))
            s9(Pebble.tier(2))
            item { player, b ->
                val newItem = ToughWoolChestplate(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    leatherColor = Color.WHITE
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