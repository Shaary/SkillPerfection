package com.shaary.skillperfection

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.shaary.skillperfection.data.Session
import com.shaary.skillperfection.data.TrackingDatabase
import kotlin.concurrent.thread

class SkillActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        val nameText: TextView = findViewById(R.id.skill_name)
        val timeText: TextView = findViewById(R.id.skill_time)

        //Id of selected skill
        val skillId: Long = intent.getLongExtra("id", 0)
        val skillName: String = intent.getStringExtra("name")
        val skillTime: Long = intent.getLongExtra("time", 0)

        timeText.text = skillTime.toString()
        nameText.text = skillName

        //TODO: move to model-view
//        val db = Room.databaseBuilder(this, TrackingDatabase::class.java, "TimeDb").build()
//        val data = Session(startedTime = System.currentTimeMillis() / 1000, skillId = 1)
//        Log.d(SkillActivity::class.java.name, "passed in object" + data.id)
//        thread {
//            db.sessionDao().insert(data)
//        }
//
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.container_layout,TimerFragment()).commit()
    }

    //Throws an error.
    //TODO: find out how to fix
    private fun formatTimeView(skillTime: Long): String {
        return String.format(getString(R.string.time_format_string), skillTime.toString(), "s")
    }
}
