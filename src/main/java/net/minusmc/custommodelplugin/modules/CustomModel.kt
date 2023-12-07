package net.minusmc.custommodelplugin.modules

import net.minusmc.custommodelplugin.modules.model.Model
import net.minusmc.minusbounce.features.module.Module
import net.minusmc.minusbounce.features.module.ModuleCategory
import net.minusmc.minusbounce.features.module.ModuleInfo
import net.minusmc.minusbounce.utils.ClassUtils
import net.minusmc.minusbounce.value.BoolValue
import net.minusmc.minusbounce.value.ListValue
import net.minusmc.minusbounce.value.FloatValue


@ModuleInfo(name = "CustomModel", description = "Custom model player", category = ModuleCategory.RENDER)
object CustomModel: Module() {
    private val models = ClassUtils.resolvePackage("${this.javaClass.`package`.name}.model", Model::class.java)
        .map {it.newInstance() as Model}
        .sortedBy { it.name }

    val model: Model
        get() = models.find {modelModeValue.get().equals(it.name, true)} ?: throw NullPointerException()

    val editPlayerSizeValue = BoolValue("EditPlayerSize", false)
    val playerSizeValue = FloatValue("PlayerSize", 0.5f, 0.01f, 5f) { editPlayerSizeValue.get() }
    val rotatePlayer = BoolValue("RotatePlayer", false)
    val customModel = BoolValue("CustomModel", false)
    private val modelModeValue = ListValue("Mode", arrayOf("Freddy", "Rabbit", "Amongus"), "Freddy") { customModel.get() }

    val baby = BoolValue("Baby", false) { !customModel.get() }
    val onlyMe = BoolValue("OnlyMe", false) { baby.get() || customModel.get() }
    val onlyOther = BoolValue("OnlyOther", false) { baby.get() || customModel.get() }
}