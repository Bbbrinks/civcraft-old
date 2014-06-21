package bob.civcraft.blocks;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bob on 20-6-2014.
 */
public class DropReplacer {
    private List<IReplacingDrop> blockList;

    public DropReplacer()
    {
        blockList = new ArrayList<IReplacingDrop>();
        blockList.add(new FallingDirtBlock());
        blockList.add(new BranchGivingLeaves());
    }

    @SubscribeEvent
    public void onGenerateDrops(BlockEvent.HarvestDropsEvent event) {
        for(IReplacingDrop block : blockList) {
            if (event.block == block.getAffectedBlock()) {
                event.drops.clear(); // remove vanilla drops
                event.drops.add(block.getDrops());
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onBlockHarvest(BlockEvent.BreakEvent event) {
        for(IReplacingDrop block : blockList) {
            if (event.block == block.getAffectedBlock()) {

            }
        }
    }
}
