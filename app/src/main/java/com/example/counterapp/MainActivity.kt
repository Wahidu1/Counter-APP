package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var countButton: Button
    private lateinit var resetButton: Button
    private lateinit var minusButton: Button
    private var counter:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.result)
        countButton = findViewById(R.id.count)
        resetButton = findViewById(R.id.reset)
        minusButton = findViewById(R.id.minus)


        textView.text = "Number of count 0"
        countButton.setOnClickListener {
            textView.text = "Number of count ${increase()}"
            Toast.makeText(this@MainActivity, "Increased", Toast.LENGTH_SHORT).show()
        }
        resetButton.setOnClickListener {
            textView.text = "Number of count ${reset()}"
            Toast.makeText(this@MainActivity, "Reset", Toast.LENGTH_SHORT).show()
        }
        minusButton.setOnClickListener {
            if (counter == 0){
                Toast.makeText(this@MainActivity, "Can't go below zero", Toast.LENGTH_SHORT).show()
            }
            else{
                textView.text = "Number of count ${decrease()}"
                Toast.makeText(this@MainActivity, "Decreased", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun decrease(): Int {
        counter--
        return counter
    }

    private fun reset(): Int {
        counter = 0
        return this.counter
    }

    private fun increase(): Int {
        counter++
        return counter
    }

}