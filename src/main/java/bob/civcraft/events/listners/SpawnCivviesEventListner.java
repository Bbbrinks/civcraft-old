package bob.civcraft.events.listners;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

/**
 * Created by bob on 20-6-2014.
 */
public class SpawnCivviesEventListner {

    @SubscribeEvent
    public void handleEvent(EntityJoinWorldEvent event) {
        if (event.entity instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP)event.entity;

            ItemStack book = new ItemStack(Items.written_book);

            // Create NBT data and add to the book
            NBTTagCompound tag = new NBTTagCompound();
            NBTTagList bookPages = new NBTTagList();
            bookPages.appendTag(new NBTTagString("This should be page 1 data"));
            bookPages.appendTag(new NBTTagString("This should be page 2 data"));
            book.setTagInfo("pages", bookPages);
            book.setTagInfo("author", new NBTTagString("delpi"));
            book.setTagInfo("title", new NBTTagString("ClanDoolittle Permissions Mod Instructions"));

            // Give the player the book
            player.inventory.addItemStackToInventory(book);
        }
    }
}
