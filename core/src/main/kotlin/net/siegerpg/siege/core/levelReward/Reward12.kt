package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Magma
import net.siegerpg.siege.core.items.implemented.weapons.melee.heavy.FemurBone
import net.siegerpg.siege.core.items.implemented.weapons.melee.light.Shovel
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward12(
		override val level : Short = 13,
		override val gold : Int = 1000,
		override val items : List<ItemStack> = listOf(
				MobKey().getUpdatedItem(false).asQuantity(2)
		                                             )
              ) : LevelReward