package com.example.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ViewControl_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_control02)


        val textViewOne : TextView = findViewById(R.id.textViewOne)
        val buttonOne : Button = findViewById(R.id.buttonOne)

        buttonOne.setOnClickListener {
            Log.d("test2","Button Clicked")
        }

        val clickListen  = View.OnClickListener { TODO("Not yet implemented") }
    }

    val gildong  = Person().apply {
        name = "Jin"
        age = 20

    }

    val gildong2 = Person("victor").also {

    }

}

class Person(var name: String? = null, var age: Int? = null) {


}
