package com.example.bruno.cocktailapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlideApp.with(this)
                .load(R.mipmap.logo)
                .placeholder(R.mipmap.logo)
                .into(appLogo)

        Handler().postDelayed({
            val listaCocktail = Intent(this, MainActivity::class.java)
            startActivity(listaCocktail)
            finish()
        }, 2000)

    }
}