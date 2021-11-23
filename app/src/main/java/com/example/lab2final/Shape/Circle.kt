package com.example.lab2final.Shape

import android.graphics.Canvas

open class Circle(x1: Float, y1: Float, x2: Float, y2: Float) : Shape(x1, y1, x2, y2,"Circle") {
    override fun draw(canvas: Canvas) {
        canvas.drawOval(x1, y1, x2, y2, blackLine)
        canvas.drawOval(x1, y1, x2, y2, greyFill)
    }

    override fun clear(canvas:Canvas) {
        canvas.drawOval(x1, y1, x2, y2, clear)
        canvas.drawOval(x1, y1, x2, y2, clearfill)
    }
}
