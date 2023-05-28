package com.example.project5

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val yesSound = MediaPlayer.create(this, R.raw.right)
        val noSound = MediaPlayer.create(this, R.raw.wrong)

        fun soundYes(mediaPlayer: MediaPlayer) {
            yesSound.start()
        }

        fun soundNo(mediaPlayer: MediaPlayer) {
            noSound.start()
        }

        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstAnswer.setOnClickListener {
            soundNo(noSound)
        }
        binding.secondAnswer.setOnClickListener {
            soundNo(noSound)
        }

        binding.thirdAnswer.setOnClickListener {
            soundYes(yesSound)
        }
    }
}