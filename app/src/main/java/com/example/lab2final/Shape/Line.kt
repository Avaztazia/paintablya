package com.example.lab2final.Shape

import android.graphics.Canvas

open class Line(x1: Float, y1: Float, x2: Float, y2: Float) : Shape(x1, y1, x2, y2,"Line") {
    override fun draw(canvas: Canvas) {
        canvas.drawLine(x1, y1, x2, y2, blackLine)
    }

    override fun clear(canvas: Canvas) {
        canvas.drawLine(x1, y1, x2, y2, clear)
    }
}
