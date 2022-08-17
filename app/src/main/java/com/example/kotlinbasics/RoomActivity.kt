package com.example.kotlinbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.*
import androidx.room.Database
import androidx.room.OnConflictStrategy.REPLACE

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)



        //기본적으로 데이터베이스 작업은 메인스레드에서 할 수 없다
        //스레드를 이요하거나 async 를 이용
        val database = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "user-database").allowMainThreadQueries().build()


        findViewById<TextView>(R.id.save).setOnClickListener {
            val userProfile = UserProfile(1,"Kim","jinwon2")
            database.userProfileDao().insert(userProfile)

        }

        findViewById<TextView>(R.id.load).setOnClickListener {
            val userProfiles = database.userProfileDao().getAll()

            userProfiles.forEach{
                Log.d("testt",""+it.firstName)
            }

        }

        findViewById<TextView>(R.id.delete).setOnClickListener {
            val userdeleted = database.userProfileDao().delete(0)

        }



    }
}

@Database(entities = [UserProfile::class], version =1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userProfileDao() : UserProfileDao

}

@Dao
interface UserProfileDao {
    @Insert(onConflict = REPLACE)
    fun insert(userProfile: UserProfile)

    @Query("DELETE FROM UserProfile WHERE id = :userId")
    fun delete(userId: Int)

    @Query("SELECT * FROM UserProfile")
    fun getAll() : List<UserProfile>
}


@Entity
class UserProfile(

    @PrimaryKey
    val id : Int,

    @ColumnInfo(name="last_name")
    val lastName : String,
    @ColumnInfo(name="first_name")
    val firstName : String) {

    constructor(lastName: String,firstName: String) : this(0,lastName,firstName)
}


