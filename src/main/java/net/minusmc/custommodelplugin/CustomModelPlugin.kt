package net.minusmc.custommodelplugin

import net.minusmc.custommodelplugin.modules.CustomModel
import net.minusmc.minusbounce.MinusBounce
import net.minusmc.minusbounce.plugin.Plugin
import net.minusmc.minusbounce.plugin.PluginAPIVersion

class CustomModelPlugin: Plugin("CustomModelPlugin", version = "dev", minApiVersion = PluginAPIVersion.VER_01) {
	override fun init() {
		println("This is an example mod!!!")
	}

	override fun registerModules() {
		MinusBounce.moduleManager.registerModule(CustomModel)
	}
}