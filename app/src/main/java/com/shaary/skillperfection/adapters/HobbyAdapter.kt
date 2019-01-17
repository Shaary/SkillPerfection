package com.shaary.skillperfection.adapters

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shaary.skillperfection.R
import com.shaary.skillperfection.SkillActivity
import com.shaary.skillperfection.data.Skill

class HobbyAdapter : RecyclerView.Adapter<HobbyAdapter.ViewHolder>() {

    //TODO: implement diffutil
    private var skills = emptyList<Skill>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.hobby_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = skills.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.hobbyName.text = hobbies[position].name
//        //TODO: convert long to normal time format
//        holder.hobbyTime.text = hobbies[position].time.toString()
        holder.bind(skills[position])
    }

    internal fun setSkills(skills: List<Skill>) {
        this.skills = skills
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val hobbyName: TextView = itemView.findViewById(R.id.hobby_name)
        val hobbyTime: TextView = itemView.findViewById(R.id.hobby_time)

        lateinit var skill: Skill

        fun bind(skill: Skill) {
            this.skill = skill
            hobbyName.text = skill.name
            //TODO: convert long to normal time format
            hobbyTime.text = skill.time.toString()
        }

        init {
            itemView.setOnClickListener{
                val intent = Intent(itemView.context, SkillActivity::class.java)
                intent.putExtra("id", skill.id)
                itemView.context.startActivity(intent)
            }
        }


    }
}