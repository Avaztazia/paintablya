package com.example.lab2final.Shape

import android.graphics.Canvas

open class Rect(x1: Float, y1: Float, x2: Float, y2: Float) : Shape(x1, y1, x2, y2,"Rect") {
    override fun draw(canvas: Canvas) {
        canvas.drawRect(2 * x1 - x2, 2 * y1 - y2, x2, y2, blackLine)
        canvas.drawRect(2 * x1 - x2, 2 * y1 - y2, x2, y2, yellowFill)
    }

    override fun clear(canvas: Canvas) {
        canvas.drawRect(2 * x1 - x2, 2 * y1 - y2, x2, y2, clear)
        canvas.drawRect(2 * x1 - x2, 2 * y1 - y2, x2, y2, clearfill)
    }
}
