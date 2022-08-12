package com.example.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val currentThread = Thread.currentThread()
        Log.d("testt",""+ currentThread)

//
//        Thread{
//            for(a in 1..500) {
//                Log.d("testt", "" + a)
//            }
//        }.start()
//
//
//        for(a in 1..500) {
//            Log.d("testt", "" + a)
//        }
//
            Thread {
                val currentThread = Thread.currentThread()
                Log.d("testt","A"+ currentThread)

                //UI관련 작업을 메인쓰레드가 아닌 쓰레드에서 하려고 하면 해당 작업 메인쓰레드의 큐에 들어간다
                runOnUiThread {
                    findViewById<TextView>(R.id.test).text = "changed"
                }
            }.start()

    }



}