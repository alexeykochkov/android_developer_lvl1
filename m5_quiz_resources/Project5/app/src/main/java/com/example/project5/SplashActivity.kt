package com.example.project5

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project5.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startSound = MediaPlayer.create(this, R.raw.start)

        fun sounds(mediaPlayer: MediaPlayer) {
            startSound.start()
        }


        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            sounds(startSound)
        }


    }

}