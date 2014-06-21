package bob.civcraft.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Created by bob on 21-6-2014.
 */
@SideOnly(Side.CLIENT)
public class RenderCivvy extends RenderLiving {
    private static final ResourceLocation civvyTexture = new ResourceLocation("minecraft:textures/entity/villager/farmer.png");

    public RenderCivvy(ModelBase modelBase, float v) {
        super(modelBase, v);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return civvyTexture;
    }
}
