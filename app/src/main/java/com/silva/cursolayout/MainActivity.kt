package com.silva.cursolayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button)
        val nombre = "Herber Sebastian Silva Muñoz"
        button.setOnClickListener {
            val toast = Toast.makeText(applicationContext, nombre, Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}