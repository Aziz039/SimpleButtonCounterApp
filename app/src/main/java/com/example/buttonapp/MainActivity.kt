package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.view.marginTop
import android.widget.LinearLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var tv_targetNumber: TextView
    lateinit var tv_decrementButton: Button
    lateinit var tv_incrementButton: Button
    var decreased = false
    var increased = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_targetNumber = findViewById(R.id.tv_targetNumber)
        tv_decrementButton = findViewById(R.id.tv_decrementButton)
        tv_incrementButton = findViewById(R.id.tv_incrementButton)

        tv_targetNumber.text = "0"
        updateNumberColor()

        tv_decrementButton.setOnClickListener { decrementButton() }
        tv_incrementButton.setOnClickListener { incrementButton() }

    }

    fun decrementButton() {
        var currentNumber = tv_targetNumber.text.toString().toInt()
        currentNumber--;
        tv_targetNumber.text = currentNumber.toString()
        updateNumberColor()
    }

    fun incrementButton() {
        var currentNumber = tv_targetNumber.text.toString().toInt()
        currentNumber++

        tv_targetNumber.text = currentNumber.toString()
        updateNumberColor()
    }

    fun updateNumberColor() {
        var currentNumber = tv_targetNumber.text.toString().toInt()
        if (currentNumber == 0) {
            tv_targetNumber.setTextColor(Color.rgb(0,0,0))
            if (increased) {
                (tv_targetNumber.layoutParams as ConstraintLayout.LayoutParams).apply {
                    // individually set text view any side margin
                    topMargin += 240
                }
            } else if (decreased) {
                (tv_targetNumber.layoutParams as ConstraintLayout.LayoutParams).apply {
                    // individually set text view any side margin
                    topMargin -= 240
                }
            }
            decreased = false
            increased = false
        } else if (currentNumber < 0) {
            tv_targetNumber.setTextColor(Color.rgb(255,0,0))
            if (!decreased) {
                (tv_targetNumber.layoutParams as ConstraintLayout.LayoutParams).apply {
                    // individually set text view any side margin
                    topMargin += 240
                }
            }
            decreased = true
        } else {
            tv_targetNumber.setTextColor(Color.rgb(0,255,0))
            if (!increased) {
                (tv_targetNumber.layoutParams as ConstraintLayout.LayoutParams).apply {
                    // individually set text view any side margin
                    topMargin -= 240
                }
                increased = true
            }
        }
    }

}