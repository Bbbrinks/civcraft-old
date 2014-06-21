package bob.civcraft.entities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by bob on 17-6-2014.
 */
public class Civvy extends net.minecraft.entity.EntityAgeable implements net.minecraft.entity.INpc {
    private EntityPlayerMP player;

    public Civvy(World par1World) {
        super(par1World);
        this.setSize(0.9F, 1.3F);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable entityAgeable) {
        throw new NotImplementedException();
    }


    public void setPlayer(EntityPlayerMP player) {
        this.player = player;
    }

    public EntityPlayerMP getPlayer() {
        return player;
    }
}
