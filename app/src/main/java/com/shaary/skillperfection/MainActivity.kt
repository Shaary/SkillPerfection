package com.shaary.skillperfection

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.shaary.skillperfection.ViewModel.SkillViewModel
import com.shaary.skillperfection.adapters.HobbyAdapter
import com.shaary.skillperfection.data.Skill
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var skillViewModel: SkillViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createHobby: Button = findViewById(R.id.create_button)

        skillViewModel = ViewModelProviders.of(this).get(SkillViewModel::class.java)

        //TODO: add card view
        recycler_view.layoutManager = LinearLayoutManager(this)
        val adapter = HobbyAdapter()
        recycler_view.adapter = adapter

        if (recycler_view.adapter.itemCount == 0) {
            createHobby.visibility = View.VISIBLE
        } else {
            createHobby.visibility = View.INVISIBLE
        }

        skillViewModel.allSkills.observe(this, Observer { skills ->
            skills?.let { adapter.submitList(it) }
        })


        createHobby.setOnClickListener{
            val intent = Intent(this@MainActivity, CreateSkillActivity::class.java)
            startActivityForResult(intent, newSkillRequestCode)
        }

        adapter.setOnItemClickListener(object : HobbyAdapter.onItemClickListener {
            override fun onItemClick(skill: Skill) {
                val intent = Intent(this@MainActivity, SkillActivity::class.java)
                intent.putExtra("id", skill.id)
                intent.putExtra("name", skill.name)
                intent.putExtra("time", skill.time)
                startActivity(intent)
            }
        })
    }

    companion object {
        const val newSkillRequestCode = 1
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newSkillRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let {
                val skill = Skill(name = it.getStringExtra(CreateSkillActivity.EXTRA_NAME))
                skillViewModel.insert(skill)
            }
        } else {
            Toast.makeText(
                    applicationContext,
                    "Skill not saved",
                    Toast.LENGTH_LONG).show()
        }
    }
}
