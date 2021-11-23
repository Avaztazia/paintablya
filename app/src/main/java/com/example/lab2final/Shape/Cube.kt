package com.example.lab2final.Shape

import android.graphics.Canvas
import java.lang.Math.abs

open class Cube(x1: Float, y1: Float, x2: Float, y2: Float) : Shape(x1, y1, x2, y2,"Cube") {
    override fun draw(canvas: Canvas) {
        canvas.drawLine(x1, y1, x2+ kotlin.math.abs(x1 - x2)/2, y1, blackLine)
        canvas.drawLine(x1, y1+kotlin.math.abs(y2-y1)/3*2, x2+ kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3*2, blackLine)
        canvas.drawLine(x1- kotlin.math.abs(x1 - x2)/2, y2, x2, y2, blackLine)
        canvas.drawLine(x1- kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3, x2, y1+kotlin.math.abs(y2-y1)/3, blackLine)
        canvas.drawLine(x1- kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3,x1- kotlin.math.abs(x1 - x2)/2, y2, blackLine)
        canvas.drawLine( x2, y1+kotlin.math.abs(y2-y1)/3, x2, y2, blackLine)
        canvas.drawLine(x1, y1,x1, y1+kotlin.math.abs(y2-y1)/3*2,blackLine)
        canvas.drawLine(x2+ kotlin.math.abs(x1 - x2)/2,y1, x2+ kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3*2, blackLine)
        canvas.drawLine(x1, y1+kotlin.math.abs(y2-y1)/3*2, x1- kotlin.math.abs(x1 - x2)/2, y2, blackLine)
        canvas.drawLine(x1, y1, x1- kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3, blackLine)
        canvas.drawLine(x2+ kotlin.math.abs(x1 - x2)/2, y1, x2, y1+kotlin.math.abs(y2-y1)/3, blackLine)
        canvas.drawLine(x2+ kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3*2, x2, y2,blackLine)

    }

    override fun clear(canvas: Canvas) {
        canvas.drawLine(x1, y1, x2+ kotlin.math.abs(x1 - x2)/2, y1, clear)
        canvas.drawLine(x1, y1+kotlin.math.abs(y2-y1)/3*2, x2+ kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3*2, clear)
        canvas.drawLine(x1- kotlin.math.abs(x1 - x2)/2, y2, x2, y2, clear)
        canvas.drawLine(x1- kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3, x2, y1+kotlin.math.abs(y2-y1)/3, clear)
        canvas.drawLine(x1- kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3,x1- kotlin.math.abs(x1 - x2)/2, y2, clear)
        canvas.drawLine( x2, y1+kotlin.math.abs(y2-y1)/3, x2, y2, clear)
        canvas.drawLine(x1, y1,x1, y1+kotlin.math.abs(y2-y1)/3*2,clear)
        canvas.drawLine(x2+ kotlin.math.abs(x1 - x2)/2,y1, x2+ kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3*2, clear)
        canvas.drawLine(x1, y1+kotlin.math.abs(y2-y1)/3*2, x1- kotlin.math.abs(x1 - x2)/2, y2, clear)
        canvas.drawLine(x1, y1, x1- kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3, clear)
        canvas.drawLine(x2+ kotlin.math.abs(x1 - x2)/2, y1, x2, y1+kotlin.math.abs(y2-y1)/3, clear)
        canvas.drawLine(x2+ kotlin.math.abs(x1 - x2)/2, y1+kotlin.math.abs(y2-y1)/3*2, x2, y2,clear)


    }
}
