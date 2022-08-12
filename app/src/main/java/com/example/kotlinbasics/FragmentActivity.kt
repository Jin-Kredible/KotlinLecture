package com.example.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)


        val fragmentManager = supportFragmentManager
        val fragmentFirst = FragmentFirst()


        findViewById<TextView>(R.id.add).setOnClickListener {
            val transaction = fragmentManager.beginTransaction()

            //프레그먼트에 데이터를 전달
            val bundle = Bundle()
            bundle.putString("key","hello")
            fragmentFirst.arguments = bundle



            transaction.replace(R.id.root, fragmentFirst, "fragment_first_tag")
            transaction.commit()

        }

        findViewById<TextView>(R.id.remove).setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.remove(fragmentFirst)
            transaction.commit()

        }

        findViewById<TextView>(R.id.access_fragment).setOnClickListener {
            //xml 에 있는 fragment 찾는 방법
//            val firstFragment = supportFragmentManager.findFragmentById(R.id.fragment_first) as FragmentFirst
//
//            firstFragment.printTestLog()

            //xml에 없는 fragment 찾는 방법
            val fragmentFirst : FragmentFirst? = supportFragmentManager.findFragmentByTag("fragment_first_tag") as FragmentFirst?
            fragmentFirst?.printTestLog()

        }

    }

    fun printTestLog() {
        Log.d("test2","print test log")
    }
}