package com.example.kotlinbasics

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class Intent_One : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_one)

        //암시적 인텐트
        // 전화 ,sms,play store, 사진첩 등등

        val implicit_intent : TextView = findViewById(R.id.implicit_intent)
        implicit_intent.setOnClickListener {
            val intent : Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "010-2792-5394"))
            startActivity(intent)
        }

        val implicit_intent2 : TextView = findViewById(R.id.implicit_intent2)
        implicit_intent2.setOnClickListener {
            val intent2 : Intent = Intent(Intent.ACTION_PICK)
            startActivity(intent2)
        }

        //명시적 인텐트
        val intent_one : TextView = findViewById(R.id.intent_one)
        intent_one.setOnClickListener {
            val intent : Intent = Intent()
            val componentName : ComponentName = ComponentName(
                "com.example.kotlinbasics",
                "com.example.kotlinbasics.Intent_Two"
            )
            intent.component = componentName
            startActivity(intent)
        }

        findViewById<TextView>(R.id.intent_two).apply {
            this.setOnClickListener {
                startActivity(Intent(this@Intent_One, Intent_Two::class.java))
            }
        }


        //명시적 인텐트 + data전달
        findViewById<TextView>(R.id.intent_three).apply {
            this.setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                intent.putExtra("extra-data","data-one")
                startActivity(intent)
            }
        }

        //명시적 인텐트 + 결과 받기

        //request Code
        // -구분을 하기 위해
        findViewById<TextView>(R.id.intent_four).apply {
            this.setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                startActivityForResult(intent,1)
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            1 -> {
                when(resultCode) {
                    RESULT_OK -> {
                        val data :String? = data?.extras?.getString("result")

                        Log.d("dataa",data!!)
                    }
                }
            }
        }
    }
}