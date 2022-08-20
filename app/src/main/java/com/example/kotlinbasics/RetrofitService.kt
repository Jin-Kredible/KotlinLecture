package com.example.kotlinbasics

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class StudentFromServer( val id: Int, val name: String, val age : Int, val intro : String)

interface RetrofitService {

    @GET("json/students")
    fun getStudnetList(): Call<ArrayList<StudentFromServer>>

    @POST("json/students/")
    fun createStudent(@Body params: HashMap<String,Any>) : Call<StudentFromServer>

}