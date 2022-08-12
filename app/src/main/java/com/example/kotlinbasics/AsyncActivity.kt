package com.example.kotlinbasics

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.loader.content.AsyncTaskLoader

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val backgroundTask = BackgroundAsyncTask(findViewById(R.id.progressBar),
            findViewById(R.id.progressBarText))

        findViewById<TextView>(R.id.start).setOnClickListener {

            backgroundTask.execute()
        }
        findViewById<TextView>(R.id.stop).setOnClickListener {
            backgroundTask.cancel(true)
        }

        findViewById<TextView>(R.id.shoot).setOnClickListener {
            Log.d("testt","SHOOT")
        }

    }
}

class BackgroundAsyncTask(
    val progressBar : ProgressBar, val progressText : TextView
) : AsyncTask<Int, Int, Int>() {


    var percent : Int = 0
    override fun doInBackground(vararg p0: Int?): Int {
        while(isCancelled==false) {
            percent++
            if(percent >100) break
            else {
                publishProgress(percent)
            }
            Thread.sleep(100)
        }

        return percent
    }

    override fun onPreExecute() {
        percent = 0
        super.onPreExecute()

    }

    override fun onPostExecute(result: Int?) {
        progressText.text ="작업이 완료되었습니다"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.setProgress(values[0] ?: 0)
        progressText.text = "퍼센트:" + values[0]
    }

    override fun onCancelled() {
        super.onCancelled()
    }

}