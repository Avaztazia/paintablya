package com.example.lab2final.Shape

import android.graphics.Canvas

class Point(x1: Float, y1: Float, x2: Float, y2: Float) : Shape(x1, y1, x1, y1,"Point") {
    override fun draw(canvas: Canvas) {
        canvas.drawOval(x1 - 10f, y1 - 10f, x1 + 10f, y1 + 10f, point)
    }

    override fun clear(canvas: Canvas) {
        canvas.drawCircle(x1, y1, 10f, clear)
    }
}