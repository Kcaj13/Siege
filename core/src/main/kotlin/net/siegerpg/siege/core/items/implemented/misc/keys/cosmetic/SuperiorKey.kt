package net.siegerpg.siege.core.items.implemented.misc.keys.cosmetic

import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomKey
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SuperiorKey() : CustomKey(
		name = "Cosmetic Key IV",
		customModelData = 630007,
		description = listOf("High chance of a", "rare cosmetic"),
		material = Material.TRIPWIRE_HOOK,
		quality = 80
                               ) {
	override fun getSellValue() : Int {
		return 7500
	}
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