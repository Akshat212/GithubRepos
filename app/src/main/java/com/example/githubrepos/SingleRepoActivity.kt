package com.example.githubrepos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubrepos.databinding.ActivitySingleRepoBinding

class SingleRepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySingleRepoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val starCount = intent.getIntExtra("StarCount",1220)
        val readMe = intent.getStringExtra("Readme")

        binding.tvStarCount.text = starCount.toString()
        binding.tvReadme.text = readMe
    }
}