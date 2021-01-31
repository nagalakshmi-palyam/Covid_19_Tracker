package com.lakshmi.mini_project.Activites

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.lakshmi.mini_project.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, LogInActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}