package net.siegerpg.siege.core.items.implemented.armor.chestplate.magmaChestplates

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class LuckyMagmaChestplate() : CustomChestplate(
    name = "Lucky Magma Chestplate",
    customModelData = 1,
    description = listOf("This really warms my heart"),
    levelRequirement = 13,
    material = Material.LEATHER_CHESTPLATE,
    baseStats = CustomItemUtils.statMap(health = 20.0, toughness = 15.0, luck = 4.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(Magma.tier(2))
            s3(Magma.tier(2))
            s4(Magma.tier(2))
            s5(Magma.tier(2))
            s6(Magma.tier(2))
            s7(Feather.tier(2))
            s8(Feather.tier(2))
            s9(Feather.tier(2))
            item { player, b ->
                val newItem = LuckyMagmaChestplate(if (b) 50 else Utils.randRarity())
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