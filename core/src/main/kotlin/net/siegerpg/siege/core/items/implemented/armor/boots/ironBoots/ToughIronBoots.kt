package net.siegerpg.siege.core.items.implemented.armor.boots.ironBoots

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.armor.CustomBoots
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ToughIronBoots() : CustomBoots(
		name = "Tough Iron Boots",
		customModelData = 1,
		description = listOf("Iron clad boots"),
		levelRequirement = 34,
		material = Material.IRON_BOOTS,
		baseStats = CustomItemUtils.statMap(defense = 80.0),
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