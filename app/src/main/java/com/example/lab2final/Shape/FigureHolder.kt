package com.example.lab2final.Shape

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

@SuppressLint("StaticFieldLeak")
object FigureHolder {
    private var figures = emptyArray<Shape>()
    lateinit var table: TableLayout
    var idGenerator = 300


    fun getFigures():Array<Shape>{
        return figures;
    }
    fun clearFigures(context: Context){
        figures = emptyArray<Shape>()
        initTable(context)

    }
    fun addFigure(figure:Shape,context: Context){
        figures += figure
        addFigureToTable(figure,context)
    }

    @SuppressLint("ResourceType")
    fun initTable(context: Context){
        table.removeAllViews()
        val tr_head = TableRow(context)
        tr_head.id = 100
        tr_head.setBackgroundColor(Color.BLUE) // part1
        tr_head.layoutParams = TableLayout.LayoutParams(
            TableLayout.LayoutParams.MATCH_PARENT,
            TableLayout.LayoutParams.WRAP_CONTENT)
        tr_head.addView(createTextRow("FigureName",context))
        tr_head.addView(createTextRow("X1",context))
        tr_head.addView(createTextRow("Y1",context))
        tr_head.addView(createTextRow("X2",context))
        tr_head.addView(createTextRow("Y2",context))
        table.addView(tr_head, TableLayout.LayoutParams(
            TableLayout.LayoutParams.FILL_PARENT,  //part4
            TableLayout.LayoutParams.WRAP_CONTENT))
    }

    fun addFigureToTable(figure:Shape,context: Context){
            val tr_head = TableRow(context)
            tr_head.id = ++idGenerator
            tr_head.setBackgroundColor(Color.GRAY)
            tr_head.layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT)
            val df = DecimalFormat("#.##")//set decimal format here
            df.roundingMode = RoundingMode.CEILING
            tr_head.addView(createTextRow(figure.figureName,context))
            tr_head.addView(createTextRow(df.format(figure.x1).toString(),context))
            tr_head.addView(createTextRow(df.format(figure.y1).toString(),context))
            tr_head.addView(createTextRow(df.format(figure.x2).toString(),context))
            tr_head.addView(createTextRow(df.format(figure.y2).toString(),context))
            table.addView(tr_head, TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT))
    }

    fun fillTable(context: Context){
        val tr_head = arrayOfNulls<TableRow>(figures.size)
        for (i in figures.indices) {
            val figure = figures[i]
            tr_head[i] = TableRow(context)
            tr_head[i]!!.id = ++idGenerator
            tr_head[i]!!.setBackgroundColor(Color.GRAY)
            tr_head[i]!!.layoutParams = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT)
            val df = DecimalFormat("#.##")//set decimal format here
            df.roundingMode = RoundingMode.CEILING
            tr_head[i]!!.addView(createTextRow(figure.figureName,context))
            tr_head[i]!!.addView(createTextRow(df.format(figure.x1).toString(),context))
            tr_head[i]!!.addView(createTextRow(df.format(figure.y1).toString(),context))
            tr_head[i]!!.addView(createTextRow(df.format(figure.x2).toString(),context))
            tr_head[i]!!.addView(createTextRow(df.format(figure.y2).toString(),context))
            table.addView(tr_head[i], TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT))
        }
    }
    fun createTextRow(name:String,context: Context) : TextView {
        val text = TextView(context)
        text.id = ++idGenerator
        text.text = name
        text.setTextColor(Color.WHITE)
        text.setPadding(5, 5, 5, 5)
        return text;
    }
}