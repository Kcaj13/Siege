package net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMaterial
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class MetalScrap() : CustomMaterial(
		name = "Metal Scrap",
		customModelData = 320008,
		description = listOf("Scrapped metal found underground"),
		levelRequirement = 0,
		material = Material.FLINT,
		upgradeStats = hashMapOf(
				4 to CustomItemUtils.statMap(toughness = 1.0, strength = 1.0),
				5 to CustomItemUtils.statMap(toughness = 10.0, strength = 8.0)
		                        )
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

	companion object {

		fun tier(tier : Int) : MetalScrap {
			val newItem = MetalScrap(0)
			newItem.tier = tier
			return newItem
		}
	}

}