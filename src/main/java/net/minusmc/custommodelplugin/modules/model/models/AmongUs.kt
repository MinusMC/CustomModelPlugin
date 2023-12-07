package net.minusmc.custommodelplugin.modules.model.models

import net.minecraft.client.model.ModelBox
import net.minecraft.client.model.ModelRenderer
import net.minecraft.client.renderer.GlStateManager
import net.minecraft.util.MathHelper
import net.minusmc.custommodelplugin.modules.model.Model
import net.minusmc.minusbounce.utils.render.RenderUtils
import net.minusmc.minusbounce.value.IntegerValue
import java.awt.Color


class AmongUs: Model("AmongUs", "custommodelplugin.models/amongus.png") {
    private val bodyColorR = IntegerValue("BodyR", 255, 0, 255)
    private val bodyColorG = IntegerValue("BodyG", 255, 0, 255)
    private val bodyColorB = IntegerValue("BodyB", 255, 0, 255)
    private val eyeColorR = IntegerValue("EyeR", 255, 0, 255)
    private val eyeColorG = IntegerValue("EyeG", 255, 0, 255)
    private val eyeColorB = IntegerValue("EyeB", 255, 0, 255)
    private val legsColorR = IntegerValue("LegsR", 255, 0, 255)
    private val legsColorG = IntegerValue("LegsG", 255, 0, 255)
    private val legsColorB = IntegerValue("LegsB", 255, 0, 255)

    private var left_leg = ModelRenderer(this)
    private var right_leg = ModelRenderer(this)
    private var body = ModelRenderer(this)
    private var eye = ModelRenderer(this)
    private var rabbitBone = ModelRenderer(this)
    private var rabbitRleg = ModelRenderer(this)
    private var rabbitLarm = ModelRenderer(this)
    private var rabbitRarm = ModelRenderer(this)
    private var rabbitLleg = ModelRenderer(this)
    private var rabbitHead = ModelRenderer(this)
    private var armRight = ModelRenderer(this, 48, 0)
    private var armLeftpad = ModelRenderer(this, 38, 54)
    private var armRightpad = ModelRenderer(this, 70, 10)

    private var footRight = ModelRenderer(this, 22, 39)
    private var earRight = ModelRenderer(this, 8, 0)
    private var legLeftpad = ModelRenderer(this, 48, 39)
    private var earRightpad_1 = ModelRenderer(this, 40, 39)
    private var legLeft = ModelRenderer(this, 54, 10)
    private var armRightpad2 = ModelRenderer(this, 0, 26)
    private var handLeft = ModelRenderer(this, 58, 56)
    private var armLeft = ModelRenderer(this, 62, 10)
    private var legRight = ModelRenderer(this, 90, 8)
    private var armLeft2 = ModelRenderer(this, 90, 48)
    private var legRight2 = ModelRenderer(this, 20, 35)
    private var armLeftpad2 = ModelRenderer(this, 0, 58)
    private var legLeft2 = ModelRenderer(this, 72, 48)
    private var hat = ModelRenderer(this, 70, 24)
    private var earRightpad = ModelRenderer(this, 85, 0)
    private var crotch = ModelRenderer(this, 56, 0)
    private var torso = ModelRenderer(this, 8, 0)
    private var armRight2 = ModelRenderer(this, 90, 20)
    private var handRight = ModelRenderer(this, 20, 26)
    private var fredbody = ModelRenderer(this, 0, 0)
    private var fredhead = ModelRenderer(this, 39, 22)
    private var legRightpad = ModelRenderer(this, 73, 33)
    private var frednose = ModelRenderer(this, 17, 67)
    private var legLeftpad2 = ModelRenderer(this, 16, 50)
    private var hat2 = ModelRenderer(this, 78, 61)
    private var legRightpad2 = ModelRenderer(this, 0, 39)
    private var jaw = ModelRenderer(this, 49, 65)
    private var footLeft = ModelRenderer(this, 72, 50)
    private var earLeft = ModelRenderer(this, 40, 0)

