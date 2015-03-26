package exoskeleton.common.core

import exoskeleton.api.skill.Tree
import exoskeleton.common.lib.tree.TreeFrost
import net.minecraft.block.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.DamageSource
import net.minecraftforge.event.entity.living.LivingAttackEvent
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent

object CoreFrost
extends AbstractCore("frost"){
  override def getTree(): Tree ={
    return TreeFrost;
  }

  override def onAttacked(e: LivingAttackEvent, player: EntityPlayer, source: DamageSource): Unit ={}

  override def onUpdate(player: EntityPlayer): Unit ={}

  override def getBreakSpeedModifier(player: EntityPlayer, b: Block, meta: Int, oldSpeed: Float): Float ={
    return oldSpeed;
  }

  override def onHarvest(e: HarvestDropsEvent): Unit ={

  }

  override def onHud(player: EntityPlayer): Unit ={

  }

  override def onJump(player: EntityPlayer): Unit ={

  }
}