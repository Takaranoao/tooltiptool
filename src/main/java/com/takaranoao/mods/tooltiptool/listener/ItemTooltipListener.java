package com.takaranoao.mods.tooltiptool.listener;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.takaranoao.mods.tooltiptool.listenerdefinitions.ItemTooltip;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ItemTooltipListener implements ItemTooltip {

    private Cache<ItemStack, ItemStack> nbtViewed =
            CacheBuilder.newBuilder()
                    .concurrencyLevel(2)
                    .maximumSize(10)
                    .expireAfterAccess(2, TimeUnit.SECONDS)
                    .build();
    @Override
    public List<ITextComponent> getTooltip(ItemStack itemStack, EntityPlayer p_getTooltip_1_, ITooltipFlag p_getTooltip_2_, List<ITextComponent> toolTip) {
        if(itemStack == null)return toolTip;
        if(GuiScreen.isShiftKeyDown() && GuiScreen.isAltKeyDown()) {
            NBTTagCompound tag = itemStack.getTag();
            if(nbtViewed.getIfPresent(itemStack) == null && tag != null){
                p_getTooltip_1_.sendMessage(new TextComponentString(""));
                p_getTooltip_1_.sendMessage(new TextComponentString((tag.toString().replace('§', '&'))));
                p_getTooltip_1_.sendMessage(new TextComponentString(""));
            }
        }
        return toolTip;
    }
}
