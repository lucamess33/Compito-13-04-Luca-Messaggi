package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    private lateinit var TVNumber: TextView
    private lateinit var CheckboxBlocca: CheckBox //
    private lateinit var CheckboxInverti: CheckBox
    private lateinit var incrementButton: Button
    private lateinit var ETincremento: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        TVNumber = findViewById<TextView>(R.id.output_Label)
        CheckboxBlocca = findViewById<CheckBox>(R.id.checkbox_blocca)
        CheckboxInverti = findViewById<CheckBox>(R.id.checkbox_inverti)
        incrementButton = findViewById<Button>(R.id.button_base)
        ETincremento = findViewById<EditText>(R.id.input_increment)


        incrementButton.setOnClickListener {

            var currentNumber: Int = TVNumber.text.toString().toInt()
            var incrementVal: Int? = ETincremento.text.toString().toIntOrNull()

            if (incrementVal != null) {
                if (!CheckboxBlocca.isChecked){
                    currentNumber =  if (CheckboxInverti.isChecked) currentNumber - incrementVal else currentNumber + incrementVal
                }

                TVNumber.text = currentNumber.toString()
            }
        }
    }
}