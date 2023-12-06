package net.minusmc.custommodelplugin

import net.minusmc.minusbounce.plugin.Plugin
import net.minusmc.minusbounce.plugin.PluginAPIVersion

class CustomModelPlugin: Plugin("CustomModelPlugin", "dev", PluginAPIVersion.VER_01) {
	override fun init() {
		println("This is an example mod!!!")
	}
}