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
import net.minusmc.minusbounce.features.module.modules.render.PlayerEdit;
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

    @ModifyConstant(method = "<init>", constant = @Constant(floatValue = 2.5F))
    private float fixAlexArmHeight(float original) {
        return 2.0F;
    }

    /**
     * @author asbyth
     * @reason Resolve item positions being incorrect on Alex custommodelplugin.models (MC-72397)
     */
    @Overwrite
    public void postRenderArm(float scale) {
        if (this.smallArms) {
            this.bipedRightArm.rotationPointX += 0.5F;
            this.bipedRightArm.postRender(scale);
            this.bipedRightArm.rotationPointZ -= 0.5F;
        } else {
            this.bipedRightArm.postRender(scale);
        }
    }

    @Inject(method = {"render"}, at = {@At("HEAD")}, cancellable = true)
    public void renderHook(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, CallbackInfo ci) {
        final CustomModel customModel = MinusBounce.moduleManager.getModule(CustomModel.class);
        if (PlayerEdit.customModel.get() && (customModel.getOnlyMe().get() && entityIn == Minecraft.getMinecraft().thePlayer || customModel.getOnlyOther().get() && entityIn != Minecraft.getMinecraft().thePlayer) && customModel.getState()) {
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

    @Inject(method = "setRotationAngles", at = @At("RETURN"))
    private void revertSwordAnimation(float p_setRotationAngles_1_, float p_setRotationAngles_2_, float p_setRotationAngles_3_, float p_setRotationAngles_4_, float p_setRotationAngles_5_, float p_setRotationAngles_6_, Entity p_setRotationAngles_7_, CallbackInfo callbackInfo) {
        MinusBounce.eventManager.callEvent(new UpdateModelEvent((EntityPlayer) p_setRotationAngles_7_,(ModelPlayer)(Object)this));
    }
}