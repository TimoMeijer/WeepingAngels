package net.minecraft.src;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            TileEntitySpecialRenderer, SignModel, TileEntityPlinth, EntityStatue, 
//            ModLoader, World, FontRenderer, mod_statues, 
//            Item, EntityCreeperStatue, EntitySkeletonStatue, EntityPigStatue, 
//            EntityZombieStatue, EntitySpiderStatue, EntityCowStatue, EntityHoneydewStatue, 
//            EntityXephosStatue, ModelRenderer, TileEntity

public class TileEntityPlinthRenderer extends TileEntitySpecialRenderer
{

    public TileEntityPlinthRenderer()
    {
        instance = this;
    }

    public void renderTileEntitySignAt(TileEntityPlinth tileentityplinth, double d, double d1, double d2, 
            float f)
    {
        GL11.glPushMatrix();
        float f1 = 0.6666667F;
        int i = tileentityplinth.getBlockMetadata();
        EntityStatue entitystatue = null;
        if(tileentityplinth.statueEntity == null)
        {
            entitystatue = LoadStatue(tileentityplinth.statueType);
        }
        if(entitystatue != null)
        {
            entitystatue.setLocationAndAngles((double)tileentityplinth.xCoord + 0.5D, (double)tileentityplinth.yCoord + 0.5D, (double)tileentityplinth.zCoord + 0.5D, 0.0F, 0.0F);
            entitystatue.onGround = true;
            if(i == 8)
            {
                entitystatue.setLocationAndAngles((double)tileentityplinth.xCoord + 0.5D, (double)tileentityplinth.yCoord + 0.5D, (double)tileentityplinth.zCoord + 0.5D, 180F, 0.0F);
            }
            if(i == 4)
            {
                entitystatue.setLocationAndAngles((double)tileentityplinth.xCoord + 0.5D, (double)tileentityplinth.yCoord + 0.5D, (double)tileentityplinth.zCoord + 0.5D, 90F, 0.0F);
            }
            if(i == 12)
            {
                entitystatue.setLocationAndAngles((double)tileentityplinth.xCoord + 0.5D, (double)tileentityplinth.yCoord + 0.5D, (double)tileentityplinth.zCoord + 0.5D, -90F, 0.0F);
            }
            ModLoader.getMinecraftInstance().theWorld.spawnEntityInWorld(entitystatue);
            tileentityplinth.statueEntity = entitystatue;
        }
        float f2 = 0.0F;
        if(i == 8)
        {
            f2 = 180F;
            d2 -= 1.7999999523162842D;
        }
        if(i == 4)
        {
            f2 = 90F;
            d2 -= 0.89999997615814209D;
            d -= 0.89999997615814209D;
        }
        if(i == 12)
        {
            f2 = -90F;
            d2 -= 0.89999997615814209D;
            d += 0.89999997615814209D;
        }
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.75F * f1, (float)d2 + 1.4F);
        GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
        GL11.glPushMatrix();
        GL11.glScalef(f1, -f1, -f1);
        GL11.glPopMatrix();
        FontRenderer fontrenderer = getFontRenderer();
        float f3 = 0.01666667F * f1;
        GL11.glTranslatef(0.0F, 0.5F * f1, 0.07F * f1);
        GL11.glScalef(f3, -f3, f3);
        GL11.glNormal3f(0.0F, 0.0F, -1F * f3);
        GL11.glDepthMask(false);
        int j = 0;
        for(int k = 0; k < tileentityplinth.signText.length; k++)
        {
            String s = tileentityplinth.signText[k];
            if(k == tileentityplinth.lineBeingEdited)
            {
                s = (new StringBuilder()).append("> ").append(s).append(" <").toString();
                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, (k * 10 - tileentityplinth.signText.length * 5) + 20, j);
            } else
            {
                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, (k * 10 - tileentityplinth.signText.length * 5) + 20, j);
            }
        }

        GL11.glDepthMask(true);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    private EntityStatue LoadStatue(int i)
    {
        World world = ModLoader.getMinecraftInstance().theWorld;
        if(i == mod_WeepingAngel.statue.shiftedIndex)
        {
            return new EntityStatue(world);
        }
        else
        {
            return null;
        }
    }

    public void renderTileEntityGuiAt(TileEntityPlinth tileentityplinth, double d, double d1, double d2, 
            float f)
    {
        GL11.glPushMatrix();
        float f1 = 0.6666667F;
        float f2 = 0.0F;
        GL11.glTranslatef((float)d + 0.5F, (float)d1 + 0.75F * f1, (float)d2 + 0.5F);
        GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(0.0F, -0.3125F, -0.4375F);
        bindTextureByName("/statues/sign.png");
        GL11.glPushMatrix();
        GL11.glScalef(f1, -f1, -f1);
        //signModel.signStick.showModel = false;
        //signModel.renderSign();
        GL11.glPopMatrix();
        FontRenderer fontrenderer = getFontRenderer();
        float f3 = 0.01666667F * f1;
        GL11.glTranslatef(0.0F, 0.5F * f1, 0.07F * f1);
        GL11.glScalef(f3, -f3, f3);
        GL11.glNormal3f(0.0F, 0.0F, -1F * f3);
        GL11.glDepthMask(false);
        int i = 0;
        for(int j = 0; j < tileentityplinth.signText.length; j++)
        {
            String s = tileentityplinth.signText[j];
            if(j == tileentityplinth.lineBeingEdited)
            {
                s = (new StringBuilder()).append("> ").append(s).append(" <").toString();
                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, j * 10 - tileentityplinth.signText.length * 5, i);
            } else
            {
                fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, j * 10 - tileentityplinth.signText.length * 5, i);
            }
        }

        GL11.glDepthMask(true);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, 
            float f)
    {
        renderTileEntitySignAt((TileEntityPlinth)tileentity, d, d1, d2, f);
    }

    public static TileEntityPlinthRenderer instance;
    //private SignModel signModel;
}
