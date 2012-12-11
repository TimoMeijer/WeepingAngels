package WeepingAngels.client;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import WeepingAngels.common.EntityWeepingAngel;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.RenderLiving;

@SideOnly(Side.CLIENT)
public class RenderWeepingAngel extends RenderLiving
{

	
    public RenderWeepingAngel(float f)
    {
        super(new ModelWeepingAngel(), f);
    }

    public void renderWeepingAngel(EntityWeepingAngel entityweepingangel, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entityweepingangel, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderWeepingAngel((EntityWeepingAngel)entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderWeepingAngel((EntityWeepingAngel)entity, d, d1, d2, f, f1);
    }
}