package net.siegerpg.siege.core.items.implemented.armor.helmet

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomHelmet
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MagmarsCrown() : CustomHelmet(
		name = "Magmar's Crown",
		customModelData = 1,
		description = listOf("The Magma Spirit is the second guardian"),
		levelRequirement = 17,
		material = Material.LEATHER_HELMET,
		baseStats = CustomItemUtils.statMap(health = 25.0, defense = 15.0, strength = 10.0, regeneration = 20.0, luck = -10.0),
		leatherColor = Color.ORANGE,
		gearSetInfo = listOf(listOf("Sneak to send a heatwave outwards"))
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