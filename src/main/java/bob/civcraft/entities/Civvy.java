package bob.civcraft.entities;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

/**
 * Created by bob on 17-6-2014.
 */
public class Civvy extends EntityVillager {
    private EntityPlayerMP player;

    public Civvy(World par1World) {
        super(par1World);
    }

    public Civvy(World par1World, int par2) {
        super(par1World, par2);
    }

    public void setPlayer(EntityPlayerMP player) {
        this.player = player;
    }

    public EntityPlayerMP getPlayer() {
        return player;
    }
}
