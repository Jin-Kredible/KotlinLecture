package com.example.kotlinbasics

import android.media.session.MediaSession
import retrofit2.Call
import retrofit2.http.*
import java.io.Serializable

class StudentFromServer( val id: Int, val name: String, val age : Int, val intro : String)

class YoutubeItem(val id : Int, val title : String, val content : String, val video : String, val thumbnail : String)

class MelonItem(val id : Int, val title : String, val song : String, val thumbnail : String) : Serializable

class UserToken(val id : String, val token: String, val userName: String)

class InstaPost(val content : String, val image : String, val owner_profile : OwnerProfile)


class OwnerProfile ( val username : String, val image : String  )

interface RetrofitService {

    @GET("melon/list")
    fun getMelonItemList() : Call<ArrayList<MelonItem>>

    @GET("json/students")
    fun getStudnetList(): Call<ArrayList<StudentFromServer>>

    @GET("youtube/list")
    fun getYoutubeItemList() : Call<ArrayList<YoutubeItem>>

    @POST("user/login/")
    @FormUrlEncoded
    fun instaLogin(@FieldMap params : HashMap<String,Any>) : Call<UserToken>

    @POST("user/signup/")
    @FormUrlEncoded
    fun instaJoin(@FieldMap params : HashMap<String,Any>) : Call<UserToken>

    @GET("instagram/post/list/all")
    fun getInstagramPosts() : Call<ArrayList<InstaPost>>



}