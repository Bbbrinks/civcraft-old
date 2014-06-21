package bob.civcraft;

import bob.civcraft.blocks.CivCraftBlocks;
import bob.civcraft.blocks.DropReplacer;
import bob.civcraft.entities.Civvy;
import bob.civcraft.events.listners.SpawnCivviesEventListener;
import bob.civcraft.items.CivCraftItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod(modid = CivCraft.MODID, version = CivCraft.VERSION)
public class CivCraft
{
    public static final String MODID = "civcraft";
    public static final String VERSION = "0.0.0";
    private Logger logger;

    @Mod.Instance(value = CivCraft.MODID)
    public static CivCraft instance;

    @SidedProxy(clientSide="bob.civcraft.client.ClientProxy", serverSide="bob.civcraft.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        logger.info("Preinit");

        GameRegistry.registerBlock(CivCraftBlocks.fallingDirt, CivCraftBlocks.fallingDirt.getUnlocalizedName());
        GameRegistry.registerItem(CivCraftItems.branch, CivCraftItems.branch.getUnlocalizedName());
        EntityRegistry.registerGlobalEntityID(Civvy.class, "Civvy",  EntityRegistry.findGlobalUniqueEntityId());

    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Init");
        removeRecipes(CraftingManager.getInstance());
        GameRegistry.addShapelessRecipe(new ItemStack(Items.stick, 2), new ItemStack(CivCraftItems.branch), new ItemStack(Items.flint));
        MinecraftForge.EVENT_BUS.register(new SpawnCivviesEventListener());
        MinecraftForge.EVENT_BUS.register(new DropReplacer());
    }

    @SubscribeEvent


/*
    @EventHandler
    public void initWorld(FMLServerStartedEvent event)
    {
        Civvy firstCivvy = new Civvy(Minecraft.getMinecraft().theWorld);
        EntityClientPlayerMP thePlayer = Minecraft.getMinecraft().thePlayer;
        firstCivvy.setPosition(thePlayer.posX, thePlayer.posY, thePlayer.posZ);
    }
*/

    private void removeRecipes(CraftingManager instance) {
        List recipeList = instance.getRecipeList();
        int recipeCount = recipeList.size();
        for (int i = 0; i < recipeCount; i++) {
            logger.info(String.format("Removing recipe [%s]", ((IRecipe)recipeList.get(0)).toString()));
            recipeList.remove(0);

        }
    }
}
