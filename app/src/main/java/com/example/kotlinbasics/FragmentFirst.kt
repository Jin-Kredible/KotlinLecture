package com.example.kotlinbasics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentFirst : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.first_fragment, container, false)

        view.findViewById<TextView>(R.id.call_activity).setOnClickListener {
            (activity as FragmentActivity).printTestLog()
        }

        return view

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data : String? = arguments?.getString("key")

        Log.d("test","datais " + data)
    }

    fun printTestLog() {
        Log.d("test3","print test log from fragmnet")
    }


}