package exoskeleton.common.core

import exoskeleton.api.Tree
import exoskeleton.common.lib.ArmorHelper
import exoskeleton.common.lib.skills.PlayerSkills
import exoskeleton.common.lib.tree.TreeInferno
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent

object CoreInferno
extends AbstractCore("inferno"){
  override def onJump(player: EntityPlayer): Unit ={

  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={
    if(PlayerSkills.get(player).hasSkill("inferno", "fireIgnore") &&
       source == DamageSource.onFire &&
       ArmorHelper.hasExoLegs(player)){

      e.setCanceled(true);
    } else if(PlayerSkills.get(player).hasSkill("inferno", "lavaIgnore") &&
              source == DamageSource.lava &&
              ArmorHelper.hasExoLegs(player)){

      e.setCanceled(true);
    }
  }

  override def onUpdate(player: EntityPlayer): Unit ={

  }

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHud(player: EntityPlayer): Unit ={

  }

  override def getTree(): Tree ={
    return new TreeInferno();
  }
}