package com.example.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

                    findViewById<RecyclerView>(R.id.studentRecyclerView).apply {
                        this.adapter = StudentListRecyclerViewAdapter(studentList!!, LayoutInflater.from(this@RetrofitActivity) )
                        this.layoutManager = LinearLayoutManager(this@RetrofitActivity)

                    }

                }
            }

            override fun onFailure(call: Call<ArrayList<StudentFromServer>>, t: Throwable) {
                t.cause
                Log.d("testt","failure" + t.cause)
            }
        })


        findViewById<TextView>(R.id.createStudent).setOnClickListener {
            val student = HashMap<String, Any>()
            student.put("name","TEST")
            student.put("intro","test2")
            student.put("age",23)
//            retrofitService.createStudent(student).enqueue(object : Callback<StudentFromServer>{
//                override fun onResponse(
//                    call: Call<StudentFromServer>,
//                    response: Response<StudentFromServer>
//                ) {
//                    if(response.isSuccessful) {
//                        val student = response.body()
//                        Log.d("testt","등록한 학생 : " + student!!.name)
//                    }
//                }
//
//                override fun onFailure(call: Call<StudentFromServer>, t: Throwable) {
//
//                    Log.d("testt","등록한 학생 : " )
//
//                }
//
//            })
        }


    }
}

class StudentListRecyclerViewAdapter (var studentList : ArrayList<StudentFromServer>, var inflater : LayoutInflater) :RecyclerView.Adapter<StudentListRecyclerViewAdapter.ViewHolder>() {


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val studentName : TextView
        val studentAge : TextView
        val studentIntro : TextView

        init {
            studentName = itemView.findViewById(R.id.studnet_name)
            studentAge = itemView.findViewById(R.id.studnet_age)
            studentIntro = itemView.findViewById(R.id.studnet_intro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.studentitem, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.studentName.text = studentList.get(position).name
        holder.studentAge.text = studentList.get(position).age.toString()
        holder.studentIntro.text = studentList.get(position).intro

    }
    override fun getItemCount(): Int {
        return studentList.size
    }

}