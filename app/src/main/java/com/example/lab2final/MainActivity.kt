package com.example.lab2final

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.example.lab2final.Shape.*
import android.widget.TextView
import android.widget.TableLayout
import org.json.JSONObject
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    lateinit var paintingLayout: ConstraintLayout
    lateinit var newView: DrawView
    lateinit var toolbar: androidx.appcompat.widget.Toolbar
    lateinit var tableScroll: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        paintingLayout = findViewById<ConstraintLayout>(R.id.paintingLayout)
        FigureHolder.table = findViewById<TableLayout>(R.id.tableLayout)
        FigureHolder.clearFigures(this)
        tableScroll = findViewById<ScrollView>(R.id.tableScroll)
        newView = DrawView(this)
        paintingLayout.addView(newView)
        newView.setFigure<Point>(Point::class)
        toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.main_activity_menu)
        toolbar.setTitle("Lab3");
        setSupportActionBar(toolbar);
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_activity_menu, menu)
        return super.onCreateOptionsMenu(menu);
    }



    // actions on click menu items
    @SuppressLint("ResourceType")
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
//        ;
        R.id.object_point -> {
            msgShow("Обрано точку")
            newView.setFigure<Point>(Point::class)
            true
        }
        R.id.object_line -> {
            msgShow("Обрано лінію")
            newView.setFigure<Line>(Line::class)
            true
        }
        R.id.object_circle -> {
            msgShow("Обрано овал")
            newView.setFigure<Circle>(Circle::class)
            true
        }
        R.id.object_rect -> {
            msgShow("Обрано квадрат")
            newView.setFigure<Rect>(Rect::class)
            true
        }
        R.id.object_cube -> {
            msgShow("Обрано куб")
            newView.setFigure<Cube>(Cube::class)
            true
        }
        R.id.object_LineWithCircles -> {
            msgShow("Обрано лінію з колами")
            newView.setFigure<LineWithCircles>(LineWithCircles::class)
            true
        }
        R.id.file_new -> {
            msgShow("Новый")
            newView.clear()
            true
        }
        R.id.help_not -> {
            msgShow("Помощи не будет")
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }


    fun msgShow(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}