package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.clobbers

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.*
import net.siegerpg.siege.core.items.recipes.recipes
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import net.siegerpg.siege.core.utils.Utils
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughClobber() : CustomMeleeWeapon(
    name = "Tough Clobber",
    customModelData = 130009,
    description = listOf("Let's go clobbing!"),
    levelRequirement = 35,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 46.0, toughness = 40.0),
    recipeList = recipes {
        recipe {
            shaped = true
            s1(RefinedMetal.tier(3))
            s2(RefinedMetal.tier(3))
            s4(RefinedMetal.tier(3))
            s5(Pebble.tier(4))
            item { player, b ->
                val newItem = ToughClobber(if (b) 50 else Utils.randRarity())
                newItem.updateMeta(b)
                newItem
            }
        }
    },
    attackSpeed = 0.9
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