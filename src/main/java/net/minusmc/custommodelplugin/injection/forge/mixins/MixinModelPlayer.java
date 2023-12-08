/*
 * LiquidBounce+ Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/WYSI-Foundation/LiquidBouncePlus/
 */
package net.minusmc.custommodelplugin.injection.forge.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minusmc.custommodelplugin.modules.CustomModel;
import net.minusmc.minusbounce.MinusBounce;
import net.minusmc.minusbounce.event.UpdateModelEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelPlayer.class)
public class MixinModelPlayer extends ModelBiped {
    @Shadow
    private boolean smallArms;
    @Shadow
    public ModelRenderer bipedLeftArmwear;

    @Shadow
    public ModelRenderer bipedRightArmwear;

    @Shadow
    public ModelRenderer bipedLeftLegwear;

    @Shadow
    public ModelRenderer bipedRightLegwear;

    @Shadow
    public ModelRenderer bipedBodyWear;


    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void renderHook(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, CallbackInfo ci) {
        final CustomModel customModel = MinusBounce.moduleManager.getModule(CustomModel.class);
        if (customModel.getCustomModel().get() && (customModel.getOnlyMe().get() && entityIn == Minecraft.getMinecraft().thePlayer || customModel.getOnlyOther().get() && entityIn != Minecraft.getMinecraft().thePlayer) && customModel.getState()) {
            ci.cancel();
            renderCustom(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    public void renderCustom(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        final CustomModel customModel = MinusBounce.moduleManager.getModule(CustomModel.class);
        customModel.getModel().generateModel();

        GlStateManager.pushMatrix();
        if (customModel.getCustomModel().get() && (customModel.getOnlyMe().get() && entityIn == Minecraft.getMinecraft().thePlayer || customModel.getOnlyOther().get() && entityIn != Minecraft.getMinecraft().thePlayer) && customModel.getState()) {
            customModel.getModel().renderGl(limbSwing, limbSwingAmount, netHeadYaw, headPitch, scale);
        } else {
            super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            if (isChild) {
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
                GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            } else {
                if (entityIn.isSneaking())
                    GlStateManager.translate(0.0F, 0.2F, 0.0F);
            }
            bipedLeftLegwear.render(scale);
            bipedRightLegwear.render(scale);
            bipedLeftArmwear.render(scale);
            bipedRightArmwear.render(scale);
            bipedBodyWear.render(scale);
        }
        GlStateManager.popMatrix();
    }
}