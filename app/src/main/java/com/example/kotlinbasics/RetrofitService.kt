package com.example.kotlinbasics

import retrofit2.Call
import retrofit2.http.GET

class StudentFromServer( val id: Int, val name: String, val age : Int, val intro : String)

class YoutubeItem(val id : Int, val title : String, val content : String, val video : String, val thumbnail : String)

class MelonItem(val id : Int, val title : String, val song : String, val thumbnail : String)

interface RetrofitService {

    @GET("melon/list")
    fun getMelonItemList() : Call<ArrayList<MelonItem>>

    @GET("json/students")
    fun getStudnetList(): Call<ArrayList<StudentFromServer>>

    @GET("youtube/list")
    fun getYoutubeItemList() : Call<ArrayList<YoutubeItem>>

}