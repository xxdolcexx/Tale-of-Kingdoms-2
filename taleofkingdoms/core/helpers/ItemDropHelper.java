package aginsun.taleofkingdoms.core.helpers;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.IMob;
import net.minecraft.world.World;
import aginsun.taleofkingdoms.items.InitItems;
import cpw.mods.fml.common.FMLCommonHandler;

public class ItemDropHelper 
{
	public static World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(0);
    public static boolean isHostileEntity(EntityLiving entity) 
    {
        if ((entity instanceof IMob)) 
        {
        	if((entity instanceof EntitySlime))
        	{
        		return false;
        	}
        	else
        	{
        		return true;
        	}
        }
        else 
        {
            return false;
        }
    }
        
	public static void dropCoins(EntityLiving entity) 
	{
			if (isHostileEntity(entity) && !world.isRemote) 
			{
				for(int i = 0; i < 15; i++)
				{
					entity.dropItem(InitItems.ItemCoins.itemID, 1);
				}
			}
		}
}

