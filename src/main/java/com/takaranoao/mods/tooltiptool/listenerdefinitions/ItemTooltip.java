package com.takaranoao.mods.tooltiptool.listenerdefinitions;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import java.util.List;

public interface ItemTooltip {
    List<ITextComponent> getTooltip(ItemStack itemStack, EntityPlayer p_getTooltip_1_, ITooltipFlag p_getTooltip_2_, List<ITextComponent> toolTip);
}
