package com.yw_kim.ourhome

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("data", "0")

            startActivity(intent)
            finish()
        }, 2000)
    }
}