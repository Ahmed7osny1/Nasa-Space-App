package com.sriyank.nasasapce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var total_res = intent.getStringExtra("total_score")
        var your_res = intent.getStringExtra("que_score")


        txt_score.text = "${your_res} / ${total_res}"

        if(your_res!!.toInt() < (total_res!!.toInt() / 2))res_view.text = "bad luck !!"

        finish.setOnClickListener {
            var i = Intent(this , MainActivity::class.java )
            startActivity(i)
            finish()
        }

    }
}