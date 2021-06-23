package net.siegerpg.siege.core.drops.materials;

import net.siegerpg.siege.core.drops.BlockDropTable;
import net.siegerpg.siege.core.drops.Reward;
import net.siegerpg.siege.core.items.implemented.misc.food.*;
import net.siegerpg.siege.core.items.implemented.misc.materials.drops.blocks.*;
import org.bukkit.Material;

public class BAMBOO extends BlockDropTable {
    public BAMBOO() {
        super(20, Material.BAMBOO, 0, 0, 0, 0, new Reward[]{
                new Reward(new Sugar(100).getUpdatedItem(false), 0.5),
                new Reward(new Sugar(50).getUpdatedItem(false), 2.5)
        });
    }
}
