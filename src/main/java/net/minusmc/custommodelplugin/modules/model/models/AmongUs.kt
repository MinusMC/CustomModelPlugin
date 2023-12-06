package net.minusmc.custommodelplugin.modules.model.models

import net.minusmc.custommodelplugin.modules.model.Model

class AmongUs: Model("AmongUs") {
	val bodyColorR = IntegerValue("BodyR", 255, 0, 255)
    val bodyColorG = IntegerValue("BodyG", 255, 0, 255)
    val bodyColorB = IntegerValue("BodyB", 255, 0, 255)
    val eyeColorR = IntegerValue("EyeR", 255, 0, 255)
    val eyeColorG = IntegerValue("EyeG", 255, 0, 255)
    val eyeColorB = IntegerValue("EyeB", 255, 0, 255)
    val legsColorR = IntegerValue("LegsR", 255, 0, 255)
    val legsColorG = IntegerValue("LegsG", 255, 0, 255)
    val legsColorB = IntegerValue("LegsB", 255, 0, 255)



    override fun renderGl() {
    	GlStateManager.pushMatrix();
        GlStateManager.scale(1.25, 1.25, 1.25)
        GlStateManager.translate(0.0, -0.3, 0.0)
        rabbitHead.rotateAngleX = bipedHead.rotateAngleX
        rabbitHead.rotateAngleY = bipedHead.rotateAngleY
        rabbitHead.rotateAngleZ = bipedHead.rotateAngleZ
        rabbitLarm.rotateAngleX = bipedLeftArm.rotateAngleX
        rabbitLarm.rotateAngleY = bipedLeftArm.rotateAngleY
        rabbitLarm.rotateAngleZ = bipedLeftArm.rotateAngleZ
        rabbitRarm.rotateAngleX = bipedRightArm.rotateAngleX
        rabbitRarm.rotateAngleY = bipedRightArm.rotateAngleY
        rabbitRarm.rotateAngleZ = bipedRightArm.rotateAngleZ
        rabbitRleg.rotateAngleX = bipedRightLeg.rotateAngleX
        rabbitRleg.rotateAngleY = bipedRightLeg.rotateAngleY
        rabbitRleg.rotateAngleZ = bipedRightLeg.rotateAngleZ
        rabbitLleg.rotateAngleX = bipedLeftLeg.rotateAngleX
        rabbitLleg.rotateAngleY = bipedLeftLeg.rotateAngleY
        rabbitLleg.rotateAngleZ = bipedLeftLeg.rotateAngleZ
        rabbitBone.render(scale)
        GlStateManager.popMatrix()
    }
}