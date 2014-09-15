package io.github.asyncronous.exo.item;

import net.minecraft.item.Item;

import io.github.asyncronous.exo.Exoskeleton;
import io.github.asyncronous.exo.core.ICore;

public final class ItemCore
extends Item{
    public final ICore core;

    public ItemCore(ICore core){
        super();
        this.core = core;
        this.setMaxStackSize(1);
        this.setCreativeTab(Exoskeleton.tab);
        this.setTextureName("exo:core/" + core.getName());
        this.setUnlocalizedName("exo.itemCore." + core.getName());
    }
}