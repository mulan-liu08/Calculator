package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num1Field = findViewById<EditText>(R.id.num1)
        val num2Field = findViewById<EditText>(R.id.num2)

        val addButton = findViewById<Button>(R.id.plus)
        val subButton = findViewById<Button>(R.id.minus)
        val multButton = findViewById<Button>(R.id.multiply)
        val divButton = findViewById<Button>(R.id.divide)

        addButton.setOnClickListener {
            val num1 = num1Field.text.toString().toFloat()
            val num2 = num2Field.text.toString().toFloat()
            val result = num1 + num2
            goToResults(result)
        }

        subButton.setOnClickListener {
            val num1 = num1Field.text.toString().toFloat()
            val num2 = num2Field.text.toString().toFloat()
            val result = num1 - num2
            goToResults(result)
        }

        multButton.setOnClickListener {
            val num1 = num1Field.text.toString().toFloat()
            val num2 = num2Field.text.toString().toFloat()
            val result = num1 * num2
            goToResults(result)
        }

        divButton.setOnClickListener {
            val num1 = num1Field.text.toString().toFloat()
            val num2 = num2Field.text.toString().toFloat()

            if (num2 == 0.toFloat()) {
                Toast.makeText(this, "Cannot divide by 0!", Toast.LENGTH_SHORT).show()
            } else {
                val result = num1 / num2
                goToResults(result)
            }
        }
    }

    private fun goToResults(result: Float) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RESULT", result)
        startActivity(intent)
    }

}