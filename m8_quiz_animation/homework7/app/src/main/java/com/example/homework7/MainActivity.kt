package com.example.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        with(window) {
            enterTransition = Slide(Gravity.LEFT)
            exitTransition = Slide(Gravity.RIGHT)
        }



    }
}