package com.example.kotlinbasics

import android.app.Application
import android.util.Log

class MasterApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("testt","oncreate")
    }



}