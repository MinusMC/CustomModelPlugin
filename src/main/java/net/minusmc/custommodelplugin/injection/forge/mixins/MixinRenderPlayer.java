package net.minusmc.custommodelplugin.injection.forge.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;
import net.minusmc.custommodelplugin.modules.CustomModel;
import net.minusmc.minusbounce.MinusBounce;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderPlayer.class)
public class MixinRenderPlayer {
    @Inject(method = "renderLivingAt*", at = @At("HEAD"))
    protected void renderLivingAt(AbstractClientPlayer entityLivingBaseIn, double x, double y, double z, CallbackInfo callbackInfo) {
        final CustomModel customModel = MinusBounce.moduleManager.get(CustomModel.class);
        if(customModel.getState() & entityLivingBaseIn.equals(Minecraft.getMinecraft().thePlayer) && customModel.getEditPlayerSizeValue().get()) {
            final float size = customModel.getPlayerSizeValue().get();
            GlStateManager.scale(size, size, size);
        }
    }
    @Inject(method = "getEntityTexture*", at = @At("HEAD"), cancellable = true)
    public void getEntityTexture(AbstractClientPlayer entity, CallbackInfoReturnable<ResourceLocation> ci) {
        final CustomModel customModel = MinusBounce.moduleManager.get(CustomModel.class);
        if (customModel.getCustomModel().get() && (customModel.getOnlyMe().get() && entity == Minecraft.getMinecraft().thePlayer || customModel.getOnlyOther().get() && entity != Minecraft.getMinecraft().thePlayer) && customModel.getState()) {
            final ResourceLocation texture = new ResourceLocation(customModel.getModel().getTextures());
            ci.setReturnValue(texture);
        }
    }
}
