package com.example.nikita.camera

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val getImg = intent.getParcelableExtra<Bitmap>("img")
        imgCam.setImageBitmap(getImg)

        val getName = intent.getStringExtra("txt")
        enteredName.text = getName
    }
}
