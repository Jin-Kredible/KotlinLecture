package com.example.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/").addConverterFactory(GsonConverterFactory.create())
            .build()



        val retrofitService = retrofit.create(RetrofitService::class.java)
        retrofitService.getStudnetList().enqueue(object : Callback<ArrayList<StudentFromServer>>{
            override fun onResponse(
                call: Call<ArrayList<StudentFromServer>>,
                response: Response<ArrayList<StudentFromServer>>
            ) {
                if(response.isSuccessful) {
                    val studentList = response.body()
                    studentList!!.forEach {
                        Log.d("testt", ""+it.name)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<StudentFromServer>>, t: Throwable) {
                t.cause
                Log.d("testt","failure" + t.cause)
            }
        })





    }
}