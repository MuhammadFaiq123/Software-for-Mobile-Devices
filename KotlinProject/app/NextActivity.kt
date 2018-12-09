package com.example.muhammadfaiq.kotlinproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

    }
    fun onClickSecond (view: View) {
        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)
    }

}
