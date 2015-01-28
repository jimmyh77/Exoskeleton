package exoskeleton.client.render.entity

import cpw.mods.fml.client.FMLClientHandler
import exoskeleton.common.lib.data.DataManager
import net.minecraft.client.renderer.entity.RenderCreeper
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.ResourceLocation

class RenderCreeperThermal
extends RenderCreeper{
  override def getEntityTexture(e: Entity): ResourceLocation ={
    val player = FMLClientHandler.instance().getClient.thePlayer.asInstanceOf[EntityPlayer];
    if(DataManager.get(player).thermal()){
      return Thermal.texture;
    } else{
      return super.getEntityTexture(e);
    }
  }
}