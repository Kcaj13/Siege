package net.siegerpg.siege.shops.shop

import net.siegerpg.siege.core.items.implemented.misc.materials.GRAYFILLER
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Bone
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.mobs.Feather
import net.siegerpg.siege.core.items.implemented.misc.wands.EarthernStaff
import net.siegerpg.siege.core.items.implemented.misc.wands.EarthernWand
import net.siegerpg.siege.core.items.implemented.misc.wands.RockWand
import net.siegerpg.siege.core.items.implemented.misc.wands.earthernStaffs.*
import net.siegerpg.siege.core.items.implemented.misc.wands.earthernWands.*
import net.siegerpg.siege.core.items.implemented.misc.wands.rockWands.*
import net.siegerpg.siege.core.utils.Utils
import net.siegerpg.siege.shops.Shop
import net.siegerpg.siege.shops.ShopItem

class Edith : Shop() {
    override var name: String = "Edith"
    override var permission: String = "siege.shops.shop.edith"
    override var items: List<ShopItem> = listOf(
        //ROCK WAND
        ShopItem(
            RockWand(-1), 3500, hashMapOf(
                Pebble.tier(3) to 1,
                Stick.tier(3) to 2), true) {
            RockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(GRAYFILLER(-1), -1, hashMapOf(), false) {
            GRAYFILLER(-1).getUpdatedItem(false)
        },
        ShopItem(
            LuckyRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 1,
                Feather.tier(3) to 2,
                Stick.tier(3) to 1), true) {
            LuckyRockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            StrongRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 1,
                Feather.tier(3) to 1,
                Bone.tier(3) to 1), true) {
            StrongRockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            ToughRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 3,
                Stick.tier(3) to 1), true) {
            ToughRockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealthyRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 1,
                PlantMatter.tier(3) to 2,
                Stick.tier(3) to 1), true) {
            HealthyRockWand(Utils.randRarity()).getUpdatedItem(false)
        },
        ShopItem(
            HealingRockWand(-1), 3750, hashMapOf(
                Pebble.tier(3) to 1,
                Wheat.tier(3) to 3,
                Stick.tier(3) to 1), true) {
            HealingRockWand(Utils.randRarity()).getUpdatedItem(false)
        }
    )
}