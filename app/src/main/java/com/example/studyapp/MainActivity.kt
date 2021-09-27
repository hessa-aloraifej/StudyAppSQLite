package com.example.studyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var buttonkotlin= findViewById<Button>(R.id.buttonk)
        var buttonandroid=findViewById<Button>(R.id.buttona)
        buttonkotlin.setOnClickListener {
            val intent = Intent(this, kotlinactivity::class.java)
            startActivity(intent)
        }
        buttonandroid.setOnClickListener {
            val intent = Intent(this, androidactivity::class.java)
            startActivity(intent)
        }

    }
}