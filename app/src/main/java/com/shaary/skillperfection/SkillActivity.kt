package com.shaary.skillperfection

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SkillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        var fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container_layout,TimerFragment()).commit()
    }
}
