package com.example.kotlinbasics

import android.app.DownloadManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MelonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_melon)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitService::class.java)

        retrofitService.getMelonItemList().enqueue(object : Callback<ArrayList<MelonItem>>{
            override fun onResponse(
                call: Call<ArrayList<MelonItem>>,
                response: Response<ArrayList<MelonItem>>
            ) {
                val melon = response.body()
                melon!!.forEach {
                    Log.d("testt",it.song)
                }
            }

            override fun onFailure(call: Call<ArrayList<MelonItem>>, t: Throwable) {
                Log.d("testt","n")
            }

        })

    }
}

class MelonItemRecyclerAdapter(val melonItemList : ArrayList<MelonItem>, val inflater : LayoutInflater, val glide : RequestManager, val context : Context) : RecyclerView.Adapter<MelonItemRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}