package bob.civcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by bob on 20-6-2014.
 */
public interface IReplacingDrop {
    Block getAffectedBlock();

    ItemStack getDrops();
}
