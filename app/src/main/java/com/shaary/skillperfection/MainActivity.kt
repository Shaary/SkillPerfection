package com.shaary.skillperfection

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timer_button.setOnClickListener {
            val intent = Intent(this, SkillActivity::class.java)
            startActivity(intent)
        }
    }
}
