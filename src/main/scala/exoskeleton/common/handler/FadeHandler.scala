package exoskeleton.common.handler

import java.util

import cpw.mods.fml.common.eventhandler.SubscribeEvent
import cpw.mods.fml.common.gameevent.TickEvent.{Phase, PlayerTickEvent}
import exoskeleton.common.lib.fade.PlayerFadeInfo
;

object FadeHandler{
  val playerFadeInfo: util.Map[String, PlayerFadeInfo] = new util.HashMap[String, PlayerFadeInfo]();

  @SubscribeEvent
  def onPlayerTick(e: PlayerTickEvent): Unit ={
    if(e.phase == Phase.END && e.side.isServer){
      val player = e.player;
      val info = this.playerFadeInfo.get(player.getCommandSenderName);
      if(info != null){
        if(info.prog <= 0){
          player.setInvisible(false);
          playerFadeInfo.remove(player.getCommandSenderName);
        } else{
          info.prog -= 1;
        }
      }
    }
  }
}