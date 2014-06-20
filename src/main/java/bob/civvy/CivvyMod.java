package bob.civvy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod(modid = CivvyMod.MODID, version = CivvyMod.VERSION)
public class CivvyMod
{
    public static final String MODID = "civvy";
    public static final String VERSION = "0.0.0";
    private Logger logger;

    @Mod.Instance(value = CivvyMod.MODID)
    public static CivvyMod instance;

    @SidedProxy(clientSide="tutorial.generic.client.ClientProxy", serverSide="tutorial.generic.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();

        logger.info("Preinit");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("Init");
        removeRecipes(CraftingManager.getInstance());
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());


    }


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
