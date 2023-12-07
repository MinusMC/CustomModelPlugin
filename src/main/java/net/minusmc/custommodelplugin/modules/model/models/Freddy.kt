package net.minusmc.custommodelplugin.modules.model.models

import net.minecraft.client.model.ModelRenderer
import net.minecraft.client.renderer.GlStateManager
import net.minusmc.custommodelplugin.modules.model.Model

class Freddy: Model("Freddy", "custommodelplugin/models/freddy.png") {

    private var fredbody = ModelRenderer(this, 0, 0)
    private var frednose = ModelRenderer(this, 17, 67)
    private var armLeft = ModelRenderer(this)
    private var legRight = ModelRenderer(this)
    private var legLeft = ModelRenderer(this)
    private var armRight = ModelRenderer(this)

    private var hat = ModelRenderer(this, 70, 24)
    private var hat2 = ModelRenderer(this, 78, 61)
    private var jaw = ModelRenderer(this, 49, 65)
    private var fredhead = ModelRenderer(this, 39, 22)
    private var legRightpad = ModelRenderer(this, 73, 33)
    private var earRight = ModelRenderer(this, 8, 0)
    private var earLeft = ModelRenderer(this, 40, 0)

    override fun generateModel() {
        earRight = ModelRenderer(this, 8, 0)
        earRight.setRotationPoint(-4.5f, -5.5f, 0.0f)
        earRight.addBox(-1.0f, -3.0f, -0.5f, 2, 3, 1, 0.0f)
        setRotationAngle(earRight, 0.05235988f, 0.0f, -1.0471976f)

        hat = ModelRenderer(this, 70, 24)
        hat.setRotationPoint(0.0f, -8.4f, 0.0f)
        hat.addBox(-3.0f, -0.5f, -3.0f, 6, 1, 6, 0.0f)
        setRotationAngle(hat, -0.017453292f, 0.0f, 0.0f)

        fredbody = ModelRenderer(this, 0, 0)
        fredbody.setRotationPoint(0.0f, -9.0f, 0.0f)
        fredbody.addBox(-1.0f, -14.0f, -1.0f, 2, 24, 2, 0.0f)

        fredhead = ModelRenderer(this, 39, 22)
        fredhead.setRotationPoint(0.0f, -13.0f, -0.5f)
        fredhead.addBox(-5.5f, -8.0f, -4.5f, 11, 8, 9, 0.0f)

        legRightpad = ModelRenderer(this, 73, 33)
        legRightpad.setRotationPoint(0.0f, 0.5f, 0.0f)
        legRightpad.addBox(-3.0f, 0.0f, -3.0f, 6, 9, 6, 0.0f)

        frednose = ModelRenderer(this, 17, 67)
        frednose.setRotationPoint(0.0f, -2.0f, -4.5f)
        frednose.addBox(-4.0f, -2.0f, -3.0f, 8, 4, 3, 0.0f)
        
        hat2 = ModelRenderer(this, 78, 61)
        hat2.setRotationPoint(0.0f, 0.1f, 0.0f)
        hat2.addBox(-2.0f, -4.0f, -2.0f, 4, 4, 4, 0.0f)
        setRotationAngle(hat2, -0.017453292f, 0.0f, 0.0f)

        jaw = ModelRenderer(this, 49, 65)
        jaw.setRotationPoint(0.0f, 0.5f, 0.0f)
        jaw.addBox(-5.0f, 0.0f, -4.5f, 10, 3, 9, 0.0f)
        setRotationAngle(jaw, 0.08726646f, 0.0f, 0.0f)

        earLeft = ModelRenderer(this, 40, 0)
        earLeft.setRotationPoint(4.5f, -5.5f, 0.0f)
        earLeft.addBox(-1.0f, -3.0f, -0.5f, 2, 3, 1, 0.0f)
        setRotationAngle(earLeft, 0.05235988f, 0.0f, 1.0471976f)

        fredhead.addChild(earRight)
        fredhead.addChild(hat)
        fredbody.addChild(fredhead)
        fredhead.addChild(frednose)
        fredhead.addChild(jaw)
        fredhead.addChild(earLeft)
    }

    override fun renderGl(limbSwing: Float, limbSwingAmount: Float, netHeadYaw: Float, headPitch: Float, scale: Float) {
    	fredhead.rotateAngleX = bipedHead.rotateAngleX
        fredhead.rotateAngleY = bipedHead.rotateAngleY
        fredhead.rotateAngleZ = bipedHead.rotateAngleZ
        armLeft.rotateAngleX = bipedLeftArm.rotateAngleX
        armLeft.rotateAngleY = bipedLeftArm.rotateAngleY
        armLeft.rotateAngleZ = bipedLeftArm.rotateAngleZ
        legRight.rotateAngleX = bipedRightLeg.rotateAngleX
        legRight.rotateAngleY = bipedRightLeg.rotateAngleY
        legRight.rotateAngleZ = bipedRightLeg.rotateAngleZ
        legLeft.rotateAngleX = bipedLeftLeg.rotateAngleX
        legLeft.rotateAngleY = bipedLeftLeg.rotateAngleY
        legLeft.rotateAngleZ = bipedLeftLeg.rotateAngleZ
        armRight.rotateAngleX = bipedRightArm.rotateAngleX
        armRight.rotateAngleY = bipedRightArm.rotateAngleY
        armRight.rotateAngleZ = bipedRightArm.rotateAngleZ
        GlStateManager.pushMatrix()
        GlStateManager.scale(0.75, 0.65, 0.75)
        GlStateManager.translate(0.0, 0.85, 0.0)
        fredbody.render(scale)
        GlStateManager.popMatrix()
    }
}