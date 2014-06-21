package bob.civcraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by bob on 20-6-2014.
 */
public class FallingDirtBlock extends BlockFalling implements IReplacingDrop {


    public FallingDirtBlock()
    {
        super(Blocks.dirt.getMaterial());
        setHardness(0.5F);
        setStepSound(Block.soundTypeGravel);
        setBlockName("fallingDirtBlock");
        setCreativeTab(CreativeTabs.tabBlock);
        setBlockTextureName("dirt");
    }



    protected FallingDirtBlock(Material p_i45394_1_) {
        super(p_i45394_1_);
    }

    @Override
    public Block getAffectedBlock() {
        return Blocks.dirt;
    }

    @Override
    public ItemStack getDrops() {
        return new ItemStack(Item.getItemFromBlock(CivCraftBlocks.fallingDirt),1);
    }
}
