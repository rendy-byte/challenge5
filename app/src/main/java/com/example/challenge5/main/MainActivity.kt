package com.example.challenge5.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.challenge5.R
import com.example.challenge5.homeactivity.homeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Permission Gilde
        val icon = findViewById<ImageView>(R.id.icon)
        Glide.with( this)
            .load("https://i.ibb.co/HC5ZPgD/splash-screen%201.png")
            .into(icon)

        //splash screen
        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this@MainActivity, homeActivity::class.java))
                finish()
            }, 3000
        )
    }
}