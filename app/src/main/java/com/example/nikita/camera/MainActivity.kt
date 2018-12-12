@file:Suppress("DEPRECATION")

package com.example.nikita.camera

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        butCam.setOnClickListener {
            if (!textName.text.isEmpty()) {
                getPhoto()
            } else {
                Toast.makeText(applicationContext, "Вы не ввели имя!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getPhoto() {
        val intCam = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (intCam.resolveActivity(packageManager) != null)
            startActivityForResult(intCam, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                1 -> {
                    val ext = data?.extras
                    val imageBitmap = ext?.get("data") as Bitmap
                    val nameTxt = textName.text.toString()
                    val startIntent = Intent(applicationContext, SecondActivity::class.java)
                    startIntent.putExtra("img", imageBitmap)
                    startIntent.putExtra("txt", nameTxt)
                    startActivity(startIntent)
                }
            }
        }
    }
}


