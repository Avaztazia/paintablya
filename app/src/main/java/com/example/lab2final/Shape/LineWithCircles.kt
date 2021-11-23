package com.example.lab2final.Shape

import android.graphics.Canvas
import java.lang.Math.pow
import kotlin.math.pow
import kotlin.math.sqrt

open class LineWithCircles(x1: Float, y1: Float, x2: Float, y2: Float) : Shape(x1, y1, x2, y2,"LineWithCircles") {
    override fun draw(canvas: Canvas) {
        val r : Float = sqrt((x1 - x2).pow(2) + (y1 - y2).pow(2))/7
        canvas.drawLine(x1, y1, x2, y2, blackLine)
        canvas.drawCircle(x1, y1, r, blackLine)
        canvas.drawCircle(x1, y1, r, clearfill)
        canvas.drawCircle(x2, y2, r, blackLine)
        canvas.drawCircle(x2, y2, r, clearfill)
    }

    override fun clear(canvas: Canvas) {
        canvas.drawLine(x1, y1, x2, y2, clear)
    }
}
