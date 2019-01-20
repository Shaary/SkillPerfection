package com.shaary.skillperfection

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import com.shaary.skillperfection.ViewModel.SkillActivityViewModel

class SkillActivity : AppCompatActivity() {

    private lateinit var skillViewModel: SkillActivityViewModel
    private var skillId: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        supportActionBar?.setHomeButtonEnabled(true)

        skillViewModel = ViewModelProviders.of(this).get(SkillActivityViewModel::class.java)

        val nameText: TextView = findViewById(R.id.skill_name)
        val timeText: TextView = findViewById(R.id.skill_time)

        //Id of selected skill
        skillId = intent.getLongExtra("id", 0)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.skill_activity_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Respond to the action bar's Up/Home button
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
            R.id.delete_skill -> {
                skillViewModel.delete(skillId)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
