package com.example.kotlinbasics

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.HttpURLConnection.HTTP_OK
import java.net.URL

class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkAsyncTask().execute()


    }
}

class NetworkAsyncTask() : AsyncTask<Any?, Any?, Any?>() {
    override fun doInBackground(vararg p0: Any?): Any? {
        val urlString : String = "https://mellowcode.org/json/students"
        val url : URL = URL(urlString)

        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type","application/json")

        var buffer = ""

        if (connection.responseCode==HttpURLConnection.HTTP_OK) {
            val reader = BufferedReader(InputStreamReader(
                connection.inputStream,"UTF-8"
            )
            )
            buffer = reader.readLine()
            Log.d("testt",buffer)
        }

        return null
    }
}