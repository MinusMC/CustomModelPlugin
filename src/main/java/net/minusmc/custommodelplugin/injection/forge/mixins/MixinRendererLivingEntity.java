package net.minusmc.custommodelplugin.injection.forge.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.EnumChatFormatting;
import net.minusmc.custommodelplugin.modules.CustomModel;
import net.minusmc.minusbounce.MinusBounce;
import net.minusmc.minusbounce.injection.forge.mixins.render.MixinRender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RendererLivingEntity.class)
public class MixinRendererLivingEntity {
    @Inject(method = "rotateCorpse", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/EntityLivingBase;deathTime:I", shift = At.Shift.AFTER))
    protected <T extends EntityLivingBase> void rotateCorpse(T p_rotateCorpse_1_, float p_rotateCorpse_2_, float p_rotateCorpse_3_, float p_rotateCorpse_4_, CallbackInfo ci) {
        String s = EnumChatFormatting.getTextWithoutFormattingCodes(p_rotateCorpse_1_.getName());
        final CustomModel customModel = MinusBounce.moduleManager.getModule(CustomModel.class);
        if (s != null && (customModel.getRotatePlayer().get() && p_rotateCorpse_1_.equals(Minecraft.getMinecraft().thePlayer) && customModel.getState()) && (!(p_rotateCorpse_1_ instanceof EntityPlayer) || ((EntityPlayer)p_rotateCorpse_1_).isWearing(EnumPlayerModelParts.CAPE))) {
            GlStateManager.translate(0.0F, p_rotateCorpse_1_.height + 0.1F, 0.0F);
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        }
    }
}
