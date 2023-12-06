package net.minusmc.custommodelplugin.modules.model.models

import net.minusmc.custommodelplugin.modules.model.Model
import net.minecraft.client.model.ModelRenderer
import net.minecraft.client.model.ModelBox
import net.minusmc.minusbounce.value.IntegerValue
import net.minecraft.client.renderer.GlStateManager

class Rabbit: Model("Rabbit") {
    var rabbitBone = ModelRenderer(this)
    var rabbitRleg = ModelRenderer(this)
    var rabbitLarm = ModelRenderer(this)
    var rabbitRarm = ModelRenderer(this)
    var rabbitLleg = ModelRenderer(this)
    var rabbitHead = ModelRenderer(this)

    override fun generateModel() {
        rabbitBone = ModelRenderer(this)
        rabbitBone.setRotationPoint(0.0F, 24.0F, 0.0F)
        rabbitBone.cubeList.add(ModelBox(rabbitBone, 28, 45, -5.0F, -13.0F, -5.0F, 10, 11, 8, 0.0F, false))

        rabbitRleg = ModelRenderer(this)
        rabbitRleg.setRotationPoint(-3.0F, -2.0F, -1.0F)
        rabbitBone.addChild(rabbitRleg)
        rabbitRleg.cubeList.add(ModelBox(rabbitRleg, 0, 0, -2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F, false))

        rabbitLarm = ModelRenderer(this)
        rabbitLarm.setRotationPoint(5.0F, -13.0F, -1.0F)
        setRotationAngle(rabbitLarm, 0.0F, 0.0F, -0.0873F)
        rabbitBone.addChild(rabbitLarm)
        rabbitLarm.cubeList.add(ModelBox(rabbitLarm, 0, 0, 0.0F, 0.0F, -2.0F, 2, 8, 4, 0.0F, false))

        rabbitRarm = ModelRenderer(this)
        rabbitRarm.setRotationPoint(-5.0F, -13.0F, -1.0F)
        setRotationAngle(rabbitRarm, 0.0F, 0.0F, 0.0873F)
        rabbitBone.addChild(rabbitRarm)
        rabbitRarm.cubeList.add(ModelBox(rabbitRarm, 0, 0, -2.0F, 0.0F, -2.0F, 2, 8, 4, 0.0F, false))

        rabbitLleg = ModelRenderer(this)
        rabbitLleg.setRotationPoint(3.0F, -2.0F, -1.0F)
        rabbitBone.addChild(rabbitLleg)
        rabbitLleg.cubeList.add(ModelBox(rabbitLleg, 0, 0, -2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F, false))

        rabbitHead = ModelRenderer(this)
        rabbitHead.setRotationPoint(0.0F, -14.0F, -1.0F)
        rabbitBone.addChild(rabbitHead)
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 0, 0, -3.0F, 0.0F, -4.0F, 6, 1, 6, 0.0F, false))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 56, 0, -5.0F, -9.0F, -5.0F, 2, 3, 2, 0.0F, false))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 56, 0, 3.0F, -9.0F, -5.0F, 2, 3, 2, 0.0F, true))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 0, 45, -4.0F, -11.0F, -4.0F, 8, 11, 8, 0.0F, false))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 46, 0, 1.0F, -20.0F, 0.0F, 3, 9, 1, 0.0F, false))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 46, 0, -4.0F, -20.0F, 0.0F, 3, 9, 1, 0.0F, false))
    }

    override fun renderGl(scale: Float) {
    	GlStateManager.pushMatrix()
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