package bob.civcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by bob on 20-6-2014.
 */
public class Branch extends Item {

    public Branch()
    {
        setTextureName("stick");
        setUnlocalizedName("branch");
        setMaxStackSize(64);
        setCreativeTab(CreativeTabs.tabMisc);
    }
}
