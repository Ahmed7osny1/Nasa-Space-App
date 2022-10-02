package com.sriyank.nasasapce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        intent.extras?.let { ProfileImg.setImageResource(it.getInt("image")) }

        Stress.text = intent.getStringExtra("stress")
        Name.text = intent.getStringExtra("name")

        Age.text = intent.getStringExtra("age")
        Likes.text = intent.getStringExtra("likes")

        About.text = intent.getStringExtra("about")
        Dreams.text = intent.getStringExtra("dream")

        video.setOnClickListener {

            val intent = Intent(this,VideoActivity::class.java)

            Log.d("tag","${Name.text.toString()}")

            when (Name.text.toString()) {
                "Semsem" -> intent.putExtra("link","Semsem")
                "Doctor" -> intent.putExtra("link","Doctor")
                "Rosa" -> intent.putExtra("link","Rosa")
                else -> intent.putExtra("link","daboor")
            }

            startActivity(intent)
        }

    }
}