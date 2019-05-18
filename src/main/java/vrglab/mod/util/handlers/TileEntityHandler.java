package vrglab.mod.util.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import vrglab.mod.objects.blocks.machines.crusher.TileEntityCrusher;

public class TileEntityHandler 
{
    public static void registerTileEntity()
    {
    	GameRegistry.registerTileEntity(TileEntityCrusher.class, "crusher");
    }
}
