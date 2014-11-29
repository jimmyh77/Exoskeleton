package exoskeleton.common.core

import cpw.mods.fml.client.FMLClientHandler
import exoskeleton.api.Tree
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.skills.PlayerSkills
import exoskeleton.common.lib.tree.TreeRecon
import net.minecraft.block.Block
import net.minecraft.client.gui.FontRenderer
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.potion.{Potion, PotionEffect}
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import org.lwjgl.opengl.GL11

object CoreRecon
extends AbstractCore("recon"){
  override def onJump(player: EntityPlayer): Unit ={
    if(PlayerSkills.get(player).hasSkill("recon", "jumpBoost") && ArmorHelper.hasExoLegs(player)){
      player.motionY += 0.2D;
    }
  }

  override def getTree(): Tree={
    return new TreeRecon();
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={
    if(PlayerSkills.get(player).hasSkill("recon", "noDrown") && ArmorHelper.hasExoHelm(player)){
      if(e.source == DamageSource.drown){
        e.setCanceled(true);
      }
    }
  }

  override def onUpdate(player: EntityPlayer): Unit ={
    if(PlayerSkills.get(player).hasSkill("recon", "nightVision") && ArmorHelper.hasExoHelm(player)){
      player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 400));
    }
  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHud(player: EntityPlayer): Unit ={
    if(PlayerSkills.get(player).hasSkill("recon", "debug") && ArmorHelper.hasExoHelm(player) && FMLClientHandler.instance().getClient.inGameHasFocus){
      GL11.glPopMatrix();

      val fRenderer: FontRenderer = FMLClientHandler.instance().getClient.fontRenderer;
      fRenderer.drawString("Jump Boost: " + PlayerSkills.get(player).hasSkill("recon", "jumpBoost"), 0, 0, 0x000000);
      fRenderer.drawString("Night Vision: " + PlayerSkills.get(player).hasSkill("recon", "nightVision"), 0, 10, 0x000000);
      fRenderer.drawString("No Drowning: " + PlayerSkills.get(player).hasSkill("recon", "noDrown"), 0, 20, 0x000000);

      GL11.glPushMatrix();
    }
  }
}