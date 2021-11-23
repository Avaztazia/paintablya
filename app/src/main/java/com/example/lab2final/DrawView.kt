package com.example.lab2final

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import com.example.lab2final.Shape.*
import com.example.lab2final.Shape.Point
import com.example.lab2final.Shape.Rect
import kotlin.reflect.KClass

private var motionTouchEventX = 0f
private var motionTouchEventY = 0f
private var currentX = 0f
private var currentY: Float = 0f
private var lastX = 0f
private var lastY = 0f
private val pix = 3
lateinit var fig: Shape

open class DrawView(context: Context) : View(context) {
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap
    private val backColor = Color.WHITE



    open fun startDraw() {
        currentX = motionTouchEventX
        currentY = motionTouchEventY
    }

    open fun clear(){
        FigureHolder.clearFigures(context)
        extraCanvas.drawColor(backColor)
        invalidate()
    }

    open fun continueDraw() {
        extraCanvas.drawColor(backColor)
        drawAll()
        invalidate()
        val changeX = motionTouchEventX - lastX
        val changeY = motionTouchEventY - lastY
        if (Math.abs(changeX) >= pix || Math.abs(changeY) >= pix) {
            fig.changeParams(currentX, currentY, motionTouchEventX, motionTouchEventY, fig.figureName)
            fig.draw(extraCanvas)
        }
        lastX = motionTouchEventX
        lastY = motionTouchEventY
        invalidate()
    }

    open fun finDraw() {
        FigureHolder.addFigure(fig,context)
        drawAll()
        invalidate()
    }

    override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
        super.onSizeChanged(width, height, oldWidth, oldHeight)
        if (::extraBitmap.isInitialized) extraBitmap.recycle()
        extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        extraCanvas = Canvas(extraBitmap)
        extraCanvas.drawColor(backColor)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(extraBitmap, 0f, 0f, null)
    }

    //типа кисточка
    private fun drawAll() {
        extraCanvas.drawColor(16777215)
            for (i in FigureHolder.getFigures().indices) {
                var f = FigureHolder.getFigures()[i]
                f.draw(extraCanvas)
            }
        invalidate()
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        if(::fig.isInitialized&& FigureHolder.getFigures().contains(fig)){
            setFigure(fig::class)
        }

        motionTouchEventX = event.x
        motionTouchEventY = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                drawAll()
                currentY = motionTouchEventY
                currentX = motionTouchEventX
                startDraw()
            }
            MotionEvent.ACTION_MOVE -> continueDraw()
            MotionEvent.ACTION_UP -> finDraw()
        }
        return true
    }

    // T - generic type. Может принимать любоой тип
    // clazz - переменная типа generic
    // KClass - чисто котлиновский класс, который может принимать generic

    fun <T> setFigure(clazz: KClass<T>) where T: Any{
        when(clazz) {
            Point::class -> fig = Point(motionTouchEventX, motionTouchEventY, motionTouchEventX, motionTouchEventY)
            Line::class -> fig = Line(motionTouchEventX, motionTouchEventY,motionTouchEventX, motionTouchEventY)
            Circle::class -> fig = Circle(motionTouchEventX, motionTouchEventY,motionTouchEventX, motionTouchEventY)
            Rect::class -> fig = Rect(motionTouchEventX, motionTouchEventY,motionTouchEventX, motionTouchEventY)
            Cube::class -> fig = Cube(motionTouchEventX, motionTouchEventY,motionTouchEventX, motionTouchEventY)
            LineWithCircles::class -> fig = LineWithCircles(motionTouchEventX, motionTouchEventY,motionTouchEventX, motionTouchEventY)
        }
    }
//    open fun setPointFigure(){
//        fig = Point(motionTouchEventX, motionTouchEventY,motionTouchEventX, motionTouchEventY)
//    }
//
//    open fun setLineFigure(){
//        fig = Line(motionTouchEventX, motionTouchEventY, motionTouchEventX, motionTouchEventY)
//    }
//
//    open fun setCircleFigure(){
//        fig = Circle(motionTouchEventX, motionTouchEventY, motionTouchEventX, motionTouchEventY)
//    }
//
//    open fun setRectFigure(){
//        fig = Rect(motionTouchEventX, motionTouchEventY,motionTouchEventX, motionTouchEventY)
//    }
}