package net.siegerpg.siege.core.levelReward

import net.siegerpg.siege.core.items.implemented.armor.leggings.ChainLeggings
import net.siegerpg.siege.core.items.implemented.misc.food.Sugar
import net.siegerpg.siege.core.items.implemented.misc.keys.crate.MobKey
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.FairyDust
import net.siegerpg.siege.core.items.implemented.weapons.ranged.Crossbow
import net.siegerpg.siege.core.listeners.GoldExpListener
import net.siegerpg.siege.core.miscellaneous.Utils
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class Reward30(
		override val level : Short = 31,
		override val gold : Int = 1000,
		override val items : List<ItemStack> = listOf(
				Sugar().getUpdatedItem(false).asQuantity(20),
				MobKey().getUpdatedItem(false).asQuantity(6)
		                                             )
              ) : LevelReward