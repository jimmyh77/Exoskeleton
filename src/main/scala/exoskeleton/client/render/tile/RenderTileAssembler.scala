package exoskeleton.client.render.tile

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler
import exoskeleton.common.tile.TileEntityAssembler
import net.minecraft.block.Block
import net.minecraft.client.renderer.RenderBlocks
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
import net.minecraft.item.ItemStack
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.IBlockAccess
import net.minecraftforge.client.IItemRenderer
import net.minecraftforge.client.IItemRenderer.{ItemRenderType, ItemRendererHelper}
import org.lwjgl.opengl.GL11

class RenderTileAssembler(val id: Int)
extends TileEntitySpecialRenderer
with ISimpleBlockRenderingHandler
with IItemRenderer{
  override def renderTileEntityAt(te: TileEntity, x : Double, y : Double, z : Double, scale : Float): Unit ={
    val tile: TileEntityAssembler = te.asInstanceOf[TileEntityAssembler];
    GL11.glPushMatrix();
    GL11.glTranslated(x + 0.5D, y + 0.05D, z + 0.5D);
    GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
    GL11.glRotatef(tile.rotation, 0.0F, 1.0F, 0.0F);
    GL11.glScalef(0.05F, 0.05F, 0.05F);
    GL11.glPopMatrix();
  }

  override def shouldUseRenderHelper(`type`: ItemRenderType, item: ItemStack, helper: ItemRendererHelper): Boolean ={
    return true;
  }

  override def handleRenderType(item: ItemStack, `type`: ItemRenderType): Boolean ={
    return true;
  }

  override def renderItem(`type`: ItemRenderType, item: ItemStack, data: AnyRef*): Unit ={
  }

  override def renderInventoryBlock(block: Block, metadata: Int, modelId: Int, renderer: RenderBlocks): Unit ={

  }

  override def getRenderId: Int ={
    return this.id;
  }

  override def shouldRender3DInInventory(modelId: Int): Boolean ={
    return true;
  }

  override def renderWorldBlock(world: IBlockAccess, x: Int, y: Int, z: Int, block: Block, modelId: Int, renderer: RenderBlocks): Boolean={
    return true;
  }
}