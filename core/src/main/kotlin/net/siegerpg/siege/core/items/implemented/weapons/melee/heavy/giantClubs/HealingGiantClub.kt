package net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.giantClubs

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.weapons.CustomMeleeWeapon
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class HealingGiantClub() : CustomMeleeWeapon(
    name = "Healing Giant Club",
    customModelData = 130002,
    description = listOf("Kneecap smasher"),
    levelRequirement = 7,
    material = Material.WOODEN_AXE,
    baseStats = CustomItemUtils.statMap(strength = 13.0, regeneration = 4.0),
    
    attackSpeed = 0.7
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