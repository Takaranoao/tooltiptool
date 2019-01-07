package com.takaranoao.mods.tooltiptool.mixins;

import com.takaranoao.mods.tooltiptool.listener.ItemTooltipListener;
import net.minecraft.nbt.NBTTagCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin(NBTTagCompound.class)
public class MixinNBTTagCompound {
    @Inject(method = "contains(Ljava/lang/String;I)Z", at = @At("RETURN"), cancellable = true)
    private void onContains(String p_contains_1_, int p_contains_2_,CallbackInfoReturnable<Boolean> cir){
        if(p_contains_1_.equals("HideFlags") && p_contains_2_ == 99 && ItemTooltipListener.atGetTooltip){
            cir.setReturnValue(false);
        }
    }
}
