package net.minusmc.custommodelplugin.modules.model

import net.minecraft.client.model.ModelRenderer
import net.minecraft.client.model.ModelBiped
import net.minusmc.custommodelplugin.modules.CustomModel
import net.minusmc.minusbounce.MinusBounce
import net.minusmc.minusbounce.value.Value
import net.minusmc.minusbounce.utils.ClassUtils

abstract class Model(val name: String, val textures: String = ""): ModelBiped() {
	open val values: List<Value<*>>
		get() = ClassUtils.getValues(this.javaClass, this)

	open fun renderGl(limbSwing: Float, limbSwingAmount: Float, netHeadYaw: Float, headPitch: Float, scale: Float) {}

	open fun generateModel() {}

	protected fun setRotationAngle(modelRenderer: ModelRenderer, x: Float, y: Float, z: Float) {
        modelRenderer.rotateAngleX = x
        modelRenderer.rotateAngleY = y
        modelRenderer.rotateAngleZ = z
    }
}