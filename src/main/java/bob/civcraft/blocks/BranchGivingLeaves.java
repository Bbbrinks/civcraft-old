package bob.civcraft.blocks;

import bob.civcraft.items.CivCraftItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockNewLeaf;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

/**
 * Created by bob on 20-6-2014.
 */
public class BranchGivingLeaves extends BlockNewLeaf implements IReplacingDrop{

    @Override
    public Block getAffectedBlock() {
        return Blocks.leaves;
    }

    @Override
    public ItemStack getDrops() {
        return new ItemStack(CivCraftItems.branch,1);
    }
}
