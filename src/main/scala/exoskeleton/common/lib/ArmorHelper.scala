package exoskeleton.common.lib

import exoskeleton.api.ExoskeletonCores
import exoskeleton.common.core._
import exoskeleton.common.item.{ItemExoBoots, ItemExoChestplate, ItemExoHelmet, ItemExoLeggings}
import exoskeleton.common.lib.skills.PlayerSkills
import net.minecraft.block.material.Material
import net.minecraft.entity.player.EntityPlayer

object ArmorHelper{
  def hasExoHelm(player: EntityPlayer): Boolean ={
    return player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().isInstanceOf[ItemExoHelmet];
  }

  def hasExoChest(player: EntityPlayer): Boolean ={
    return player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().isInstanceOf[ItemExoChestplate];
  }

  def hasExoLegs(player: EntityPlayer): Boolean ={
    return player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().isInstanceOf[ItemExoLeggings];
  }

  def hasExoBoots(player: EntityPlayer): Boolean ={
    return player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().isInstanceOf[ItemExoBoots];
  }

  def fadable(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreGhost &&
           PlayerSkills.get(player).hasSkill("ghost", "fade");
  }

  def camo(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreAssassin &&
           PlayerSkills.get(player).hasSkill("assassin", "camo");
  }

  def nightVision(player: EntityPlayer): Boolean={
    return hasExoHelm(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(3)) == CoreRecon &&
           PlayerSkills.get(player).hasSkill("recon", "nightVision");
  }

  def thermal(player: EntityPlayer): Boolean={
    return hasExoHelm(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(3)) == CoreGhost &&
           PlayerSkills.get(player).hasSkill("ghost", "thermal");
  }

  def xray(player: EntityPlayer): Boolean={
    return hasExoHelm(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(3)) == CoreBulldozer &&
           PlayerSkills.get(player).hasSkill("bulldozer", "xray");
  }

  def assassin(player: EntityPlayer): Boolean={
    return hasExoHelm(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(3)) == CoreAssassin &&
           PlayerSkills.get(player).hasSkill("assassin", "eagleVision");
  }

  def recallable(player: EntityPlayer): Boolean={
    return hasExoBoots(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(0)) == CoreReflex &&
           PlayerSkills.get(player).hasSkill("reflex", "recall") &&
           !player.isInsideOfMaterial(Material.lava);
  }

  def blinkable(player: EntityPlayer): Boolean={
    return hasExoLegs(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(1)) == CoreReflex &&
           PlayerSkills.get(player).hasSkill("reflex", "blink");
  }

  def backtrack(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreReflex &&
           PlayerSkills.get(player).hasSkill("reflex", "backtrack");
  }

  def autosmelt(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreInferno &&
           PlayerSkills.get(player).hasSkill("inferno", "autoSmelt");
  }

  def flight(player: EntityPlayer): Boolean={
    return hasExoChest(player) &&
           ExoskeletonCores.findCore(player.getCurrentArmor(2)) == CoreSkybound &&
           PlayerSkills.get(player).hasSkill("skybound", "flight");
  }
}