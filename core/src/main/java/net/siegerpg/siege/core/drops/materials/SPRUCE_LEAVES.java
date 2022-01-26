package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.Apple;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.Stick;
import org.bukkit.Material;

public class SPRUCE_LEAVES extends BlockDropTable {

	public SPRUCE_LEAVES() {

		super(200, Material.SPRUCE_LEAVES, 0, 0, 1, 1, new Reward[] {
				new Reward(new Apple().getUpdatedItem(false), 5.0),
				new Reward(new Apple().getUpdatedItem(false), 10.0),
				new Reward(Stick.Companion
						           .tier(1)
						           .getUpdatedItem(false), 25)
		});
	}

}
