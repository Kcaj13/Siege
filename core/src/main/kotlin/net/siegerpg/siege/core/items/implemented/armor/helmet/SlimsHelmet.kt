package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SlimsHelmet() : CustomHelmet(
		name = "Slim's Helmet",
		customModelData = 1,
		description = listOf("The Slime Spirit is the first guardian"),
		levelRequirement = 7,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 12.0, defense = -10.0, strength = 12.0, luck = 6.0),
		leatherColor = Color.LIME,
		gearSetInfo = listOf(listOf("Double jump to jump forwards"))
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