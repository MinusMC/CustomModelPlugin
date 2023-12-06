package net.minusmc.custommodelplugin.injection.forge.mixins;

import net.minusmc.minusbounce.MinusBounce;
import net.minusmc.custommodelplugin.modules.CustomModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.entity.EntityLivingBase;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LayerArmorBase.class)
public class MixinLayerArmorBase {

    @Inject(method = "doRenderLayer", at = @At("HEAD"), cancellable = true)
    public void doRenderLayer(final EntityLivingBase entitylivingbaseIn, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale, final CallbackInfo ci) {
        final CustomModel customModelModule = MinusBounce.moduleManager.getModule(PlayerEdit.class)
        if (customModelModule.getCustomModel().get() && (customModelModule.getOnlyMe().get() && entitylivingbaseIn == Minecraft.getMinecraft().thePlayer || customModelModule.onlyOther.get() && entitylivingbaseIn != Minecraft.getMinecraft().thePlayer) && customModelModule.getState()) {
            ci.cancel();
        }
    }

}