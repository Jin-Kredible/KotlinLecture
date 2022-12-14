package com.example.kotlinbasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class Intent_Two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)

        val intent = intent
        val data : String? = intent.extras?.getString("extra-data")
        if(data != null) {
            Log.d("dataa",data)
        }

        findViewById<TextView>(R.id.finish).apply {
            this.setOnClickListener {
                val intent : Intent = Intent()

                intent.putExtra("result","success")
                setResult(RESULT_OK,intent)

                finish()
            }
        }



    }
}