package com.example.muhammadfaiq.kotlinproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener{v ->
            imageView.setBackgroundColor(R.color.background_material_dark);
        }


    }
    fun onClickFirst (view: View) {
        val intent = Intent(this, NextActivity::class.java)

        startActivity(intent)
    }


}
