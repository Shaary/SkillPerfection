package com.shaary.skillperfection

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Button
import com.shaary.skillperfection.adapters.HobbyAdapter
import com.shaary.skillperfection.data.Skill
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createHobby: Button = findViewById(R.id.create_button)

        val hobbies: ArrayList<Skill> = arrayListOf()

        for (i in 1..10) {
            hobbies.add(Skill("Programming"))
        }

        //TODO: add card view
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = HobbyAdapter(hobbies)

        if (recycler_view.adapter.itemCount == 0) {
            createHobby.visibility = View.VISIBLE
        }
    }
}
