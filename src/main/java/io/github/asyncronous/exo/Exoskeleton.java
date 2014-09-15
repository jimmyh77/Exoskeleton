package io.github.asyncronous.exo;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import io.github.asyncronous.exo.block.BlockTest;
import io.github.asyncronous.exo.handler.EXOToolTipHandler;
import io.github.asyncronous.exo.handler.ReconCoreHandler;
import io.github.asyncronous.exo.item.ItemExoskeletonBoots;
import io.github.asyncronous.exo.item.ItemExoskeletonChestplate;
import io.github.asyncronous.exo.item.ItemExoskeletonHelmet;
import io.github.asyncronous.exo.item.ItemExoskeletonLeggings;
import io.github.asyncronous.exo.tile.TileTestBlock;

@Mod(modid = "EXO", version = "0.0.0", name = "Exoskeleton")
public final class Exoskeleton{
    @Mod.Instance("EXO")
    public static Exoskeleton instance;

    public static final CreativeTabs tab = new CreativeTabs("exoskeleton"){
        @Override
        public Item getTabIconItem(){
            return itemCoreEmpty;
        }
    };

    public static final Block blockTest = new BlockTest();

    // Cores
    public static final Item itemCoreAssassin = Cores.coreAssassin.getItem();
    public static final Item itemCoreBerzerker = Cores.coreBerzerker.getItem();
    public static final Item itemCoreBulldozer = Cores.coreBulldozer.getItem();
    public static final Item itemCoreFrost = Cores.coreFrost.getItem();
    public static final Item itemCoreGhost = Cores.coreGhost.getItem();
    public static final Item itemCoreInfernal = Cores.coreInfernal.getItem();
    public static final Item itemCoreMystic = Cores.coreMystic.getItem();
    public static final Item itemCoreRecon = Cores.coreRecon.getItem();
    public static final Item itemCoreReflex = Cores.coreReflex.getItem();
    public static final Item itemCoreSkybound = Cores.coreSkybound.getItem();
    public static final Item itemCoreEmpty = Cores.coreEmpty.getItem();
    public static final Item itemCoreIntro = Cores.coreIntro.getItem();

    // Armour pieces
    public static final Item itemExoskeletonHelmet = new ItemExoskeletonHelmet();
    public static final Item itemExoskeletonChestplate = new ItemExoskeletonChestplate();
    public static final Item itemExoskeletonLeggings = new ItemExoskeletonLeggings();
    public static final Item itemExoskeletonBoots = new ItemExoskeletonBoots();

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){

    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){
        GameRegistry.registerBlock(blockTest, "blockTest");

        GameRegistry.registerTileEntity(TileTestBlock.class, "tileTestBlock");

        GameRegistry.registerItem(itemCoreAssassin, "itemCoreAssassin");
        GameRegistry.registerItem(itemCoreBerzerker, "itemCoreBerzerker");
        GameRegistry.registerItem(itemCoreBulldozer, "itemCoreBulldozer");
        GameRegistry.registerItem(itemCoreFrost, "itemCoreFrost");
        GameRegistry.registerItem(itemCoreGhost, "itemCoreGhost");
        GameRegistry.registerItem(itemCoreInfernal, "itemCoreInfernal");
        GameRegistry.registerItem(itemCoreMystic, "itemCoreMystic");
        GameRegistry.registerItem(itemCoreRecon, "itemCoreRecon");
        GameRegistry.registerItem(itemCoreReflex, "itemCoreReflex");
        GameRegistry.registerItem(itemCoreSkybound, "itemCoreSkybound");
        GameRegistry.registerItem(itemCoreEmpty, "itemCoreEmpty");
        GameRegistry.registerItem(itemCoreIntro, "itemCoreIntro");

        GameRegistry.registerItem(itemExoskeletonHelmet, "itemExoskeletonHelmet");
        GameRegistry.registerItem(itemExoskeletonChestplate, "itemExoskeletonChestplate");
        GameRegistry.registerItem(itemExoskeletonLeggings, "itemExoskeletonLeggings");
        GameRegistry.registerItem(itemExoskeletonBoots, "itemExoskeletonBoots");
    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent e){
        MinecraftForge.EVENT_BUS.register(new ReconCoreHandler());
        MinecraftForge.EVENT_BUS.register(new EXOToolTipHandler());
    }
}