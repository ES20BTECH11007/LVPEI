package com.example.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class OtherActivity : AppCompatActivity(), SurfaceHolder.Callback {

    private lateinit var cameraPreview: SurfaceView
    private lateinit var surfaceHolder: SurfaceHolder

    private val CAMERA_PERMISSION_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        cameraPreview = findViewById(R.id.cameraPreview)
        surfaceHolder = cameraPreview.holder
        surfaceHolder.addCallback(this)

        checkCameraPermission()
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_CODE
            )
        } else {
            // Permission already granted
            // Initialize and start the camera
            startCamera()
        }
    }

    private fun startCamera() {
        // Initialize camera here and start capturing pictures
        // You need to implement camera initialization and picture capturing logic
        // This involves working with CameraX or Camera2 API to handle the camera functionality
        // For brevity, the camera initialization code is not provided here
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, initialize and start the camera
                startCamera()
            } else {
                // Permission denied, handle accordingly
            }
        }
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        // Surface created
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        // Surface changed
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        // Surface destroyed
    }
}

