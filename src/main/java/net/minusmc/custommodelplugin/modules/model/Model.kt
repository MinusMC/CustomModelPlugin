package net.minusmc.custommodelplugin.modules.model

import net.minusmc.minusbounce.utils.MinecraftInstance
import net.minusmc.minusbounce.value.Value
import net.minusmc.minusbounce.utils.ClassUtils

abstract class Model(val name: String): MinecraftInstance() {
	open val values: List<Value<*>>
		get() = ClassUtils.getValues(this.javaClass, this)

	open fun renderGl() {}

	open fun generateModel() {}
}