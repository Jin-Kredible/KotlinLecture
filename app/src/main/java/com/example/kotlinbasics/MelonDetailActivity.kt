package com.example.kotlinbasics

import android.media.Image
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

class MelonDetailActivity : AppCompatActivity() {

    lateinit var playPauseBtn : ImageView
    lateinit var mediaPlayer : MediaPlayer


    var isPlaying : Boolean = true
        set(value) {
            if(value == true) {
                playPauseBtn.setImageDrawable(
                this.resources.getDrawable(R.drawable.ic_launcher_foreground, this.theme))
            } else {
                playPauseBtn.setImageDrawable(
                this.resources.getDrawable(R.drawable.youtube_logo, this.theme))
            }
            field = value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_melon_detail)

        var melonItemList = intent.getSerializableExtra("melonList") as ArrayList<MelonItem>
        var position = intent.getIntExtra("position", 0)
        playMelonItem(melonItemList.get(position))
        changeThumbnail(melonItemList.get(position))

        playPauseBtn = findViewById(R.id.play_pause)
        playPauseBtn.setOnClickListener {
            if( isPlaying ==true) {
                isPlaying = false
                Log.d("testt",""+mediaPlayer.isPlaying)
                mediaPlayer.pause()

            } else {
                isPlaying = true
                playMelonItem(melonItemList.get(position))
            }

            Log.d("testt","" + melonItemList.get(position).thumbnail)
        }

        findViewById<ImageView>(R.id.previous).setOnClickListener {


            mediaPlayer.pause()
            if(position>0) {

                playMelonItem(melonItemList.get(position - 1))
                changeThumbnail(melonItemList.get(position - 1))
                position -= 1
            }
        }

        findViewById<ImageView>(R.id.next).setOnClickListener {



            Log.d("testt",""+position)
            Log.d("testt",""+melonItemList.size)
            mediaPlayer.pause()
            if(position<melonItemList.size-1) {

                playMelonItem(melonItemList.get(position + 1))
                changeThumbnail(melonItemList.get(position + 1))
                position += 1
            }
        }
    }

    fun playMelonItem(melonItem : MelonItem) {
        mediaPlayer = MediaPlayer.create(this, Uri.parse(melonItem.song))
        mediaPlayer.start()
    }

    fun changeThumbnail(melonItem: MelonItem) {
       findViewById<ImageView>(R.id.thumbnail).apply{
            val glide = Glide.with(this@MelonDetailActivity)
           glide.load(melonItem.thumbnail).into(this)
       }



    }
}