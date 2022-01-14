package net.siegerpg.siege.core.items.implemented.misc.mounts

import net.siegerpg.siege.core.items.CustomItemUtils
import net.siegerpg.siege.core.items.enums.Rarity
import net.siegerpg.siege.core.items.types.misc.CustomMount
import net.siegerpg.siege.core.items.types.misc.CustomTool
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class CatMount() : CustomMount(
		name = "Cat Mount",
		customModelData = 330002,
		description = listOf("Kitty kitty"),
		material = Material.CAT_SPAWN_EGG,
                              ) {

	constructor(quality : Int) : this() {
		this.quality = 50
		this.rarity = Rarity.UNCOMMON
		this.serialize()
	}

	constructor(item : ItemStack) : this() {
		this.item = item
		deserialize()
	}

}