package com.example.lab2final.Shape

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
private const val STROKE_WIDTH = 10f

open class Shape(var x1: Float, var y1: Float, var x2: Float, var y2: Float,var figureName:String) {

    open val blackLine = Paint().apply {
        color = Color.BLACK
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH
    }
    open val yellowFill = Paint().apply {
        color = Color.YELLOW
        isAntiAlias = true
        isDither = true
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH
    }
    open val point = Paint().apply {
        color = Color.BLACK
        isAntiAlias = true
        isDither = true
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH
    }
    open val greyFill = Paint().apply {
        color = Color.GRAY
        isAntiAlias = true
        isDither = true
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH
    }
    open val clear = Paint().apply {
        color = Color.WHITE
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH + 5
    }
    open val clearfill = Paint().apply {
        color = Color.WHITE
        isAntiAlias = true
        isDither = true
        style = Paint.Style.FILL
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = STROKE_WIDTH + 5
    }

    open fun draw(canvas: Canvas) {

    }

    open fun clear(canvas: Canvas) {

    }

    open fun changeParams(lX: Float, lY: Float, rX: Float, rY: Float,name:String) {
        this.x1 = lX
        this.y1 = lY
        this.x2 = rX
        this.y2 = rY
        this.figureName = name
    }

}