    override fun generateModel() {
        body = ModelRenderer(this)
        body.setRotationPoint(0.0f, 0.0f, 0.0f)
        body.setTextureOffset(34, 8).addBox(-4.0f, 6.0f, -3.0f, 8, 12, 6)
        body.setTextureOffset(15, 10).addBox(-3.0f, 9.0f, 3.0f, 6, 8, 3)
        body.setTextureOffset(26, 0).addBox(-3.0f, 5.0f, -3.0f, 6, 1, 6)

        eye = ModelRenderer(this)
        eye.setTextureOffset(0, 10).addBox(-3.0f, 7.0f, -4.0f, 6, 4, 1)

        left_leg = ModelRenderer(this)
        left_leg.setRotationPoint(-2.0f, 18.0f, 0.0f)
        left_leg.setTextureOffset(0, 0).addBox(2.9f, 0.0f, -1.5f, 3, 6, 3, 0.0f)

        right_leg = ModelRenderer(this)
        right_leg.setRotationPoint(2.0f, 18.0f, 0.0f)
        right_leg.setTextureOffset(13, 0).addBox(-5.9f, 0.0f, -1.5f, 3, 6, 3)
        rabbitBone = ModelRenderer(this)
        rabbitBone.setRotationPoint(0.0f, 24.0f, 0.0f)
        rabbitBone.cubeList.add(ModelBox(rabbitBone, 28, 45, -5.0f, -13.0f, -5.0f, 10, 11, 8, 0.0f, false))

        rabbitRleg = ModelRenderer(this)
        rabbitRleg.setRotationPoint(-3.0f, -2.0f, -1.0f)
        rabbitBone.addChild(rabbitRleg)
        rabbitRleg.cubeList.add(ModelBox(rabbitRleg, 0, 0, -2.0f, 0.0f, -2.0f, 4, 2, 4, 0.0f, false))

        rabbitLarm = ModelRenderer(this)
        rabbitLarm.setRotationPoint(5.0f, -13.0f, -1.0f)
        setRotationAngle(rabbitLarm, 0.0f, 0.0f, -0.0873f)
        rabbitBone.addChild(rabbitLarm)
        rabbitLarm.cubeList.add(ModelBox(rabbitLarm, 0, 0, 0.0f, 0.0f, -2.0f, 2, 8, 4, 0.0f, false))

        rabbitRarm = ModelRenderer(this)
        rabbitRarm.setRotationPoint(-5.0f, -13.0f, -1.0f)
        setRotationAngle(rabbitRarm, 0.0f, 0.0f, 0.0873f)
        rabbitBone.addChild(rabbitRarm)
        rabbitRarm.cubeList.add(ModelBox(rabbitRarm, 0, 0, -2.0f, 0.0f, -2.0f, 2, 8, 4, 0.0f, false))

        rabbitLleg.setRotationPoint(3.0f, -2.0f, -1.0f)
        rabbitBone.addChild(rabbitLleg)
        rabbitLleg.cubeList.add(ModelBox(rabbitLleg, 0, 0, -2.0f, 0.0f, -2.0f, 4, 2, 4, 0.0f, false))

        rabbitHead.setRotationPoint(0.0f, -14.0f, -1.0f)
        rabbitBone.addChild(rabbitHead)
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 0, 0, -3.0f, 0.0f, -4.0f, 6, 1, 6, 0.0f, false))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 56, 0, -5.0f, -9.0f, -5.0f, 2, 3, 2, 0.0f, false))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 56, 0, 3.0f, -9.0f, -5.0f, 2, 3, 2, 0.0f, true))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 0, 45, -4.0f, -11.0f, -4.0f, 8, 11, 8, 0.0f, false))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 46, 0, 1.0f, -20.0f, 0.0f, 3, 9, 1, 0.0f, false))
        rabbitHead.cubeList.add(ModelBox(rabbitHead, 46, 0, -4.0f, -20.0f, 0.0f, 3, 9, 1, 0.0f, false))

        textureWidth = 100
        textureHeight = 80

        footRight = ModelRenderer(this, 22, 39)
        footRight.setRotationPoint(0.0f, 8.0f, 0.0f)
        footRight.addBox(-2.5f, 0.0f, -6.0f, 5, 3, 8, 0.0f)
        setRotationAngle(footRight, -0.034906585f, 0.0f, 0.0f)

        earRight = ModelRenderer(this, 8, 0)
        earRight.setRotationPoint(-4.5f, -5.5f, 0.0f)
        earRight.addBox(-1.0f, -3.0f, -0.5f, 2, 3, 1, 0.0f)
        setRotationAngle(earRight, 0.05235988f, 0.0f, -1.0471976f)

        legLeftpad = ModelRenderer(this, 48, 39)
        legLeftpad.setRotationPoint(0.0f, 0.5f, 0.0f)
        legLeftpad.addBox(-3.0f, 0.0f, -3.0f, 6, 9, 6, 0.0f)

        earRightpad_1 = ModelRenderer(this, 40, 39)
        earRightpad_1.setRotationPoint(0.0f, -1.0f, 0.0f)
        earRightpad_1.addBox(-2.0f, -5.0f, -1.0f, 4, 4, 2, 0.0f)

        legLeft = ModelRenderer(this, 54, 10)
        legLeft.setRotationPoint(3.3f, 12.5f, 0.0f)
        legLeft.addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f)

        armRightpad2 = ModelRenderer(this, 0, 26)
        armRightpad2.setRotationPoint(0.0f, 0.5f, 0.0f)
        armRightpad2.addBox(-2.5f, 0.0f, -2.5f, 5, 7, 5, 0.0f)

        handLeft.setRotationPoint(0.0f, 8.0f, 0.0f)
        handLeft.addBox(-2.0f, 0.0f, -2.5f, 4, 4, 5, 0.0f)
        setRotationAngle(handLeft, 0.0f, 0.0f, 0.05235988f)

        armLeft = ModelRenderer(this, 62, 10)
        armLeft.setRotationPoint(6.5f, -8.0f, 0.0f)
        armLeft.addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f)
        setRotationAngle(armLeft, 0.0f, 0.0f, -0.2617994f)

        legRight = ModelRenderer(this, 90, 8)
        legRight.setRotationPoint(-3.3f, 12.5f, 0.0f)
        legRight.addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f)

        armLeft2 = ModelRenderer(this, 90, 48)
        armLeft2.setRotationPoint(0.0f, 9.6f, 0.0f)
        armLeft2.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f)
        setRotationAngle(armLeft2, -0.17453292f, 0.0f, 0.0f)

        legRight2 = ModelRenderer(this, 20, 35)
        legRight2.setRotationPoint(0.0f, 9.6f, 0.0f)
        legRight2.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f)
        setRotationAngle(legRight2, 0.034906585f, 0.0f, 0.0f)

        armLeftpad2 = ModelRenderer(this, 0, 58)
        armLeftpad2.setRotationPoint(0.0f, 0.5f, 0.0f)
        armLeftpad2.addBox(-2.5f, 0.0f, -2.5f, 5, 7, 5, 0.0f)

        legLeft2 = ModelRenderer(this, 72, 48)
        legLeft2.setRotationPoint(0.0f, 9.6f, 0.0f)
        legLeft2.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f)
        setRotationAngle(legLeft2, 0.034906585f, 0.0f, 0.0f)

        hat = ModelRenderer(this, 70, 24)
        hat.setRotationPoint(0.0f, -8.4f, 0.0f)
        hat.addBox(-3.0f, -0.5f, -3.0f, 6, 1, 6, 0.0f)
        setRotationAngle(hat, -0.017453292f, 0.0f, 0.0f)

        earRightpad = ModelRenderer(this, 85, 0)
        earRightpad.setRotationPoint(0.0f, -1.0f, 0.0f)
        earRightpad.addBox(-2.0f, -5.0f, -1.0f, 4, 4, 2, 0.0f)

        crotch = ModelRenderer(this, 56, 0)
        crotch.setRotationPoint(0.0f, 9.5f, 0.0f)
        crotch.addBox(-5.5f, 0.0f, -3.5f, 11, 3, 7, 0.0f)

        torso = ModelRenderer(this, 8, 0)
        torso.setRotationPoint(0.0f, 0.0f, 0.0f)
        torso.addBox(-6.0f, -9.0f, -4.0f, 12, 18, 8, 0.0f)
        setRotationAngle(torso, 0.017453292f, 0.0f, 0.0f)

        armRight2 = ModelRenderer(this, 90, 20)
        armRight2.setRotationPoint(0.0f, 9.6f, 0.0f)
        armRight2.addBox(-1.0f, 0.0f, -1.0f, 2, 8, 2, 0.0f)
        setRotationAngle(armRight2, -0.17453292f, 0.0f, 0.0f)

        handRight = ModelRenderer(this, 20, 26)
        handRight.setRotationPoint(0.0f, 8.0f, 0.0f)
        handRight.addBox(-2.0f, 0.0f, -2.5f, 4, 4, 5, 0.0f)
        setRotationAngle(handRight, 0.0f, 0.0f, -0.05235988f)

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

        legLeftpad2 = ModelRenderer(this, 16, 50)
        legLeftpad2.setRotationPoint(0.0f, 0.5f, 0.0f)
        legLeftpad2.addBox(-2.5f, 0.0f, -3.0f, 5, 7, 6, 0.0f)

        armRightpad = ModelRenderer(this, 70, 10)
        armRightpad.setRotationPoint(0.0f, 0.5f, 0.0f)
        armRightpad.addBox(-2.5f, 0.0f, -2.5f, 5, 9, 5, 0.0f)

        armLeftpad = ModelRenderer(this, 38, 54)
        armLeftpad.setRotationPoint(0.0f, 0.5f, 0.0f)
        armLeftpad.addBox(-2.5f, 0.0f, -2.5f, 5, 9, 5, 0.0f)

        hat2 = ModelRenderer(this, 78, 61)
        hat2.setRotationPoint(0.0f, 0.1f, 0.0f)
        hat2.addBox(-2.0f, -4.0f, -2.0f, 4, 4, 4, 0.0f)
        setRotationAngle(hat2, -0.017453292f, 0.0f, 0.0f)

        legRightpad2 = ModelRenderer(this, 0, 39)
        legRightpad2.setRotationPoint(0.0f, 0.5f, 0.0f)
        legRightpad2.addBox(-2.5f, 0.0f, -3.0f, 5, 7, 6, 0.0f)

        jaw = ModelRenderer(this, 49, 65)
        jaw.setRotationPoint(0.0f, 0.5f, 0.0f)
        jaw.addBox(-5.0f, 0.0f, -4.5f, 10, 3, 9, 0.0f)
        setRotationAngle(jaw, 0.08726646f, 0.0f, 0.0f)

        armRight = ModelRenderer(this, 48, 0)
        armRight.setRotationPoint(-6.5f, -8.0f, 0.0f)
        armRight.addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2, 0.0f)
        setRotationAngle(armRight, 0.0f, 0.0f, 0.2617994f)

        footLeft = ModelRenderer(this, 72, 50)
        footLeft.setRotationPoint(0.0f, 8.0f, 0.0f)
        footLeft.addBox(-2.5f, 0.0f, -6.0f, 5, 3, 8, 0.0f)
        setRotationAngle(footLeft, -0.034906585f, 0.0f, 0.0f)

        earLeft = ModelRenderer(this, 40, 0)
        earLeft.setRotationPoint(4.5f, -5.5f, 0.0f)
        earLeft.addBox(-1.0f, -3.0f, -0.5f, 2, 3, 1, 0.0f)
        setRotationAngle(earLeft, 0.05235988f, 0.0f, 1.0471976f)


        legRight2.addChild(footRight)
        fredhead.addChild(earRight)
        legLeft.addChild(legLeftpad)
        earLeft.addChild(earRightpad_1)
        fredbody.addChild(legLeft)
        armRight2.addChild(armRightpad2)
        armLeft2.addChild(handLeft)
        fredbody.addChild(armLeft)
        fredbody.addChild(legRight)
        armLeft.addChild(armLeft2)
        legRight.addChild(legRight2)
        armLeft2.addChild(armLeftpad2)
        legLeft.addChild(legLeft2)
        fredhead.addChild(hat)
        earRight.addChild(earRightpad)
        fredbody.addChild(crotch)
        fredbody.addChild(torso)
        armRight.addChild(armRight2)
        armRight2.addChild(handRight)
        fredbody.addChild(fredhead)
        legRight.addChild(legRightpad)
        fredhead.addChild(frednose)
        legLeft2.addChild(legLeftpad2)
        armRight.addChild(armRightpad)
        armLeft.addChild(armLeftpad)
        hat.addChild(hat2)
        legRight2.addChild(legRightpad2)
        fredhead.addChild(jaw)
        fredbody.addChild(armRight)
        legLeft2.addChild(footLeft)
        fredhead.addChild(earLeft)
    }

    override fun renderGl(limbSwing: Float, limbSwingAmount: Float, netHeadYaw: Float, headPitch: Float, scale: Float) {
        bipedHead.rotateAngleY = netHeadYaw * 0.017453292f
        bipedHead.rotateAngleX = headPitch * 0.017453292f
        bipedBody.rotateAngleY = 0.0f
        var f = 1.0f
        if (f < 1.0f) f = 1.0f
        right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount / f
        this.left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount / f
        this.right_leg.rotateAngleY = 0.0f
        this.left_leg.rotateAngleY = 0.0f
        this.right_leg.rotateAngleZ = 0.0f
        this.left_leg.rotateAngleZ = 0.0f
        val bodyCustomColor: Int = Color(bodyColorR.get(), bodyColorG.get(), bodyColorB.get()).rgb
        val eyeCustomColor: Int = Color(eyeColorR.get(), eyeColorG.get(), eyeColorB.get()).rgb
        val legsCustomColor: Int = Color(legsColorR.get(), legsColorG.get(), legsColorB.get()).rgb
        if (isChild) {
            GlStateManager.scale(0.5f, 0.5f, 0.5f)
            GlStateManager.translate(0.0f, 24.0f * scale, 0.0f)
            this.body.render(scale)
            this.left_leg.render(scale)
            this.right_leg.render(scale)
        } else {
            GlStateManager.translate(0.0, -0.8, 0.0)
            GlStateManager.scale(1.8, 1.6, 1.6)
            RenderUtils.color(bodyCustomColor)
            GlStateManager.translate(0.0, 0.15, 0.0)
            this.body.render(scale)
            RenderUtils.color(eyeCustomColor)
            this.eye.render(scale)
            RenderUtils.color(legsCustomColor)
            GlStateManager.translate(0.0, -0.15, 0.0)
            this.left_leg.render(scale)
            this.right_leg.render(scale)
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f)
        }
    }
}