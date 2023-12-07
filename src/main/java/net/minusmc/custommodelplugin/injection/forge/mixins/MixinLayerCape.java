package net.minusmc.custommodelplugin.injection.forge.mixins;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minusmc.custommodelplugin.modules.CustomModel;
import net.minusmc.minusbounce.MinusBounce;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LayerCape.class)
public class MixinLayerCape {
    /**
     * @author Randomguy && wxdbie
     * @reason for PlayerEdit
     */
    @Inject(method = "doRenderLayer", at = @At("HEAD"), cancellable = true)
    public void doRenderLayer(AbstractClientPlayer p_doRenderLayer_1_, float p_doRenderLayer_2_, float p_doRenderLayer_3_, float p_doRenderLayer_4_, float p_doRenderLayer_5_, float p_doRenderLayer_6_, float p_doRenderLayer_7_, float p_doRenderLayer_8_, CallbackInfo ci) {
        final CustomModel customModel = MinusBounce.moduleManager.getModule(CustomModel.class);
        if (customModel.getState() && customModel.getCustomModel().get())
            ci.cancel();
    }
}
