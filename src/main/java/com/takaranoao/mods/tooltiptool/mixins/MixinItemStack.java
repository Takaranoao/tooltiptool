package com.takaranoao.mods.tooltiptool.mixins;

import com.takaranoao.mods.tooltiptool.listenerdefinitions.ItemTooltip;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import org.apache.logging.log4j.LogManager;
import org.dimdev.riftloader.RiftLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;


@Mixin(ItemStack.class)
public class MixinItemStack {
    @Inject(method = "getTooltip", at = @At("RETURN"), cancellable = true)
    public void onGettooltip(EntityPlayer p_getTooltip_1_, ITooltipFlag p_getTooltip_2_, CallbackInfoReturnable<List<ITextComponent>> cir){
        LogManager.getLogger().info(">>>>>getTooltip");
        List<ITextComponent> originalToolTip = cir.getReturnValue();
        List<ITextComponent> toolTip = originalToolTip;
        for (ItemTooltip listener : RiftLoader.instance.getListeners(ItemTooltip.class)) {
            toolTip = listener.getTooltip((ItemStack)((Object)this),p_getTooltip_1_,p_getTooltip_2_,toolTip);
        }
        if(toolTip != originalToolTip){
            cir.setReturnValue(toolTip);
        }
    }
}
