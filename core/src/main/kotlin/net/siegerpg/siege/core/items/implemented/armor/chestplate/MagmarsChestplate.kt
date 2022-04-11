package net.siegerpg.siege.core.items.implemented.armor.chestplate

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomChestplate
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MagmarsChestplate() : CustomChestplate(
		name = "Magmar's Chestplate",
		customModelData = 1,
		description = listOf("The Magma Spirit is the second guardian"),
		levelRequirement = 17,
		material = Material.LEATHER_CHESTPLATE,
		baseStats = CustomItemUtils.statMap(health = 35.0, defense = 25.0, strength = 15.0, luck = -15.0),
		leatherColor = Color.ORANGE,
		gearSetInfo = listOf("Sneak to send a heatwave outwards")
                                            ) {

	constructor(quality : Int) : this() {
		this.quality = quality
		this.rarity = Rarity.getFromInt(quality)
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}