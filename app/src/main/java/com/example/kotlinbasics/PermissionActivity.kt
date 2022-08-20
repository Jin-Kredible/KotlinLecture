package com.example.kotlinbasics

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        findViewById<TextView>(R.id.askPermission).setOnClickListener {
            val cameraPermission = ContextCompat.checkSelfPermission(
                this,android.Manifest.permission.CAMERA
            )

            if(cameraPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CAMERA),
                    100
                )

                Log.d("testt","Camer persmission1")
            }else {
                Log.d("testt","Camer persmission2")
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode ==100) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d("testt","accepted")
            } else {
                Log.d("testt","Denied")
            }
        }
    }
}