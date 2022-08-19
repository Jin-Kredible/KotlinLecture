package com.example.kotlinbasics

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.zip.Inflater

class YoutubeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_youtube)


        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/").addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService = retrofit.create(RetrofitService::class.java)

        retrofitService.getYoutubeItemList().enqueue(object : Callback<ArrayList<YoutubeItem>>{
            override fun onResponse(
                call: Call<ArrayList<YoutubeItem>>,
                response: Response<ArrayList<YoutubeItem>>
            ) {
                val youtubeItemList = response.body()

                youtubeItemList!!.forEach {
                    Log.d("testt",it.title)
                }
            }

            override fun onFailure(call: Call<ArrayList<YoutubeItem>>, t: Throwable) {
                Log.d("testt","yes")
            }

        })

    }
}

class YoutubeListAdapter (val youtubeItemList : ArrayList<YoutubeItem>, val inflater : LayoutInflater, val glide : RequestManager, val context : Context ) : RecyclerView.Adapter<YoutubeListAdapter.ViewHoler> {
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView
        val thumbnail : ImageView
        val content : TextView

        init {
            title = itemView.findViewById(R.id.title)
            thumbnail = itemView.findViewById(R.id.thumbnail)
            content = itemView.findViewById(R.id.content)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): YoutubeListAdapter.ViewHolder {
        TODO("Not yet implemented")
    }


    override fun onBindViewHolder(holder: YoutubeListAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return youtubeItemList.size
    }
}
